/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto;

import codedriver.framework.autoexec.constvalue.ParamType;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

public class AutoexecParamVo implements Serializable {
    @EntityField(name = "参数名", type = ApiParamType.STRING)
    private String key;
    @EntityField(name = "中文名", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "参数默认值", type = ApiParamType.STRING)
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

    @EntityField(name = "配置信息", type = ApiParamType.JSONOBJECT)
    private JSONObject config;

    private transient String defaultValueStr;

    private transient String configStr;

    public AutoexecParamVo() {

    }

    public AutoexecParamVo(AutoexecParamVo autoexecParamVo) {
        this.key = autoexecParamVo.key;
        this.name = autoexecParamVo.name;
        this.defaultValue = autoexecParamVo.defaultValue;
        this.mode = autoexecParamVo.mode;
        this.type = autoexecParamVo.type;
        this.isRequired = autoexecParamVo.isRequired;
        this.description = autoexecParamVo.description;
        this.sort = autoexecParamVo.sort;
        this.config = autoexecParamVo.config;
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
        if (defaultValue != null) {
            if (defaultValue instanceof String) {
                switch (type) {
                    case "select":
                    case "multiselect":
                    case "radio":
                    case "checkbox":
                    case "file":
                        try {
                            defaultValue = JSONObject.parseObject((String) defaultValue);
                            break;
                        } catch (JSONException ex) {
                            break;
                        }
                    case "node":
                        defaultValue = JSONObject.parseArray((String) defaultValue);
                        break;
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
            typeText = ParamType.getParamType(type).getText();
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
}
