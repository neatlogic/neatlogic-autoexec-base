package neatlogic.framework.autoexec.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class AutoexecJobNotSupportMultiParentException extends ApiRuntimeException {

    public AutoexecJobNotSupportMultiParentException(Long jobId) {
        super("nfae.autoexecjobnotsupportmultiparentexception.autoexecjobnotsupportmultiparentexception", jobId);
    }
}
