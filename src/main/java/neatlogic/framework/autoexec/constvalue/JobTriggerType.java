/*
 *
 * Copyright (C) 2025  TechSure Co., Ltd.  All Rights Reserved.
 * This file is part of the NeatLogic software.
 * Licensed under the NeatLogic Sustainable Use License (NSUL), Version 4.x – 2025.
 * You may use this file only in compliance with the License.
 * See the LICENSE file distributed with this work for the full license text.
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 */

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
