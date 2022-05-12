package codedriver.framework.autoexec.constvalue;

/**
 * @author lvzk
 * @since 2021/4/27 15:40
 **/
public enum JobAction {
    FIRE("fire", "执行"),
    PAUSE("pause", "暂停"),
    ABORT("abort", "中止"),
    RESET_NODE("resetNode", "重置节点"),
    IGNORE_NODE("ignoreNode", "重置节点"),
    GOON("goon","继续"),
    RESET_REFIRE("refireResetAll","重置并重新执行"),
    REFIRE_NODE("refireNode","重新执行节点"),
    REFIRE_PHASE("refirePhase","重新执行节点"),
    REFIRE("refireAll","重新执行"),
    GET_NODE_SQL_LIST("getNodeSqlList","获取节点sql列表"),
    GET_NODE_SQL_CONTENT("getNodeSqlContent","获取节点sql内容"),
    GET_NODE_OUTPUT_PARAM("getNodeOutputParam","获取节点出参"),
    SUBMIT_NODE_WAIT_INPUT("submitNodeWaitInput","获取节点出参"),
    DOWNLOAD_NODE_AUDIT("downloadNodeAudit","下载节点记录"),
    NODE_AUDIT_LIST("nodeAuditList","获取节点记录"),
    CONSOLE_LOG_TAIL("consoleLogTail","获取控制台日志"),
    CONSOLE_LOG_AUDIT_LIST("consoleLogAuditList","获取控制台日志记录列表"),
    DOWNLOAD_CONSOLE_LOG_AUDIT("downloadConsoleLogAuditList","下载控制台日志记录"),
    DOWNLOAD_CONSOLE_LOG("downloadConsoleLog","下载控制台日志"),
    DOWNLOAD_NODE_LOG("downloadNodeLog","下载节点日志"),
    DOWNLOAD_NODE_OUT_PUT("downloadNodeOutPut","下载节点输出参数"),
    DELETE("delete","删除作业"),
    TAIL_NODE_LOG("tailNodeLog","获取节点日志"),
    INFORM_PHASE_ROUND("informPhaseRound","通知下一个phase round");
    private final String value;
    private final String text;

    JobAction(String _value, String _text) {
        this.value = _value;
        this.text = _text;
    }

    public String getValue() {
        return this.value;
    }

    public String getText() {
        return this.text;
    }
}
