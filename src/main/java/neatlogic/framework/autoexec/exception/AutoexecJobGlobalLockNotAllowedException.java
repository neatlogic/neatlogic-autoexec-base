package neatlogic.framework.autoexec.exception;
import neatlogic.framework.exception.core.ApiRuntimeException;
import neatlogic.framework.dto.globallock.GlobalLockVo;
/** 终态作业不得重新入队或获取资源锁。 */
public class AutoexecJobGlobalLockNotAllowedException extends ApiRuntimeException {
    /** 返回当前作业及阻止获锁的终态。 */
    public AutoexecJobGlobalLockNotAllowedException(Long jobId, String status) {
        super("globallock.terminal", jobId, status);
    }

    /** 附带本次申请的锁及执行身份，区分同一作业不同执行实例的迟到请求。 */
    public AutoexecJobGlobalLockNotAllowedException(Long jobId, String status, GlobalLockVo lock) {
        super("globallock.error.terminalrequest", jobId, status, lock.getId(), lock.getKey(), lock.getHandler(),
                lock.getHandlerParam() == null ? null : lock.getHandlerParam().getString("execId"),
                lock.getHandlerParam() == null ? null : lock.getHandlerParam().getString("runnerId"));
    }
}
