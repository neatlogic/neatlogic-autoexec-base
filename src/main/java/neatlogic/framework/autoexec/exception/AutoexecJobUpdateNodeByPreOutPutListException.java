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

package neatlogic.framework.autoexec.exception;

import neatlogic.framework.autoexec.dto.combop.AutoexecCombopPhaseVo;
import neatlogic.framework.autoexec.dto.job.AutoexecJobPhaseVo;
import neatlogic.framework.autoexec.dto.job.AutoexecJobVo;
import neatlogic.framework.exception.core.ApiRuntimeException;

import java.util.List;
import java.util.stream.Collectors;

public class AutoexecJobUpdateNodeByPreOutPutListException extends ApiRuntimeException {
    private static final long serialVersionUID = 4165697641029305057L;

    public AutoexecJobUpdateNodeByPreOutPutListException(AutoexecJobVo jobVo) {
        super("作业“{0}”通过上游出参更新执行目标异常：配置错误，请确认配置后重试", jobVo.getId());
    }

    public AutoexecJobUpdateNodeByPreOutPutListException(AutoexecJobPhaseVo currentJobPhaseVo, List<AutoexecCombopPhaseVo> autoexecCombopPhaseVos) {
        super("作业通过上游出参更新阶段({1})的执行目标异常：target阶段({0}) 只允许存在一个节点", autoexecCombopPhaseVos.stream().map(AutoexecCombopPhaseVo::getName).collect(Collectors.joining(",")), currentJobPhaseVo.getName());
    }
}
