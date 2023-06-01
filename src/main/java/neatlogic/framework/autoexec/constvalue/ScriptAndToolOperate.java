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
    EDIT("edit", "编辑"),
    DELETE("delete", "删除"),
    VERSION_DELETE("delete", "删除"),
    COPY("copy", "复制"),
    TEST("test", "测试"),
    COMPARE("compare", "对比"),
    VALIDATE("validate", "校验"),
    SAVE("save", "存为草稿"),
    SUBMIT("submit", "提交审核"),
    PASS("pass", "通过"),
    REJECT("reject", "驳回"),
    GENERATETOCOMBOP("generateToCombop", "发布为组合工具"),
    EXPORT("export", "导出"),
    ACTIVE("active", "启用/禁用"),
    SWITCH_VERSION("switchversion", "回退"),
    REVOKE("revoke", "撤回");
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
