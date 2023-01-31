/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.autoexec.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class AutoexecJobPhaseOperationMustBeCombopException extends ApiRuntimeException {

    private static final long serialVersionUID = -1846754071829308117L;

    public AutoexecJobPhaseOperationMustBeCombopException() {
        super("此操作仅支持'组合工具'");
    }


}
