/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.script;

import codedriver.framework.autoexec.constvalue.ChangeType;
import codedriver.framework.autoexec.dto.IParam;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;
import com.alibaba.fastjson.JSONObject;

public class AutoexecScriptVersionParamVo implements IParam {

    @EntityField(name = "脚本版本ID", type = ApiParamType.LONG)
    private Long scriptVersionId;
    @EntityField(name = "参数名", type = ApiParamType.STRING)
    private String key;
    @EntityField(name = "参数默认值", type = ApiParamType.STRING)
    private Object defaultValue;
    @EntityField(name = "参数类型(出参、入参)", type = ApiParamType.STRING)
    private String mode;
    @EntityField(name = "表单类型", type = ApiParamType.STRING)
    private String type;
    @EntityField(name = "是否必填(1:是;0:否)", type = ApiParamType.INTEGER)
    private Integer isRequired;
    @EntityField(name = "说明", type = ApiParamType.STRING)
    private String description;
    @EntityField(name = "排序", type = ApiParamType.INTEGER)
    private Integer sort;

    @EntityField(name = "插入(insert)、删除(delete)、更新(update)", type = ApiParamType.ENUM, member = ChangeType.class)
    private String changeType;

    public AutoexecScriptVersionParamVo() {
    }

    public Long getScriptVersionId() {
        return scriptVersionId;
    }

    public void setScriptVersionId(Long scriptVersionId) {
        this.scriptVersionId = scriptVersionId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getDefaultValue() {
        if (defaultValue != null) {
            if (defaultValue instanceof String) {
                switch (type) {
                    case "file":
                        defaultValue = JSONObject.parseObject((String) defaultValue);
                        break;
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

    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType;
    }
}
