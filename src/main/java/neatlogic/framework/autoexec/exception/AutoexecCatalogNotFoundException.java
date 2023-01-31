package neatlogic.framework.autoexec.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class AutoexecCatalogNotFoundException  extends ApiRuntimeException {

    private static final long serialVersionUID = 8992292645266664029L;

    public AutoexecCatalogNotFoundException(Long id){
        super("工具目录：'" + id + "'不存在");
    }

    public AutoexecCatalogNotFoundException(String name){
        super("工具目录：'" + name + "'不存在");
    }
}
