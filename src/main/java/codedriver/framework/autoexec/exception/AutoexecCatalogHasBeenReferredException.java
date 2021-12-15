package codedriver.framework.autoexec.exception;

import codedriver.framework.exception.core.ApiRuntimeException;

public class AutoexecCatalogHasBeenReferredException extends ApiRuntimeException {

    private static final long serialVersionUID = -928973151311839786L;

    public AutoexecCatalogHasBeenReferredException(String name){
        super("目录：'" + name + "'中还有工具，不可删除");
    }
}
