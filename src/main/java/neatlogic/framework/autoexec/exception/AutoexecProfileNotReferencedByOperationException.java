package neatlogic.framework.autoexec.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

/**
 * @author longrf
 * @date 2022/3/18 11:00 上午
 */
public class AutoexecProfileNotReferencedByOperationException extends ApiRuntimeException {
    private static final long serialVersionUID = -6188997839410484037L;

    public AutoexecProfileNotReferencedByOperationException(Long profileId, Long operationId) {
        super("nfae.autoexecprofilenotreferencedbyoperationexception.autoexecprofilenotreferencedbyoperationexception", profileId, operationId);
    }

    public AutoexecProfileNotReferencedByOperationException(String profileName, String operationName) {
        super("nfae.autoexecprofilenotreferencedbyoperationexception.autoexecprofilenotreferencedbyoperationexception", profileName, operationName);
    }
}
