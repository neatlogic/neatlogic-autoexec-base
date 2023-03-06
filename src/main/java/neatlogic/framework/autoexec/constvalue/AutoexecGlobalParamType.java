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
    TEXT("text", "enum.autoexec.autoexecglobalparamtype.text", "enum.autoexec.autoexecglobalparamtype.text.1"),
    PASSWORD("password", "enum.autoexec.autoexecglobalparamtype.password", "enum.autoexec.autoexecglobalparamtype.password.1"),
    DATE("date", "enum.autoexec.autoexecglobalparamtype.date", "enum.autoexec.autoexecglobalparamtype.date.1"),
    DATETIME("datetime", "enum.autoexec.autoexecglobalparamtype.datetime", "enum.autoexec.autoexecglobalparamtype.datetime.1"),
    TIME("time", "enum.autoexec.autoexecglobalparamtype.time", "enum.autoexec.autoexecglobalparamtype.time.1"),
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
