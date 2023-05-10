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

/**
 * @author: laiwt
 * @since: 2021/5/27 11:15
 **/
public enum ScriptAndToolOperate {
    EDIT("edit", "enum.autoexec.scriptandtooloperate.edit"),
    DELETE("delete", "enum.autoexec.scriptandtooloperate.delete"),
    VERSION_DELETE("delete", "enum.autoexec.scriptandtooloperate.version_delete"),
    COPY("copy", "enum.autoexec.scriptandtooloperate.copy"),
    TEST("test", "enum.autoexec.scriptandtooloperate.test"),
    COMPARE("compare", "enum.autoexec.scriptandtooloperate.compare"),
    VALIDATE("validate", "enum.autoexec.scriptandtooloperate.validate"),
    SAVE("save", "enum.autoexec.scriptandtooloperate.save"),
    SUBMIT("submit", "enum.autoexec.scriptandtooloperate.submit"),
    PASS("pass", "enum.autoexec.scriptandtooloperate.pass"),
    REJECT("reject", "enum.autoexec.scriptandtooloperate.reject"),
    GENERATETOCOMBOP("generateToCombop", "enum.autoexec.scriptandtooloperate.generatetocombop"),
    EXPORT("export", "enum.autoexec.scriptandtooloperate.export"),
    ACTIVE("active", "enum.autoexec.scriptandtooloperate.active"),
    SWITCH_VERSION("switchversion", "enum.autoexec.scriptandtooloperate.switch_version"),
    REVOKE("revoke", "enum.autoexec.scriptandtooloperate.revoke");
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
        return I18nUtils.getMessage(text);
    }

}
