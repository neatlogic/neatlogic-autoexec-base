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

import neatlogic.framework.util.$;

import java.util.Objects;

public enum ParamMode {
    INPUT("input", "入参"),
    OUTPUT("output", "出参");
    private String value;
    private String text;

    private ParamMode(String value, String text) {
        this.value = value;
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return $.t(text);
    }

    public static ParamMode getParamMode(String _value) {
        for (ParamMode e : values()) {
            if (Objects.equals(e.getValue(), _value)) {
                return e;
            }
        }
        return null;
    }
}
