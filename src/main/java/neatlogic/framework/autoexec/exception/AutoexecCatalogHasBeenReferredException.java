package neatlogic.framework.autoexec.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class AutoexecCatalogHasBeenReferredException extends ApiRuntimeException {

    private static final long serialVersionUID = -928973151311839786L;

    public AutoexecCatalogHasBeenReferredException(String name) {
        super("exception.autoexec.autoexeccataloghasbeenreferredexception", name);
    }
}
