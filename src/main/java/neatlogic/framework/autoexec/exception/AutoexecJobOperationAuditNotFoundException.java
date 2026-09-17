package neatlogic.framework.autoexec.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

/** 审计记录不存在或不属于请求作业时，统一拒绝读取。 */
public class AutoexecJobOperationAuditNotFoundException extends ApiRuntimeException {
    /** 返回可定位的作业及记录标识，不暴露其它作业的数据。 */
    public AutoexecJobOperationAuditNotFoundException(Long jobId, Long auditId) {
        super("autoexec.operationaudit.notfound", jobId, auditId);
    }
}
