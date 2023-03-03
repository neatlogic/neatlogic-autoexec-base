/*
 * Copyright(c) 2023 NeatLogic Co., Ltd. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package neatlogic.framework.autoexec.dto.service;

import neatlogic.framework.autoexec.dto.combop.ParamMappingVo;

import java.io.Serializable;
import java.util.List;

public class AutoexecServiceConfigVo implements Serializable {

    private Long scenarioId;

    private ParamMappingVo roundCount;

    private ParamMappingVo protocol;

    private ParamMappingVo executeNodeConfig;

    private ParamMappingVo executeUser;

    private List<ParamMappingVo> runtimeParamList;

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

    public List<ParamMappingVo> getRuntimeParamList() {
        return runtimeParamList;
    }

    public void setRuntimeParamList(List<ParamMappingVo> runtimeParamList) {
        this.runtimeParamList = runtimeParamList;
    }
}
