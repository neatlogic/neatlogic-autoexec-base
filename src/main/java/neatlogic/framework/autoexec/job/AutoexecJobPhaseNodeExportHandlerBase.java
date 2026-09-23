package neatlogic.framework.autoexec.job;

import com.alibaba.fastjson.JSONException;
import neatlogic.framework.autoexec.dto.INodeDetail;
import neatlogic.framework.autoexec.dto.job.AutoexecJobPhaseNodeVo;
import neatlogic.framework.autoexec.dto.job.AutoexecJobPhaseVo;
import neatlogic.framework.autoexec.dto.job.AutoexecJobVo;
import neatlogic.framework.autoexec.exception.AutoexecJobSourceInvalidException;
import neatlogic.framework.autoexec.source.AutoexecJobSourceFactory;
import neatlogic.framework.autoexec.source.IAutoexecJobSource;
import neatlogic.framework.integration.authentication.enums.AuthenticateType;
import neatlogic.framework.util.HttpRequestUtil;
import neatlogic.framework.util.excel.ExcelBuilder;
import neatlogic.framework.util.excel.SheetBuilder;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONReader;
import com.alibaba.fastjson.serializer.SerializerFeature;
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

    private static final String PASSWORD_MASK = "******";
    private static final int EXCEL_CELL_MAX_LENGTH = 32767;
    private static final String META_KEY = "_meta";

    @Resource
    MongoTemplate mongoTemplate;

    @Override
    final public void exportJobPhaseNodeWithNodeOutputParam(AutoexecJobVo jobVo, AutoexecJobPhaseVo phaseVo, Map<String, AutoexecJobOutputParamExportConfig> outputParamConfigMap, ExcelBuilder excelBuilder, List<String> headList, List<String> columnList) {
        exportJobPhaseNode(jobVo, phaseVo, true, false, outputParamConfigMap, excelBuilder, headList, columnList);
    }

    @Override
    final public void exportJobPhaseNodeWithNodeLog(AutoexecJobVo jobVo, AutoexecJobPhaseVo phaseVo, ExcelBuilder excelBuilder, List<String> headList, List<String> columnList) {
        exportJobPhaseNode(jobVo, phaseVo, false, true, null, excelBuilder, headList, columnList);
    }

    /**
     * 导出节点
     *
     * @param jobVo           作业
     * @param phaseVo         阶段
     * @param withOutputParam 是否需要导出节点输出参数
     * @param withNodeLog     是否需要导出节点日志
     * @param outputParamConfigMap 工具与输出参数导出配置的映射
     * @param excelBuilder    excelBuilder
     * @param headList        表头中文名
     * @param columnList      表头英文名
     */
    private void exportJobPhaseNode(AutoexecJobVo jobVo, AutoexecJobPhaseVo phaseVo, boolean withOutputParam, boolean withNodeLog, Map<String, AutoexecJobOutputParamExportConfig> outputParamConfigMap, ExcelBuilder excelBuilder, List<String> headList, List<String> columnList) {
        IAutoexecJobSource jobSource = AutoexecJobSourceFactory.getEnumInstance(jobVo.getSource());
        if (jobSource == null) {
            throw new AutoexecJobSourceInvalidException(jobVo.getSource());
        }
        AutoexecJobPhaseNodeVo searchVo = new AutoexecJobPhaseNodeVo(jobVo.getId(), phaseVo.getId());
        int count = getJobPhaseNodeCount(searchVo, jobSource.getType());
        if (count > 0) {
            List<? extends INodeDetail> list;
            searchVo.setRowNum(count);
            SheetBuilder sheetBuilder = excelBuilder.addSheet(phaseVo.getName())
                    .withHeaderList(headList)
                    .withColumnList(columnList);
            searchVo.setPageSize(20);
            Integer pageCount = searchVo.getPageCount();
            for (int i = 1; i <= pageCount; i++) {
                searchVo.setCurrentPage(i);
                list = searchJobPhaseNode(searchVo, jobSource.getType());
                Map<Long, Map<String, Object>> nodeDataMap = new LinkedHashMap<>();
                Map<String, List<Long>> runnerNodeMap = new HashMap<>();
                Map<Long, JSONObject> nodeLogTailParamMap = new HashMap<>();
                Map<Long, String> nodeOutputParamMap = null;
                if (withOutputParam && MapUtils.isNotEmpty(outputParamConfigMap)) {
                    List<JSONObject> nodeOutputList = mongoTemplate.find(new Query(Criteria.where("jobId").is(jobVo.getId().toString())
                                    .and("resourceId").in(list.stream().map(INodeDetail::getResourceId).collect(Collectors.toList())))
                            , JSONObject.class, "_node_output");
                    if (CollectionUtils.isNotEmpty(nodeOutputList)) {
                        nodeOutputParamMap = getNodeOutputParamMap(outputParamConfigMap, nodeOutputList);
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

    /**
     * 获取节点输出参数
     *
     * @param outputParamConfigMap 工具与输出参数导出配置的映射
     * @param nodeOutputList 从mongodb查询的节点输出参数值
     * @return 节点resourceId与输出参数的映射
     */
    protected Map<Long, String> getNodeOutputParamMap(Map<String, AutoexecJobOutputParamExportConfig> outputParamConfigMap, List<JSONObject> nodeOutputList) {
        Map<Long, String> nodeOutputParamMap = new HashMap<>();
        for (JSONObject object : nodeOutputList) {
            Long resourceId = object.getLong("resourceId");
            JSONObject data = object.getJSONObject("data");
            if (MapUtils.isNotEmpty(data)) {
                JSONObject outputParamJson = new JSONObject(new LinkedHashMap<>());
                for (Map.Entry<String, Object> entry : data.entrySet()) {
                    AutoexecJobOutputParamExportConfig outputParamConfig = outputParamConfigMap.get(entry.getKey());
                    if (outputParamConfig != null) {
                        Object value = entry.getValue();
                        if (value instanceof Map) {
                            JSONObject operationOutputJson = new JSONObject(new LinkedHashMap<>());
                            ((Map<String, Object>) value).forEach((paramKey, paramValue) -> {
                                if (outputParamConfig.isIncluded(paramKey)) {
                                    if (outputParamConfig.isPassword(paramKey)) {
                                        operationOutputJson.put(paramKey, PASSWORD_MASK);
                                    } else if (paramValue == null) {
                                        operationOutputJson.put(paramKey, null);
                                    } else {
                                        try {
                                            JSONObject json = JSONObject.parseObject(paramValue.toString());
                                            operationOutputJson.put(paramKey, json);
                                        } catch (JSONException e) {
                                            operationOutputJson.put(paramKey, paramValue);
                                        }
                                    }
                                }
                            });
                            if (MapUtils.isNotEmpty(operationOutputJson)) {
                                outputParamJson.put(entry.getKey(), operationOutputJson);
                            }
                        }
                    }
                }
                nodeOutputParamMap.put(resourceId, serializeWithinExcelCellLimit(outputParamJson));
            }
        }
        return nodeOutputParamMap;
    }

    /**
     * 将输出参数序列化为合法 JSON；超过 Excel 单元格上限时仅省略完整字段并添加截断标记。
     */
    private String serializeWithinExcelCellLimit(JSONObject outputParamJson) {
        String content = toJSONString(outputParamJson);
        if (content.length() <= EXCEL_CELL_MAX_LENGTH) {
            return content;
        }
        JSONObject truncatedJson = new JSONObject(new LinkedHashMap<>());
        JSONObject metaJson = new JSONObject(new LinkedHashMap<>());
        metaJson.put("truncated", true);
        truncatedJson.put(META_KEY, metaJson);
        for (Map.Entry<String, Object> operationEntry : outputParamJson.entrySet()) {
            if (!(operationEntry.getValue() instanceof Map)) {
                continue;
            }
            JSONObject retainedOperationJson = new JSONObject(new LinkedHashMap<>());
            truncatedJson.put(operationEntry.getKey(), retainedOperationJson);
            for (Map.Entry<String, Object> paramEntry : ((Map<String, Object>) operationEntry.getValue()).entrySet()) {
                retainedOperationJson.put(paramEntry.getKey(), paramEntry.getValue());
                if (toJSONString(truncatedJson).length() > EXCEL_CELL_MAX_LENGTH) {
                    retainedOperationJson.remove(paramEntry.getKey());
                }
            }
            if (retainedOperationJson.isEmpty()) {
                truncatedJson.remove(operationEntry.getKey());
            }
        }
        return toJSONString(truncatedJson);
    }

    /**
     * 序列化输出参数并保留值为 null 的字段。
     */
    private String toJSONString(JSONObject outputParamJson) {
        return JSONObject.toJSONString(outputParamJson, SerializerFeature.WriteMapNullValue);
    }

    /**
     * 获取节点日志
     *
     * @param nodeDataMap         节点数据map
     * @param runnerNodeMap       runner地址与节点的映射
     * @param nodeLogTailParamMap 节点与日志请求参数的映射
     */
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
