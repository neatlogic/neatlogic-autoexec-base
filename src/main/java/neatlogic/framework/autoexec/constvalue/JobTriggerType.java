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
import org.springframework.context.NoSuchMessageException;

import java.util.List;

public enum JobTriggerType implements IEnum {
    AUTO("自动", "auto"),
    MANUAL("手动", "manual");
    private final String text;
    private final String value;

    JobTriggerType(String _text, String _value) {
        this.text = _text;
        this.value = _value;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return $.t(text);
    }

    public static String getText(String _status) {
        for (JobTriggerType s : JobTriggerType.values()) {
            if (s.getValue().equals(_status)) {
                try {
                    return $.t(s.getText());
                } catch (NoSuchMessageException ignored) {
                    return s.getText();
                }

            }
        }
        return "";
    }

    @Override
    public List getValueTextList() {
        JSONArray array = new JSONArray();
        for (JobTriggerType value : JobTriggerType.values()) {
            array.add(new JSONObject() {
                {
                    this.put("value", value.getValue());
                    try {
                        this.put("text", $.t(value.getText()));
                    } catch (NoSuchMessageException ignored) {
                        this.put("text", value.getText());
                    }
                }
            });
        }
        return array;
    }
}
