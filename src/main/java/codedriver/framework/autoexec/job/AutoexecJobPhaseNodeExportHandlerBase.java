package codedriver.framework.autoexec.job;

import codedriver.framework.autoexec.dto.INodeDetail;
import codedriver.framework.autoexec.dto.job.AutoexecJobPhaseNodeVo;
import codedriver.framework.autoexec.dto.job.AutoexecJobPhaseVo;
import codedriver.framework.autoexec.dto.job.AutoexecJobVo;
import codedriver.framework.integration.authentication.enums.AuthenticateType;
import codedriver.framework.util.HttpRequestUtil;
import codedriver.framework.util.excel.ExcelBuilder;
import codedriver.framework.util.excel.SheetBuilder;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONReader;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class AutoexecJobPhaseNodeExportHandlerBase implements IAutoexecJobPhaseNodeExportHandler {

    @Override
    final public Workbook exportJobPhaseNode(AutoexecJobPhaseNodeVo jobPhaseNodeVo, AutoexecJobVo jobVo, AutoexecJobPhaseVo phaseVo, List<String> headList, List<String> columnList) {
        Workbook workbook = null;
        int count = getJobPhaseNodeCount(jobPhaseNodeVo);
        if (count > 0) {
            List<? extends INodeDetail> list;
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
                list = searchJobPhaseNode(jobPhaseNodeVo);
                Map<Long, Map<String, Object>> nodeDataMap = new LinkedHashMap<>();
                Map<String, List<Long>> runnerNodeMap = new HashMap<>();
                Map<Long, JSONObject> nodeLogTailParamMap = new HashMap<>();
                assembleData(jobVo, phaseVo, list, nodeDataMap, runnerNodeMap, nodeLogTailParamMap);
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

    /**
     * 查询节点总数
     *
     * @param jobPhaseNodeVo 用于查询的vo
     * @return
     */
    protected abstract int getJobPhaseNodeCount(AutoexecJobPhaseNodeVo jobPhaseNodeVo);

    /**
     * 分页查询节点
     *
     * @param jobPhaseNodeVo 用于查询的vo
     * @return
     */
    protected abstract List<? extends INodeDetail> searchJobPhaseNode(AutoexecJobPhaseNodeVo jobPhaseNodeVo);

    /**
     * 组装一些必要的数据
     *
     * @param jobVo               作业
     * @param phaseVo             阶段
     * @param nodeList            节点列表
     * @param nodeDataMap         除去日志的表格数据
     * @param runnerNodeMap       runner地址与节点列表的map
     * @param nodeLogTailParamMap 请求runner获取日志的参数map
     */
    protected abstract void assembleData(AutoexecJobVo jobVo, AutoexecJobPhaseVo phaseVo, List<? extends INodeDetail> nodeList, Map<Long, Map<String, Object>> nodeDataMap, Map<String, List<Long>> runnerNodeMap, Map<Long, JSONObject> nodeLogTailParamMap);
}
