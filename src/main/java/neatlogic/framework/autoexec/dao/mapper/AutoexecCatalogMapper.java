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

import neatlogic.framework.autoexec.dto.catalog.AutoexecCatalogVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AutoexecCatalogMapper {

    AutoexecCatalogVo getAutoexecCatalogById(Long id);

    AutoexecCatalogVo getAutoexecCatalogByName(String name);

    AutoexecCatalogVo getAutoexecCatalogByNameAndParentId(@Param("name") String name, @Param("parentId") Long parentId);

    int checkAutoexecCatalogIsExists(Long id);

    int checkAutoexecCatalogNameIsRepeat(AutoexecCatalogVo vo);

    int searchAutoexecCatalogCount(AutoexecCatalogVo vo);

    List<AutoexecCatalogVo> searchAutoexecCatalog(AutoexecCatalogVo vo);

    Integer getMaxRhtCode();

    List<AutoexecCatalogVo> getCatalogForTree(@Param("lft") Integer lft, @Param("rht") Integer rht);

    int getReferenceCountByLR(@Param("lft") Integer lft, @Param("rht") Integer rht);

    AutoexecCatalogVo getAutoexecCatalogByParentIdAndStartNum(@Param("parentId") Long parentId, @Param("startNum") Integer startNum);

    List<Long> getChildrenIdListByLeftRightCode(@Param("lft") Integer lft, @Param("rht") Integer rht);

    List<AutoexecCatalogVo> getAutoexecCatalogChildCountListByIdList(List<Long> idList);

    List<AutoexecCatalogVo> getReferenceCountForScriptListByIdList(List<Long> idList);

    List<AutoexecCatalogVo> getParentListAndSelfByLR(@Param("lft") Integer lft, @Param("rht") Integer rht);

    int getReferenceCountForScriptOfSelfAndChildrenByLR(@Param("lft") Integer lft, @Param("rht") Integer rht);

    List<AutoexecCatalogVo> getAutoexecFullCatalogByIdList(List<Long> scriptIdList);

    int updateAutoexecCatalogNameById(AutoexecCatalogVo vo);

    int insertAutoexecCatalog(AutoexecCatalogVo vo);

    int deleteAutoexecCatalogByIdList(List<Long> idList);

    List<AutoexecCatalogVo> getCatalogListByIdList(@Param("idList") List<Long> idList);

    List<AutoexecCatalogVo> getChildrenByLftRht(AutoexecCatalogVo catalogVo);

    AutoexecCatalogVo getAutoexecCatalogByScriptId(Long scriptId);

}
