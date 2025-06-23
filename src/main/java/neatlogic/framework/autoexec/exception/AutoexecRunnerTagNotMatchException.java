package neatlogic.framework.autoexec.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class AutoexecRunnerTagNotMatchException extends ApiRuntimeException {
    public AutoexecRunnerTagNotMatchException(String value) {
        super("找不到同时满足：标签“{0}”和规则的执行器组", value);
    }

    public AutoexecRunnerTagNotMatchException(String runnerGroupFrom, String runnerGroupTagFrom, String runnerGroupName, String runnerGroupTagName) {
        super("nfae.autoexecrunnergrouptagnotmatchexception.autoexecrunnergrouptagnotmatchexception", runnerGroupFrom, runnerGroupName, runnerGroupTagFrom, runnerGroupTagName);
    }
}
