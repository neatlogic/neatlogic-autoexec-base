package neatlogic.framework.autoexec.constvalue;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import neatlogic.framework.autoexec.script.paramtype.ScriptParamTypeFactory;
import neatlogic.framework.common.constvalue.IEnum;
import neatlogic.framework.util.$;

import java.util.List;
import java.util.Objects;

/**
 * @author longrf
 * @date 2022/4/20 2:29 下午
 */
public enum AutoexecGlobalParamType implements IEnum {
    TEXT("text", "nfacv.autoexecglobalparamtype.text.text", "nfacv.autoexecglobalparamtype.description.text"),
    PASSWORD("password", "common.password", "nmaspt.common.description.password"),
    DATE("date", "nfacv.autoexecglobalparamtype.text.date", "nmaspt.common.description.date"),
    DATETIME("datetime", "nfacv.autoexecglobalparamtype.text.datetime", "nmaspt.common.description.datetime"),
    TIME("time", "common.time", "nmaspt.common.description.time"),
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
        return $.t(text);
    }

    public String getDescription() {
        return $.t(description);
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
