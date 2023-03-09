package neatlogic.framework.autoexec.constvalue;

import neatlogic.framework.util.I18nUtils;

/**
 * @author lvzk
 * @date 2022/04/28 4:16 下午
 */
public enum JobSourceType {
    AUTOEXEC("auto","enum.autoexec.jobsourcetype.autoexec");

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
        return I18nUtils.getMessage(text);
    }
}
