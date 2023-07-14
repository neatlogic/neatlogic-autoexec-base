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

    int getToolCountByEpochTime(Long epochTime);

    List<Long> getToolIdListByExcludeEpochTime(Long epochTime);

    int updateActiveStatus(AutoexecToolVo toolVo);

    int updateConfig(AutoexecToolVo toolVo);

    int updateCustomTemplate(AutoexecToolVo toolVo);

    int insertTool(AutoexecToolVo toolVo);

    int deleteToolByIdList(List<Long> list);
}
