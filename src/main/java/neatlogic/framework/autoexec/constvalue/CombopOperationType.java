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

import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.util.I18nUtils;

/**
 * 组合工具操作类型
 * @author: linbq
 * @since: 2021/4/13 14:43
 **/
public enum CombopOperationType {
    COMBOP("combop", "enum.autoexec.combopoperationtype.combop"),
    SCRIPT("script", "enum.autoexec.combopoperationtype.script"),
    TOOL("tool", "enum.autoexec.combopoperationtype.tool");

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
        return I18nUtils.getMessage(text);
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
