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
