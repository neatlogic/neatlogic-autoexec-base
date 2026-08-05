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
 * @author: laiwt
 * @since: 2021/5/27 11:15
 **/
public enum ScriptAndToolOperate {
    EDIT("edit", "common.edit"),
    DELETE("delete", "common.delete"),
    VERSION_DELETE("delete", "common.delete"),
    COPY("copy", "common.copy"),
    TEST("test", "common.test"),
    COMPARE("compare", "common.compare"),
    VALIDATE("validate", "common.validate"),
    SAVE("save", "common.saveasdraft"),
    SUBMIT("submit", "common.commitcheck"),
    PASS("pass", "common.pass"),
    REJECT("reject", "common.reject"),
    GENERATETOCOMBOP("generateToCombop", "term.autoexec.generatetocombop"),
    EXPORT("export", "common.export"),
    ACTIVE("active", "nfac.scriptandtooloperate.active.text"),
    SWITCH_VERSION("switchversion", "nfpc.processtaskaudittype.text.back"),
    REVOKE("revoke", "common.recall");
    private final String value;
    private final String text;

    ScriptAndToolOperate(String value, String text) {
        this.value = value;
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return $.t(text);
    }

}
