package neatlogic.framework.autoexec.crossover;

import neatlogic.framework.crossover.ICrossoverService;

/** 兼容旧流程的作业来源和历史输出。 */
public interface IStepScriptJobService extends ICrossoverService {
    /** 工单分析作业的来源及作业路由类型。 */
    String SOURCE = "itsmalert";

    /** 使用执行身份读取实际作业输出，并排除密码类型的参数。 */
    Object output(Long jobId) throws Exception;

}
