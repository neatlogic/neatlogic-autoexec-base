/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.autoexec.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class AutoexecJobTakeOverPermissionDeniedException extends ApiRuntimeException {

    private static final long serialVersionUID = 3175429889181207833L;

    public AutoexecJobTakeOverPermissionDeniedException(Long jobId) {
        super("您没有权限接管作业: " + jobId);
    }


}
