package neatlogic.framework.autoexec.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

/**
 * @author longrf
 * @date 2022/4/19 11:21 上午
 */
public class AutoexecGlobalParamKeyRepeatException extends ApiRuntimeException {
    private static final long serialVersionUID = 1583391303875131143L;

    public AutoexecGlobalParamKeyRepeatException(String name) {
        super("exception.autoexec.autoexecglobalparamkeyrepeatexception", name);
    }
}
