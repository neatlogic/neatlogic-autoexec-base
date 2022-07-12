package codedriver.framework.autoexec.constvalue;

/**
 * @author lvzk
 * @date 2022/04/28 4:16 下午
 */
public enum JobSourceType {
    AUTOEXEC("auto","自动化");

    private final String value;
    private final String text;

    private JobSourceType(String value, String text) {
        this.value = value;
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
}
