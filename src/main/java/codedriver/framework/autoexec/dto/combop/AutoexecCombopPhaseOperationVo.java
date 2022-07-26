/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.combop;

import codedriver.framework.autoexec.dto.AutoexecOperationBaseVo;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;
import codedriver.framework.util.SnowflakeUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * 组合工具阶段操作Vo类
 *
 * @author: linbq
 * @since: 2021/4/13 10:08
 **/
public class AutoexecCombopPhaseOperationVo implements Serializable {

    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "操作id", type = ApiParamType.LONG)
    private Long operationId;
    @EntityField(name = "工具名", type = ApiParamType.STRING)
    private String operationName;
    @EntityField(name = "操作类型，自定义工具或工具", type = ApiParamType.STRING)
    private String operationType;
    @EntityField(name = "失败策略", type = ApiParamType.STRING)
    private String failPolicy;
    @EntityField(name = "配置信息", type = ApiParamType.JSONOBJECT)
    private AutoexecCombopPhaseOperationConfigVo config;
    @EntityField(name = "排序", type = ApiParamType.INTEGER)
    private Integer sort;
    @EntityField(name = "父工具id", type = ApiParamType.LONG)
    private Long parentOperationId;
    @EntityField(name = "父工具类型", type = ApiParamType.LONG)
    private String parentOperationType;
    @JSONField(serialize = false)
    private String configStr;
    @EntityField(name = "uuid", type = ApiParamType.STRING)
    private String uuid;
    private String letter;

    @EntityField(name = "工具信息", type = ApiParamType.JSONOBJECT)
    private AutoexecOperationBaseVo operation;

    @EntityField(name = "指定脚本版本Id", type = ApiParamType.LONG)
    private Long scriptVersionId;

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

    public Long getId() {
        if (id == null) {
            id = SnowflakeUtil.uniqueLong();
        }
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperationName() {
        if (operation != null) {
            return operation.getName();
        }
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public AutoexecOperationBaseVo getOperation() {
        return operation;
    }

    public void setOperation(AutoexecOperationBaseVo operation) {
        this.operation = operation;
    }

    public String getFailPolicy() {
        return failPolicy;
    }

    public void setFailPolicy(String failPolicy) {
        this.failPolicy = failPolicy;
    }

    public AutoexecCombopPhaseOperationConfigVo getConfig() {
        if (config == null && configStr != null) {
            config = JSONObject.parseObject(configStr, AutoexecCombopPhaseOperationConfigVo.class);
        }
        return config;
    }

    public void setConfig(AutoexecCombopPhaseOperationConfigVo config) {
        if (config != null) {
            configStr = null;
        }
        this.config = config;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getConfigStr() {
        if (configStr == null && config != null) {
            configStr = JSONObject.toJSONString(config);
        }
        return configStr;
    }

    public void setConfigStr(String configStr) {
        if (configStr != null) {
            config = null;
        }
        this.configStr = configStr;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public Long getParentOperationId() {
        return parentOperationId;
    }

    public void setParentOperationId(Long parentOperationId) {
        this.parentOperationId = parentOperationId;
    }

    public String getParentOperationType() {
        return parentOperationType;
    }

    public void setParentOperationType(String parentOperationType) {
        this.parentOperationType = parentOperationType;
    }

    public Long getScriptVersionId() {
        return scriptVersionId;
    }

    public void setScriptVersionId(Long scriptVersionId) {
        this.scriptVersionId = scriptVersionId;
    }
}
