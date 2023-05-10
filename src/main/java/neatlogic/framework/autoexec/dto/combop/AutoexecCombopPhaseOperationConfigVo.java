/*
Copyright(c) 2023 NeatLogic Co., Ltd. All Rights Reserved.

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

import neatlogic.framework.autoexec.dto.profile.AutoexecProfileParamVo;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;

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
