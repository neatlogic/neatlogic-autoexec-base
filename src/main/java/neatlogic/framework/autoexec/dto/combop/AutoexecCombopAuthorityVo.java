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
