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

package neatlogic.framework.autoexec.dto.combop;

import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;

/**
 * 组合工具授权Vo类
 *
 * @author: linbq
 * @since: 2021/4/13 9:58
 **/
public class AutoexecCombopAuthorityVo {

    @EntityField(name = "组合工具id", type = ApiParamType.LONG)
    private Long combopId;

    @EntityField(name = "授权目标类型，用户、组、角色", type = ApiParamType.STRING)
    private String type;

    @EntityField(name = "授权目标uuid", type = ApiParamType.STRING)
    private String uuid;

    @EntityField(name = "权限类型，执行或编辑", type = ApiParamType.STRING)
    private String action;

    public Long getCombopId() {
        return combopId;
    }

    public void setCombopId(Long combopId) {
        this.combopId = combopId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
