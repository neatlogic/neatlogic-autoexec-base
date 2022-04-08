/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.comboptemplate;

import codedriver.framework.autoexec.dto.AutoexecOperationVo;
import codedriver.framework.autoexec.dto.combop.AutoexecCombopConfigVo;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.common.dto.BaseEditorVo;
import codedriver.framework.restful.annotation.EntityField;
import codedriver.framework.util.SnowflakeUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.io.Serializable;

/**
 * 组合工具Vo类
 *
 * @author: linbq
 * @since: 2021/4/13 9:54
 **/
public class AutoexecCombopTemplateVo extends BaseEditorVo implements Serializable {

    @EntityField(name = "主键id", type = ApiParamType.LONG)
    private Long id;
    //    @EntityField(name = "唯一标识", type = ApiParamType.STRING)
//    private String uk;
    @EntityField(name = "显示名", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "描述", type = ApiParamType.STRING)
    private String description;
    @EntityField(name = "类型id", type = ApiParamType.LONG)
    private Long typeId;
    @EntityField(name = "类型名称", type = ApiParamType.STRING)
    private String typeName;
    @EntityField(name = "状态", type = ApiParamType.INTEGER)
    private Integer isActive = 1;
    @EntityField(name = "操作类型", type = ApiParamType.STRING)
    private String operationType;
    //    @EntityField(name = "通知策略id", type = ApiParamType.LONG)
//    private Long notifyPolicyId;
//    @EntityField(name = "维护人", type = ApiParamType.STRING)
//    private String owner;
    @EntityField(name = "配置信息", type = ApiParamType.JSONOBJECT)
    private AutoexecCombopConfigVo config;
    @EntityField(name = "被引用次数", type = ApiParamType.INTEGER)
    private int referenceCount;
//    @EntityField(name = "是否可查看", type = ApiParamType.INTEGER)
//    private Integer viewable;
//    @EntityField(name = "是否可编辑", type = ApiParamType.INTEGER)
//    private Integer editable = 1;
//    @EntityField(name = "是否可删除", type = ApiParamType.INTEGER)
//    private Integer deletable = 1;
//    @EntityField(name = "是否可执行", type = ApiParamType.INTEGER)
//    private Integer executable = 1;
//    @EntityField(name = "是否可编辑维护人", type = ApiParamType.INTEGER)
//    private Integer ownerEditable = 1;
//    @EntityField(name = "运行时参数列表", type = ApiParamType.INTEGER)
//    private List<AutoexecCombopTemplateParamVo> runtimeParamList;
//    @EntityField(name = "执行页面是否需要设置执行用户", type = ApiParamType.BOOLEAN)
//    private boolean needExecuteUser = false;
//    @EntityField(name = "执行页面是否需要设置连接协议", type = ApiParamType.BOOLEAN)
//    private boolean needProtocol = false;
//    @EntityField(name = "执行页面是否需要设置执行目标", type = ApiParamType.BOOLEAN)
//    private boolean needExecuteNode = false;

//    @JSONField(serialize = false)
//    private String configStr;
//    @JSONField(serialize = false)
//    private Boolean isTest;//是否测试

    public AutoexecCombopTemplateVo() {
    }

    public AutoexecCombopTemplateVo(AutoexecOperationVo autoexecToolAndScriptVo) {
//        this.uk = autoexecToolAndScriptVo.getUk();
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

//    public String getUk() {
//        return uk;
//    }
//
//    public void setUk(String uk) {
//        this.uk = uk;
//    }

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

//    public Long getNotifyPolicyId() {
//        return notifyPolicyId;
//    }
//
//    public void setNotifyPolicyId(Long notifyPolicyId) {
//        this.notifyPolicyId = notifyPolicyId;
//    }

//    public String getOwner() {
//        return owner;
//    }
//
//    public void setOwner(String owner) {
//        this.owner = owner;
//    }

    public AutoexecCombopConfigVo getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = JSONObject.parseObject(config, new TypeReference<AutoexecCombopConfigVo>() {
        });
    }

    public int getReferenceCount() {
        return referenceCount;
    }

    public void setReferenceCount(int referenceCount) {
        this.referenceCount = referenceCount;
    }

//    public Integer getViewable() {
//        return viewable;
//    }
//
//    public void setViewable(Integer viewable) {
//        this.viewable = viewable;
//    }

//    public Integer getEditable() {
//        return editable;
//    }
//
//    public void setEditable(Integer editable) {
//        this.editable = editable;
//    }
//
//    public Integer getDeletable() {
//        return deletable;
//    }
//
//    public void setDeletable(Integer deletable) {
//        this.deletable = deletable;
//    }
//
//    public Integer getExecutable() {
//        return executable;
//    }
//
//    public void setExecutable(Integer executable) {
//        this.executable = executable;
//    }
//
//    public Integer getOwnerEditable() {
//        return ownerEditable;
//    }
//
//    public void setOwnerEditable(Integer ownerEditable) {
//        this.ownerEditable = ownerEditable;
//    }

//    public List<AutoexecCombopTemplateParamVo> getRuntimeParamList() {
//        return runtimeParamList;
//    }
//
//    public void setRuntimeParamList(List<AutoexecCombopTemplateParamVo> runtimeParamList) {
//        this.runtimeParamList = runtimeParamList;
//    }

//    public boolean getNeedExecuteUser() {
//        return needExecuteUser;
//    }
//
//    public void setNeedExecuteUser(boolean needExecuteUser) {
//        this.needExecuteUser = needExecuteUser;
//    }
//
//    public boolean getNeedProtocol() {
//        return needProtocol;
//    }
//
//    public void setNeedProtocol(boolean needProtocol) {
//        this.needProtocol = needProtocol;
//    }
//
//    public boolean getNeedExecuteNode() {
//        return needExecuteNode;
//    }
//
//    public void setNeedExecuteNode(boolean needExecuteNode) {
//        this.needExecuteNode = needExecuteNode;
//    }

    public String getConfigStr() {
        if (this.config == null) {
            return null;
        }
        return JSONObject.toJSONString(config);
    }

//    public Boolean getIsTest() {
//        return isTest;
//    }
//
//    public void setIsTest(Boolean test) {
//        isTest = test;
//    }
}