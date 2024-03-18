/*Copyright (C) 2023  深圳极向量科技有限公司 All Rights Reserved.

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
import neatlogic.framework.common.constvalue.IEnum;

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
    JAVASCRIPT("javascript"),
    PACKAGE("package");
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
