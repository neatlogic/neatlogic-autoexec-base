/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.exception;

import codedriver.framework.exception.core.ApiRuntimeException;

public class AutoexecJobNotSupportedExecuteAndRevokeException extends ApiRuntimeException {

    private static final long serialVersionUID = -3197031921753145510L;

    public AutoexecJobNotSupportedExecuteAndRevokeException() {
        super("只有从组合工具保存的作业才支持执行与撤销");
    }


}
