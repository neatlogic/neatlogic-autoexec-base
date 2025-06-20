package neatlogic.framework.autoexec.exception;

import neatlogic.framework.autoexec.dto.job.AutoexecJobPhaseVo;
import neatlogic.framework.exception.core.ApiRuntimeException;

public class AutoexecRunnerGroupNotFoundByTagAndRuleException extends ApiRuntimeException {

    public AutoexecRunnerGroupNotFoundByTagAndRuleException(String value) {
        super("nfae.autoexecrunnergroupnotfoundbytagandruleexception.autoexecrunnergroupnotfoundbytagandruleexception", value);
    }

    public AutoexecRunnerGroupNotFoundByTagAndRuleException(String value, AutoexecJobPhaseVo jobPhaseVo) {
        super("nfae.autoexecrunnergroupnotfoundbytagandruleexception.autoexecrunnergroupnotfoundbytagandruleexceptionphase", jobPhaseVo.getName(), value);
    }
}
