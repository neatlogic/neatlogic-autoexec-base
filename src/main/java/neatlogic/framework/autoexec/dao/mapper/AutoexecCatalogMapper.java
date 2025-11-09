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
