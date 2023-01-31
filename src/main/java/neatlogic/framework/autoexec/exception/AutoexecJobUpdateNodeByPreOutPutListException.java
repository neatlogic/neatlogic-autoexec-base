/*
 * Copyright (c)  2022 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
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
        super("作业通过上游出参更新执行目标异常：配置错误，请确认配置后重试");
    }

    public AutoexecJobUpdateNodeByPreOutPutListException(AutoexecJobPhaseVo currentJobPhaseVo, List<AutoexecCombopPhaseVo> autoexecCombopPhaseVos) {
        super("作业通过上游出参更新阶段(" + autoexecCombopPhaseVos.stream().map(AutoexecCombopPhaseVo::getName).collect(Collectors.joining(",")) + ")的执行目标异常：target阶段(" + currentJobPhaseVo.getName() + ") 只允许存在一个节点");
    }
}
