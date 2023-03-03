package neatlogic.framework.autoexec.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

/**
 * @author longrf
 * @date 2022/4/18 7:09 下午
 */
public class AutoexecGlobalParamIsNotFoundException extends ApiRuntimeException {
    private static final long serialVersionUID = -8092385572700724749L;

    public AutoexecGlobalParamIsNotFoundException(Long paramId) {
        super("exception.autoexec.autoexecglobalparamisnotfoundexception", paramId);
    }

    public AutoexecGlobalParamIsNotFoundException(String key) {
        super("exception.autoexec.autoexecglobalparamisnotfoundexception", key);
    }
}
