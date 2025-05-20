package neatlogic.framework.autoexec.exception;

import neatlogic.framework.autoexec.dto.job.AutoexecJobPhaseVo;
import neatlogic.framework.exception.core.ApiRuntimeException;

public class AutoexecRunnerGroupNotFoundByTagException extends ApiRuntimeException {

    public AutoexecRunnerGroupNotFoundByTagException(String value) {
        super("nfae.autoexecrunnergroupnotfoundbytagexception.autoexecrunnergroupnotfoundbytagexception", value);
    }

    public AutoexecRunnerGroupNotFoundByTagException(String value, AutoexecJobPhaseVo jobPhaseVo) {
        super("根据作业阶段”{0}“设置的执行器组标签“{1}”，找不到执行器组", jobPhaseVo.getName(), value);
    }
}
