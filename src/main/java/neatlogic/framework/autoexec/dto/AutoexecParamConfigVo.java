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

package neatlogic.framework.autoexec.dto;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;

import java.io.Serializable;

public class AutoexecParamConfigVo implements Serializable {

    @EntityField(name = "是否必填", type = ApiParamType.BOOLEAN)
    private Boolean isRequired;
    @EntityField(name = "类型", type = ApiParamType.STRING)
    private String type;
    @EntityField(name = "默认值", type = ApiParamType.NOAUTH)
    private Object defaultValue;
    @EntityField(name = "静态数据源列表", type = ApiParamType.JSONARRAY)
    private JSONArray dataList;
    @EntityField(name = "数据源类型", type = ApiParamType.STRING)
    private String dataSource;
    @EntityField(name = "矩阵UUID", type = ApiParamType.STRING)
    private String matrixUuid;
    @EntityField(name = "字段映射", type = ApiParamType.JSONOBJECT)
    private JSONObject mapping;
    @EntityField(name = "过滤条件", type = ApiParamType.JSONOBJECT)
    private JSONObject filter;
    @EntityField(name = "节点类型", type = ApiParamType.STRING)
    private String nodeType;
    @EntityField(name = "校验规则列表", type = ApiParamType.JSONARRAY)
    private JSONArray validateList;

    @EntityField(name = "用户、组、角色列表", type = ApiParamType.JSONARRAY)
    private JSONArray groupList;

    @EntityField(name = "是否多选", type = ApiParamType.INTEGER)
    private Integer isMultiple;

    public Boolean getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(Boolean required) {
        isRequired = required;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(Object defaultValue) {
        this.defaultValue = defaultValue;
    }

    public JSONArray getDataList() {
        return dataList;
    }

    public void setDataList(JSONArray dataList) {
        this.dataList = dataList;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public String getMatrixUuid() {
        return matrixUuid;
    }

    public void setMatrixUuid(String matrixUuid) {
        this.matrixUuid = matrixUuid;
    }

    public JSONObject getMapping() {
        return mapping;
    }

    public void setMapping(JSONObject mapping) {
        this.mapping = mapping;
    }

    public JSONObject getFilter() {
        return filter;
    }

    public void setFilter(JSONObject filter) {
        this.filter = filter;
    }

    public String getNodeType() {
        return nodeType;
    }

    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }

    public JSONArray getValidateList() {
        return validateList;
    }

    public void setValidateList(JSONArray validateList) {
        this.validateList = validateList;
    }

    public JSONArray getGroupList() {
        return groupList;
    }

    public void setGroupList(JSONArray groupList) {
        this.groupList = groupList;
    }

    public Integer getIsMultiple() {
        return isMultiple;
    }

    public void setIsMultiple(Integer isMultiple) {
        this.isMultiple = isMultiple;
    }
}
