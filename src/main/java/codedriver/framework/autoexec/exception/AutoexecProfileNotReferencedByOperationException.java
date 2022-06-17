package codedriver.framework.autoexec.exception;

import codedriver.framework.exception.core.ApiRuntimeException;

/**
 * @author longrf
 * @date 2022/3/18 11:00 上午
 */
public class AutoexecProfileNotReferencedByOperationException extends ApiRuntimeException {
    private static final long serialVersionUID = -6188997839410484037L;

    public AutoexecProfileNotReferencedByOperationException(Long profileId, Long operationId) {
        super("profile：" + profileId + "”未关联工具：" + operationId);
    }

    public AutoexecProfileNotReferencedByOperationException(String profileName, String operationName) {
        super("profile：" + profileName + "”未关联工具：" + operationName);
    }
}
