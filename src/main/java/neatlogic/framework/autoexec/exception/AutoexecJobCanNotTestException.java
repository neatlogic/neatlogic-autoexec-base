/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.autoexec.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class AutoexecJobCanNotTestException extends ApiRuntimeException {

    private static final long serialVersionUID = -8770787702818369798L;

    public AutoexecJobCanNotTestException(String jobId) {
        super("无法测试工具库: "+jobId+"，存在正在测试该工具库的作业");
    }

}
