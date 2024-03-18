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

import neatlogic.framework.autoexec.dto.AutoexecOperationVo;
import neatlogic.framework.autoexec.dto.AutoexecToolVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AutoexecToolMapper {

    int checkToolExistsById(Long id);

    List<AutoexecOperationVo> getToolListByIdList(List<Long> idList);

    List<AutoexecOperationVo> getAutoexecOperationListByIdList(List<Long> idList);

    List<AutoexecToolVo> searchTool(AutoexecToolVo toolVo);

    AutoexecToolVo getToolByName(String name);

    List<AutoexecToolVo> getToolBaseInfoListByIdList(List<Long> idList);

    List<AutoexecToolVo> getToolByNameList(List<String> toolNameList);

    AutoexecToolVo getToolById(Long id);

    int searchToolCount(AutoexecToolVo toolVo);

    int checkToolHasBeenGeneratedToCombop(Long id);

    List<Long> checkToolListHasBeenGeneratedToCombop(List<Long> idList);

    List<AutoexecToolVo> getAllTool();

    List<Long> getToolIdListByIdListAndTypeId(@Param("idList") List<Long> idList, @Param("typeId") Long typeId);

    int getToolCountByImportTime(Long importTime);

    List<Long> getToolIdListByExcludeImportTime(Long importTime);

    int updateActiveStatus(AutoexecToolVo toolVo);

    int updateConfig(AutoexecToolVo toolVo);

    int updateCustomTemplate(AutoexecToolVo toolVo);

    int insertTool(AutoexecToolVo toolVo);

    int deleteToolByIdList(List<Long> list);

    void updateImportTime(@Param("id") Long id, @Param("importTime") Long importTime);
}
