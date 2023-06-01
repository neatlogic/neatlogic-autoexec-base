package neatlogic.framework.autoexec.constvalue;

import neatlogic.framework.common.constvalue.IEnum;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import neatlogic.framework.util.I18nUtils;

import java.util.List;
import java.util.Objects;

/**
 * @author longrf
 * @date 2022/5/19 4:48 下午
 */
public enum AutoexecProfileParamInvokeType implements IEnum {
    GLOBAL_PARAM("globalparam", "全局参数"),
    CONSTANT("constant", "常量");

    private final String value;
    private final String text;

    AutoexecProfileParamInvokeType(String value, String text) {
        this.value = value;
        this.text = text;

    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return I18nUtils.getMessage(text);
    }


    public static AutoexecProfileParamInvokeType getParamType(String _value) {
        for (AutoexecProfileParamInvokeType e : values()) {
            if (Objects.equals(e.getValue(), _value)) {
                return e;
            }
        }
        return null;
    }

    @Override
    public List getValueTextList() {
        JSONArray array = new JSONArray();
        for (AutoexecProfileParamInvokeType type : AutoexecProfileParamInvokeType.values()) {
            array.add(new JSONObject() {
                {
                    this.put("value", type.getValue());
                    this.put("text", type.getText());
                }
            });
        }
        return array;
    }
}
