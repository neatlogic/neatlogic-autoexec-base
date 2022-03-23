/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.job.group.policy.core;

import codedriver.framework.autoexec.dto.job.AutoexecJobPhaseVo;
import codedriver.framework.autoexec.dto.job.AutoexecJobVo;
import codedriver.framework.dto.runner.RunnerMapVo;

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
     * @return 节点列表
     */
    List<AutoexecJobPhaseVo> getFirstExecutePhaseList(AutoexecJobVo jobVo);

    /**
     * 获取执行的runner列表
     * @param jobVo 作业
     * @return runner列表
     */
    List<RunnerMapVo> getExecuteRunnerList(AutoexecJobVo jobVo);
}
