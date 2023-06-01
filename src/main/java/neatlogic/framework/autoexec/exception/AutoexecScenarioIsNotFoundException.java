package neatlogic.framework.autoexec.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

/**
 * @author longrf
 * @date 2022/4/15 2:12 下午
 */
public class AutoexecScenarioIsNotFoundException extends ApiRuntimeException {
    private static final long serialVersionUID = -6179270634867916136L;

    public AutoexecScenarioIsNotFoundException(Long id) {
        super("场景 “{0}”不存在", id);
    }

    public AutoexecScenarioIsNotFoundException(String name) {
        super("场景 “{0}”不存在", name);
    }
}