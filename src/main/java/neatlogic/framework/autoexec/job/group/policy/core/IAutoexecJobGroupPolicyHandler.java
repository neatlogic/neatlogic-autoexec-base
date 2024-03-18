/*Copyright (C) $today.year  深圳极向量科技有限公司 All Rights Reserved.

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.*/

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
