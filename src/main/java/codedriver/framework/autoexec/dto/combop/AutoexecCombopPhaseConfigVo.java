/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.combop;

import java.util.List;

/**
 * @author: linbq
 * @since: 2021/4/21 18:29
 **/
public class AutoexecCombopPhaseConfigVo {
    private List<AutoexecCombopPhaseOperationVo> phaseOperationList;
    private List phaseNodeList;

    public List<AutoexecCombopPhaseOperationVo> getPhaseOperationList() {
        return phaseOperationList;
    }

    public void setPhaseOperationList(List<AutoexecCombopPhaseOperationVo> phaseOperationList) {
        this.phaseOperationList = phaseOperationList;
    }

    public List getPhaseNodeList() {
        return phaseNodeList;
    }

    public void setPhaseNodeList(List phaseNodeList) {
        this.phaseNodeList = phaseNodeList;
    }
}
