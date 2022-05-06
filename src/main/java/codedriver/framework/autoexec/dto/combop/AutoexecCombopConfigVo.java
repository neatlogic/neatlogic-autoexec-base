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
 * @since: 2021/4/21 18:06
 **/
public class AutoexecCombopConfigVo implements Serializable {

    @EntityField(name = "阶段列表", type = ApiParamType.JSONARRAY)
    private List<AutoexecCombopPhaseVo> combopPhaseList;

    @EntityField(name = "阶段组列表", type = ApiParamType.JSONARRAY)
    private List<AutoexecCombopGroupVo> combopGroupList;

    @EntityField(name = "执行目标配置", type = ApiParamType.JSONOBJECT)
    private AutoexecCombopExecuteConfigVo executeConfig;

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
}
