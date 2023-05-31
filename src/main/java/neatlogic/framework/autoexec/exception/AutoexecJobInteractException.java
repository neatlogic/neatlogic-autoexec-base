package neatlogic.framework.autoexec.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class AutoexecJobInteractException extends ApiRuntimeException {

    private static final long serialVersionUID = 3024745064863084481L;

    public AutoexecJobInteractException() {
        super("exception.autoexec.autoexecjobinteractexception.a");
    }

    public AutoexecJobInteractException(String msg) {
        super("exception.autoexec.autoexecjobinteractexception.b", msg);
    }
}
