/*Copyright (C) 2023  深圳极向量科技有限公司 All Rights Reserved.

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
 * @author: linbq
 * @since: 2021/4/23 14:28
 **/
public enum NodeStatus {
    NORMAL("normal", "正常", "#25b865"),
    USER_NOT_FOUND("user_not_found", "执行用户不存在","#ffff66"),
    NODE_NOT_FOUND("node_not_found", "执行目标不存在","#f71010");
    private final String value;
    private final String text;
    private final String color;
    private NodeStatus(String value, String text, String color) {
        this.value = value;
        this.text = text;
        this.color = color;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return $.t(text);
    }

    public String getColor() {
        return color;
    }
}
