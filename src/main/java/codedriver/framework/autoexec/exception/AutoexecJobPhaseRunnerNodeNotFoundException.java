/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.exception;

import codedriver.framework.exception.core.ApiRuntimeException;

public class AutoexecJobPhaseRunnerNodeNotFoundException extends ApiRuntimeException {

    private static final long serialVersionUID = -7403012386956725383L;

    public AutoexecJobPhaseRunnerNodeNotFoundException(String jobPhase) {
        super("作业剧本runner节点：'" + jobPhase + "' 不存在");
    }


}
