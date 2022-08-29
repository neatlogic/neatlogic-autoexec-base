package codedriver.framework.autoexec.job.source.type;

import codedriver.framework.asynchronization.threadlocal.UserContext;
import codedriver.framework.autoexec.dao.mapper.AutoexecJobMapper;
import codedriver.framework.autoexec.dto.ISqlDetail;
import codedriver.framework.autoexec.dto.job.AutoexecJobPhaseNodeVo;
import codedriver.framework.autoexec.dto.job.AutoexecJobPhaseVo;
import codedriver.framework.autoexec.dto.job.AutoexecJobVo;
import codedriver.framework.autoexec.exception.AutoexecJobExecutePermissionDeniedException;
import codedriver.framework.integration.authentication.enums.AuthenticateType;
import codedriver.framework.util.HttpRequestUtil;
import codedriver.framework.util.TimeUtil;
import codedriver.framework.util.excel.ExcelBuilder;
import codedriver.framework.util.excel.SheetBuilder;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONReader;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author longrf
 * @date 2022/5/31 5:12 下午
 */
public abstract class AutoexecJobSourceTypeHandlerBase implements IAutoexecJobSourceTypeHandler {
    protected static AutoexecJobMapper autoexecJobMapper;

    @Autowired
    private void setAutoexecJobMapper(AutoexecJobMapper _autoexecJobMapper) {
        autoexecJobMapper = _autoexecJobMapper;
    }

    Logger logger = LoggerFactory.getLogger(AutoexecJobSourceTypeHandlerBase.class);

    public void getFireParamJson(JSONObject jsonObject, AutoexecJobVo jobVo) {
        getMyFireParamJson(jsonObject, jobVo);
    }

    public void getMyFireParamJson(JSONObject jsonObject, AutoexecJobVo jobVo) {
    }


    @Override
    public void executeAuthCheck(AutoexecJobVo jobParam, boolean isNeedCheckTakeOver) {
        Long jobId = jobParam.getId();
        String execUser = StringUtils.isNotBlank(jobParam.getAssignExecUser()) ? jobParam.getAssignExecUser() : UserContext.get().getUserUuid(true);
        jobParam.setExecUser(execUser);
        if (isNeedCheckTakeOver) {
            AutoexecJobVo originJob = autoexecJobMapper.getJobInfo(jobId);
            //作业存在 且 执行人不相等，则需要先接管作业
            if (originJob != null && !execUser.equals(originJob.getExecUser())) {
                //是否需要替换execUser
                if (jobParam.getIsTakeOver() == 1) {
                    autoexecJobMapper.updateJobExecUser(jobId, jobParam.getExecUser());
                } else {
                    throw new AutoexecJobExecutePermissionDeniedException(jobId);
                }
            }
        }
        myExecuteAuthCheck(jobParam);
    }

    protected void myExecuteAuthCheck(AutoexecJobVo jobParam) {
    }

    @Override
    public Workbook exportJobPhaseSql(AutoexecJobPhaseNodeVo jobPhaseNodeVo, AutoexecJobVo jobVo, AutoexecJobPhaseVo phaseVo, List<String> headList, List<String> columnList) {
        Workbook workbook = null;
        int count = getJobPhaseSqlCount(jobPhaseNodeVo);
        if (count > 0) {
            List<ISqlDetail> list;
            jobPhaseNodeVo.setRowNum(count);
            ExcelBuilder builder = new ExcelBuilder(SXSSFWorkbook.class);
            SheetBuilder sheetBuilder = builder.withBorderColor(HSSFColor.HSSFColorPredefined.GREY_40_PERCENT)
                    .withHeadFontColor(HSSFColor.HSSFColorPredefined.WHITE)
                    .withHeadBgColor(HSSFColor.HSSFColorPredefined.DARK_BLUE)
                    .withColumnWidth(30)
                    .addSheet("数据")
                    .withHeaderList(headList)
                    .withColumnList(columnList);
            workbook = builder.build();
            jobPhaseNodeVo.setPageSize(20);
            Integer pageCount = jobPhaseNodeVo.getPageCount();
            for (int i = 1; i <= pageCount; i++) {
                jobPhaseNodeVo.setCurrentPage(i);
                list = searchJobPhaseSqlForExpport(jobPhaseNodeVo);
                Map<Long, Map<String, Object>> nodeDataMap = new LinkedHashMap<>();
                Map<String, List<Long>> runnerNodeMap = new HashMap<>();
                Map<Long, JSONObject> nodeLogTailParamMap = new HashMap<>();
                for (ISqlDetail vo : list) {
                    Map<String, Object> dataMap = new HashMap<>();
                    dataMap.put("name", vo.getSqlFile());
                    dataMap.put("host", vo.getHost() + (vo.getPort() != null ? ":" + vo.getPort() : ""));
                    dataMap.put("nodeName", vo.getNodeName());
                    dataMap.put("statusName", vo.getStatusName());
                    dataMap.put("costTime", vo.getCostTime());
                    dataMap.put("startTime", vo.getStartTime() != null ? TimeUtil.convertDateToString(vo.getStartTime(), TimeUtil.YYYY_MM_DD_HH_MM_SS) : "");
                    dataMap.put("endTime", vo.getEndTime() != null ? TimeUtil.convertDateToString(vo.getEndTime(), TimeUtil.YYYY_MM_DD_HH_MM_SS) : "");
                    nodeDataMap.put(vo.getId(), dataMap);
                    runnerNodeMap.computeIfAbsent(vo.getRunnerUrl(), k -> new ArrayList<>()).add(vo.getId());
                    nodeLogTailParamMap.put(vo.getId(), new JSONObject() {
                        {
                            this.put("id", vo.getId());
                            this.put("jobId", jobVo.getId());
                            this.put("resourceId", vo.getResourceId());
                            this.put("sqlName", vo.getSqlFile());
                            this.put("phase", phaseVo.getName());
                            this.put("ip", vo.getHost());
                            this.put("port", vo.getPort());
                            this.put("execMode", phaseVo.getExecMode());
                        }
                    });
                }
                for (Map.Entry<String, List<Long>> entry : runnerNodeMap.entrySet()) {
                    String url = entry.getKey() + "api/binary/job/phase/batchnode/log/tail";
                    List<Long> value = entry.getValue();
                    if (org.apache.commons.collections4.CollectionUtils.isNotEmpty(value)) {
                        JSONArray nodeList = new JSONArray();
                        value.forEach(o -> nodeList.add(nodeLogTailParamMap.get(o)));
                        JSONObject paramJson = new JSONObject();
                        paramJson.put("nodeList", nodeList);
                        paramJson.put("wordCountLimit", 2048);
                        ByteArrayOutputStream bos = new ByteArrayOutputStream();
                        HttpRequestUtil requestUtil = HttpRequestUtil.download(url, "POST", bos)
                                .setPayload(paramJson.toJSONString())
                                .setAuthType(AuthenticateType.BUILDIN)
                                .setConnectTimeout(5000)
                                .setReadTimeout(5000)
                                .sendRequest();
                        String error = requestUtil.getError();
                        if (StringUtils.isNotBlank(error)) {
                            continue;
                        }
                        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
                        InputStreamReader isr = new InputStreamReader(bis);
                        JSONReader jsonReader = new JSONReader(isr);
                        jsonReader.startArray();
                        while (jsonReader.hasNext()) {
                            JSONObject nodeObj = jsonReader.readObject(JSONObject.class);
                            Long id = nodeObj.getLong("id");
                            String content = nodeObj.getString("content");
                            Map<String, Object> map = nodeDataMap.get(id);
                            if (map != null) {
                                map.put("log", content);
                            }
                        }
                        jsonReader.endArray();
                        jsonReader.close();
                        try {
                            bis.close();
                            bos.close();
                        } catch (IOException e) {

                        }
                    }
                }
                nodeDataMap.values().forEach(sheetBuilder::addData);
            }
        }
        return workbook;
    }

    protected abstract int getJobPhaseSqlCount(AutoexecJobPhaseNodeVo jobPhaseNodeVo);

    protected abstract List<ISqlDetail> searchJobPhaseSqlForExpport(AutoexecJobPhaseNodeVo jobPhaseNodeVo);
}
