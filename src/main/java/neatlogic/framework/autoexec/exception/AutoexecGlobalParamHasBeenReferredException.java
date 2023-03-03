package neatlogic.framework.autoexec.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

/**
 * @author longrf
 * @date 2022/6/10 3:05 下午
 */
public class AutoexecGlobalParamHasBeenReferredException extends ApiRuntimeException {
    private static final long serialVersionUID = -7697433532280027555L;

    public AutoexecGlobalParamHasBeenReferredException(String name) {
        super("exception.autoexec.autoexecglobalparamhasbeenreferredexception", name);
    }
}
