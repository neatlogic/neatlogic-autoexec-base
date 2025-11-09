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
