/*Copyright (C) $today.year  深圳极向量科技有限公司 All Rights Reserved.

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

import neatlogic.framework.util.$;

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
        return $.t(text);
    }

    public String getTitle() {
        return $.t(title);
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
