package neatlogic.framework.autoexec.globallock;

import com.alibaba.fastjson.JSONObject;
import neatlogic.framework.autoexec.constvalue.JobStatus;
import neatlogic.framework.autoexec.dao.mapper.AutoexecJobMapper;
import neatlogic.framework.autoexec.dto.job.AutoexecJobVo;
import neatlogic.framework.autoexec.exception.AutoexecJobGlobalLockNotAllowedException;
import neatlogic.framework.autoexec.exception.AutoexecJobNotFoundException;
import neatlogic.framework.common.RootComponent;
import neatlogic.framework.dto.globallock.GlobalLockVo;
import neatlogic.framework.exception.type.ParamIrregularException;
import neatlogic.framework.globallock.GlobalLockManager;
import neatlogic.framework.globallock.exception.GlobalLockIdentityMismatchException;
import neatlogic.framework.util.$;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/** 先锁作业行再锁资源行，使终态更新与申请互斥，正常申请之间允许共享。 */
@Service
@RootComponent
public class AutoexecJobGlobalLockService {
    private static final Logger logger = LoggerFactory.getLogger(AutoexecJobGlobalLockService.class);
    @Resource private AutoexecJobMapper mapper;

    /** 终态范围包含已暂停，恢复执行时必须重新申请资源锁。 */
    public static boolean isTerminal(String status) {
        return JobStatus.isCompletedStatus(status) || JobStatus.isFailedStatus(status);
    }

    /** 仅在获锁事务内调用，并在取得资源行锁前完成状态校验。 */
    public void validate(GlobalLockVo lock) {
        Long jobId = lock.getHandlerParam() == null ? null : lock.getHandlerParam().getLong("jobId");
        if (jobId == null) throw new ParamIrregularException("jobId",
                $.t("globallock.error.jobrequired", lock.getId(), lock.getKey(), lock.getHandler()));
        lock.setOwnerId(jobId.toString());
        AutoexecJobVo job = mapper.getJobStatusForShare(jobId);
        if (job == null) throw new AutoexecJobNotFoundException(jobId.toString());
        if (isTerminal(job.getStatus())) throw new AutoexecJobGlobalLockNotAllowedException(jobId, job.getStatus(), lock);
    }

    /** 重新读取事务中的最终状态，不依赖调用方可变的状态对象。 */
    public void cleanup(Long jobId) {
        AutoexecJobVo job = mapper.getJobLockByJobId(jobId);
        if (job != null && isTerminal(job.getStatus())) GlobalLockManager.releaseOwnedLocks(Arrays.asList("auto", "deploy"), jobId.toString());
    }
    /** 作业锁仅允许同一执行实例和 Runner 重用原 ID。 */
    public void validateIdentity(GlobalLockVo existing, GlobalLockVo request) {
        for (String field : new String[]{"jobId", "execId", "runnerId"}) {
            if (existing.getHandlerParam() == null || request.getHandlerParam() == null
                    || !Objects.equals(existing.getHandlerParam().getString(field), request.getHandlerParam().getString(field))) {
                throw new GlobalLockIdentityMismatchException(existing, request, field,
                        existing.getHandlerParam() == null ? null : existing.getHandlerParam().getString(field),
                        request.getHandlerParam() == null ? null : request.getHandlerParam().getString(field));
            }
        }
    }

    /** 索引归属和原始作业元数据必须一致，历史空归属只按元数据判断。 */
    public boolean ownsLock(GlobalLockVo lock, String ownerId) {
        return (lock.getOwnerId() == null || ownerId.equals(lock.getOwnerId()))
                && lock.getHandlerParam() != null && ownerId.equals(lock.getHandlerParam().getString("jobId"));
    }

    /** 展示作业执行身份与名称；完整锁详情仍由当前记录提供。 */
    public JSONObject identity(GlobalLockVo lock) {
        JSONObject result = new JSONObject();
        if (lock.getHandlerParam() != null) {
            for (String field : new String[]{"jobId", "execId", "runnerId"}) result.put(field, lock.getHandlerParam().getString(field));
            Long jobId = lock.getHandlerParam().getLong("jobId");
            if (jobId != null) {
                try {
                    List<AutoexecJobVo> jobs = mapper.getJobListByIdList(Collections.singletonList(jobId));
                    if (!jobs.isEmpty()) result.put("jobName", jobs.get(0).getName());
                } catch (Exception ex) {
                    // 名称补充失败仍返回执行身份，不影响框架解锁和通知。
                    logger.error("Read lock job name {} failed", jobId, ex);
                }
            }
        }
        return result;
    }
}
