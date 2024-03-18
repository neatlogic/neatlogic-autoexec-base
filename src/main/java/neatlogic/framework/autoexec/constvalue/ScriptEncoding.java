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
