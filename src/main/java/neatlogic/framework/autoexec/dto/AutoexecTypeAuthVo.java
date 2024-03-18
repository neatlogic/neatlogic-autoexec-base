/*Copyright (C) 2024  深圳极向量科技有限公司 All Rights Reserved.

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
package neatlogic.framework.autoexec.dto;

import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;

import java.io.Serializable;

/**
 * @author longrf
 * @date 2022/11/29 16:40
 */

public class AutoexecTypeAuthVo implements Serializable {

    @EntityField(name = "工具分类id", type = ApiParamType.LONG)
    private Long typeId;
    @EntityField(name = "授权对象类型", type = ApiParamType.STRING)
    private String authType;
    @EntityField(name = "授权对象uuid", type = ApiParamType.STRING)
    private String authUuid;
    @EntityField(name = "操作类型", type = ApiParamType.STRING)
    private String action;

    public AutoexecTypeAuthVo() {
    }

    public AutoexecTypeAuthVo(Long typeId, String action, String authType, String authUuid) {
        this.typeId = typeId;
        this.action = action;
        this.authType = authType;
        this.authUuid = authUuid;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }

    public String getAuthUuid() {
        return authUuid;
    }

    public void setAuthUuid(String authUuid) {
        this.authUuid = authUuid;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
