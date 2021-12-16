/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dao.mapper;

import codedriver.framework.autoexec.dto.catalog.AutoexecCatalogVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AutoexecCatalogMapper {

    int checkCatalogIsExistsById(Long id);

    List<AutoexecCatalogVo> getCatalogListByIdList(@Param("idList") List<Long> idList);

    List<AutoexecCatalogVo> getChildrenByLftRht(AutoexecCatalogVo catalogVo);

    AutoexecCatalogVo getCatalogById(Long id);

}
