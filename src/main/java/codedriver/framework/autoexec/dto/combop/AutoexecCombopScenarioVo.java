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
    private Long ScenarioId;
    @EntityField(name = "阶段id列表", type = ApiParamType.JSONARRAY)
    private List<Long> combopPhaseIdList;
    @EntityField(name = "阶段uuid列表", type = ApiParamType.JSONARRAY)
    private List<String> combopPhaseUuidList;

    public Long getScenarioId() {
        return ScenarioId;
    }

    public void setScenarioId(Long scenarioId) {
        ScenarioId = scenarioId;
    }

    public List<Long> getCombopPhaseIdList() {
        return combopPhaseIdList;
    }

    public void setCombopPhaseIdList(List<Long> combopPhaseIdList) {
        this.combopPhaseIdList = combopPhaseIdList;
    }

    public List<String> getCombopPhaseUuidList() {
        return combopPhaseUuidList;
    }

    public void setCombopPhaseUuidList(List<String> combopPhaseUuidList) {
        this.combopPhaseUuidList = combopPhaseUuidList;
    }
}
