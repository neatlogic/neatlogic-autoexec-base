package codedriver.framework.autoexec.exception;

import codedriver.framework.exception.core.ApiRuntimeException;

public class AutoexecExecModeNotFoundException extends ApiRuntimeException {

    private static final long serialVersionUID = 1866112846379463038L;

    public AutoexecExecModeNotFoundException(String name){
        super("执行方式：'" + name + "'不存在");
    }
}
