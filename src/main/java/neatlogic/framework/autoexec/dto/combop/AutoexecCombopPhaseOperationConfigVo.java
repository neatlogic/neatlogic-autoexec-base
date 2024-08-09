/*Copyright (C) 2023  深圳极向量科技有限公司 All Rights Reserved.

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.*/

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
    @EntityField(name = "循环项", type = ApiParamType.STRING)
    private String loopItems;
    @EntityField(name = "循环项变量", type = ApiParamType.STRING)
    private String loopItemVar;
    @EntityField(name = "循环执行工具列表", type = ApiParamType.JSONARRAY)
    private List<AutoexecCombopPhaseOperationVo> operations;

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

    public List<AutoexecCombopPhaseOperationVo> getOperations() {
        return operations;
    }

    public void setOperations(List<AutoexecCombopPhaseOperationVo> operations) {
        this.operations = operations;
    }

    public String getLoopItems() {
        return loopItems;
    }

    public void setLoopItems(String loopItems) {
        this.loopItems = loopItems;
    }

    public String getLoopItemVar() {
        return loopItemVar;
    }

    public void setLoopItemVar(String loopItemVar) {
        this.loopItemVar = loopItemVar;
    }
}
