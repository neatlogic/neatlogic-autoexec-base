/*Copyright (C) 2024  深圳极向量科技有限公司 All Rights Reserved.

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.*/

package neatlogic.framework.autoexec.constvalue;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import neatlogic.framework.autoexec.script.paramtype.ScriptParamTypeFactory;
import neatlogic.framework.common.constvalue.IEnum;
import neatlogic.framework.util.$;

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
    PASSWORD("password", "密码", "可输入数字或字符串，页面显示为密文"),
    FILE("file", "文件", "common.file"),
    DATE("date", "日期", "日期选择器"),
    DATETIME("datetime", "日期时间", "日期时间选择器"),
    TIME("time", "时间", "时间选择器"),
    JSON("json", "json对象", "支持json对象和json数组，输入内容需是合法Json格式"),
    SELECT("select", "单选下拉", "单选下拉选择器"),
    MULTISELECT("multiselect", "多选下拉", "多选下拉选择器"),
    RADIO("radio", "单选", "单选选择器"),
    CHECKBOX("checkbox", "复选", "复选选择器"),
    NODE("node", "节点信息", "将节点的相关信息生成脚本变量，但不会分派到该节点执行"),
    ACCOUNT("account", "账号", "common.account"),
    USERSELECT("userselect", "用户选择器", "用于选择系统用户、分组、角色"),
    TEXTAREA("textarea", "文本域", "可输入字符串、数字"),
    PHASE("phase", "阶段", "可选择阶段"),
    SWITCH("switch", "开关", "开关"),
    FILEPATH("filepath", "文件路径", "可输出文件路径参数");

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
        return $.t(text);
    }

    public String getDescription() {
        return $.t(description);
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
