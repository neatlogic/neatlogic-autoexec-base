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
