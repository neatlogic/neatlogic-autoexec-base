package codedriver.framework.autoexec.constvalue;

/**
 * @author lvzk
 * @since 2021/4/27 15:40
 **/
public enum JobAction {
    FIRE("fire", "执行"),
    PAUSE("pause", "暂停"),
    ABORT("abort", "中止"),
    RESET_NODE("reset_node", "重置节点"),
    IGNORE_NODE("reset_node", "重置节点"),
    GOON("goon","继续"),
    REFIRE("refire","重新执行");
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
