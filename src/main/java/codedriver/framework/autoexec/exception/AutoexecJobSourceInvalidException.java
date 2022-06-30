package codedriver.framework.autoexec.exception;

import codedriver.framework.exception.core.ApiRuntimeException;

public class AutoexecJobSourceInvalidException extends ApiRuntimeException {

    private static final long serialVersionUID = -7416333968448707570L;

    public AutoexecJobSourceInvalidException(String name){
        super("作业来源：'" + name + "'不合法");
    }
}
