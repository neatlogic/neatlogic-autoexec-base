/*Copyright (C) $today.year  深圳极向量科技有限公司 All Rights Reserved.

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.*/

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
    @EntityField(name = "runner执行组", type = ApiParamType.JSONOBJECT)
    private ParamMappingVo runnerGroup;
    @EntityField(name = "runner执行组标签", type = ApiParamType.JSONOBJECT)
    private ParamMappingVo runnerGroupTag;
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
    @EntityField(name = "前置执行目标配置", type = ApiParamType.JSONOBJECT)
    private AutoexecCombopExecuteNodeConfigVo combopNodeConfig; //设置过滤器后，执行时只能在过滤器范围内选择执行目标

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

    public AutoexecCombopExecuteNodeConfigVo getCombopNodeConfig() {
        return combopNodeConfig;
    }

    public void setCombopNodeConfig(AutoexecCombopExecuteNodeConfigVo combopNodeConfig) {
        this.combopNodeConfig = combopNodeConfig;
    }

    public ParamMappingVo getRunnerGroup() {
        return runnerGroup;
    }

    public void setRunnerGroup(ParamMappingVo runnerGroup) {
        this.runnerGroup = runnerGroup;
    }

    public ParamMappingVo getRunnerGroupTag() {
        return runnerGroupTag;
    }

    public void setRunnerGroupTag(ParamMappingVo runnerGroupTag) {
        this.runnerGroupTag = runnerGroupTag;
    }
}
