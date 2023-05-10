/*
Copyright(c) 2023 NeatLogic Co., Ltd. All Rights Reserved.

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

public enum ScriptAction {
    SWITCH_VERSION("switchversion", "enum.autoexec.scriptaction.switch_version", "enum.autoexec.scriptaction.switch_version.1", true),
    DISABLE("disable", "enum.autoexec.scriptaction.disable", "enum.autoexec.scriptaction.disable.1", true),
    DELETE("delete", "enum.autoexec.scriptaction.delete", "enum.autoexec.scriptaction.delete.1", true),
    SUBMIT("submit", "enum.autoexec.scriptaction.submit", "enum.autoexec.scriptaction.submit.1", true),
    PASS("pass", "enum.autoexec.scriptaction.pass", "enum.autoexec.scriptaction.pass.1", true),
    REJECT("reject", "enum.autoexec.scriptaction.reject", "enum.autoexec.scriptaction.reject.1", true),
    REVOKE("revoke", "enum.autoexec.scriptaction.revoke", "enum.autoexec.scriptaction.revoke.1", true);
    private String value;
    private String text;
    private String title;
    private boolean needReplaceParam;

    private ScriptAction(String value, String text, String title, boolean needReplaceParam) {
        this.value = value;
        this.text = text;
        this.title = title;
        this.needReplaceParam = needReplaceParam;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return I18nUtils.getMessage(text);
    }

    public String getTitle() {
        return I18nUtils.getMessage(title);
    }

    public static boolean isNeedReplaceParam(String _value) {
        for (ScriptAction operate : values()) {
            if (operate.value.equals(_value)) {
                return operate.needReplaceParam;
            }
        }
        return false;
    }

    public static String getTitle(String _value) {
        for (ScriptAction operate : values()) {
            if (operate.value.equals(_value)) {
                return operate.getTitle();
            }
        }
        return "";
    }

}
