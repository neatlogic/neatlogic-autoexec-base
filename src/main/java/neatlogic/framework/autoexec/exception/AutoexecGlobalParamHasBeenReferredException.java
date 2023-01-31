package neatlogic.framework.autoexec.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

/**
 * @author longrf
 * @date 2022/6/10 3:05 下午
 */
public class AutoexecGlobalParamHasBeenReferredException extends ApiRuntimeException {
    public AutoexecGlobalParamHasBeenReferredException(String name) {
        super("全局参数“" + name + "” 被引用,无法删除");
    }
}
