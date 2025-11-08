/*
 *
 * Copyright (C) 2025  TechSure Co., Ltd.  All Rights Reserved.
 * This file is part of the NeatLogic software.
 * Licensed under the NeatLogic Sustainable Use License (NSUL), Version 4.x – 2025.
 * You may use this file only in compliance with the License.
 * See the LICENSE file distributed with this work for the full license text.
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 */

package neatlogic.framework.autoexec.dto.combop;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import neatlogic.framework.autoexec.constvalue.AutoexecCombopOpType;
import neatlogic.framework.autoexec.dto.AutoexecOperationVo;
import neatlogic.framework.autoexec.dto.AutoexecParamVo;
import neatlogic.framework.cmdb.enums.CmdbTenantConfig;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.common.dto.BaseEditorVo;
import neatlogic.framework.config.ConfigManager;
import neatlogic.framework.restful.annotation.EntityField;
import neatlogic.framework.util.SnowflakeUtil;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.List;

/**
 * 组合工具Vo类
 *
 * @author: linbq
 * @since: 2021/4/13 9:54
 **/
public class AutoexecCombopVo extends BaseEditorVo implements Serializable {

    @EntityField(name = "common.id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "common.name", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "common.description", type = ApiParamType.STRING)
    private String description;
    @EntityField(name = "common.typeid", type = ApiParamType.LONG)
    private Long typeId;
    @EntityField(name = "操作类型", type = ApiParamType.STRING)
    private String opType;
    @EntityField(name = "common.typename", type = ApiParamType.STRING)
    private String typeName;
    @EntityField(name = "common.isactive", type = ApiParamType.INTEGER)
    private Integer isActive;
    @EntityField(name = "common.actiontype", type = ApiParamType.STRING)
    private String operationType;
    @EntityField(name = "common.owneruuid", type = ApiParamType.STRING)
    private String owner;
    @EntityField(name = "common.config", type = ApiParamType.JSONOBJECT)
    private AutoexecCombopConfigVo config;

    @EntityField(name = "common.viewable", type = ApiParamType.INTEGER)
    private Integer viewable;
    @EntityField(name = "common.editable", type = ApiParamType.INTEGER)
    private Integer editable;
    @EntityField(name = "common.deletable", type = ApiParamType.INTEGER)
    private Integer deletable;
    @EntityField(name = "common.executable", type = ApiParamType.INTEGER)
    private Integer executable;
    @EntityField(name = "common.ownereditable", type = ApiParamType.INTEGER)
    private Integer ownerEditable;
    @EntityField(name = "common.reviewable", type = ApiParamType.INTEGER)
    private Integer reviewable;
    @EntityField(name = "term.autoexec.jobparamlist", type = ApiParamType.JSONARRAY)
    private List<AutoexecParamVo> runtimeParamList;
    @EntityField(name = "term.autoexec.needexecuteuser", type = ApiParamType.BOOLEAN)
    private boolean needExecuteUser = false;
    @EntityField(name = "term.autoexec.needprotocol", type = ApiParamType.BOOLEAN)
    private boolean needProtocol = false;
    @EntityField(name = "term.autoexec.needexecutenode", type = ApiParamType.BOOLEAN)
    private boolean needExecuteNode = false;
    @EntityField(name = "term.autoexec.needroundcount", type = ApiParamType.BOOLEAN)
    private boolean needRoundCount = false;
    @EntityField(name = "term.autoexec.needrunnergroup", type = ApiParamType.BOOLEAN)
    private boolean needRunnerGroup = false;
    @EntityField(name = "common.versioncount", type = ApiParamType.INTEGER)
    private Integer versionCount;
    @EntityField(name = "common.viewauthoritylist", type = ApiParamType.JSONARRAY)
    private List<String> viewAuthorityList;
    @EntityField(name = "common.editauthoritylist", type = ApiParamType.JSONARRAY)
    private List<String> editAuthorityList;
    @EntityField(name = "common.executeauthoritylist", type = ApiParamType.JSONARRAY)
    private List<String> executeAuthorityList;

    @EntityField(name = "common.activeversionid", type = ApiParamType.LONG)
    private Long activeVersionId;
    @EntityField(name = "common.specifyversionid", type = ApiParamType.LONG)
    private Long specifyVersionId;
    @EntityField(name = "common.versionlist", type = ApiParamType.JSONARRAY)
    private List<AutoexecCombopVersionVo> versionList;
    @JSONField(serialize = false)
    private String configStr;
    @EntityField(name = "term.autoexec.allphasesarerunnerorsqlexecmode", type = ApiParamType.BOOLEAN)
    private Boolean allPhasesAreRunnerOrSqlExecMode;
    @EntityField(name = "term.autoexec.existrunnerorsqlexecmode", type = ApiParamType.BOOLEAN)
    private Boolean existRunnerOrSqlExecMode;
    @EntityField(name = "term.autoexec.configexpired", type = ApiParamType.INTEGER)
    private Integer configExpired;
    @EntityField(name = "term.autoexec.configexpiredreason", type = ApiParamType.JSONOBJECT)
    private JSONObject configExpiredReason;

    @EntityField(name = "引用数量", type = ApiParamType.INTEGER)
    private Integer referenceCount;

    public AutoexecCombopVo() {
    }

    public AutoexecCombopVo(AutoexecOperationVo autoexecToolAndScriptVo) {
        this.name = autoexecToolAndScriptVo.getName();
        this.typeId = autoexecToolAndScriptVo.getTypeId();
        this.operationType = autoexecToolAndScriptVo.getType();
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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public AutoexecCombopConfigVo getConfig() {
        if (config == null && configStr != null) {
            try {
                config = JSONObject.parseObject(configStr, AutoexecCombopConfigVo.class);
            } catch (Exception ignored) {

            }
        }
        return config;
    }

    public void setConfig(AutoexecCombopConfigVo config) {
        if (config != null) {
            this.configStr = null;
        }
        this.config = config;
    }

    public Integer getViewable() {
        return viewable;
    }

    public void setViewable(Integer viewable) {
        this.viewable = viewable;
    }

    public Integer getEditable() {
        return editable;
    }

    public void setEditable(Integer editable) {
        this.editable = editable;
    }

    public Integer getDeletable() {
        return deletable;
    }

    public void setDeletable(Integer deletable) {
        this.deletable = deletable;
    }

    public Integer getExecutable() {
        return executable;
    }

    public void setExecutable(Integer executable) {
        this.executable = executable;
    }

    public Integer getOwnerEditable() {
        return ownerEditable;
    }

    public void setOwnerEditable(Integer ownerEditable) {
        this.ownerEditable = ownerEditable;
    }

    public Integer getReviewable() {
        return reviewable;
    }

    public void setReviewable(Integer reviewable) {
        this.reviewable = reviewable;
    }

    @Deprecated
    public List<AutoexecParamVo> getRuntimeParamList() {
        return runtimeParamList;
    }

    @Deprecated
    public void setRuntimeParamList(List<AutoexecParamVo> runtimeParamList) {
        this.runtimeParamList = runtimeParamList;
    }

    public boolean getNeedExecuteUser() {
        return needExecuteUser;
    }

    public void setNeedExecuteUser(boolean needExecuteUser) {
        this.needExecuteUser = needExecuteUser;
    }

    public boolean getNeedProtocol() {
        return needProtocol;
    }

    public void setNeedProtocol(boolean needProtocol) {
        this.needProtocol = needProtocol;
    }

    public boolean getNeedExecuteNode() {
        return needExecuteNode;
    }

    public void setNeedExecuteNode(boolean needExecuteNode) {
        this.needExecuteNode = needExecuteNode;
    }

    public boolean getNeedRoundCount() {
        return needRoundCount;
    }

    public void setNeedRoundCount(boolean needRoundCount) {
        this.needRoundCount = needRoundCount;
    }

    public boolean getNeedRunnerGroup() {
        return needRunnerGroup;
    }

    public void setNeedRunnerGroup(boolean needRunnerGroup) {
        this.needRunnerGroup = needRunnerGroup;
    }

    public String getConfigStr() {
        if (configStr == null && config != null) {
            configStr = JSONObject.toJSONString(config);
        }
        return configStr;
    }

    public void setConfigStr(String configStr) {
        if (configStr != null) {
            this.config = null;
        }
        this.configStr = configStr;
    }

    public Integer getVersionCount() {
        return versionCount;
    }

    public void setVersionCount(Integer versionCount) {
        this.versionCount = versionCount;
    }

    public List<String> getViewAuthorityList() {
        return viewAuthorityList;
    }

    public void setViewAuthorityList(List<String> viewAuthorityList) {
        this.viewAuthorityList = viewAuthorityList;
    }

    public List<String> getEditAuthorityList() {
        return editAuthorityList;
    }

    public void setEditAuthorityList(List<String> editAuthorityList) {
        this.editAuthorityList = editAuthorityList;
    }

    public List<String> getExecuteAuthorityList() {
        return executeAuthorityList;
    }

    public void setExecuteAuthorityList(List<String> executeAuthorityList) {
        this.executeAuthorityList = executeAuthorityList;
    }

    public Long getActiveVersionId() {
        return activeVersionId;
    }

    public void setActiveVersionId(Long activeVersionId) {
        this.activeVersionId = activeVersionId;
    }

    public Long getSpecifyVersionId() {
        return specifyVersionId;
    }

    public void setSpecifyVersionId(Long specifyVersionId) {
        this.specifyVersionId = specifyVersionId;
    }

    public List<AutoexecCombopVersionVo> getVersionList() {
        return versionList;
    }

    public void setVersionList(List<AutoexecCombopVersionVo> versionList) {
        this.versionList = versionList;
    }

    public Boolean getAllPhasesAreRunnerOrSqlExecMode() {
        return allPhasesAreRunnerOrSqlExecMode;
    }

    public void setAllPhasesAreRunnerOrSqlExecMode(Boolean allPhasesAreRunnerOrSqlExecMode) {
        this.allPhasesAreRunnerOrSqlExecMode = allPhasesAreRunnerOrSqlExecMode;
    }

    public Integer getConfigExpired() {
        return configExpired;
    }

    public void setConfigExpired(Integer configExpired) {
        this.configExpired = configExpired;
    }

    public JSONObject getConfigExpiredReason() {
        return configExpiredReason;
    }

    public void setConfigExpiredReason(JSONObject configExpiredReason) {
        this.configExpiredReason = configExpiredReason;
    }

    public String getOpType() {
        if (StringUtils.isBlank(opType)) {
            return AutoexecCombopOpType.READONLY.getValue();
        }
        return opType;
    }

    public void setOpType(String opType) {
        this.opType = opType;
    }

    public String getOpTypeName() {
        if (StringUtils.isNotBlank(opType)) {
            return AutoexecCombopOpType.getText(opType);
        }
        return AutoexecCombopOpType.READONLY.getText();
    }

    public String getIsResourcecenterAuth() {
        return ConfigManager.getConfig(CmdbTenantConfig.IS_RESOURCECENTER_AUTH);
    }

    public Boolean getExistRunnerOrSqlExecMode() {
        return existRunnerOrSqlExecMode;
    }

    public void setExistRunnerOrSqlExecMode(Boolean existRunnerOrSqlExecMode) {
        this.existRunnerOrSqlExecMode = existRunnerOrSqlExecMode;
    }

    public Integer getReferenceCount() {
        return referenceCount;
    }

    public void setReferenceCount(Integer referenceCount) {
        this.referenceCount = referenceCount;
    }
}
