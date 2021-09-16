/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.combop;

import java.io.Serializable;

/**
 * @author: linbq
 * @since: 2021/4/25 11:49
 **/
public class AutoexecCombopExecuteConfigVo implements Serializable {

    private String protocol;

    private Long protocolId;

    private String executeUser;

    private String whenToSpecify;

    private AutoexecCombopExecuteNodeConfigVo executeNodeConfig;

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public Long getProtocolId() {
        return protocolId;
    }

    public void setProtocolId(Long protocolId) {
        this.protocolId = protocolId;
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
