/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto;

import codedriver.framework.asynchronization.threadlocal.UserContext;
import codedriver.framework.auth.core.AuthActionChecker;
import codedriver.framework.autoexec.auth.AUTOEXEC_MODIFY;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.common.dto.BaseEditorVo;
import codedriver.framework.dto.AuthenticationInfoVo;
import codedriver.framework.restful.annotation.EntityField;
import codedriver.framework.util.SnowflakeUtil;
import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class AutoexecTypeVo extends BaseEditorVo {

    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "分类名", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "描述", type = ApiParamType.STRING)
    private String description;
    @EntityField(name = "类型", type = ApiParamType.STRING)
    private String type;

    @EntityField(name = "关联的工具数", type = ApiParamType.INTEGER)
    private Integer referenceCountForTool = 0;

    @EntityField(name = "关联的自定义工具数", type = ApiParamType.INTEGER)
    private Integer referenceCountForScript = 0;

    @EntityField(name = "关联的组合工具数", type = ApiParamType.INTEGER)
    private Integer referenceCountForCombop = 0;

    @JSONField(serialize = false)
    private Integer isNeedCheckDataAuth = 0; //是否校验数据权限（1：校验，0：不校验）
    @JSONField(serialize = false)
    private List<AutoexecTypeAuthVo> autoexecTypeAuthList; //授权列表
    @JSONField(serialize = false)
    private List<String> authList; //授权字符串列表
    @JSONField(serialize = false)
    private List<String> authUuidList; //用户、分组、角色的uuid列表

    public AutoexecTypeVo() {
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

    public Integer getReferenceCountForTool() {
        return referenceCountForTool;
    }

    public void setReferenceCountForTool(Integer referenceCountForTool) {
        this.referenceCountForTool = referenceCountForTool;
    }

    public Integer getReferenceCountForScript() {
        return referenceCountForScript;
    }

    public void setReferenceCountForScript(Integer referenceCountForScript) {
        this.referenceCountForScript = referenceCountForScript;
    }

    public Integer getReferenceCountForCombop() {
        return referenceCountForCombop;
    }

    public void setReferenceCountForCombop(Integer referenceCountForCombop) {
        this.referenceCountForCombop = referenceCountForCombop;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getAuthList() {
        if (CollectionUtils.isEmpty(authList) && CollectionUtils.isNotEmpty(autoexecTypeAuthList)) {
            this.authList = new ArrayList<>();
            for (AutoexecTypeAuthVo autoexecTypeAuthVo : autoexecTypeAuthList) {
                this.authList.add(autoexecTypeAuthVo.getAuthType() + "#" + autoexecTypeAuthVo.getAuthUuid());
            }
        }
        return authList;
    }

    public void setAuthList(List<String> authList) {
        this.authList = authList;
    }

    public List<AutoexecTypeAuthVo> getAutoexecTypeAuthList() {
        if (CollectionUtils.isEmpty(autoexecTypeAuthList) && CollectionUtils.isNotEmpty(authList)) {
            this.autoexecTypeAuthList = new ArrayList<>();
            for (String auth : authList) {
                autoexecTypeAuthList.add(new AutoexecTypeAuthVo(id, auth.split("#")[0], auth.split("#")[1]));
            }
        }
        return autoexecTypeAuthList;
    }

    public void setAutoexecTypeAuthList(List<AutoexecTypeAuthVo> autoexecTypeAuthList) {
        this.autoexecTypeAuthList = autoexecTypeAuthList;
    }

    public Integer getIsNeedCheckDataAuth() {
        if (isNeedCheckDataAuth == 1 && AuthActionChecker.check(AUTOEXEC_MODIFY.class)) {
            isNeedCheckDataAuth = 0;
        }
        return isNeedCheckDataAuth;
    }

    public void setIsNeedCheckDataAuth(Integer isNeedCheckDataAuth) {
        this.isNeedCheckDataAuth = isNeedCheckDataAuth;
    }

    public List<String> getAuthUuidList() {
        if (CollectionUtils.isEmpty(authUuidList)) {
            authUuidList = new ArrayList<>();
            AuthenticationInfoVo authInfo = UserContext.get().getAuthenticationInfoVo();
            authUuidList.add(authInfo.getUserUuid());
            if (CollectionUtils.isNotEmpty(authInfo.getTeamUuidList())) {
                authUuidList.addAll(authInfo.getTeamUuidList());
            }
            if (CollectionUtils.isNotEmpty(authInfo.getRoleUuidList())) {
                authUuidList.addAll(authInfo.getRoleUuidList());
            }
        }
        return authUuidList;
    }

    public void setAuthUuidList(List<String> authUuidList) {
        this.authUuidList = authUuidList;
    }
}
