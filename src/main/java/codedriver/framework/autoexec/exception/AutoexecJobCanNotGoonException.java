/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.exception;

import codedriver.framework.exception.core.ApiRuntimeException;

public class AutoexecJobCanNotGoonException extends ApiRuntimeException {

    private static final long serialVersionUID = -1740731878298153021L;

    public AutoexecJobCanNotGoonException(String jobId) {
        super("无法暂停作业: "+jobId+"，请确保作业存于'运行中（running）'状态");
    }


}
