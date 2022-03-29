package codedriver.framework.autoexec.exception;

import codedriver.framework.exception.core.ApiRuntimeException;

/**
 * @author longrf
 * @date 2022/3/29 2:36 下午
 */
public class AutoexecScriptHasReferenceByProfileException extends ApiRuntimeException {
    public AutoexecScriptHasReferenceByProfileException() {
        super("当前自定义工具已经被发布profile工具引用，无法删除");
    }
}
