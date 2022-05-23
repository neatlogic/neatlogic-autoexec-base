package codedriver.framework.autoexec.crossover;

import codedriver.framework.autoexec.dto.combop.AutoexecCombopConfigVo;
import codedriver.framework.crossover.ICrossoverService;

/**
 * @author longrf
 * @date 2022/1/24 6:33 下午
 */
public interface IAutoexecServiceCrossoverService extends ICrossoverService {

    void updateAutoexecCombopConfig(AutoexecCombopConfigVo config);

}
