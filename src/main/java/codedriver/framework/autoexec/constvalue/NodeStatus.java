/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.constvalue;

/**
 * @author: linbq
 * @since: 2021/4/23 14:28
 **/
public enum NodeStatus {
    NORMAL("normal", "正常", "#25b865"),
    USER_NOT_FOUND("user_not_found", "执行用户不存在","#ffff66"),
    NODE_NOT_FOUND("node_not_found", "执行目标不存在","#f71010");
    private final String value;
    private final String text;
    private final String color;
    private NodeStatus(String value, String text, String color) {
        this.value = value;
        this.text = text;
        this.color = color;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    public String getColor() {
        return color;
    }
}
