/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.combop;

import codedriver.framework.autoexec.constvalue.ParamType;
import codedriver.framework.autoexec.dto.script.AutoexecScriptVersionParamVo;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.common.dto.BasePageVo;
import codedriver.framework.restful.annotation.EntityField;
import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

/**
 * 组合工具运行参数Vo类
 *
 * @author: linbq
 * @since: 2021/4/13 10:04
 **/
public class AutoexecCombopParamVo extends BasePageVo implements Serializable {
    @EntityField(name = "组合工具id", type = ApiParamType.LONG)
    private Long combopId;
    @EntityField(name = "参数名", type = ApiParamType.STRING)
    private String key;
    @EntityField(name = "中文名", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "参数值", type = ApiParamType.STRING)
    private Object defaultValue;
    @EntityField(name = "描述", type = ApiParamType.STRING)
    private String description;
    @EntityField(name = "是否必填", type = ApiParamType.INTEGER)
    private Integer isRequired;
    @EntityField(name = "参数类型", type = ApiParamType.STRING)
    private String type;
    @EntityField(name = "顺序", type = ApiParamType.INTEGER)
    private Integer sort;
    @EntityField(name = "配置信息", type = ApiParamType.JSONOBJECT)
    private JSONObject config;

    private transient String defaultValueStr;

    public AutoexecCombopParamVo() {
    }

    public AutoexecCombopParamVo(AutoexecScriptVersionParamVo autoexecScriptVersionParamVo) {
        this.key = autoexecScriptVersionParamVo.getKey();
        this.defaultValue = autoexecScriptVersionParamVo.getDefaultValue();
        this.description = autoexecScriptVersionParamVo.getDescription();
        this.isRequired = autoexecScriptVersionParamVo.getIsRequired();
        this.type = autoexecScriptVersionParamVo.getType();
//        this.config = autoexecScriptVersionParamVo.getConfig();
    }

    public Long getCombopId() {
        return combopId;
    }

    public void setCombopId(Long combopId) {
        this.combopId = combopId;
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
        return defaultValue;
    }

    public void setDefaultValue(Object defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(Integer isRequired) {
        this.isRequired = isRequired;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public void setConfig(JSONObject config) {
        this.config = config;
    }

    public String getDefaultValueStr() {
        if (defaultValue != null) {
            return defaultValue.toString();
        }
        return null;
    }
}
