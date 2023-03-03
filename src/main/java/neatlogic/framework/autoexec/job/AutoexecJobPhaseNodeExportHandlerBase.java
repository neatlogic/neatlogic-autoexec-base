package neatlogic.framework.autoexec.job;

import neatlogic.framework.autoexec.dto.AutoexecJobSourceVo;
import neatlogic.framework.autoexec.dto.INodeDetail;
import neatlogic.framework.autoexec.dto.job.AutoexecJobPhaseNodeVo;
import neatlogic.framework.autoexec.dto.job.AutoexecJobPhaseVo;
import neatlogic.framework.autoexec.dto.job.AutoexecJobVo;
import neatlogic.framework.autoexec.exception.AutoexecJobSourceInvalidException;
import neatlogic.framework.autoexec.source.AutoexecJobSourceFactory;
import neatlogic.framework.integration.authentication.enums.AuthenticateType;
import neatlogic.framework.util.HttpRequestUtil;
import neatlogic.framework.util.excel.ExcelBuilder;
import neatlogic.framework.util.excel.SheetBuilder;
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
    final public void exportJobPhaseNodeWithNodeOutputParam(AutoexecJobVo jobVo, AutoexecJobPhaseVo phaseVo, Map<String, List<String>> outputParamMap, ExcelBuilder excelBuilder, List<String> headList, List<String> columnList) {
        exportJobPhaseNode(jobVo, phaseVo, true, false, outputParamMap, excelBuilder, headList, columnList);
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
     * @param outputParamMap  工具与输出参数名称的映射
     * @param excelBuilder    excelBuilder
     * @param headList        表头中文名
     * @param columnList      表头英文名
     */
    private void exportJobPhaseNode(AutoexecJobVo jobVo, AutoexecJobPhaseVo phaseVo, boolean withOutputParam, boolean withNodeLog, Map<String, List<String>> outputParamMap, ExcelBuilder excelBuilder, List<String> headList, List<String> columnList) {
        AutoexecJobSourceVo jobSourceVo = AutoexecJobSourceFactory.getSourceMap().get(jobVo.getSource());
        if (jobSourceVo == null) {
            throw new AutoexecJobSourceInvalidException(jobVo.getSource());
        }
        AutoexecJobPhaseNodeVo searchVo = new AutoexecJobPhaseNodeVo(jobVo.getId(), phaseVo.getId());
        int count = getJobPhaseNodeCount(searchVo, jobSourceVo.getType());
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
                list = searchJobPhaseNode(searchVo, jobSourceVo.getType());
                Map<Long, Map<String, Object>> nodeDataMap = new LinkedHashMap<>();
                Map<String, List<Long>> runnerNodeMap = new HashMap<>();
                Map<Long, JSONObject> nodeLogTailParamMap = new HashMap<>();
                Map<Long, String> nodeOutputParamMap = null;
                if (withOutputParam) {
                    if (MapUtils.isNotEmpty(outputParamMap)) {
                        List<JSONObject> nodeOutputList = mongoTemplate.find(new Query(Criteria.where("jobId").is(jobVo.getId().toString())
                                        .and("resourceId").in(list.stream().map(INodeDetail::getResourceId).collect(Collectors.toList())))
                                , JSONObject.class, "_node_output");
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

    /**
     * 获取节点输出参数
     *
     * @param outputParamMap 工具与输出参数名称的映射
     * @param nodeOutputList 从mongodb查询的节点输出参数值
     * @return 节点resourceId与输出参数的映射
     */
    private Map<Long, String> getNodeOutputParamMap(Map<String, List<String>> outputParamMap, List<JSONObject> nodeOutputList) {
        Map<Long, String> nodeOutputParamMap = new HashMap<>();
        for (JSONObject object : nodeOutputList) {
            Long resourceId = object.getLong("resourceId");
            JSONObject data = object.getJSONObject("data");
            if (MapUtils.isNotEmpty(data)) {
                StringBuilder sb = new StringBuilder();
                for (Map.Entry<String, Object> entry : data.entrySet()) {
                    List<String> outputParamKey = outputParamMap.get(entry.getKey());
                    if (CollectionUtils.isNotEmpty(outputParamKey)) {
                        Object value = entry.getValue();
                        if (value instanceof Map) {
                            ((Map<String, Object>) value).forEach((paramKey, paramValue) -> {
                                if (outputParamKey.contains(paramKey)) {
                                    sb.append((new JSONObject() {
                                        {
                                            this.put(paramKey, paramValue);
                                        }
                                    }).toJSONString()).append(";");
                                }
                            });
                        }
                    }
                }
                String content = sb.toString();
                if (content.length() > 2048) {
                    content = content.substring(0, 2048) + "\n更多内容请前往系统查看";
                }
                nodeOutputParamMap.put(resourceId, content);
            }
        }
        return nodeOutputParamMap;
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
