package codedriver.framework.autoexec.exception;

import codedriver.framework.exception.core.ApiRuntimeException;

/**
 * @author longrf
 * @date 2022/3/25 5:01 下午
 */
public class AutoexecProfileNameRepeatsException extends ApiRuntimeException {
    public AutoexecProfileNameRepeatsException(String name) {
        super("profile名称：'" + name + "'已存在");
    }
}
