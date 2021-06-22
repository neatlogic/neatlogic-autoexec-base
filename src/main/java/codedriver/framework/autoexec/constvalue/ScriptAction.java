/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.constvalue;

public enum ScriptAction {
    SWITCH_VERSION("switchversion", "切换版本", "从版本${DATA.oldVersion}切换到版本${DATA.newVersion}", true),
    DISABLE("disable", "禁用", "禁用了版本${DATA.version}", true),
    DELETE("delete", "删除版本", "删除了版本${DATA.version}", true),
    SUBMIT("submit", "提交", "提交了版本${DATA.version}", true),
    PASS("pass", "通过", "通过了版本${DATA.version}", true),
    REJECT("reject", "驳回", "驳回了版本${DATA.version}", true);
    private String value;
    private String text;
    private String title;
    private boolean needReplaceParam;

    private ScriptAction(String value, String text, String title, boolean needReplaceParam) {
        this.value = value;
        this.text = text;
        this.title = title;
        this.needReplaceParam = needReplaceParam;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    public String getTitle() {
        return title;
    }

    public static boolean isNeedReplaceParam(String _value) {
        for (ScriptAction operate : values()) {
            if (operate.value.equals(_value)) {
                return operate.needReplaceParam;
            }
        }
        return false;
    }

    public static String getTitle(String _value) {
        for (ScriptAction operate : values()) {
            if (operate.value.equals(_value)) {
                return operate.title;
            }
        }
        return "";
    }

}
