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

    @EntityField(name = "配置已失效", type = ApiParamType.INTEGER)
    private Integer configExpired;

    @EntityField(name = "配置失效原因", type = ApiParamType.JSONOBJECT)
    private JSONObject configExpiredReason;

    @EntityField(name = "配置信息", type = ApiParamType.JSONOBJECT)
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
