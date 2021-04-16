/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.combop;

import com.alibaba.fastjson.JSONObject;

/**
 * 组合工具阶段操作Vo类
 * @author: linbq
 * @since: 2021/4/13 10:08
 **/
public class AutoexecCombopPhaseOperationVo {
    private Long combopPhaseId;
    private Long operationId;
    private String operationType;
    private String failPolicy;
    private JSONObject config;
    private Integer sort;
    private transient String configStr;

    public Long getCombopPhaseId() {
        return combopPhaseId;
    }

    public void setCombopPhaseId(Long combopPhaseId) {
        this.combopPhaseId = combopPhaseId;
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

    public String getFailPolicy() {
        return failPolicy;
    }

    public void setFailPolicy(String failPolicy) {
        this.failPolicy = failPolicy;
    }

    public JSONObject getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = JSONObject.parseObject(config);
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
        return config.toJSONString();
    }
}
