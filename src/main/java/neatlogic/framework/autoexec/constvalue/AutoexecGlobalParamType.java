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
    TEXT("text", "common.text", "common.textparameter,caninputstrings,numbers"),
    PASSWORD("password", "common.password", "common.passworddesc"),
    DATE("date", "common.date", "common.dateform"),
    DATETIME("datetime", "common.datatime", "common.datetimeform"),
    TIME("time", "common.time", "common.timeform"),
    TEXTAREA("textarea", "common.textarea", "common.textarea"),
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
