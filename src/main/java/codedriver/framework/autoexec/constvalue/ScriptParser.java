/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.constvalue;

import codedriver.framework.common.constvalue.IEnum;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public enum ScriptParser implements IEnum {
    PYTHON("python"),
    RUBY("ruby"),
    VBS("vbscript"),
    PERL("perl"),
    POWERSHELL("powershell"),
    CMD("cmd"),
    BASH("bash"),
    KSH("ksh"),
    CSH("csh"),
    SH("sh"),
    JAVASCRIPT("javascript");
    private final String value;

    private ScriptParser(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ScriptParser getScriptParser(String value) {
        for (ScriptParser parser : ScriptParser.values()) {
            if (parser.getValue().equals(value)) {
                return parser;
            }
        }
        return null;
    }


    @Override
    public List getValueTextList() {
        JSONArray resultList = new JSONArray();
        for (ScriptParser e : values()) {
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("value", e.getValue());
            jsonObj.put("text", e.getValue());
            resultList.add(jsonObj);
        }
        return resultList;
    }
}
