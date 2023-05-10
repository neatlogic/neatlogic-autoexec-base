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
