/*
Copyright(c) $today.year NeatLogic Co., Ltd. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package neatlogic.framework.autoexec.dto.combop;

import neatlogic.framework.autoexec.dto.node.AutoexecNodeVo;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;

import java.io.Serializable;
import java.util.List;

/**
 * @author: linbq
 * @since: 2021/4/25 11:49
 **/
public class AutoexecCombopExecuteConfigVo implements Serializable {

    @EntityField(name = "协议", type = ApiParamType.STRING)
    private String protocol;
    @EntityField(name = "协议端口", type = ApiParamType.INTEGER)
    private Integer protocolPort;
    @EntityField(name = "协议id", type = ApiParamType.LONG)
    private Long protocolId;
    @EntityField(name = "执行用户", type = ApiParamType.JSONOBJECT)
    private ParamMappingVo executeUser;
    @EntityField(name = "如何指定执行目标，（现在指定执行目标、运行时再指定执行目标、运行参数作为执行目标）", type = ApiParamType.STRING)
    private String whenToSpecify;
    @EntityField(name = "执行目标配置", type = ApiParamType.JSONOBJECT)
    private AutoexecCombopExecuteNodeConfigVo executeNodeConfig;
    @EntityField(name = "白名单", type = ApiParamType.JSONARRAY)
    private List<AutoexecNodeVo> whitelist;
    @EntityField(name = "黑名单", type = ApiParamType.JSONARRAY)
    private List<AutoexecNodeVo> blacklist;
    @EntityField(name = "是否预设执行目标", type = ApiParamType.INTEGER)
    private Integer isPresetExecuteConfig;
    @EntityField(name = "分批数量", type = ApiParamType.INTEGER)
    private Integer roundCount;

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public Integer getProtocolPort() {
        return protocolPort;
    }

    public void setProtocolPort(Integer protocolPort) {
        this.protocolPort = protocolPort;
    }

    public Long getProtocolId() {
        return protocolId;
    }

    public void setProtocolId(Long protocolId) {
        this.protocolId = protocolId;
    }

    public ParamMappingVo getExecuteUser() {
        return executeUser;
    }

    public void setExecuteUser(ParamMappingVo executeUser) {
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

    public Integer getIsPresetExecuteConfig() {
        return isPresetExecuteConfig;
    }

    public void setIsPresetExecuteConfig(Integer isPresetExecuteConfig) {
        this.isPresetExecuteConfig = isPresetExecuteConfig;
    }

    public Integer getRoundCount() {
        return roundCount;
    }

    public void setRoundCount(Integer roundCount) {
        this.roundCount = roundCount;
    }
}
