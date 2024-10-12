package neatlogic.framework.autoexec.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class AutoexecRunnerGroupNotFoundByTagException extends ApiRuntimeException {

    public AutoexecRunnerGroupNotFoundByTagException(String value) {
        super("nfae.autoexecrunnergroupnotfoundbytagexception.autoexecrunnergroupnotfoundbytagexception", value);
    }
}
