package neatlogic.framework.autoexec.crossover;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import neatlogic.framework.crossover.ICrossoverService;
import java.util.Set;
import java.util.Map;
import java.util.function.Consumer;

/** 以当前工单身份按顺序解析目标并执行激活版本的脚本。 */
public interface IStepScriptExecrtoolService extends ICrossoverService {
    /** 根据已授权工单中的审计编号，批量读取实际执行版本的出参名称。 */
    Map<String, Map<String, String>> getOutputLabelsByAuditIds(Set<Long> auditIds);

    /** 每个目标结束后同步交付独立结果；回调失败时停止下发，以免丢失执行证据。 */
    void execute(Long taskId, JSONObject taskFields, JSONObject settings, Consumer<JSONObject> onResult) throws Exception;

    /** 校验手动执行所选版本及执行人的直接执行权限，返回脚本名称。 */
    String requireManualVersion(Long scriptId, Long versionId) throws Exception;

    /** 返回已授权脚本执行方式，校验当前版本的自由参数数量。 */
    String manualMode(Long scriptId, Long versionId, JSONArray args) throws Exception;
}
