package neatlogic.framework.autoexec.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class AutoexecRunnerGroupTagNotMatchException extends ApiRuntimeException {
    public AutoexecRunnerGroupTagNotMatchException(String value) {
        super("不存在执行器(runner)满足：执行器组在标签“{0}”范围内", value);
    }

    public AutoexecRunnerGroupTagNotMatchException(String runnerGroupFrom, String runnerGroupTagFrom, String runnerGroupName, String runnerGroupTagName) {
        super("nfae.autoexecrunnergrouptagnotmatchexception.autoexecrunnergrouptagnotmatchexception", runnerGroupFrom, runnerGroupName, runnerGroupTagFrom, runnerGroupTagName);
    }
}
