/*Copyright (C) 2024  深圳极向量科技有限公司 All Rights Reserved.

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
import neatlogic.framework.util.$;

import java.util.List;

public enum AutoexecParallelPolicy implements IEnum {
    PARALLEL("parallel", "并发"),
    ROUND_COUNT("roundCount", "分批");
    private final String value;
    private final String name;

    AutoexecParallelPolicy(String _value, String _name) {
        this.value = _value;
        this.name = _name;
    }

    @Override
    public List getValueTextList() {
        JSONArray resultList = new JSONArray();
        for (AutoexecParallelPolicy e : values()) {
            JSONObject obj = new JSONObject();
            obj.put("value", e.getValue());
            obj.put("text", e.getName());
            resultList.add(obj);
        }
        return resultList;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String getEnumName() {
        return IEnum.super.getEnumName();
    }

    public String getName() {
        return $.t(name);
    }

    public static String getValue(String _value) {
        for (AutoexecParallelPolicy s : AutoexecParallelPolicy.values()) {
            if (s.getValue().equals(_value)) {
                return s.getValue();
            }
        }
        return null;
    }

    public static String getName(String _value) {
        for (AutoexecParallelPolicy s : AutoexecParallelPolicy.values()) {
            if (s.getValue().equals(_value)) {
                return s.getName();
            }
        }
        return "";
    }

}
