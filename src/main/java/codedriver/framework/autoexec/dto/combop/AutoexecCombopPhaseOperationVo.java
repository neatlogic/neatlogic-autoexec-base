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
import com.alibaba.fastjson.TypeReference;

import java.io.Serializable;

/**
 * 组合工具阶段操作Vo类
 *
 * @author: linbq
 * @since: 2021/4/13 10:08
 **/
public class AutoexecCombopPhaseOperationVo extends AutoexecOperationBaseVo implements Serializable {
    @EntityField(name = "阶段id", type = ApiParamType.LONG)
    private Long combopPhaseId;
    @EntityField(name = "操作id", type = ApiParamType.LONG)
    private Long operationId;
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
//    @JSONField(serialize = false)
//    private String configStr;
    @EntityField(name = "uuid", type = ApiParamType.STRING)
    private String uuid;
    private String letter;

    public Long getCombopPhaseId() {
        return combopPhaseId;
    }

    public void setCombopPhaseId(Long combopPhaseId) {
        this.combopPhaseId = combopPhaseId;
    }

    public Long getOperationId() {
        if (operationId == null) {
            operationId = SnowflakeUtil.uniqueLong();
        }
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

    public String getFailPolicy() {
        return failPolicy;
    }

    public void setFailPolicy(String failPolicy) {
        this.failPolicy = failPolicy;
    }

    public AutoexecCombopPhaseOperationConfigVo getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = JSONObject.parseObject(config, new TypeReference<AutoexecCombopPhaseOperationConfigVo>() {
        });
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getConfigStr() {
        if (this.config == null) {
            return null;
        }
        return JSONObject.toJSONString(config);
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
}
