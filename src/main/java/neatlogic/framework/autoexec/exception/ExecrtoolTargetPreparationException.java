package neatlogic.framework.autoexec.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

/** 指出整批校验失败的实际目标，并保留首个失败原因。 */
public class ExecrtoolTargetPreparationException extends ApiRuntimeException {
    /** 使用可定位的目标标识或批内序号，保留原始异常。 */
    public ExecrtoolTargetPreparationException(String target, Exception cause) {
        super("execrtoolinvoke.prepareFailed", cause, target, cause.getMessage());
    }
}
