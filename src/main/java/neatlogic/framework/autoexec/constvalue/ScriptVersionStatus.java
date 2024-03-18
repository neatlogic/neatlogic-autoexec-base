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

public enum ScriptVersionStatus {
    DRAFT("draft", "草稿"),
    SUBMITTED("submitted", "待审核"),
    PASSED("passed", "已通过"),
    REJECTED("rejected", "已驳回"),
    CURRENT("current", "激活"),
    HISTORY("history", "历史");
    private String value;
    private String text;

    ScriptVersionStatus(String value, String text) {
        this.value = value;
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return $.t(text);
    }

    public static String getText(String _value) {
        for (ScriptVersionStatus status : values()) {
            if (status.value.equals(_value)) {
                return status.getText();
            }
        }
        return "";
    }

}
