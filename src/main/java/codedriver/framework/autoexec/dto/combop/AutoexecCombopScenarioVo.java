/*
 * Copyright(c) 2022 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.combop;

import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;

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
