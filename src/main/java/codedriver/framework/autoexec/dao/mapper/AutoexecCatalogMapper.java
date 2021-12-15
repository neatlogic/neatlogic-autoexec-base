/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dao.mapper;

import codedriver.framework.autoexec.dto.catalog.AutoexecCatalogVo;

import java.util.List;

public interface AutoexecCatalogMapper {

    AutoexecCatalogVo getAutoexecCatalogById(Long id);

    int checkAutoexecCatalogIsExists(Long id);

    int checkAutoexecCatalogNameIsRepeat(AutoexecCatalogVo vo);

    int searchAutoexecCatalogCount(AutoexecCatalogVo vo);

    List<AutoexecCatalogVo> searchAutoexecCatalog(AutoexecCatalogVo vo);

    int updateAutoexecCatalogNameById(AutoexecCatalogVo vo);

    int insertAutoexecCatalog(AutoexecCatalogVo vo);

}
