package neatlogic.framework.autoexec.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

/**
 * @author longrf
 * @date 2022/4/19 11:23 上午
 */
public class AutoexecGlobalParamNameRepeatException extends ApiRuntimeException {
    private static final long serialVersionUID = 2811695475637054791L;

    public AutoexecGlobalParamNameRepeatException(String name) {
        super("exception.autoexec.autoexecglobalparamnamerepeatexception", name);
    }
}
