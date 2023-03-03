package neatlogic.framework.autoexec.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

/**
 * @author longrf
 * @date 2022/3/18 10:57 上午
 */
public class AutoexecProfileIsNotFoundException extends ApiRuntimeException {
    private static final long serialVersionUID = -5868227422405940239L;

    public AutoexecProfileIsNotFoundException(Long id) {
        super("exception.autoexec.autoexecprofileisnotfoundexception", id);
    }
}
