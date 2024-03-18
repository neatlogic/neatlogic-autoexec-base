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

package neatlogic.framework.autoexec.dao.mapper;

import neatlogic.framework.autoexec.dto.AutoexecTypeVo;
import neatlogic.framework.autoexec.dto.combop.AutoexecCombopAuthorityVo;
import neatlogic.framework.autoexec.dto.combop.AutoexecCombopVo;
import neatlogic.framework.common.dto.BasePageVo;
import neatlogic.framework.dto.AuthenticationInfoVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author: linbq
 * @since: 2021/4/13 11:05
 **/
public interface AutoexecCombopMapper {
    int checkAutoexecCombopIsExists(Long id);

    Long checkAutoexecCombopNameIsRepeat(AutoexecCombopVo autoexecCombopVo);

    Integer getAutoexecCombopIsActiveByIdForUpdate(Long id);

    AutoexecCombopVo getAutoexecCombopById(Long id);

    AutoexecCombopVo getAutoexecCombopByName(String name);

    List<AutoexecCombopVo> getAutoexecCombopByIdList(List<Long> idList);

    int getAutoexecCombopCount(AutoexecCombopVo searchVo);

    List<AutoexecCombopVo> getAutoexecCombopList(AutoexecCombopVo searchVo);

    List<Long> getAutoexecCombopIdList(AutoexecCombopVo searchVo);

    List<AutoexecCombopVo> getAutoexecCombopListByIdList(List<Long> idList);

    List<AutoexecCombopAuthorityVo> getAutoexecCombopAuthorityListByCombopId(Long combopId);

    List<String> getAutoexecCombopAuthorityListByCombopIdAndUserUuidAndTeamUuidListAndRoleUuidList(
            @Param("combopId") Long combopId,
            @Param("userUuid") String userUuid,
            @Param("teamUuidList") List<String> teamUuidList,
            @Param("roleUuidList") List<String> roleUuidList
    );

    Set<Long> getExecutableAutoexecCombopIdListByKeywordAndAuthenticationInfo(
            @Param("keyword") String keyword,
            @Param("typeId") Long typeId,
            @Param("authenticationInfoVo") AuthenticationInfoVo authenticationInfoVo
    );

    Set<Long> getExecutableAutoexecCombopIdListByAuthenticationInfo(
            @Param("authenticationInfoVo") AuthenticationInfoVo authenticationInfoVo
    );

    List<Long> checkAutoexecCombopIdListIsExists(List<Long> idList);

    Long checkItHasBeenGeneratedToCombopByOperationId(Long operationId);

    List<AutoexecTypeVo> getAutoexecTypeListByCombopIdList(@Param("combopIdList") List<Long> combopIdList);

    List<AutoexecTypeVo> getAllAutoexecTypeListUsedByCombop();

    int getAutoexecCombopCountForUpdateConfig();

    List<Map<String, Object>> getAutoexecCombopListForUpdateConfig(BasePageVo searchVo);

    int insertAutoexecCombop(AutoexecCombopVo autoexecCombopVo);

    int insertAutoexecCombopAuthorityVoList(List<AutoexecCombopAuthorityVo> autoexecCombopAuthorityVoList);

    int insertAutoexecOperationGenerateCombop(@Param("combopId") Long combopId, @Param("operationType") String operationType, @Param("operationId") Long operationId);

    int updateAutoexecCombopById(AutoexecCombopVo autoexecCombopVo);

    int updateAutoexecCombopIsActiveById(AutoexecCombopVo autoexecCombopVo);

    int updateAutoexecCombopConfigById(AutoexecCombopVo autoexecCombopVo);

    int updateAutoexecCombopConfigByIdAndConfigStr(@Param("id") Long id, @Param("configStr") String configStr);

    int deleteAutoexecCombopById(Long id);

    int deleteAutoexecCombopAuthorityByCombopId(Long combopId);

    int deleteAutoexecOperationGenerateCombop(Long combopId);
}
