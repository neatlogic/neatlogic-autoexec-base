/*
 * Copyright (c)  2022 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.autoexec.exception;

import neatlogic.framework.autoexec.dto.job.AutoexecJobPhaseVo;
import neatlogic.framework.exception.core.ApiRuntimeException;

public class AutoexecJobPhaseRunnerNotFoundException extends ApiRuntimeException {
    private static final long serialVersionUID = 2559211960167897973L;

    public AutoexecJobPhaseRunnerNotFoundException(AutoexecJobPhaseVo phaseVo) {
        super("作业（"+phaseVo.getJobId()+"）阶段"+phaseVo.getName()+"（"+phaseVo.getId()+"） 找不到runner");
    }
}

