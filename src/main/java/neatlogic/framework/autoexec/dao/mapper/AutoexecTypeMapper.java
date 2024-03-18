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

    List<AutoexecTypeVo> searchType(AutoexecTypeVo vo);

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
