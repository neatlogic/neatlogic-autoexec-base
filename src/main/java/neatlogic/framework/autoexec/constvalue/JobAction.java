package neatlogic.framework.autoexec.constvalue;

import neatlogic.framework.util.I18nUtils;

/**
 * @author lvzk
 * @since 2021/4/27 15:40
 **/
public enum JobAction {
    FIRE("fire", "common.execute"),
    PAUSE("pause", "common.pause"),
    ABORT("abort", "enum.autoexec.jobaction.abort"),
    CHECK("check", "enum.autoexec.jobaction.check"),
    RESET_NODE("resetNode", "enum.autoexec.jobaction.reset_node"),
    IGNORE_NODE("ignoreNode", "enum.autoexec.jobaction.ignore_node"),
    IGNORE_PHASE("ignorePhase", "enum.autoexec.jobaction.ignore_phase"),
    GOON("goon", "enum.autoexec.jobaction.goon"),
    RESET_REFIRE("refireResetAll", "enum.autoexec.jobaction.reset_refire"),
    REFIRE_NODE("refireNode", "common.re-executenode"),
    REFIRE_PHASE("refirePhase", "common.re-executenode"),
    REFIRE("refireAll", "enum.autoexec.jobaction.refire.a"),
    GET_NODE_SQL_LIST("getNodeSqlList", "enum.autoexec.jobaction.get_node_sql_list"),
    GET_NODE_SQL_CONTENT("getNodeSqlContent", "enum.autoexec.jobaction.get_node_sql_content"),
    DOWNLOAD_NODE_SQL_FILE("downloadNodeSqlFile", "enum.autoexec.jobaction.download_node_sql_file"),
    GET_NODE_OUTPUT_PARAM("getNodeOutputParam", "common.getnodeoutputparameters"),
    GET_NODE_OPERATION_INPUT_PARAM("getNodeOperationInputParam", "enum.autoexec.jobaction.get_node_operation_input_param"),
    SUBMIT_NODE_WAIT_INPUT("submitNodeWaitInput", "common.getnodeoutputparameters"),
    DOWNLOAD_NODE_AUDIT("downloadNodeAudit", "enum.autoexec.jobaction.download_node_audit"),
    NODE_AUDIT_LIST("nodeAuditList", "enum.autoexec.jobaction.node_audit_list"),
    CONSOLE_LOG_TAIL("consoleLogTail", "enum.autoexec.jobaction.console_log_tail"),
    CONSOLE_LOG_AUDIT_LIST("consoleLogAuditList", "enum.autoexec.jobaction.console_log_audit_list"),
    DOWNLOAD_CONSOLE_LOG_AUDIT("downloadConsoleLogAuditList", "enum.autoexec.jobaction.download_console_log_audit"),
    DOWNLOAD_CONSOLE_LOG("downloadConsoleLog", "enum.autoexec.jobaction.download_console_log.a"),
    DOWNLOAD_NODE_LOG("downloadNodeLog", "enum.autoexec.jobaction.download_node_log"),
    DOWNLOAD_NODE_OUT_PUT("downloadNodeOutPut", "enum.autoexec.jobaction.download_node_out_put"),
    DOWNLOAD_NODE_IN_PUT("downloadNodeInput", "enum.autoexec.jobaction.download_node_in_put"),
    TAIL_NODE_LOG("tailNodeLog", "enum.autoexec.jobaction.tail_node_log"),
    GET_NODE_OPERATION_LIST("getNodeOperationList", "enum.autoexec.jobaction.get_node_operation_list"),
    INFORM_PHASE_ROUND("informPhaseRound", "enum.autoexec.jobaction.inform_phase_round"),
    TAKE_OVER("takeOver", "enum.autoexec.jobaction.take_over"),
    GET_OPERATION_CUSTOM_DATA("getOperationCustomData", "enum.autoexec.jobaction.get_operation_custom_data"),
    ;

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
        return I18nUtils.getMessage(this.text);
    }
}
