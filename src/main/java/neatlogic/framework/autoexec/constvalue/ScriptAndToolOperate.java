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
