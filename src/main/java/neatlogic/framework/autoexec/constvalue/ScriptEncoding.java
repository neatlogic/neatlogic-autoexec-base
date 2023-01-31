/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.autoexec.constvalue;

import neatlogic.framework.common.constvalue.IEnum;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public enum ScriptEncoding implements IEnum {
    UTF8("UTF-8"),
    GBK("GBK");
    private final String value;

    ScriptEncoding(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ScriptEncoding getScriptEncode(String value) {
        for (ScriptEncoding encoding : ScriptEncoding.values()) {
            if (encoding.getValue().equals(value)) {
                return encoding;
            }
        }
        return null;
    }


    @Override
    public List getValueTextList() {
        JSONArray resultList = new JSONArray();
        for (ScriptEncoding e : values()) {
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("value", e.getValue());
            jsonObj.put("text", e.getValue());
            resultList.add(jsonObj);
        }
        return resultList;
    }
}
