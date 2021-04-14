/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.combop;

import codedriver.framework.common.dto.BaseEditorVo;
import codedriver.framework.util.SnowflakeUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 组合工具Vo类
 *
 * @author: linbq
 * @since: 2021/4/13 9:54
 **/
public class AutoexecCombopVo extends BaseEditorVo {

    private Long id;
    private String uk;
    private String name;
    private String description;
    private Long typeId;
    private String typeName;
    private Integer isActive;
    private String operationType;
    private Long notifyPolicyId;
    private JSONObject config;
    private int referenceCount;
    private transient String configStr;

    public Long getId() {
        if (id == null) {
            id = SnowflakeUtil.uniqueLong();
        }
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUk() {
        return uk;
    }

    public void setUk(String uk) {
        this.uk = uk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public Long getNotifyPolicyId() {
        return notifyPolicyId;
    }

    public void setNotifyPolicyId(Long notifyPolicyId) {
        this.notifyPolicyId = notifyPolicyId;
    }

    public JSONObject getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = JSONObject.parseObject(config);
    }

    public int getReferenceCount() {
        return referenceCount;
    }

    public void setReferenceCount(int referenceCount) {
        this.referenceCount = referenceCount;
    }

    public String getConfigStr() {
        if (this.config == null) {
            return null;
        }
        return config.toJSONString();
    }
}
