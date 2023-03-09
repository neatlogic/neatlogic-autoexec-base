/*
 * Copyright(c) 2023 NeatLogic Co., Ltd. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package neatlogic.framework.autoexec.dto.service;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;
import neatlogic.framework.util.SnowflakeUtil;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AutoexecServiceVo implements Serializable {

    private static final long serialVersionUID = 9045187703084309758L;

    @EntityField(name = "唯一标识ID", type = ApiParamType.LONG)
    private Long id;

    @EntityField(name = "名称", type = ApiParamType.STRING)
    private String name;

    @EntityField(name = "父级ID", type = ApiParamType.LONG)
    private Long parentId;

    @EntityField(name = "是否启用，0：禁用，1：启用", type = ApiParamType.INTEGER)
    private Integer isActive;

    @EntityField(name = "描述", type = ApiParamType.STRING)
    private String description;

    @EntityField(name = "类型", type = ApiParamType.STRING)
    private String type;

    @EntityField(name = "授权对象", type = ApiParamType.JSONARRAY)
    private List<String> authorityList;

    @EntityField(name = "组合工具ID", type = ApiParamType.LONG)
    private Long combopId;

    @EntityField(name = "表单", type = ApiParamType.STRING)
    private String formUuid;

    @EntityField(name = "是否已收藏", type = ApiParamType.INTEGER)
    private Integer isFavorite;

    @EntityField(name = "左编码", type = ApiParamType.INTEGER)
    private Integer lft;

    @EntityField(name = "右编码", type = ApiParamType.INTEGER)
    private Integer rht;

    @EntityField(name = "配置信息", type = ApiParamType.JSONOBJECT)
    private AutoexecServiceConfigVo config;

    @JSONField(serialize = false)
    private String configStr;

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