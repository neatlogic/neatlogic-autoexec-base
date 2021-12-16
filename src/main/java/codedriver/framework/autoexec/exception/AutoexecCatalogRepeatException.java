package codedriver.framework.autoexec.exception;

import codedriver.framework.exception.core.ApiRuntimeException;

public class AutoexecCatalogRepeatException extends ApiRuntimeException {

    private static final long serialVersionUID = 8295617007859765849L;

    public AutoexecCatalogRepeatException(String name){
        super("工具目录：'" + name + "'已存在");
    }
}
