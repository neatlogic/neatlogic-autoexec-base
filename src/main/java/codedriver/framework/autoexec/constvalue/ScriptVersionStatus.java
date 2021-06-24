/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.constvalue;

public enum ScriptVersionStatus {
    DRAFT("draft", "草稿"),
    SUBMITTED("submitted", "待审核"),
    PASSED("passed", "已通过"),
    REJECTED("rejected", "已驳回"),
    CURRENT("current", "激活"),
    HISTORY("history", "历史");
    private String value;
    private String text;

    ScriptVersionStatus(String value, String text) {
        this.value = value;
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    public static String getText(String _value) {
        for (ScriptVersionStatus status : values()) {
            if (status.value.equals(_value)) {
                return status.text;
            }
        }
        return "";
    }

}
