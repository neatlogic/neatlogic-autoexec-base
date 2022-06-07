/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto;

import codedriver.framework.autoexec.constvalue.*;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Objects;

public class AutoexecParamVo implements Serializable {
    @EntityField(name = "参数名", type = ApiParamType.STRING)
    private String key;
    @EntityField(name = "中文名", type = ApiParamType.STRING)
    private String name;
    //TODO defaultValue 与 BasePageVo的defaultValue冲突，类型不一致，现无法继承 BasePageVo
    @EntityField(name = "参数默认值", type = ApiParamType.NOAUTH)
    private Object defaultValue;
    @EntityField(name = "参数类型(出参、入参)", type = ApiParamType.STRING)
    private String mode;
    @EntityField(name = "表单类型", type = ApiParamType.STRING)
    private String type;
    @EntityField(name = "表单类型名称", type = ApiParamType.STRING)
    private String typeText;
    @EntityField(name = "是否必填(1:是;0:否)", type = ApiParamType.INTEGER)
    private Integer isRequired;
    @EntityField(name = "说明", type = ApiParamType.STRING)
    private String description;
    @EntityField(name = "排序", type = ApiParamType.INTEGER)
    private Integer sort;
    @EntityField(name = "正则校验", type = ApiParamType.STRING)
    private String validate;

    @EntityField(name = "key来源的工具id", type = ApiParamType.LONG)
    private Long operationId;
    @EntityField(name = "key来源的工具类型", type = ApiParamType.STRING)
    private String operationType;

    @EntityField(name = "配置信息", type = ApiParamType.JSONOBJECT)
    private JSONObject config;

    @EntityField(name = "自由参数数量", type = ApiParamType.INTEGER)
    private Integer argumentCount = 0;

    @EntityField(name = "参数映射模式", type = ApiParamType.STRING)
    private String mappingMode = AutoexecProfileParamInvokeType.CONSTANT.getValue();

    @EntityField(name = "参数映射模式中文名", type = ApiParamType.STRING)
    private String mappingModeText;

    @JSONField(serialize = false)
    private String defaultValueStr;

    @JSONField(serialize = false)
    private String configStr;

    public AutoexecParamVo() {

    }

    public AutoexecParamVo(AutoexecParamVo autoexecParamVo) {
        this.key = autoexecParamVo.key;
        this.name = autoexecParamVo.name;
        this.defaultValue = autoexecParamVo.defaultValue;
        this.mode = autoexecParamVo.mode;
        this.mappingMode = autoexecParamVo.mappingMode;
        this.type = autoexecParamVo.type;
        this.isRequired = autoexecParamVo.isRequired;
        this.description = autoexecParamVo.description;
        this.sort = autoexecParamVo.sort;
        this.config = autoexecParamVo.config;
    }

    public AutoexecParamVo(JSONObject argumentJson) {
        this.name = argumentJson.getString("name");
        this.defaultValue = argumentJson.getString("defaultValue");
        this.mode = ParamMode.INPUT.getValue();
        this.type = argumentJson.getString("type");
        this.isRequired = 0;
        String required = argumentJson.getString("required");
        if (StringUtils.isNotBlank(required) && Boolean.parseBoolean(required)) {
            this.isRequired = 1;
        }
        this.validate = argumentJson.getString("validate");
        this.description = argumentJson.getString("help");
        this.argumentCount = argumentJson.getInteger("count");
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getDefaultValue() {
        if (defaultValue != null && type != null) {
            if (defaultValue instanceof String) {
                switch (type) {
                    case "multiselect":
                    case "checkbox":
                    case "node":
                        defaultValue = JSONObject.parseArray((String) defaultValue);
                        break;
                    case "file":
                        try {
                            defaultValue = JSONObject.parseObject((String) defaultValue);
                            break;
                        } catch (JSONException ex) {
                            break;
                        }
                    case "json":
                        String valueStr = (String) defaultValue;
                        if (valueStr.startsWith("[") && valueStr.endsWith("]")) {
                            defaultValue = JSONObject.parseArray(valueStr);
                        } else if (valueStr.startsWith("{") && valueStr.endsWith("}")) {
                            defaultValue = JSONObject.parseObject(valueStr);
                        }
                        break;
                    default:
                        break;
                }
            }
        }
        return defaultValue;
    }

    public void setDefaultValue(Object defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeText() {
        if (StringUtils.isNotBlank(type)) {
            if (Objects.equals(ParamMode.INPUT.getValue(), mode)) {
                ParamType paramType = ParamType.getParamType(type);
                typeText = paramType != null ? paramType.getText() : null;
            } else {
                OutputParamType paramType = OutputParamType.getParamType(type);
                typeText = paramType != null ? paramType.getText() : null;
            }
        }
        return typeText;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Integer getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(Integer isRequired) {
        this.isRequired = isRequired;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public JSONObject getConfig() {
        return config;
    }

    public void setConfig(String configStr) {
        if (StringUtils.isNotBlank(configStr)) {
            this.config = JSONObject.parseObject(configStr);
        }
    }

    public String getDefaultValueStr() {
        if (defaultValue != null) {
            if (defaultValue instanceof String) {
                return (String) defaultValue;
            } else {
                return JSONObject.toJSONString(defaultValue);
            }
        }
        return null;
    }

    public String getConfigStr() {
        if (config != null) {
            return config.toJSONString();
        }
        return null;
    }

    public Integer getArgumentCount() {
        return argumentCount;
    }

    public void setArgumentCount(Integer argumentCount) {
        this.argumentCount = argumentCount;
    }

    public String getValidate() {
        return validate;
    }

    public void setValidate(String validate) {
        this.validate = validate;
    }

    public Long getOperationId() {
        return operationId;
    }

    public void setOperationId(Long operationId) {
        this.operationId = operationId;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getMappingMode() {
        return mappingMode;
    }

    public void setMappingMode(String mappingMode) {
        this.mappingMode = mappingMode;
    }

    public String getMappingModeText() {
        if (StringUtils.isNotBlank(mappingMode)) {
            AutoexecProfileParamInvokeType mode = AutoexecProfileParamInvokeType.getParamType(mappingMode);
            if (mode != null) {
                mappingModeText = mode.getText();
            }
        }
        return mappingModeText;
    }
}
