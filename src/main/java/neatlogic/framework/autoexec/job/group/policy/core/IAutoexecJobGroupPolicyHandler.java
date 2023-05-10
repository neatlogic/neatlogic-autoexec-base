/*
Copyright(c) 2023 NeatLogic Co., Ltd. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
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
