/*
 *
 * Copyright (C) 2025  TechSure Co., Ltd.  All Rights Reserved.
 * This file is part of the NeatLogic software.
 * Licensed under the NeatLogic Sustainable Use License (NSUL), Version 4.x – 2025.
 * You may use this file only in compliance with the License.
 * See the LICENSE file distributed with this work for the full license text.
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 */

package neatlogic.framework.autoexec.dto.combop;

import com.alibaba.fastjson.JSONObject;
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
    @EntityField(name = "并发数量", type = ApiParamType.INTEGER)
    private Integer parallelCount;
    @EntityField(name = "并发策略", type = ApiParamType.STRING)
    private String parallelPolicy;
    @EntityField(name = "前置执行目标配置", type = ApiParamType.JSONOBJECT)
    private JSONObject preCondition; //设置过滤器后，执行时只能在过滤器范围内选择执行目标


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

    public JSONObject getPreCondition() {
        return preCondition;
    }

    public void setPreCondition(JSONObject preCondition) {
        this.preCondition = preCondition;
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

    public String getParallelPolicy() {
        return parallelPolicy;
    }

    public void setParallelPolicy(String parallelPolicy) {
        this.parallelPolicy = parallelPolicy;
    }

    public Integer getParallelCount() {
        return parallelCount;
    }

    public void setParallelCount(Integer parallelCount) {
        this.parallelCount = parallelCount;
    }
}
