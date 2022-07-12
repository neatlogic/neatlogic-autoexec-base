/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.combop;

import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;

import java.util.List;

public class AutoexecCombopScenarioVo {
    @EntityField(name = "场景id", type = ApiParamType.LONG)
    private Long scenarioId;
    @EntityField(name = "场景名", type = ApiParamType.STRING)
    private String scenarioName;
    @EntityField(name = "阶段名列表", type = ApiParamType.JSONARRAY)
    private List<String> combopPhaseNameList;

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
}
