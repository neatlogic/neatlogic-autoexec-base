package codedriver.framework.autoexec.crossover;

import codedriver.framework.autoexec.dto.AutoexecOperationBaseVo;
import codedriver.framework.autoexec.dto.AutoexecParamVo;
import codedriver.framework.autoexec.dto.combop.AutoexecCombopConfigVo;
import codedriver.framework.autoexec.dto.combop.AutoexecCombopPhaseOperationVo;
import codedriver.framework.crossover.ICrossoverService;

import java.util.List;

/**
 * @author longrf
 * @date 2022/1/24 6:33 下午
 */
public interface IAutoexecServiceCrossoverService extends ICrossoverService {

    void updateAutoexecCombopConfig(AutoexecCombopConfigVo config);

    /**
     * 补充阶段操作中的自定义工具或工具信息
     * @param autoexecCombopPhaseOperationVo
     * @return
     */
    AutoexecOperationBaseVo getAutoexecOperationBaseVoByIdAndType(String phaseName, AutoexecCombopPhaseOperationVo autoexecCombopPhaseOperationVo, boolean throwException);

    void mergeConfig(AutoexecParamVo autoexecParamVo);

    void validateRuntimeParamList(List<? extends AutoexecParamVo> runtimeParamList);
}
