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

package neatlogic.framework.autoexec.dto;

import neatlogic.framework.asynchronization.threadlocal.UserContext;
import neatlogic.framework.auth.core.AuthActionChecker;
import neatlogic.framework.autoexec.auth.AUTOEXEC_MODIFY;
import neatlogic.framework.autoexec.constvalue.AutoexecTypeAuthorityAction;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.common.dto.BaseEditorVo;
import neatlogic.framework.restful.annotation.EntityField;
import neatlogic.framework.util.SnowflakeUtil;
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
    private List<AutoexecTypeAuthVo> autoexecTypeAuthList; //授权列表 insertAuth时用
    @EntityField(name = "授权字符串列表", type = ApiParamType.JSONARRAY)
    private List<String> authList; //前端入参出参用
    @EntityField(name = "审核授权字符串列表", type = ApiParamType.JSONARRAY)
    private List<String> reviewAuthList; //前端入参出参用

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
                autoexecTypeAuthList.add(new AutoexecTypeAuthVo(id, AutoexecTypeAuthorityAction.ADD.getValue(), auth.split("#")[0], auth.split("#")[1]));
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
        return UserContext.get().getUuidList();
    }

    public List<String> getReviewAuthList() {
        return reviewAuthList;
    }

    public void setReviewAuthList(List<String> reviewAuthList) {
        this.reviewAuthList = reviewAuthList;
    }
}
