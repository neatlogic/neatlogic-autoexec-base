/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.constvalue;

/**
 * 脚本执行失败策略枚举类
 *
 * @author: linbq
 * @since: 2021/4/14 18:08
 **/
public enum FailPolicy {
    redo("redo", "失败重做"),
    goon("goon", "失败继续"),
    stop("stop", "失败终止");

    private String value;
    private String text;

    private FailPolicy(String value, String text) {
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
