package codedriver.framework.autoexec.crossover;

import codedriver.framework.autoexec.dto.AutoexecOperationBaseVo;
import codedriver.framework.autoexec.dto.AutoexecParamVo;
import codedriver.framework.autoexec.dto.combop.AutoexecCombopConfigVo;
import codedriver.framework.crossover.ICrossoverService;

import java.util.List;

/**
 * @author longrf
 * @date 2022/1/24 6:33 下午
 */
public interface IAutoexecServiceCrossoverService extends ICrossoverService {

    void updateAutoexecCombopConfig(AutoexecCombopConfigVo config);

    /**
     * 根据id和类型获取自定义工具或工具信息
     * @param id 自定义工具id或工具id
     * @param name 自定义工具名或工具名
     * @param type 类型
     * @return
     */
    AutoexecOperationBaseVo getAutoexecOperationBaseVoByIdAndType(Long id, String name, String type);

    void mergeConfig(AutoexecParamVo autoexecParamVo);

    void validateRuntimeParamList(List<? extends AutoexecParamVo> runtimeParamList);
}
