package neatlogic.framework.autoexec.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

/**
 * @author longrf
 * @date 2022/3/18 11:00 上午
 */
public class AutoexecProfileHasBeenReferredException extends ApiRuntimeException {
    private static final long serialVersionUID = 7545519122832745739L;

    public AutoexecProfileHasBeenReferredException(String name) {
        super("exception.autoexec.autoexecprofilehasbeenreferredexception", name);

    }
}
