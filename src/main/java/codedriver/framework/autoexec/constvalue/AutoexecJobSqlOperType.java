package codedriver.framework.autoexec.constvalue;

/**
 * @author longrf
 * @date 2022/4/27 2:50 下午
 */
public enum AutoexecJobSqlOperType {

    AUTO("auto", "自动化"),
    DEPLOY("deploy", "发布");
    private String value;
    private String text;

    private AutoexecJobSqlOperType(String value, String text) {
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
