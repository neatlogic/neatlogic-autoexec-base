/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.combop;

import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;

import java.io.Serializable;
import java.util.List;

/**
 * @author: linbq
 * @since: 2021/4/21 18:29
 **/
public class AutoexecCombopPhaseConfigVo implements Serializable {
    @EntityField(name = "工具列表", type = ApiParamType.JSONARRAY)
    private List<AutoexecCombopPhaseOperationVo> phaseOperationList;
    @EntityField(name = "执行目标配置", type = ApiParamType.JSONOBJECT)
    private AutoexecCombopExecuteConfigVo executeConfig;
    @EntityField(name = "是否预设执行目标", type = ApiParamType.INTEGER)
    private Integer isPresetExecuteConfig;

    public List<AutoexecCombopPhaseOperationVo> getPhaseOperationList() {
        return phaseOperationList;
    }

    public void setPhaseOperationList(List<AutoexecCombopPhaseOperationVo> phaseOperationList) {
        this.phaseOperationList = phaseOperationList;
    }

    public AutoexecCombopExecuteConfigVo getExecuteConfig() {
        return executeConfig;
    }

    public void setExecuteConfig(AutoexecCombopExecuteConfigVo executeConfig) {
        this.executeConfig = executeConfig;
    }

    public Integer getIsPresetExecuteConfig() {
        return isPresetExecuteConfig;
    }

    public void setIsPresetExecuteConfig(Integer isPresetExecuteConfig) {
        this.isPresetExecuteConfig = isPresetExecuteConfig;
    }
}
