/*Copyright (C) 2024  深圳极向量科技有限公司 All Rights Reserved.

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

import java.util.List;

/**
 * @author longrf
 * @date 2022/5/23 7:00 下午
 */
public interface IAutoexecJobCrossoverService extends ICrossoverService {

    List<AutoexecJobVo> searchJob(AutoexecJobVo jobVo);

    void saveAutoexecCombopJob(AutoexecJobVo jobVo);
}
