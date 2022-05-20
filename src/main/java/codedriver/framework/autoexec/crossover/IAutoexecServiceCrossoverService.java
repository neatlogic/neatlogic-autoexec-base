package codedriver.framework.autoexec.crossover;

import codedriver.framework.autoexec.dto.combop.AutoexecCombopConfigVo;
import codedriver.framework.autoexec.dto.job.AutoexecJobVo;
import codedriver.framework.crossover.ICrossoverService;

import java.util.List;

/**
 * @author longrf
 * @date 2022/1/24 6:33 下午
 */
public interface IAutoexecServiceCrossoverService extends ICrossoverService {

    List<AutoexecJobVo> getJobList(AutoexecJobVo jobVo);

    void updateAutoexecCombopConfig(AutoexecCombopConfigVo config);

}
