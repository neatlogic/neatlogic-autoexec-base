/*
 * Copyright (c)  2022 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.exception;

import codedriver.framework.autoexec.dto.job.AutoexecJobVo;
import codedriver.framework.exception.core.ApiRuntimeException;

public class AutoexecJobUpdateNodeByPreOutPutListException extends ApiRuntimeException {
    private static final long serialVersionUID = 4165697641029305057L;

    public AutoexecJobUpdateNodeByPreOutPutListException(AutoexecJobVo jobVo) {
        super("作业通过上游出参更新执行目标异常：配置错误，请确认配置后重试");
    }
}
