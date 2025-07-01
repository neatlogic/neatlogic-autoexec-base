package neatlogic.framework.autoexec.exception;

import neatlogic.framework.dto.runner.RunnerGroupVo;
import neatlogic.framework.exception.core.ApiRuntimeException;

public class AutoexecRunnerGroupRuleNotMatchException extends ApiRuntimeException {
    public AutoexecRunnerGroupRuleNotMatchException(RunnerGroupVo runnerGroupVo, String form) {
        super("nfae.autoexecrunnergrouprulenotmatchexception.autoexecrunnergrouprulenotmatchexception", form, runnerGroupVo.getName(), runnerGroupVo.getId());
    }

    public AutoexecRunnerGroupRuleNotMatchException(RunnerGroupVo runnerGroupVo, String form, String formName) {
        super("{0}“{3}”设置的执行器组“{1}({2})”,不满足规则", form, runnerGroupVo.getName(), runnerGroupVo.getId(), formName);
    }

}
