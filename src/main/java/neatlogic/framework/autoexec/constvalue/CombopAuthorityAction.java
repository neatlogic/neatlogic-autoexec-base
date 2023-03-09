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

import neatlogic.framework.util.I18nUtils;

/**
 * 组合工具授权类型
 *
 * @author: linbq
 * @since: 2021/4/14 7:38
 **/
public enum CombopAuthorityAction {
    EDIT("edit", "enum.autoexec.combopauthorityaction.edit"),
    EXECUTE("execute", "enum.autoexec.combopauthorityaction.execute"),
    VIEW("view", "enum.autoexec.combopauthorityaction.view");
    private String value;
    private String text;

    private CombopAuthorityAction(String value, String text) {
        this.value = value;
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return I18nUtils.getMessage(text);
    }
}