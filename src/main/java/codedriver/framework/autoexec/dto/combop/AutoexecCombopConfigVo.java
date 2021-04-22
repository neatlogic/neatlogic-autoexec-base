/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.combop;

import java.util.List;

/**
 * @author: linbq
 * @since: 2021/4/21 18:06
 **/
public class AutoexecCombopConfigVo {

    private List<AutoexecCombopPhaseVo> combopPhaseList;

    public List<AutoexecCombopPhaseVo> getCombopPhaseList() {
        return combopPhaseList;
    }

    public void setCombopPhaseList(List<AutoexecCombopPhaseVo> combopPhaseList) {
        this.combopPhaseList = combopPhaseList;
    }
}
