/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto;

import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;
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
}
