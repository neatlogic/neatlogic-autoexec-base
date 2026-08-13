package neatlogic.framework.autoexec.exception;

import neatlogic.framework.dto.runner.RunnerGroupVo;
import neatlogic.framework.exception.core.ApiRuntimeException;

public class AutoexecRunnerGroupRuleNotMatchException extends ApiRuntimeException {
    public AutoexecRunnerGroupRuleNotMatchException(RunnerGroupVo runnerGroupVo, String form) {
        super("nfae.autoexecrunnergrouprulenotmatchexception.autoexecrunnergrouprulenotmatchexception", form, runnerGroupVo.getName(), runnerGroupVo.getId());
    }

    public AutoexecRunnerGroupRuleNotMatchException(RunnerGroupVo runnerGroupVo, String form, String formName) {
        super("nfae.autoexecrunnergrouprulenotmatchexception.autoexecrunnergrouprulenotmatchexception_a", form, runnerGroupVo.getName(), runnerGroupVo.getId(), formName);
    }

}
