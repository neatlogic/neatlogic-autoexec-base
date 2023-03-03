package neatlogic.framework.autoexec.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

/**
 * @author longrf
 * @date 2022/4/19 11:14 上午
 */
public class AutoexecScenarioRepeatException extends ApiRuntimeException {
    private static final long serialVersionUID = -8003494867526185700L;

    public AutoexecScenarioRepeatException(String name) {
        super("exception.autoexec.autoexecscenariorepeatexception", name);
    }
}
