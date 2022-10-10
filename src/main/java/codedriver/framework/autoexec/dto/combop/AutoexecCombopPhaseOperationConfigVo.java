/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.combop;

import codedriver.framework.autoexec.dto.profile.AutoexecProfileParamVo;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;

import java.io.Serializable;
import java.util.List;

/**
 * @author: linbq
 * @since: 2021/4/21 18:41
 **/
public class AutoexecCombopPhaseOperationConfigVo implements Serializable {
    private static final long serialVersionUID = 5926053553385616019L;
    @EntityField(name = "参数映射列表", type = ApiParamType.JSONARRAY)
    private List<ParamMappingVo> paramMappingList;
    @EntityField(name = "自由参数映射列表", type = ApiParamType.JSONARRAY)
    private List<ParamMappingVo> argumentMappingList;
    @EntityField(name = "预置参数集id", type = ApiParamType.LONG)
    private Long profileId;
    @EntityField(name = "预置参数集名", type = ApiParamType.STRING)
    private String profileName;
    @EntityField(name = "预置参数列表", type = ApiParamType.JSONARRAY)
    private List<AutoexecProfileParamVo> profileParamList;
    @EntityField(name = "条件", type = ApiParamType.STRING)
    private String condition;
    @EntityField(name = "条件成立执行列表", type = ApiParamType.JSONARRAY)
    private List<AutoexecCombopPhaseOperationVo> ifList;
    @EntityField(name = "条件不成立执行列表", type = ApiParamType.JSONARRAY)
    private List<AutoexecCombopPhaseOperationVo> elseList;

    public List<ParamMappingVo> getParamMappingList() {
        return paramMappingList;
    }

    public void setParamMappingList(List<ParamMappingVo> paramMappingList) {
        this.paramMappingList = paramMappingList;
    }

    public List<ParamMappingVo> getArgumentMappingList() {
        return argumentMappingList;
    }

    public void setArgumentMappingList(List<ParamMappingVo> argumentMappingList) {
        this.argumentMappingList = argumentMappingList;
    }

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public List<AutoexecCombopPhaseOperationVo> getIfList() {
        return ifList;
    }

    public void setIfList(List<AutoexecCombopPhaseOperationVo> ifList) {
        this.ifList = ifList;
    }

    public List<AutoexecCombopPhaseOperationVo> getElseList() {
        return elseList;
    }

    public void setElseList(List<AutoexecCombopPhaseOperationVo> elseList) {
        this.elseList = elseList;
    }

    public List<AutoexecProfileParamVo> getProfileParamList() {
        return profileParamList;
    }

    public void setProfileParamList(List<AutoexecProfileParamVo> profileParamList) {
        this.profileParamList = profileParamList;
    }
}
