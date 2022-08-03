/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.exception;

import codedriver.framework.exception.core.ApiRuntimeException;

public class AutoexecJobCanNotExecuteException extends ApiRuntimeException {

    private static final long serialVersionUID = -8039611777108111151L;

    public AutoexecJobCanNotExecuteException(Long jobId) {
        super("无法执行作业: " + jobId + "，需同时满足以下条件：触发方式为'人工触发'；状态为'已就绪'；用户为'执行用户'或拥有'作业管理'权限的用户");
    }


}
