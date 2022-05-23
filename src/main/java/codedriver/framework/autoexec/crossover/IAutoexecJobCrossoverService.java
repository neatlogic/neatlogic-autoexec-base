package codedriver.framework.autoexec.crossover;

import codedriver.framework.autoexec.dto.job.AutoexecJobVo;
import codedriver.framework.crossover.ICrossoverService;

import java.util.List;

/**
 * @author longrf
 * @date 2022/5/23 7:00 下午
 */
public interface IAutoexecJobCrossoverService extends ICrossoverService {

    List<AutoexecJobVo> getJobList(AutoexecJobVo jobVo);
}
