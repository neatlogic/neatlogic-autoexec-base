package codedriver.framework.autoexec.exception;

import codedriver.framework.exception.core.ApiRuntimeException;

/**
 * @author longrf
 * @date 2022/4/15 2:12 下午
 */
public class AutoexecScenarioIsNotFoundException extends ApiRuntimeException {
    public AutoexecScenarioIsNotFoundException(Long id) {
        super("场景 id“" + id + "”不存在");
    }
}