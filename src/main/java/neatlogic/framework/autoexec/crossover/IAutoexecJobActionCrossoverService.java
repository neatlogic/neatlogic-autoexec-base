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

package neatlogic.framework.autoexec.crossover;

import neatlogic.framework.autoexec.dto.job.AutoexecJobVo;
import neatlogic.framework.crossover.ICrossoverService;

/**
 * @author laiwt
 * @since 2021/12/07 15:03
 **/
public interface IAutoexecJobActionCrossoverService extends ICrossoverService {
    /**
     * 校验根据组合工具创建的作业
     *
     */
    void validateAndCreateJobFromCombop(AutoexecJobVo autoexecJobParam);

    /**
     * 校验创建并激活作业
     *
     */
    void validateCreateJob(AutoexecJobVo autoexecJobParam) throws Exception;


    /**
     * 获取作业详细并激活作业
     * @param jobVo 作业vo
     */
    void getJobDetailAndFireJob(AutoexecJobVo jobVo) throws Exception;
}
