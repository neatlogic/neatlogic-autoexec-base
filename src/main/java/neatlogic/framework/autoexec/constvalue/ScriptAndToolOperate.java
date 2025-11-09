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
        return $.t(text);
    }

}
