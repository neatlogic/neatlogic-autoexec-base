/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.combop;

import codedriver.framework.autoexec.dto.node.AutoexecNodeVo;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.List;

/**
 * @author: linbq
 * @since: 2021/4/25 11:49
 **/
public class AutoexecCombopExecuteConfigVo implements Serializable {

    @EntityField(name = "协议", type = ApiParamType.STRING)
    private String protocol;
    @EntityField(name = "协议id", type = ApiParamType.LONG)
    private Long protocolId;
    @EntityField(name = "执行用户", type = ApiParamType.STRING)
    private String executeUser;
    @EntityField(name = "如何指定执行目标，（现在指定执行目标、运行时再指定执行目标、运行参数作为执行目标）", type = ApiParamType.STRING)
    private String whenToSpecify;
    @EntityField(name = "执行目标配置", type = ApiParamType.JSONOBJECT)
    private AutoexecCombopExecuteNodeConfigVo executeNodeConfig;
    @EntityField(name = "白名单", type = ApiParamType.JSONARRAY)
    private List<AutoexecNodeVo> whitelist;
    @EntityField(name = "黑名单", type = ApiParamType.JSONARRAY)
    private List<AutoexecNodeVo> blacklist;

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public Long getProtocolId() {
        //TODO 临时兼容老数据，后续删除
        if (StringUtils.isNotBlank(protocol)) {
            try {
                protocolId = Long.valueOf(protocol);
            } catch (Exception ignored) {

            }
        }
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

    public List<AutoexecNodeVo> getWhitelist() {
        return whitelist;
    }

    public void setWhitelist(List<AutoexecNodeVo> whitelist) {
        this.whitelist = whitelist;
    }

    public List<AutoexecNodeVo> getBlacklist() {
        return blacklist;
    }

    public void setBlacklist(List<AutoexecNodeVo> blacklist) {
        this.blacklist = blacklist;
    }
}
