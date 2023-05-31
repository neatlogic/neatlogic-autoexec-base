package neatlogic.framework.autoexec.constvalue;

import neatlogic.framework.autoexec.script.paramtype.ScriptParamTypeFactory;
import neatlogic.framework.common.constvalue.IEnum;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import neatlogic.framework.util.I18nUtils;

import java.util.List;
import java.util.Objects;

/**
 * @author longrf
 * @date 2022/4/20 2:29 下午
 */
public enum AutoexecGlobalParamType implements IEnum {
    TEXT("text", "enum.autoexec.autoexecglobalparamtype.text.a", "enum.autoexec.autoexecglobalparamtype.text.b"),
    PASSWORD("password", "enum.autoexec.autoexecglobalparamtype.password.a", "enum.autoexec.autoexecglobalparamtype.password.b"),
    DATE("date", "enum.autoexec.autoexecglobalparamtype.date.a", "enum.autoexec.autoexecglobalparamtype.date.b"),
    DATETIME("datetime", "enum.autoexec.autoexecglobalparamtype.datetime.a", "enum.autoexec.autoexecglobalparamtype.datetime.b"),
    TIME("time", "enum.autoexec.autoexecglobalparamtype.time.a", "enum.autoexec.autoexecglobalparamtype.time.b"),
    TEXTAREA("textarea", "enum.autoexec.autoexecglobalparamtype.textarea", "enum.autoexec.autoexecglobalparamtype.textarea"),
    ;

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
        return I18nUtils.getMessage(text);
    }

    public String getDescription() {
        return I18nUtils.getMessage(description);
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
