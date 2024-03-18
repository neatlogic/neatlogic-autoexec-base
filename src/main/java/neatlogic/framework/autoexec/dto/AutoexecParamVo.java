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

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import neatlogic.framework.autoexec.constvalue.AutoexecProfileParamInvokeType;
import neatlogic.framework.autoexec.constvalue.OutputParamType;
import neatlogic.framework.autoexec.constvalue.ParamMode;
import neatlogic.framework.autoexec.constvalue.ParamType;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;
import neatlogic.framework.util.SnowflakeUtil;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Objects;

public class AutoexecParamVo implements Serializable {

    private static final long serialVersionUID = 3196317808541689056L;
    @EntityField(name = "唯一标识", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "参数名", type = ApiParamType.STRING)
    private String key;
    @EntityField(name = "中文名", type = ApiParamType.STRING)
    private String name;
    //TODO defaultValue 与 BasePageVo的defaultValue冲突，类型不一致，现无法继承 BasePageVo
    @EntityField(name = "参数默认值", type = ApiParamType.NOAUTH)
    private Object defaultValue;
    @EntityField(name = "参数值", type = ApiParamType.NOAUTH)
    private Object value;
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
    private AutoexecParamConfigVo config;

    @EntityField(name = "自由参数数量", type = ApiParamType.INTEGER)
    private Integer argumentCount = 0;

    @EntityField(name = "参数映射模式", type = ApiParamType.STRING)
    private String mappingMode = AutoexecProfileParamInvokeType.CONSTANT.getValue();

    @EntityField(name = "参数映射模式中文名", type = ApiParamType.STRING)
    private String mappingModeText;

    @EntityField(name = "是否可编辑", type = ApiParamType.INTEGER)
    private Integer editable;

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
        this.value = autoexecParamVo.value;
        this.mode = autoexecParamVo.mode;
        this.mappingMode = autoexecParamVo.mappingMode;
        this.type = autoexecParamVo.type;
        this.isRequired = autoexecParamVo.isRequired;
        this.description = autoexecParamVo.description;
        this.sort = autoexecParamVo.sort;
        this.config = autoexecParamVo.config;
        this.editable = autoexecParamVo.editable;
    }

    public AutoexecParamVo(JSONObject argumentJson) {
        this.name = argumentJson.getString("name");
        this.defaultValue = argumentJson.getString("defaultValue");
        this.value = argumentJson.getString("value");
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

    public Long getId() {
        if (id == null) {
            id = SnowflakeUtil.uniqueLong();
        }
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
                    case "switch":
                        defaultValue = Boolean.valueOf(defaultValue.toString());
                        break;
                    case "userselect":
                        String valueString = (String) defaultValue;
                        if (valueString.startsWith("[") && valueString.endsWith("]")) {
                            defaultValue = JSONObject.parseArray(valueString);
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

    public Object getValue() {
        if (value != null && type != null) {
            if (value instanceof String) {
                switch (type) {
                    case "multiselect":
                    case "checkbox":
                    case "node":
                        value = JSONObject.parseArray((String) value);
                        break;
                    case "file":
                        try {
                            value = JSONObject.parseObject((String) value);
                            break;
                        } catch (JSONException ex) {
                            break;
                        }
                    case "json":
                        String valueStr = (String) value;
                        if (valueStr.startsWith("[") && valueStr.endsWith("]")) {
                            value = JSONObject.parseArray(valueStr);
                        } else if (valueStr.startsWith("{") && valueStr.endsWith("}")) {
                            value = JSONObject.parseObject(valueStr);
                        }
                        break;
                    case "switch":
                        value = Boolean.valueOf(value.toString());
                        break;
                    case "userselect":
                        String valueString = (String) defaultValue;
                        if (valueString.startsWith("[") && valueString.endsWith("]")) {
                            defaultValue = JSONObject.parseArray(valueString);
                        }
                        break;
                    default:
                        break;
                }
            }
        }
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
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

    public AutoexecParamConfigVo getConfig() {
        return config;
    }

    public void setConfig(String configStr) {
        if (StringUtils.isNotBlank(configStr)) {
            this.config = JSONObject.parseObject(configStr, AutoexecParamConfigVo.class);
        } else {
            this.config = null;
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
            return JSONObject.toJSONString(config);
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

    public Integer getEditable() {
        return editable;
    }

    public void setEditable(Integer editable) {
        this.editable = editable;
    }
}
