package codedriver.framework.autoexec.exception;

import codedriver.framework.exception.core.ApiRuntimeException;

public class AutoexecJobActionInvalidException extends ApiRuntimeException {

    private static final long serialVersionUID = 4088710250739420409L;
    public AutoexecJobActionInvalidException(){
        super("作业执行策略不能为null，执行所有节点：refireResetAll；跳过所有已完成、已忽略的节点：refireAll");
    }

}
