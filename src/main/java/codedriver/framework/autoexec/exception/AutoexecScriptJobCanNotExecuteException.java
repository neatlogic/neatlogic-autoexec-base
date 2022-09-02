/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.exception;

import codedriver.framework.exception.core.ApiRuntimeException;

public class AutoexecScriptJobCanNotExecuteException extends ApiRuntimeException {

    private static final long serialVersionUID = -918734863398597862L;

    public AutoexecScriptJobCanNotExecuteException(Long jobId) {
        super("无法执行作业: " + jobId + "，当前用户没有'工具、自定义工具管理权限'");
    }


}
