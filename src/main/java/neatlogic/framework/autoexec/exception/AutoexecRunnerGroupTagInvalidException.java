package neatlogic.framework.autoexec.exception;

import neatlogic.framework.autoexec.dto.job.AutoexecJobPhaseVo;
import neatlogic.framework.exception.core.ApiRuntimeException;

public class AutoexecRunnerGroupTagInvalidException extends ApiRuntimeException {

    private static final long serialVersionUID = -8429963336414538508L;

    public AutoexecRunnerGroupTagInvalidException(String value) {
        super("nfae.autoexecrunnergrouptaginvalidexception.autoexecrunnergrouptaginvalidexception", value);
    }

    public AutoexecRunnerGroupTagInvalidException(String value, AutoexecJobPhaseVo jobPhaseVo) {
        super("nfae.autoexecrunnergrouptaginvalidexception.autoexecrunnergrouptaginvalidexceptiona", jobPhaseVo.getName(), value);
    }
}
