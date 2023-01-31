package neatlogic.framework.autoexec.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

/**
 * @author longrf
 * @date 2022/4/15 2:12 下午
 */
public class AutoexecScenarioIsNotFoundException extends ApiRuntimeException {
    public AutoexecScenarioIsNotFoundException(Long id) {
        super("场景 id“" + id + "”不存在");
    }

    public AutoexecScenarioIsNotFoundException(String name) {
        super("场景 “" + name + "”不存在");
    }
}