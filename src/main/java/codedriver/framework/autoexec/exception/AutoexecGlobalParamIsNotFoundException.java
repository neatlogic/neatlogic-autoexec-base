package codedriver.framework.autoexec.exception;

import codedriver.framework.exception.core.ApiRuntimeException;

/**
 * @author longrf
 * @date 2022/4/18 7:09 下午
 */
public class AutoexecGlobalParamIsNotFoundException extends ApiRuntimeException {
    public AutoexecGlobalParamIsNotFoundException(Long paramId) {
        super("全局参数 id“" + paramId + "”不存在");
    }
}
