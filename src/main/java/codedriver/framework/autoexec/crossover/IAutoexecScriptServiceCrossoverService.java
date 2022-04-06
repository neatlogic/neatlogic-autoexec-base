package codedriver.framework.autoexec.crossover;

import codedriver.framework.crossover.ICrossoverService;
import codedriver.framework.dependency.dto.DependencyInfoVo;

import java.util.Map;

/**
 * @author longrf
 * @date 2022/3/23 10:46 上午
 */
public interface IAutoexecScriptServiceCrossoverService extends ICrossoverService {

    public DependencyInfoVo getScriptDependencyPageUrl(Map<String, Object> map, Long scriptId, String groupName, String pathFormat);
}
