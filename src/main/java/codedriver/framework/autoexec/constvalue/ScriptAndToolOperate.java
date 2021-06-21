/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.constvalue;

/**
 * @author: laiwt
 * @since: 2021/5/27 11:15
 **/
public enum ScriptAndToolOperate {
    DELETE("delete", "删除"),
    VERSION_DELETE("delete", "删除"),
    COPY("copy", "复制"),
    TEST("test", "测试"),
    COMPARE("compare", "对比"),
    VALIDATE("validate", "校验"),
    SAVE("save", "保存"),
    SUBMIT("submit", "提交审核"),
    PASS("pass", "通过"),
    REJECT("reject", "驳回"),
    GENERATETOCOMBOP("generateToCombop", "发布为组合工具"),
    EXPORT("export", "导出"),
    ACTIVE("active", "启用/禁用"),
    SWITCH_VERSION("switchversion","回退");
    private final String value;
    private final String text;

    ScriptAndToolOperate(String value, String text) {
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
