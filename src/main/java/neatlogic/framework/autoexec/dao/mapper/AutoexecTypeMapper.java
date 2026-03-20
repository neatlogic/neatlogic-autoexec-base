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

import neatlogic.framework.autoexec.dto.AutoexecTypeAuthVo;
import neatlogic.framework.autoexec.dto.AutoexecTypeVo;
import neatlogic.framework.dto.AuthenticationInfoVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AutoexecTypeMapper {

    AutoexecTypeVo getTypeById(Long id);

    AutoexecTypeVo getTypeByName(String name);

    List<AutoexecTypeVo> getTypeListByIdList(List<Long> idList);

    int checkTypeNameIsExists(AutoexecTypeVo vo);

    Long getTypeIdByName(String name);

    int searchTypeCount(AutoexecTypeVo vo);

    List<Long> searchTypeIdList(AutoexecTypeVo vo);

    int checkTypeIsExistsById(Long id);

    /**
     * 检查插件类型是否被工具或脚本引用
     *
     * @param id 类型ID
     * @return 引用次数
     */
    int checkTypeHasBeenReferredById(Long id);

    List<AutoexecTypeVo> getReferenceCountListForTool(List<Long> idList);

    List<AutoexecTypeVo> getReferenceCountListForScript(List<Long> idList);

    List<AutoexecTypeVo> getReferenceCountListForCombop(List<Long> idList);

    List<AutoexecTypeVo> getTypeListByNameList(List<String> nameList);

    List<Long> getHasAuthTypeIdListByTypeIdList(List<Long> idList);

    List<Long> getTypeIdListByNameList(List<String> typeNameList);

    List<AutoexecTypeAuthVo> getAutoexecTypeAuthListByTypeIdAndAction(@Param("typeId") Long typeId, @Param("action") String action);

    List<AutoexecTypeAuthVo> getAutoexecTypeAuthListByTypeIdListAndAction(@Param("typeIdList") List<Long> typeIdList, @Param("action") String action);

    int checkAutoexecTypeAuthorityByTypeIdAndActionAndUserUuidAndTeamUuidListAndRoleUuidList(@Param("typeId") Long typeId, @Param("action") String value, @Param("authenticationInfoVo") AuthenticationInfoVo authenticationInfoVo);

    int insertType(AutoexecTypeVo vo);

    void insertTypeList(List<AutoexecTypeVo> typeList);

    void insertTypeAuthList(List<AutoexecTypeAuthVo> autoexecTypeAuthList);

    void insertBatchTypeAuth(@Param("typeIdList") List<Long> typeIdList, @Param("action") String action, @Param("authType") String authType, @Param("authUuid") String authUuid);

    void insertDeployActiveList(@Param("typeIdList") List<Long> typeIdList, @Param("isActive") int isActive);

    int updateType(AutoexecTypeVo vo);

    int deleteTypeById(Long id);

    void deleteTypeAuthByTypeId(Long id);
}
