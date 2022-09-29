package codedriver.framework.autoexec.job;

import codedriver.framework.autoexec.dto.AutoexecJobSourceVo;
import codedriver.framework.autoexec.dto.INodeDetail;
import codedriver.framework.autoexec.dto.job.AutoexecJobPhaseNodeVo;
import codedriver.framework.autoexec.dto.job.AutoexecJobPhaseVo;
import codedriver.framework.autoexec.dto.job.AutoexecJobVo;
import codedriver.framework.autoexec.exception.AutoexecJobSourceInvalidException;
import codedriver.framework.autoexec.source.AutoexecJobSourceFactory;
import codedriver.framework.integration.authentication.enums.AuthenticateType;
import codedriver.framework.util.HttpRequestUtil;
import codedriver.framework.util.excel.ExcelBuilder;
import codedriver.framework.util.excel.SheetBuilder;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONReader;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class AutoexecJobPhaseNodeExportHandlerBase implements IAutoexecJobPhaseNodeExportHandler {

    @Resource
    MongoTemplate mongoTemplate;

    @Override
    final public void exportJobPhaseNodeWithNodeOutputParam(ExcelBuilder excelBuilder, AutoexecJobPhaseNodeVo jobPhaseNodeVo, AutoexecJobVo jobVo, AutoexecJobPhaseVo phaseVo, Map<String, List<String>> outputParamMap, List<String> headList, List<String> columnList) {
        exportJobPhaseNode(excelBuilder, jobPhaseNodeVo, jobVo, phaseVo, headList, columnList, true, false, outputParamMap);
    }

    @Override
    public void exportJobPhaseNodeWithNodeLog(ExcelBuilder excelBuilder, AutoexecJobPhaseNodeVo jobPhaseNodeVo, AutoexecJobVo jobVo, AutoexecJobPhaseVo phaseVo, List<String> headList, List<String> columnList) {
        exportJobPhaseNode(excelBuilder, jobPhaseNodeVo, jobVo, phaseVo, headList, columnList, false, true, null);
    }

    private void exportJobPhaseNode(ExcelBuilder excelBuilder, AutoexecJobPhaseNodeVo jobPhaseNodeVo, AutoexecJobVo jobVo, AutoexecJobPhaseVo phaseVo, List<String> headList, List<String> columnList, boolean withOutputParam, boolean withNodeLog, Map<String, List<String>> outputParamMap) {
        AutoexecJobSourceVo jobSourceVo = AutoexecJobSourceFactory.getSourceMap().get(jobVo.getSource());
        if (jobSourceVo == null) {
            throw new AutoexecJobSourceInvalidException(jobVo.getSource());
        }
        int count = getJobPhaseNodeCount(jobPhaseNodeVo, jobSourceVo.getType());
        if (count > 0) {
            List<? extends INodeDetail> list;
            jobPhaseNodeVo.setRowNum(count);
            SheetBuilder sheetBuilder = excelBuilder.addSheet(phaseVo.getName())
                    .withHeaderList(headList)
                    .withColumnList(columnList);
            jobPhaseNodeVo.setPageSize(20);
            Integer pageCount = jobPhaseNodeVo.getPageCount();
            for (int i = 1; i <= pageCount; i++) {
                jobPhaseNodeVo.setCurrentPage(i);
                list = searchJobPhaseNode(jobPhaseNodeVo, jobSourceVo.getType());
                Map<Long, Map<String, Object>> nodeDataMap = new LinkedHashMap<>();
                Map<String, List<Long>> runnerNodeMap = new HashMap<>();
                Map<Long, JSONObject> nodeLogTailParamMap = new HashMap<>();
                Map<Long, String> nodeOutputParamMap = null;
                if (withOutputParam) {
                    if (MapUtils.isNotEmpty(outputParamMap)) {
                        List<JSONObject> nodeOutputList = mongoTemplate.find(new Query(Criteria.where("jobId").is(jobVo.getId().toString()).and("resourceId").in(list.stream().map(INodeDetail::getResourceId).collect(Collectors.toList()))), JSONObject.class, "_node_output");
                        if (CollectionUtils.isNotEmpty(nodeOutputList)) {
                            nodeOutputParamMap = getNodeOutputParamMap(outputParamMap, nodeOutputList);
                        }
                    }
                }
                assembleData(jobVo, phaseVo, list, nodeDataMap, runnerNodeMap, nodeLogTailParamMap, nodeOutputParamMap);
                if (withNodeLog) {
                    getNodeLog(nodeDataMap, runnerNodeMap, nodeLogTailParamMap);
                }
                nodeDataMap.values().forEach(sheetBuilder::addData);
            }
        }
    }

    private Map<Long, String> getNodeOutputParamMap(Map<String, List<String>> outputParamMap, List<JSONObject> nodeOutputList) {
        Map<Long, String> nodeOutputParamMap = new HashMap<>();
//            List<JSONObject> nodeOutputList = mongoTemplate.find(new Query(Criteria.where("jobId").is("725123329744896").and("resourceId").in(722231667515396L, 722231105478660L, 722190294900740L, 497544614174720L, 497544396070912L)), JSONObject.class, "_node_output");
        for (JSONObject object : nodeOutputList) {
            Long resourceId = object.getLong("resourceId");
            JSONObject data = object.getJSONObject("data");
            if (MapUtils.isNotEmpty(data)) {
                JSONObject param = new JSONObject();
                for (Map.Entry<String, Object> entry : data.entrySet()) {
                    List<String> outputParamKey = outputParamMap.get(entry.getKey());
                    if (CollectionUtils.isNotEmpty(outputParamKey)) {
                        Object value = entry.getValue();
                        if (value instanceof LinkedHashMap) {
                            ((LinkedHashMap<String, Object>) value).forEach((paramKey, paramValue) -> {
                                if (outputParamKey.contains(paramKey)) {
                                    param.put(paramKey, paramValue);
                                }
                            });
                        }
                    }
                }
                nodeOutputParamMap.put(resourceId, param.toJSONString());
            }
        }
        return nodeOutputParamMap;
    }

    private void getNodeLog(Map<Long, Map<String, Object>> nodeDataMap, Map<String, List<Long>> runnerNodeMap, Map<Long, JSONObject> nodeLogTailParamMap) {
        for (Map.Entry<String, List<Long>> entry : runnerNodeMap.entrySet()) {
            String url = entry.getKey() + "api/binary/job/phase/batchnode/log/tail";
            List<Long> value = entry.getValue();
            if (CollectionUtils.isNotEmpty(value)) {
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
    }

    /**
     * 查询节点总数
     *
     * @param jobPhaseNodeVo 用于查询的vo
     * @param source         作业来源
     * @return
     */
    protected abstract int getJobPhaseNodeCount(AutoexecJobPhaseNodeVo jobPhaseNodeVo, String source);

    /**
     * 分页查询节点
     *
     * @param jobPhaseNodeVo 用于查询的vo
     * @param source         作业来源
     * @return
     */
    protected abstract List<? extends INodeDetail> searchJobPhaseNode(AutoexecJobPhaseNodeVo jobPhaseNodeVo, String source);

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
    protected abstract void assembleData(AutoexecJobVo jobVo, AutoexecJobPhaseVo phaseVo, List<? extends INodeDetail> nodeList, Map<Long, Map<String, Object>> nodeDataMap, Map<String, List<Long>> runnerNodeMap, Map<Long, JSONObject> nodeLogTailParamMap, Map<Long, String> nodeOutputParamMap);
}
