package codedriver.framework.autoexec.exception;

import codedriver.framework.exception.core.ApiRuntimeException;

/**
 * @author longrf
 * @date 2022/3/18 11:00 上午
 */
public class AutoexecProfileHasBeenReferredException extends ApiRuntimeException {
    public AutoexecProfileHasBeenReferredException(String name) {
        super("当前profile“" + name + "”工具已经引用，不可删除");

    }
}
