/*
 * Copyright (c)  2022 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.exception;

import codedriver.framework.exception.core.ApiRuntimeException;

public class AutoexecJobConfigNotFoundException extends ApiRuntimeException {
    private static final long serialVersionUID = 7835389708160437229L;

    public AutoexecJobConfigNotFoundException(Long jobId) {
        super("作业 "+jobId+" 配置不存在");
    }
}
