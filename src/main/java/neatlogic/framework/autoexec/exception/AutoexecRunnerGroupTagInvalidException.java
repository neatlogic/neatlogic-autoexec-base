package neatlogic.framework.autoexec.exception;

import neatlogic.framework.autoexec.dto.job.AutoexecJobPhaseVo;
import neatlogic.framework.exception.core.ApiRuntimeException;

public class AutoexecRunnerGroupTagInvalidException extends ApiRuntimeException {

    public AutoexecRunnerGroupTagInvalidException(String value) {
        super("nfae.autoexecrunnergrouptaginvalidexception.autoexecrunnergrouptaginvalidexception", value);
    }

    public AutoexecRunnerGroupTagInvalidException(String value, AutoexecJobPhaseVo jobPhaseVo) {
        super("nfae.autoexecrunnergrouptaginvalidexception.autoexecrunnergrouptaginvalidexceptiona", jobPhaseVo.getName(), value);
    }
}
