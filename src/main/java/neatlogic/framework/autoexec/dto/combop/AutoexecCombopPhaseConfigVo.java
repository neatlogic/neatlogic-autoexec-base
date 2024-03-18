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
    @EntityField(name = "工具列表", type = ApiParamType.JSONARRAY)
    private List<AutoexecCombopPhaseOperationVo> phaseOperationList;
    @EntityField(name = "执行目标配置", type = ApiParamType.JSONOBJECT)
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
