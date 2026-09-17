package neatlogic.framework.autoexec.constvalue;

import neatlogic.framework.util.$;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * 统一业务动作及审计展示元数据，审计配置不改变处理器分发。
 * @author lvzk
 * @since 2021/4/27 15:40
 **/
public enum JobAction {
    FIRE("fire", "执行", "job", "execute"),
    PAUSE("pause", "暂停", "job", "pause"),
    ABORT("abort", "中止", "job", "abort"),
    CHECK("check", "验证", "job", "check"),
    RESET_NODE("resetNode", "重置节点", "node", "reset"),
    IGNORE_NODE("ignoreNode", "忽略节点", "node", "ignore"),
    IGNORE_PHASE("ignorePhase", "忽略阶段", "phase", "ignore"),
    GOON("goon", "继续", "node", "interact"),
    RESET_REFIRE("refireResetAll", "重置并重新执行", "job", "refire"),
    REFIRE_NODE("refireNode", "重新执行节点", "node", "refire"),
    REFIRE_PHASE("refirePhase", "重新执行节点", "phase", "refire"),
    REFIRE("refireAll", "重新执行", "job", "refire"),
    GET_NODE_SQL_LIST("getNodeSqlList", "获取节点sql列表"),
    GET_NODE_SQL_CONTENT("getNodeSqlContent", "获取节点sql内容"),
    DOWNLOAD_NODE_SQL_FILE("downloadNodeSqlFile", "下载节点sql文件"),
    GET_NODE_OUTPUT_PARAM("getNodeOutputParam", "获取节点出参"),
    GET_NODE_OPERATION_INPUT_PARAM("getNodeOperationInputParam", "获取节点工具入参"),
    SUBMIT_NODE_WAIT_INPUT("submitNodeWaitInput", "获取节点出参", "node", "interact"),
    DOWNLOAD_NODE_AUDIT("downloadNodeAudit", "下载节点记录"),
    NODE_AUDIT_LIST("nodeAuditList", "获取节点记录"),
    CONSOLE_LOG_TAIL("consoleLogTail", "获取控制台日志"),
    CONSOLE_LOG_AUDIT_LIST("consoleLogAuditList", "获取控制台日志记录列表"),
    DOWNLOAD_CONSOLE_LOG_AUDIT("downloadConsoleLogAuditList", "下载控制台日志记录"),
    DOWNLOAD_CONSOLE_LOG("downloadConsoleLog", "下载控制台日志"),
    DOWNLOAD_NODE_LOG("downloadNodeLog", "下载节点日志"),
    DOWNLOAD_NODE_OUT_PUT("downloadNodeOutPut", "下载节点输出参数"),
    DOWNLOAD_NODE_IN_PUT("downloadNodeInput", "下载节点输入参数"),
    TAIL_NODE_LOG("tailNodeLog", "获取节点日志"),
    GET_NODE_OPERATION_LIST("getNodeOperationList", "获取节点操作列表"),
    INFORM_PHASE_ROUND("informPhaseRound", "通知下一个phase round"),
    TAKE_OVER("takeOver", "接管", "job", "takeover"),
    GET_OPERATION_CUSTOM_DATA("getOperationCustomData", "获取工具个性化数据"),
    REVOKE("revoke", "撤销", "job", "revoke"),
    RESET_SQL("resetSql", "重置 SQL 文件", "sql", "reset");

    private final String value;
    private final String text;
    private final String auditObjectType;
    private final String auditGroup;

    /** 非审计动作保留原有业务定义，不参与审计选项生成。 */
    JobAction(String value, String text) {
        this(value, text, null, null);
    }

    /** 审计元数据只描述入口语义，不触发记录或改变业务分发。 */
    JobAction(String value, String text, String objectType, String group) {
        this.value = value;
        this.text = text;
        this.auditObjectType = objectType;
        this.auditGroup = group;
    }

    public boolean isAuditAction() { return auditGroup != null; }
    public String getAuditObjectType() { return auditObjectType; }
    public String getAuditGroup() { return auditGroup; }

    /** 业务动作编码与筛选组名统一解析，未知值原样保留。 */
    public static String normalizeAuditAction(String action) {
        for (JobAction candidate : values()) {
            if (!candidate.isAuditAction()) { continue; }
            if (candidate.value.equals(action) || candidate.auditGroup.equals(action)) { return candidate.auditGroup; }
        }
        return action;
    }

    /** 查询同一展示组对应的业务动作编码。 */
    public static List<String> getAuditQueryValues(String action) {
        Set<String> codes = new LinkedHashSet<>();
        String group = normalizeAuditAction(action);
        for (JobAction candidate : values()) {
            if (candidate.isAuditAction() && candidate.auditGroup.equals(group)) {
                codes.add(candidate.value);
            }
        }
        // 未知编码维持精确查询，避免退化为无条件查询。
        if (codes.isEmpty()) { codes.add(action); }
        return new ArrayList<>(codes);
    }

    /** 返回去重后的审计代表动作，供筛选选项生成使用。 */
    public static List<JobAction> getAuditActions() {
        Set<String> groups = new LinkedHashSet<>();
        List<JobAction> actions = new ArrayList<>();
        for (JobAction candidate : values()) {
            if (candidate.isAuditAction() && groups.add(candidate.auditGroup)) { actions.add(candidate); }
        }
        return actions;
    }

    /** 审计名称不携带对象类型，不影响既有业务名称。 */
    public String getAuditText() { return $.t("autoexec.operationaudit.action." + auditGroup); }

    public String getValue() {
        return this.value;
    }

    public String getText() {
        return $.t(this.text);
    }
}
