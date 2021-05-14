/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.exception;

import codedriver.framework.exception.core.ApiRuntimeException;

/**
 * @author lvzk
 * @since 2021/5/14 12:23
 **/
public class AutoexecCombopPhasePreParamException extends ApiRuntimeException {
    private static final long serialVersionUID = 6959712402637246992L;

    public AutoexecCombopPhasePreParamException(String message) {
        super("引用上游节点输出参数异常："+message);
    }
}
