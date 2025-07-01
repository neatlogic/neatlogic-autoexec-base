package neatlogic.framework.autoexec.exception;

import neatlogic.framework.autoexec.dto.job.AutoexecJobPhaseVo;
import neatlogic.framework.exception.core.ApiRuntimeException;

public class AutoexecRunnerGroupNotFoundByTagException extends ApiRuntimeException {

    public AutoexecRunnerGroupNotFoundByTagException(String value) {
        super("nfae.autoexecrunnergroupnotfoundbytagexception.autoexecrunnergroupnotfoundbytagexception", value);
    }

    public AutoexecRunnerGroupNotFoundByTagException(String value, AutoexecJobPhaseVo jobPhaseVo) {
        super("nfae.autoexecrunnergroupnotfoundbytagexception.autoexecrunnergroupnotfoundbytagexceptionphase", jobPhaseVo.getName(), value);
    }
}
