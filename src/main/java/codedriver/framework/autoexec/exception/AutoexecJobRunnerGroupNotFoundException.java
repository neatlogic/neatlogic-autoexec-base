/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.exception;

import codedriver.framework.exception.core.ApiRuntimeException;

public class AutoexecJobRunnerGroupNotFoundException extends ApiRuntimeException {

    private static final long serialVersionUID = -2208449808982631219L;

    public AutoexecJobRunnerGroupNotFoundException(String name) {
        super("runnerGroup: " + name + " 不存在");
    }
}
