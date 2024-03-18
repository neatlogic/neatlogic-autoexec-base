/*Copyright (C) 2024  深圳极向量科技有限公司 All Rights Reserved.

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
