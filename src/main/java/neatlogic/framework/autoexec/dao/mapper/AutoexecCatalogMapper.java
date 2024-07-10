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

import neatlogic.framework.autoexec.dto.catalog.AutoexecCatalogVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AutoexecCatalogMapper {

    AutoexecCatalogVo getAutoexecCatalogById(Long id);

    AutoexecCatalogVo getAutoexecCatalogByName(String name);

    AutoexecCatalogVo getAutoexecCatalogByFullName(String name);

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
