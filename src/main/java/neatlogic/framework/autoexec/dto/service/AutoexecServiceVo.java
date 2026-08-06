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

package neatlogic.framework.autoexec.dto.service;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;
import neatlogic.framework.util.SnowflakeUtil;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class AutoexecServiceVo implements Serializable {

    private static final long serialVersionUID = 9045187703084309758L;

    @EntityField(name = "nfad.autoexecservicevo.entityfield.id.name", type = ApiParamType.LONG)
    private Long id;

    @EntityField(name = "common.name", type = ApiParamType.STRING)
    private String name;

    @EntityField(name = "common.parentid", type = ApiParamType.LONG)
    private Long parentId;

    @EntityField(name = "nfad.autoexecservicevo.entityfield.isactive.name", type = ApiParamType.INTEGER)
    private Integer isActive;

    @EntityField(name = "common.description", type = ApiParamType.STRING)
    private String description;

    @EntityField(name = "common.type", type = ApiParamType.STRING)
    private String type;

    @EntityField(name = "nfad.autoexecservicevo.entityfield.authoritylist.name", type = ApiParamType.JSONARRAY)
    private List<String> authorityList;

    @EntityField(name = "term.autoexec.combopid", type = ApiParamType.LONG)
    private Long combopId;

    @EntityField(name = "nfad.autoexecservicevo.entityfield.formuuid.name", type = ApiParamType.STRING)
    private String formUuid;

    @EntityField(name = "nfad.autoexecservicevo.entityfield.isfavorite.name", type = ApiParamType.INTEGER)
    private Integer isFavorite;

    @EntityField(name = "common.lft", type = ApiParamType.INTEGER)
    private Integer lft;

    @EntityField(name = "common.rht", type = ApiParamType.INTEGER)
    private Integer rht;

    @EntityField(name = "nfad.autoexecservicevo.entityfield.configexpired.name", type = ApiParamType.INTEGER)
    private Integer configExpired;

    @EntityField(name = "nfad.autoexecservicevo.entityfield.configexpiredreason.name", type = ApiParamType.JSONOBJECT)
    private JSONObject configExpiredReason;

    @EntityField(name = "common.config", type = ApiParamType.JSONOBJECT)
    private AutoexecServiceConfigVo config;

    @JSONField(serialize = false)
    private String configStr;

    @JSONField(serialize = false)
    private String configExpiredReasonStr;

    public Long getId() {
        if (id == null) {
            id = SnowflakeUtil.uniqueLong();
        }
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getAuthorityList() {
        return authorityList;
    }

    public void setAuthorityList(List<String> authorityList) {
        this.authorityList = authorityList;
    }

    public Long getCombopId() {
        return combopId;
    }

    public void setCombopId(Long combopId) {
        this.combopId = combopId;
    }

    public String getFormUuid() {
        return formUuid;
    }

    public void setFormUuid(String formUuid) {
        this.formUuid = formUuid;
    }

    public Integer getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(Integer isFavorite) {
        this.isFavorite = isFavorite;
    }

    public Integer getLft() {
        return lft;
    }

    public void setLft(Integer lft) {
        this.lft = lft;
    }

    public Integer getRht() {
        return rht;
    }

    public void setRht(Integer rht) {
        this.rht = rht;
    }

    public Integer getConfigExpired() {
        return configExpired;
    }

    public void setConfigExpired(Integer configExpired) {
        this.configExpired = configExpired;
    }

    public JSONObject getConfigExpiredReason() {
        if (configExpiredReason == null && StringUtils.isNotBlank(configExpiredReasonStr)) {
            try {
                configExpiredReason = JSONObject.parseObject(configExpiredReasonStr);
            } catch (Exception ignored) {

            }
        }
        return configExpiredReason;
    }

    public void setConfigExpiredReason(JSONObject configExpiredReason) {
        this.configExpiredReasonStr = null;
        this.configExpiredReason = configExpiredReason;
    }

    public String getConfigExpiredReasonStr() {
        if (StringUtils.isBlank(configExpiredReasonStr) && configExpiredReason != null) {
            configExpiredReasonStr = JSONObject.toJSONString(configExpiredReason);
        }
        return configExpiredReasonStr;
    }

    public void setConfigExpiredReasonStr(String configExpiredReasonStr) {
        this.configExpiredReasonStr = configExpiredReasonStr;
    }

    public AutoexecServiceConfigVo getConfig() {
        if (config == null && StringUtils.isNotBlank(configStr)) {
            try {
                config = JSONObject.parseObject(configStr, AutoexecServiceConfigVo.class);
            } catch (Exception ignored) {

            }
        }
        return config;
    }

    public void setConfig(AutoexecServiceConfigVo config) {
        this.configStr = null;
        this.config = config;
    }

    public String getConfigStr() {
        if (StringUtils.isBlank(configStr) && config != null) {
            configStr = JSONObject.toJSONString(config);
        }
        return configStr;
    }

    public void setConfigStr(String configStr) {
        this.configStr = configStr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AutoexecServiceVo)) return false;
        AutoexecServiceVo nodeVo = (AutoexecServiceVo) o;
        return Objects.equals(getId(), nodeVo.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
