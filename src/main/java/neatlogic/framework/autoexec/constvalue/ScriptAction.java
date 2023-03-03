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

public enum ScriptAction {
    SWITCH_VERSION("switchversion", "切换版本", "从版本${DATA.oldVersion}切换到版本${DATA.newVersion}", true),
    DISABLE("disable", "禁用", "禁用了版本${DATA.version}", true),
    DELETE("delete", "删除版本", "删除了版本${DATA.version}", true),
    SUBMIT("submit", "提交", "提交了版本${DATA.version}", true),
    PASS("pass", "通过", "通过了版本${DATA.version}", true),
    REJECT("reject", "驳回", "驳回了版本${DATA.version}", true),
    REVOKE("revoke", "撤回", "撤回了提交版本${DATA.version}", true);
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
        return text;
    }

    public String getTitle() {
        return title;
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
                return operate.title;
            }
        }
        return "";
    }

}
