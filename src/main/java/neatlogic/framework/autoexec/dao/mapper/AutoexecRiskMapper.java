/*Copyright (C) 2023  深圳极向量科技有限公司 All Rights Reserved.

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

package neatlogic.framework.autoexec.dao.mapper;

import neatlogic.framework.autoexec.dto.AutoexecRiskVo;
import neatlogic.framework.common.dto.ValueTextVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AutoexecRiskMapper {

    int checkRiskIsExistsById(Long id);

    Long getRiskIdByName(String name);

    List<ValueTextVo> getAllActiveRisk();

    AutoexecRiskVo getAutoexecRiskById(Long riskId);

    AutoexecRiskVo getAutoexecRiskByName(String name);

    int searchRiskCount(AutoexecRiskVo vo);

    List<AutoexecRiskVo> searchRisk(AutoexecRiskVo vo);

    Integer getMaxSort();

    int checkRiskNameIsRepeats(AutoexecRiskVo vo);

    int checkRiskHasBeenReferredById(Long id);

    List<AutoexecRiskVo> getReferenceCountListForTool(List<Long> idList);

    List<AutoexecRiskVo> getReferenceCountListForScript(List<Long> idList);

    int updateRisk(AutoexecRiskVo vo);

    int updateSortDecrement(@Param("fromSort")Integer fromSort, @Param("toSort")Integer toSort);

    int updateSortIncrement(@Param("fromSort")Integer fromSort, @Param("toSort")Integer toSort);

    int insertRisk(AutoexecRiskVo vo);

    int deleteRiskById(Long id);
}
