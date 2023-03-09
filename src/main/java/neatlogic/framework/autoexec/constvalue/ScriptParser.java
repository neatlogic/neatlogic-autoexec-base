/*
Copyright(c) $today.year NeatLogic Co., Ltd. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License. 
 */

package neatlogic.framework.autoexec.constvalue;

import neatlogic.framework.common.constvalue.IEnum;
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