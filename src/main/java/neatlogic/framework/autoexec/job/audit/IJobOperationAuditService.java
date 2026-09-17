package neatlogic.framework.autoexec.job.audit;

import com.alibaba.fastjson.JSONObject;
import neatlogic.framework.autoexec.constvalue.JobAction;

/** 动作处理链的采集契约，由自动化模块实现，基础模块不依赖具体存储。 */
public interface IJobOperationAuditService {
    /** 执行原业务并保留其返回类型及异常。 */
    @FunctionalInterface
    interface Operation<T> { T execute() throws Exception; }

    /** 采集最外层白名单动作，嵌套调用去重，不改变业务返回与异常契约。 */
    <T> T execute(JobAction action, JSONObject request, Operation<T> operation) throws Exception;
}
