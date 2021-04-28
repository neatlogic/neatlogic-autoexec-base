package codedriver.framework.autoexec.constvalue;

/**
 * @author lvzk
 * @since 2021/4/27 15:40
 **/
public enum JobAction {
    EXEC("exec", "执行"), PAUSE("pause", "暂停"), STOP("stop", "中止"),RESET("reset", "重置");
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
