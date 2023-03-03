package neatlogic.framework.autoexec.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class AutoexecJobActionInvalidException extends ApiRuntimeException {

    private static final long serialVersionUID = 4088710250739420409L;
    public AutoexecJobActionInvalidException(){
        super("exception.autoexec.autoexecjobactioninvalidexception");
    }

}
