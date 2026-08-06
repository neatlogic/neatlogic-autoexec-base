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

/**
 * 组合工具操作类型
 * @author: linbq
 * @since: 2021/4/13 14:43
 **/
public enum CombopOperationType {
    COMBOP("combop", "nfacv.combopoperationtype.text.combop"),
    SCRIPT("script", "term.autoexec.script"),
    TOOL("tool", "term.autoexec.tool");

    private CombopOperationType(String value, String text) {
        this.value = value;
        this.text = text;
    }

    private final String value;
    private final String text;

    public String getValue() {
        return value;
    }

    public String getText() {
        return $.t(text);
    }

    public static String getText(String name) {
        for (CombopOperationType s : CombopOperationType.values()) {
            if (s.getValue().equals(name)) {
                return s.getText();
            }
        }
        return "";
    }
}
