/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.autoexec.dto.combop;

import neatlogic.framework.autoexec.dto.AutoexecParamVo;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.notify.dto.InvokeNotifyPolicyConfigVo;
import neatlogic.framework.restful.annotation.EntityField;

import java.io.Serializable;
import java.util.List;

/**
 * @author: linbq
 * @since: 2021/4/21 18:06
 **/
public class AutoexecCombopConfigVo implements Serializable {

    @EntityField(name = "通知策略配置", type = ApiParamType.STRING)
    private InvokeNotifyPolicyConfigVo invokeNotifyPolicyConfig;

    @EntityField(name = "阶段列表", type = ApiParamType.JSONARRAY)
    private List<AutoexecCombopPhaseVo> combopPhaseList;

    @EntityField(name = "阶段组列表", type = ApiParamType.JSONARRAY)
    private List<AutoexecCombopGroupVo> combopGroupList;

    @EntityField(name = "执行目标配置", type = ApiParamType.JSONOBJECT)
    private AutoexecCombopExecuteConfigVo executeConfig;

    @EntityField(name = "场景列表", type = ApiParamType.JSONARRAY)
    private List<AutoexecCombopScenarioVo> scenarioList;

    @EntityField(name = "默认场景id", type = ApiParamType.LONG)
    private Long defaultScenarioId;

    @EntityField(name = "运行时参数列表", type = ApiParamType.INTEGER)
    private List<AutoexecParamVo> runtimeParamList;

    public InvokeNotifyPolicyConfigVo getInvokeNotifyPolicyConfig() {
        return invokeNotifyPolicyConfig;
    }

    public void setInvokeNotifyPolicyConfig(InvokeNotifyPolicyConfigVo invokeNotifyPolicyConfig) {
        this.invokeNotifyPolicyConfig = invokeNotifyPolicyConfig;
    }

    public List<AutoexecCombopPhaseVo> getCombopPhaseList() {
        return combopPhaseList;
    }

    public void setCombopPhaseList(List<AutoexecCombopPhaseVo> combopPhaseList) {
        this.combopPhaseList = combopPhaseList;
    }

    public List<AutoexecCombopGroupVo> getCombopGroupList() {
        return combopGroupList;
    }

    public void setCombopGroupList(List<AutoexecCombopGroupVo> combopGroupList) {
        this.combopGroupList = combopGroupList;
    }

    public AutoexecCombopExecuteConfigVo getExecuteConfig() {
        return executeConfig;
    }

    public void setExecuteConfig(AutoexecCombopExecuteConfigVo executeConfig) {
        this.executeConfig = executeConfig;
    }

    public List<AutoexecCombopScenarioVo> getScenarioList() {
        return scenarioList;
    }

    public void setScenarioList(List<AutoexecCombopScenarioVo> scenarioList) {
        this.scenarioList = scenarioList;
    }

    public Long getDefaultScenarioId() {
        return defaultScenarioId;
    }

    public void setDefaultScenarioId(Long defaultScenarioId) {
        this.defaultScenarioId = defaultScenarioId;
    }

    public List<AutoexecParamVo> getRuntimeParamList() {
        return runtimeParamList;
    }

    public void setRuntimeParamList(List<AutoexecParamVo> runtimeParamList) {
        this.runtimeParamList = runtimeParamList;
    }
}
