package neatlogic.framework.autoexec.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class AutoexecCatalogNotFoundException extends ApiRuntimeException {

    private static final long serialVersionUID = 8992292645266664029L;

    public AutoexecCatalogNotFoundException(Long id) {
        super("exception.autoexec.autoexeccatalognotfoundexception", id);
    }
}
