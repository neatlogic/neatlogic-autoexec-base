/*
Copyright(c) $today.year NeatLogic Co., Ltd. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package neatlogic.framework.autoexec.dto.combop;

import neatlogic.framework.autoexec.dto.AutoexecOperationVo;
import neatlogic.framework.autoexec.dto.AutoexecParamVo;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.common.dto.BaseEditorVo;
import neatlogic.framework.notify.dto.InvokeNotifyPolicyConfigVo;
import neatlogic.framework.restful.annotation.EntityField;
import neatlogic.framework.util.SnowflakeUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;

/**
 * 组合工具Vo类
 *
 * @author: linbq
 * @since: 2021/4/13 9:54
 **/
public class AutoexecCombopVo extends BaseEditorVo implements Serializable {

    @EntityField(name = "主键id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "显示名", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "描述", type = ApiParamType.STRING)
    private String description;
    @EntityField(name = "类型id", type = ApiParamType.LONG)
    private Long typeId;
    @EntityField(name = "类型名称", type = ApiParamType.STRING)
    private String typeName;
    @EntityField(name = "状态", type = ApiParamType.INTEGER)
    private Integer isActive;
    @EntityField(name = "操作类型", type = ApiParamType.STRING)
    private String operationType;
    @EntityField(name = "通知策略id", type = ApiParamType.LONG)
    private Long notifyPolicyId;
    @EntityField(name = "通知策略名", type = ApiParamType.STRING)
    private String notifyPolicyName;
    @EntityField(name = "维护人", type = ApiParamType.STRING)
    private String owner;
    @EntityField(name = "配置信息", type = ApiParamType.JSONOBJECT)
    private AutoexecCombopConfigVo config;

    @EntityField(name = "是否可查看", type = ApiParamType.INTEGER)
    private Integer viewable;
    @EntityField(name = "是否可编辑", type = ApiParamType.INTEGER)
    private Integer editable;
    @EntityField(name = "是否可删除", type = ApiParamType.INTEGER)
    private Integer deletable;
    @EntityField(name = "是否可执行", type = ApiParamType.INTEGER)
    private Integer executable;
    @EntityField(name = "是否可编辑维护人", type = ApiParamType.INTEGER)
    private Integer ownerEditable;
    @EntityField(name = "是否可审核", type = ApiParamType.INTEGER)
    private Integer reviewable;
    @EntityField(name = "运行时参数列表", type = ApiParamType.INTEGER)
    private List<AutoexecParamVo> runtimeParamList;
    @EntityField(name = "执行页面是否需要设置执行用户", type = ApiParamType.BOOLEAN)
    private boolean needExecuteUser = false;
    @EntityField(name = "执行页面是否需要设置连接协议", type = ApiParamType.BOOLEAN)
    private boolean needProtocol = false;
    @EntityField(name = "执行页面是否需要设置执行目标", type = ApiParamType.BOOLEAN)
    private boolean needExecuteNode = false;
    @EntityField(name = "执行页面是否需要设置分批数量", type = ApiParamType.BOOLEAN)
    private boolean needRoundCount = false;
    @EntityField(name = "版本数量", type = ApiParamType.INTEGER)
    private Integer versionCount;
    @EntityField(name = "查看权限列表", type = ApiParamType.JSONARRAY)
    private List<String> viewAuthorityList;
    @EntityField(name = "编辑权限列表", type = ApiParamType.JSONARRAY)
    private List<String> editAuthorityList;
    @EntityField(name = "执行权限列表", type = ApiParamType.JSONARRAY)
    private List<String> executeAuthorityList;

    @EntityField(name = "激活版本ID", type = ApiParamType.LONG)
    private Long activeVersionId;
    @EntityField(name = "指定版本ID", type = ApiParamType.LONG)
    private Long specifyVersionId;
    @EntityField(name = "版本列表", type = ApiParamType.JSONARRAY)
    private List<AutoexecCombopVersionVo> versionList;
    @JSONField(serialize = false)
    private String configStr;

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

    public Long getNotifyPolicyId() {
        return notifyPolicyId;
    }

    public void setNotifyPolicyId(Long notifyPolicyId) {
        this.notifyPolicyId = notifyPolicyId;
    }

    public String getNotifyPolicyName() {
        return notifyPolicyName;
    }

    public void setNotifyPolicyName(String notifyPolicyName) {
        this.notifyPolicyName = notifyPolicyName;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public AutoexecCombopConfigVo getConfig() {
        if (config == null && configStr != null) {
            config = JSONObject.parseObject(configStr, AutoexecCombopConfigVo.class);
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

    public List<AutoexecParamVo> getRuntimeParamList() {
        return runtimeParamList;
    }

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
}