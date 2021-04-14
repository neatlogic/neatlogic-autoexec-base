/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.constvalue;

/**
 * @author: linbq
 * @since: 2021/4/14 7:38
 **/
public enum CombopAuthorityAction {
    EDIT("edit", "编辑"), EXECUTE("execute", "执行");
    private String value;
    private String text;

    private CombopAuthorityAction(String value, String text) {
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
