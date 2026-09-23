package neatlogic.framework.autoexec.job;

import com.alibaba.fastjson.JSONObject;
import neatlogic.framework.autoexec.dto.INodeDetail;
import neatlogic.framework.autoexec.dto.job.AutoexecJobPhaseNodeVo;
import neatlogic.framework.autoexec.dto.job.AutoexecJobPhaseVo;
import neatlogic.framework.autoexec.dto.job.AutoexecJobVo;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/** 验证作业输出参数的阶段隔离、字段筛选和密码脱敏。 */
public class AutoexecJobPhaseNodeExportHandlerBaseTest {

    /** 未配置报告字段时导出当前操作的全部输出，并对密码值脱敏。 */
    @Test
    public void includeAllMasksPasswordAndExcludesOtherOperations() {
        TestExportHandler handler = new TestExportHandler();
        Map<String, AutoexecJobOutputParamExportConfig> configMap = new LinkedHashMap<>();
        configMap.put("demo/local_1", new AutoexecJobOutputParamExportConfig(true, Collections.emptyList(), Collections.singleton("outpassword")));

        Map<Long, String> result = handler.output(configMap, Collections.singletonList(nodeOutput()));

        JSONObject content = JSONObject.parseObject(result.get(100L));
        JSONObject operationOutput = content.getJSONObject("demo/local_1");
        Assert.assertEquals("text-value", operationOutput.getString("outtext"));
        Assert.assertEquals("******", operationOutput.getString("outpassword"));
        Assert.assertEquals("demo", operationOutput.getJSONObject("outjson").getString("name"));
        Assert.assertTrue(operationOutput.containsKey("emptyValue"));
        Assert.assertNull(operationOutput.get("emptyValue"));
        Assert.assertFalse(result.get(100L).contains("secret-value"));
        Assert.assertFalse(content.containsKey("other_2"));
        Assert.assertFalse(content.containsKey("nodeEnv"));
    }

    /** 存在显式报告配置时仅导出选中字段，选中的密码字段仍必须脱敏。 */
    @Test
    public void configuredFieldsRemainFilteredAndMasked() {
        TestExportHandler handler = new TestExportHandler();
        Map<String, AutoexecJobOutputParamExportConfig> configMap = new LinkedHashMap<>();
        configMap.put("demo/local_1", new AutoexecJobOutputParamExportConfig(false, Arrays.asList("outtext", "outpassword"), Collections.singleton("outpassword")));

        String content = handler.output(configMap, Collections.singletonList(nodeOutput())).get(100L);
        JSONObject operationOutput = JSONObject.parseObject(content).getJSONObject("demo/local_1");

        Assert.assertEquals(2, operationOutput.size());
        Assert.assertEquals("text-value", operationOutput.getString("outtext"));
        Assert.assertEquals("******", operationOutput.getString("outpassword"));
        Assert.assertFalse(content.contains("secret-value"));
    }

    /** 不同操作的同名参数必须保留在各自分组中。 */
    @Test
    public void keepsSameNamedParamsInSeparateOperationGroups() {
        TestExportHandler handler = new TestExportHandler();
        Map<String, AutoexecJobOutputParamExportConfig> configMap = new LinkedHashMap<>();
        configMap.put("demo/local_1", new AutoexecJobOutputParamExportConfig(true, Collections.emptyList(), Collections.emptyList()));
        configMap.put("other_2", new AutoexecJobOutputParamExportConfig(true, Collections.emptyList(), Collections.emptyList()));
        JSONObject nodeOutput = nodeOutput();
        nodeOutput.getJSONObject("data").getJSONObject("other_2").put("outtext", "other-text");

        JSONObject content = JSONObject.parseObject(handler.output(configMap, Collections.singletonList(nodeOutput)).get(100L));

        Assert.assertEquals("text-value", content.getJSONObject("demo/local_1").getString("outtext"));
        Assert.assertEquals("other-text", content.getJSONObject("other_2").getString("outtext"));
    }

    /** 超长值按完整字段省略，结果保持合法 JSON 并携带截断标记。 */
    @Test
    public void truncatesByWholeFieldAndKeepsValidJson() {
        TestExportHandler handler = new TestExportHandler();
        Map<String, AutoexecJobOutputParamExportConfig> configMap = new LinkedHashMap<>();
        configMap.put("demo/local_1", new AutoexecJobOutputParamExportConfig(true, Collections.emptyList(), Collections.emptyList()));
        JSONObject nodeOutput = nodeOutput();
        JSONObject operationOutput = nodeOutput.getJSONObject("data").getJSONObject("demo/local_1");
        operationOutput.put("oversized", repeat('x', 33000));
        operationOutput.put("afterOversized", "retained-value");

        String result = handler.output(configMap, Collections.singletonList(nodeOutput)).get(100L);
        JSONObject content = JSONObject.parseObject(result);

        Assert.assertTrue(result.length() <= 32767);
        Assert.assertTrue(content.getJSONObject("_meta").getBooleanValue("truncated"));
        Assert.assertFalse(content.getJSONObject("demo/local_1").containsKey("oversized"));
        Assert.assertEquals("retained-value", content.getJSONObject("demo/local_1").getString("afterOversized"));
    }

    /** 生成指定长度的测试字符串。 */
    private String repeat(char value, int count) {
        char[] values = new char[count];
        Arrays.fill(values, value);
        return new String(values);
    }

    /** 构造包含当前操作、其他操作和节点环境的 MongoDB 输出文档。 */
    private JSONObject nodeOutput() {
        JSONObject currentOperationOutput = new JSONObject(new LinkedHashMap<>());
        currentOperationOutput.put("outtext", "text-value");
        currentOperationOutput.put("outpassword", "secret-value");
        currentOperationOutput.put("outjson", "{\"name\":\"demo\"}");
        currentOperationOutput.put("emptyValue", null);
        JSONObject data = new JSONObject(new LinkedHashMap<>());
        data.put("nodeEnv", new JSONObject());
        data.put("demo/local_1", currentOperationOutput);
        JSONObject otherOperationOutput = new JSONObject(new LinkedHashMap<>());
        otherOperationOutput.put("otherValue", "value");
        data.put("other_2", otherOperationOutput);
        JSONObject result = new JSONObject();
        result.put("resourceId", 100L);
        result.put("data", data);
        return result;
    }

    /** 仅暴露待测输出格式化能力的导出处理器。 */
    private static class TestExportHandler extends AutoexecJobPhaseNodeExportHandlerBase {
        private Map<Long, String> output(Map<String, AutoexecJobOutputParamExportConfig> configMap, List<JSONObject> outputList) {
            return getNodeOutputParamMap(configMap, outputList);
        }

        @Override
        public String getName() {
            return "test";
        }

        @Override
        protected int getJobPhaseNodeCount(AutoexecJobPhaseNodeVo jobPhaseNodeVo, String source) {
            return 0;
        }

        @Override
        protected List<? extends INodeDetail> searchJobPhaseNode(AutoexecJobPhaseNodeVo jobPhaseNodeVo, String source) {
            return Collections.emptyList();
        }

        @Override
        protected void assembleData(AutoexecJobVo jobVo, AutoexecJobPhaseVo phaseVo, List<? extends INodeDetail> nodeList, Map<Long, Map<String, Object>> nodeDataMap, Map<String, List<Long>> runnerNodeMap, Map<Long, JSONObject> nodeLogTailParamMap, Map<Long, String> nodeOutputParamMap) {
        }
    }
}
