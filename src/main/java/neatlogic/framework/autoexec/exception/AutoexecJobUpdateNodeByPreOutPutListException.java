/*
Copyright(c) 2023 NeatLogic Co., Ltd. All Rights Reserved.

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
