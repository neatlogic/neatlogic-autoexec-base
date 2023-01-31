package neatlogic.framework.autoexec.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

/**
 * @author longrf
 * @date 2022/3/18 10:57 上午
 */
public class AutoexecProfileIsNotFoundException extends ApiRuntimeException {
    public AutoexecProfileIsNotFoundException(Long id) {
        super("profile id“" + id + "”不存在");
    }
}
