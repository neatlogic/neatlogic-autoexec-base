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
    SWITCH_VERSION("switchversion", "nfacv.scriptaction.text.switch_version", "nfacv.scriptaction.description.switch_version", true),
    DISABLE("disable", "nfacv.scriptaction.text.disable", "nfacv.scriptaction.description.disable", true),
    DELETE("delete", "nfacv.scriptaction.text.delete", "nfacv.scriptaction.description.delete", true),
    SUBMIT("submit", "nfacv.scriptaction.text.submit", "nfacv.scriptaction.description.submit", true),
    PASS("pass", "term.autoexec.approve", "nfacv.scriptaction.description.pass", true),
    REJECT("reject", "common.reject", "nfacv.scriptaction.description.reject", true),
    REVOKE("revoke", "common.recall", "nfacv.scriptaction.description.revoke", true);
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
