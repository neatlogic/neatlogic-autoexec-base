/*
 * Copyright(c) 2023 NeatLogic Co., Ltd. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package neatlogic.framework.autoexec.constvalue;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import neatlogic.framework.common.constvalue.IEnum;
import neatlogic.framework.util.I18nUtils;
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
        return I18nUtils.getMessage(text);
    }

    public static String getText(String _status) {
        for (JobTriggerType s : JobTriggerType.values()) {
            if (s.getValue().equals(_status)) {
                try {
                    return I18nUtils.getMessage(s.getText());
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
                        this.put("text", I18nUtils.getMessage(value.getText()));
                    } catch (NoSuchMessageException ignored) {
                        this.put("text", value.getText());
                    }
                }
            });
        }
        return array;
    }
}
