/*
 *
 * Copyright (C) 2025  TechSure Co., Ltd.  All Rights Reserved.
 * This file is part of the NeatLogic software.
 * Licensed under the NeatLogic Sustainable Use License (NSUL), Version 4.x – 2025.
 * You may use this file only in compliance with the License.
 * See the LICENSE file distributed with this work for the full license text.
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 */

package neatlogic.framework.autoexec.dao.mapper;

import neatlogic.framework.autoexec.dto.AutoexecTypeVo;
import neatlogic.framework.autoexec.dto.combop.AutoexecCombopAuthorityVo;
import neatlogic.framework.autoexec.dto.combop.AutoexecCombopSearchVo;
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

    int getAutoexecCombopCount(AutoexecCombopSearchVo searchVo);

    List<Long> getAutoexecCombopIdList(AutoexecCombopSearchVo searchVo);

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
