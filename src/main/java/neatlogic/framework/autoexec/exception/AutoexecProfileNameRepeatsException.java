package neatlogic.framework.autoexec.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

/**
 * @author longrf
 * @date 2022/3/25 5:01 下午
 */
public class AutoexecProfileNameRepeatsException extends ApiRuntimeException {
    private static final long serialVersionUID = 449283302399568001L;

    public AutoexecProfileNameRepeatsException(String name) {
        super("exception.autoexec.autoexecprofilenamerepeatsexception", name);
    }
}
