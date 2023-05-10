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

package neatlogic.framework.autoexec.dto;

import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

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
