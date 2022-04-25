package codedriver.framework.autoexec.constvalue;

import codedriver.framework.autoexec.script.paramtype.ScriptParamTypeFactory;
import codedriver.framework.common.constvalue.IEnum;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Objects;

/**
 * @author longrf
 * @date 2022/4/20 2:29 下午
 */
public enum AutoexecGlobalParamType implements IEnum {
    TEXT("text", "文本", "文本参数，可输入字符串、数字"),
    PASSWORD("password", "密码",  "可输入数字或字符串，页面显示为密文"),
    DATE("date", "日期",  "日期选择器"),
    DATETIME("datetime", "日期时间", "日期时间选择器"),
    TIME("time", "时间", "时间选择器");

    private final String value;
    private final String text;
    private final String description;

    AutoexecGlobalParamType(String value, String text, String description) {
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

    public static AutoexecGlobalParamType getParamType(String _value) {
        for (AutoexecGlobalParamType e : values()) {
            if (Objects.equals(e.getValue(), _value)) {
                return e;
            }
        }
        return null;
    }

    @Override
    public List getValueTextList() {
        JSONArray resultList = new JSONArray();
        for (AutoexecGlobalParamType e : values()) {
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
