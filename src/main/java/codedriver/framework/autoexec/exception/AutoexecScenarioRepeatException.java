package codedriver.framework.autoexec.exception;

import codedriver.framework.exception.core.ApiRuntimeException;

/**
 * @author longrf
 * @date 2022/4/19 11:14 上午
 */
public class AutoexecScenarioRepeatException extends ApiRuntimeException {
    public AutoexecScenarioRepeatException(String name) {
        super("场景名称：'" + name + "'已存在");
    }
}
