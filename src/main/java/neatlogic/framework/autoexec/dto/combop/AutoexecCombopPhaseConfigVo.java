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

import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;

import java.io.Serializable;
import java.util.List;

/**
 * @author: linbq
 * @since: 2021/4/21 18:29
 **/
public class AutoexecCombopPhaseConfigVo implements Serializable {
    private static final long serialVersionUID = -9186252904413790405L;
    @EntityField(name = "nfad.autoexeccombopphaseconfigvo.entityfield.phaseoperationlist.name", type = ApiParamType.JSONARRAY)
    private List<AutoexecCombopPhaseOperationVo> phaseOperationList;
    @EntityField(name = "term.autoexec.executetargetconfig", type = ApiParamType.JSONOBJECT)
    private AutoexecCombopExecuteConfigVo executeConfig;

    public List<AutoexecCombopPhaseOperationVo> getPhaseOperationList() {
        return phaseOperationList;
    }

    public void setPhaseOperationList(List<AutoexecCombopPhaseOperationVo> phaseOperationList) {
        this.phaseOperationList = phaseOperationList;
    }

    public AutoexecCombopExecuteConfigVo getExecuteConfig() {
        return executeConfig;
    }

    public void setExecuteConfig(AutoexecCombopExecuteConfigVo executeConfig) {
        this.executeConfig = executeConfig;
    }
}
