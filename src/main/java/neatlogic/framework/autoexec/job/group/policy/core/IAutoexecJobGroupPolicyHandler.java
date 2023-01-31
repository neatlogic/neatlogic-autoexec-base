/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.autoexec.job.group.policy.core;

import neatlogic.framework.autoexec.dto.job.AutoexecJobVo;
import neatlogic.framework.dto.runner.RunnerMapVo;

import java.util.List;

/**
 * @author lvzk
 * @since 2022/03/23 11:29
 **/
public interface IAutoexecJobGroupPolicyHandler {

    /**
     * 策略名
     * @return 策略名
     */
    String getName();

    /**
     * 获取第一次执行阶段列表
     * @param jobVo 作业
     */
    void getExecutePhaseList(AutoexecJobVo jobVo);

    /**
     * 获取执行的runner列表
     * @param jobVo 作业
     * @return runner列表
     */
    List<RunnerMapVo> getExecuteRunnerList(AutoexecJobVo jobVo);

    /**
     * 更新执行Phase状态
     * @param jobVo 作业
     */
    void updateExecutePhaseListStatus(AutoexecJobVo jobVo);
}
