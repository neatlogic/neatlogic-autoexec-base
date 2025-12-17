/*
 * Copyright (C) 2025  TechSure Co., Ltd.  All Rights Reserved.
 * This file is part of the NeatLogic software.
 * Licensed under the NeatLogic Sustainable Use License (NSUL), Version 4.x – 2025.
 * You may use this file only in compliance with the License.
 * See the LICENSE file distributed with this work for the full license text.
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */

package neatlogic.framework.autoexec.dto.combop;

import neatlogic.framework.common.dto.BasePageVo;

import java.util.List;

public class AutoexecCombopSearchVo extends BasePageVo {
    private String versionStatus;
    private Long typeId;
    private Integer IsActive;
    private List<String> uuidList;
    private Integer isHasAllAuthority;
    private String userUuid;
    private String action;
    public String getVersionStatus() {
        return versionStatus;
    }

    public void setVersionStatus(String status) {
        this.versionStatus = status;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Integer getIsActive() {
        return IsActive;
    }

    public void setIsActive(Integer isActive) {
        IsActive = isActive;
    }

    public List<String> getUuidList() {
        return uuidList;
    }

    public void setUuidList(List<String> uuidList) {
        this.uuidList = uuidList;
    }

    public Integer getIsHasAllAuthority() {
        return isHasAllAuthority;
    }

    public void setIsHasAllAuthority(Integer isHasAllAuthority) {
        this.isHasAllAuthority = isHasAllAuthority;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
