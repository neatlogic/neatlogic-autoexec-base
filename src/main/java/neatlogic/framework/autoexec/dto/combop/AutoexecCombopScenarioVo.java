/*Copyright (C) 2024  深圳极向量科技有限公司 All Rights Reserved.

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

import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;

import java.io.Serializable;
import java.util.List;

public class AutoexecCombopScenarioVo implements Serializable {
    @EntityField(name = "场景id", type = ApiParamType.LONG)
    private Long scenarioId;
    @EntityField(name = "场景名", type = ApiParamType.STRING)
    private String scenarioName;
    @EntityField(name = "阶段名列表", type = ApiParamType.JSONARRAY)
    private List<String> combopPhaseNameList;

    //发布作业：当前场景是否有BUILD分类的工具，前端需要根据此标识调用 不同的选择版本下拉接口
    @EntityField(name = "是否拥有BUILD类型的工具库工具", type = ApiParamType.INTEGER)
    private int isHasBuildTypeTool = 0;
    @EntityField(name = "是否拥有DEPLOY类型的工具库工具", type = ApiParamType.INTEGER)
    private int isHasDeployTypeTool = 0;

    @EntityField(name = "前端展示时是否可选", type = ApiParamType.BOOLEAN)
    private Boolean isEnable;

    public Long getScenarioId() {
        return scenarioId;
    }

    public void setScenarioId(Long scenarioId) {
        this.scenarioId = scenarioId;
    }

    public String getScenarioName() {
        return scenarioName;
    }

    public void setScenarioName(String scenarioName) {
        this.scenarioName = scenarioName;
    }

    public List<String> getCombopPhaseNameList() {
        return combopPhaseNameList;
    }

    public void setCombopPhaseNameList(List<String> combopPhaseNameList) {
        this.combopPhaseNameList = combopPhaseNameList;
    }

    public Boolean getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Boolean isEnable) {
        this.isEnable = isEnable;
    }

    public int getIsHasBuildTypeTool() {
        return isHasBuildTypeTool;
    }

    public void setIsHasBuildTypeTool(int isHasBuildTypeTool) {
        this.isHasBuildTypeTool = isHasBuildTypeTool;
    }

    public int getIsHasDeployTypeTool() {
        return isHasDeployTypeTool;
    }

    public void setIsHasDeployTypeTool(int isHasDeployTypeTool) {
        this.isHasDeployTypeTool = isHasDeployTypeTool;
    }
}
