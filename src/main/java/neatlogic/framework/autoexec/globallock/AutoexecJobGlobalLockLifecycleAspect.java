package neatlogic.framework.autoexec.globallock;

import neatlogic.framework.autoexec.dto.job.AutoexecJobVo;
import neatlogic.framework.transaction.util.TransactionUtil;
import neatlogic.framework.common.RootComponent;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.Resource;
import java.util.SortedSet;
import java.util.TreeSet;

/** 仅拦截普通作业状态更新，同步清理锁，与现有异步业务回调保持独立。 */
@Aspect
@RootComponent
@Order(-100)
public class AutoexecJobGlobalLockLifecycleAspect {
    private static final Logger logger = LoggerFactory.getLogger(AutoexecJobGlobalLockLifecycleAspect.class);
    @Resource private AutoexecJobGlobalLockService service;

    /** 先建立状态更新事务，保证现有业务回调切面也在事务内登记。 */
    @Around("execution(* neatlogic.framework.autoexec.dao.mapper.AutoexecJobMapper.updateJobStatus(..))")
    public Object updateStatus(ProceedingJoinPoint point) throws Throwable {
        TransactionStatus tx = TransactionUtil.openTx();
        try {
            Object result = point.proceed();
            Long jobId = ((AutoexecJobVo) point.getArgs()[0]).getId();
            if (!(result instanceof Number) || ((Number) result).intValue() > 0) {
                Cleanup cleanup = null;
                // 清理登记绑定实际事务，独立新事务单独登记，不能仅按线程去重。
                for (TransactionSynchronization item : TransactionSynchronizationManager.getSynchronizations()) {
                    if (item instanceof Cleanup) { cleanup = (Cleanup) item; break; }
                }
                if (cleanup == null) {
                    cleanup = new Cleanup(service);
                    TransactionSynchronizationManager.registerSynchronization(cleanup);
                }
                cleanup.ids.add(jobId);
            }
            TransactionUtil.commitTx(tx);
            return result;
        } catch (Throwable ex) {
            logger.error("Job status/lock cleanup transaction failed", ex);
            if (!tx.isCompleted()) TransactionUtil.rollbackTx(tx);
            throw ex;
        }
    }

    /** 在事务实际提交前，逐一复核去重后的作业 ID。 */
    private static final class Cleanup implements TransactionSynchronization {
        private final SortedSet<Long> ids = new TreeSet<>();
        private final AutoexecJobGlobalLockService service;
        private Cleanup(AutoexecJobGlobalLockService service) { this.service = service; }
        @Override public void beforeCommit(boolean readOnly) {
            for (Long id : ids) service.cleanup(id);
        }
    }
}
