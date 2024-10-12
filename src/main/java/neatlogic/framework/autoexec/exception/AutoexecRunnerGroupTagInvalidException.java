package neatlogic.framework.autoexec.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class AutoexecRunnerGroupTagInvalidException extends ApiRuntimeException {

    public AutoexecRunnerGroupTagInvalidException(String value) {
        super("nfae.autoexecrunnergrouptaginvalidexception.autoexecrunnergrouptaginvalidexception", value);
    }
}
