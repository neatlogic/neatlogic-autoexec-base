/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.constvalue;

import codedriver.framework.autoexec.script.paramtype.ScriptParamTypeFactory;
import codedriver.framework.common.constvalue.IEnum;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Objects;

/**
 * 全局参数类型枚举类
 *
 * @author: linbq
 * @since: 2021/4/15 14:26
 **/
public enum ParamType implements IEnum {
    TEXT("text", "文本", "文本参数，可输入字符串、数字"),
    PASSWORD("password", "密码",  "可输入数字或字符串，页面显示为密文"),
    FILE("file", "文件",  "支持多个文件同时上传，执行时，自动上传文件到目标主机特定目录下，保留原文件名"),
    FILEPATH("filepath", "文件路径",  "输入文件路径"),
    DATE("date", "日期",  "日期选择器"),
    DATETIME("datetime", "日期时间", "日期时间选择器"),
    TIME("time", "时间", "时间选择器"),
    JSON("json", "json对象","支持json对象和json数组，输入内容需是合法Json格式"),
    SELECT("select", "单选下拉", "单选下拉选择器"),
    MULTISELECT("multiselect", "多选下拉", "多选下拉选择器"),
    RADIO("radio", "单选", "单选选择器"),
    CHECKBOX("checkbox", "复选", "复选选择器"),
    NODE("node", "节点信息", "将节点的相关信息生成脚本变量，但不会分派到该节点执行"),
    ACCOUNT("account", "账号", "服务的连接协议、帐号，用户连接主机上的数据库，中间件等服务");

    private final String value;
    private final String text;
    private final String description;

    ParamType(String value, String text, String description) {
        this.value = value;
        this.text = text;
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    public String getDescription() {
        return description;
    }

    public static ParamType getParamType(String _value) {
        for (ParamType e : values()) {
            if (Objects.equals(e.getValue(), _value)) {
                return e;
            }
        }
        return null;
    }

    /**
     * @Description: 不同的枚举类，返回不同的枚举值，可自由组合成List<>或者JSONArray
     * @Author: laiwt
     * @Date: 2021/1/12 14:57
     * @Params: []
     * @Returns: java.util.List
     **/
    @Override
    public List getValueTextList() {
        JSONArray resultList = new JSONArray();
        for (ParamType e : values()) {
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("value", e.getValue());
            jsonObj.put("text", e.getText());
            jsonObj.put("config", ScriptParamTypeFactory.getHandler(e.getValue()).getConfig());
            jsonObj.put("description", e.getDescription());
            resultList.add(jsonObj);
        }
        return resultList;
    }
}
