package neatlogic.framework.autoexec.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

/**
 * @author longrf
 * @date 2022/4/19 11:23 上午
 */
public class AutoexecGlobalParamNameRepeatException extends ApiRuntimeException {
    public AutoexecGlobalParamNameRepeatException(String name) {
        super("全局参数显示名：'" + name + "'已存在");
    }
}
