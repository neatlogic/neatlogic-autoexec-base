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
import neatlogic.framework.util.$;

import java.util.List;
import java.util.Objects;

public enum ExecMode implements IEnum {
    RUNNER("runner", "nfac.execmode.text.runner", "nfac.execmode.description.runner"),
    TARGET("target", "nfac.execmode.text.target", "nfac.execmode.description.target"),
    RUNNER_TARGET("runner_target", "nfac.execmode.text.runner_target", "nfac.execmode.description.runner_target"),
    SQL("sqlfile", "nfac.execmode.text.sqlfile", "nfac.execmode.description.sqlfile");
    private final String value;
    private final String text;
    private final String description;

    ExecMode(String value, String text, String description) {
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

    public static ExecMode getExecMode(String _value) {
        for (ExecMode e : ExecMode.values()) {
            if (e.getValue().equals(_value)) {
                return e;
            }
        }
        return null;
    }

    public String getDescription() {
        return $.t(description);
    }

    public static String getText(String _value) {
        for (ExecMode e : values()) {
            if (Objects.equals(e.getValue(), _value)) {
                return e.getText();
            }
        }
        return "";
    }
    /**
     * @Description: 不同的枚举类，返回不同的枚举值，可自由组合成List<>或者JSONArray
     * @Author: laiwt
     * @Date: 2021/1/12 14:57
     * @Params: []
     * @Returns: java.util.List
     **/
    @Override
    public List getValueTextList() {
        JSONArray resultList = new JSONArray();
        for (ExecMode e : values()) {
            JSONObject obj = new JSONObject();
            obj.put("value", e.getValue());
            obj.put("text", e.getText());
            obj.put("description", e.getDescription());
            resultList.add(obj);
        }
        return resultList;
    }
}
