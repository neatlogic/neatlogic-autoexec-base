/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.combop;

import codedriver.framework.autoexec.dto.AutoexecToolAndScriptVo;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.io.Serializable;

/**
 * 组合工具阶段操作Vo类
 *
 * @author: linbq
 * @since: 2021/4/13 10:08
 **/
public class AutoexecCombopPhaseOperationVo extends AutoexecToolAndScriptVo implements Serializable {
    private Long combopPhaseId;
    private Long operationId;
    private String operationType;
    private String failPolicy;
    private AutoexecCombopPhaseOperationConfigVo config;
    private Integer sort;
    private transient String configStr;
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
            operationId = super.getId();
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
}
