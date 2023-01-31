package neatlogic.framework.autoexec.crossover;

import neatlogic.framework.autoexec.dto.AutoexecOperationBaseVo;
import neatlogic.framework.autoexec.dto.AutoexecParamVo;
import neatlogic.framework.autoexec.dto.combop.AutoexecCombopConfigVo;
import neatlogic.framework.autoexec.dto.combop.AutoexecCombopPhaseOperationVo;
import neatlogic.framework.crossover.ICrossoverService;

import java.util.List;

/**
 * @author longrf
 * @date 2022/1/24 6:33 下午
 */
public interface IAutoexecServiceCrossoverService extends ICrossoverService {

    /**
     * 补充AutoexecCombopConfigVo对象中的场景名称、预置参数集名称、操作对应的工具信息
     * @param config config对象
     */
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
