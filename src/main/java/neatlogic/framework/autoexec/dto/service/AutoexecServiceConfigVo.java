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

package neatlogic.framework.autoexec.dto.service;

import com.alibaba.fastjson.JSONObject;
import neatlogic.framework.autoexec.dto.combop.ParamMappingVo;

import java.io.Serializable;
import java.util.List;

public class AutoexecServiceConfigVo implements Serializable {

    private Long scenarioId;

    private ParamMappingVo roundCount;

    private ParamMappingVo parallelCount;

    private ParamMappingVo parallelPolicy;

    private ParamMappingVo protocol;

    private ParamMappingVo executeNodeConfig;

    private ParamMappingVo executeUser;

    private ParamMappingVo runnerGroup;

    private ParamMappingVo runnerGroupTag;

    private List<ParamMappingVo> runtimeParamList;

    private JSONObject preCondition;

    public Long getScenarioId() {
        return scenarioId;
    }

    public void setScenarioId(Long scenarioId) {
        this.scenarioId = scenarioId;
    }

    public ParamMappingVo getRoundCount() {
        return roundCount;
    }

    public void setRoundCount(ParamMappingVo roundCount) {
        this.roundCount = roundCount;
    }

    public ParamMappingVo getProtocol() {
        return protocol;
    }

    public void setProtocol(ParamMappingVo protocol) {
        this.protocol = protocol;
    }

    public ParamMappingVo getExecuteNodeConfig() {
        return executeNodeConfig;
    }

    public void setExecuteNodeConfig(ParamMappingVo executeNodeConfig) {
        this.executeNodeConfig = executeNodeConfig;
    }

    public ParamMappingVo getExecuteUser() {
        return executeUser;
    }

    public void setExecuteUser(ParamMappingVo executeUser) {
        this.executeUser = executeUser;
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

    public List<ParamMappingVo> getRuntimeParamList() {
        return runtimeParamList;
    }

    public void setRuntimeParamList(List<ParamMappingVo> runtimeParamList) {
        this.runtimeParamList = runtimeParamList;
    }

    public ParamMappingVo getParallelCount() {
        return parallelCount;
    }

    public void setParallelCount(ParamMappingVo parallelCount) {
        this.parallelCount = parallelCount;
    }

    public ParamMappingVo getParallelPolicy() {
        return parallelPolicy;
    }

    public void setParallelPolicy(ParamMappingVo parallelPolicy) {
        this.parallelPolicy = parallelPolicy;
    }

    public JSONObject getPreCondition() {
        return preCondition;
    }

    public void setPreCondition(JSONObject preCondition) {
        this.preCondition = preCondition;
    }
}
