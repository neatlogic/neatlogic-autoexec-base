package neatlogic.framework.autoexec.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class AutoexecCatalogRepeatException extends ApiRuntimeException {

    private static final long serialVersionUID = 8295617007859765849L;

    public AutoexecCatalogRepeatException(String name) {
        super("工具目录：“{0}”已存在", name);
    }
}
