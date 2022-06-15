package codedriver.framework.autoexec.exception;

import codedriver.framework.exception.core.ApiRuntimeException;

public class AutoexecJobInteractException extends ApiRuntimeException {

    private static final long serialVersionUID = 3024745064863084481L;

    public AutoexecJobInteractException() {
        super("interact is null");
    }

    public AutoexecJobInteractException(String msg) {
        super("interact failed! " + msg);
    }
}
