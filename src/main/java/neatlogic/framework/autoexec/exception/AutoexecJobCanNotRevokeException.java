/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.autoexec.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class AutoexecJobCanNotRevokeException extends ApiRuntimeException {

    private static final long serialVersionUID = -6343241416891736903L;

    public AutoexecJobCanNotRevokeException(Long jobId) {
        super("无法撤销作业: " + jobId + "，执行用户才有权限撤销，且作业需要处于'已就绪'状态");
    }


}
