package neatlogic.framework.autoexec.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class AutoexecJobSourceInvalidException extends ApiRuntimeException {

    private static final long serialVersionUID = -7416333968448707570L;

    public AutoexecJobSourceInvalidException(String name) {
        super("exception.autoexec.autoexecjobsourceinvalidexception", name);
    }
}
