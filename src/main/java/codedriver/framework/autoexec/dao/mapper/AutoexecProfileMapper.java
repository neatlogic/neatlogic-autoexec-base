package codedriver.framework.autoexec.dao.mapper;

import codedriver.framework.autoexec.dto.profile.AutoexecProfileVo;

import java.util.List;

/**
 * @author longrf
 * @date 2022/3/16 11:42 上午
 */
public interface AutoexecProfileMapper {
    int searchAutoexecProfileCount(AutoexecProfileVo profileVo);

    List<AutoexecProfileVo> searchAutoexecCatalog(AutoexecProfileVo profileVo);
}
