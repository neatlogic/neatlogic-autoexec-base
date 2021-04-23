/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.combop;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @author: linbq
 * @since: 2021/4/21 18:06
 **/
public class AutoexecCombopConfigVo {

    private List<AutoexecCombopPhaseVo> combopPhaseList;

    private String executeUser;

    private String whenToSpecify;

    private AutoexecCombopExecuteNodeConfigVo executeNodeConfig;

    public List<AutoexecCombopPhaseVo> getCombopPhaseList() {
        return combopPhaseList;
    }

    public void setCombopPhaseList(List<AutoexecCombopPhaseVo> combopPhaseList) {
        this.combopPhaseList = combopPhaseList;
    }

    public String getExecuteUser() {
        return executeUser;
    }

    public void setExecuteUser(String executeUser) {
        this.executeUser = executeUser;
    }

    public String getWhenToSpecify() {
        return whenToSpecify;
    }

    public void setWhenToSpecify(String whenToSpecify) {
        this.whenToSpecify = whenToSpecify;
    }

    public AutoexecCombopExecuteNodeConfigVo getExecuteNodeConfig() {
        return executeNodeConfig;
    }

    public void setExecuteNodeConfig(AutoexecCombopExecuteNodeConfigVo executeNodeConfig) {
        this.executeNodeConfig = executeNodeConfig;
    }
}
