package codedriver.framework.autoexec.crossover;

import codedriver.framework.autoexec.dto.AutoexecOperationVo;
import codedriver.framework.autoexec.dto.AutoexecParamVo;
import codedriver.framework.autoexec.dto.combop.AutoexecCombopConfigVo;
import codedriver.framework.autoexec.dto.job.AutoexecJobVo;
import codedriver.framework.autoexec.dto.profile.AutoexecProfileParamVo;
import codedriver.framework.crossover.ICrossoverService;

import java.util.List;

/**
 * @author longrf
 * @date 2022/1/24 6:33 下午
 */
public interface IAutoexecServiceCrossoverService extends ICrossoverService {

    List<AutoexecJobVo> getJobList(AutoexecJobVo jobVo);


    /**
     * 根据关联的operationVoList获取工具参数并与数据库存储的旧参数oldOperationParamList做去重处理
     *
     * @param paramAutoexecOperationVoList
     * @param oldOperationParamList
     * @return
     */
    List<AutoexecParamVo> getAutoexecOperationParamVoList(List<AutoexecOperationVo> paramAutoexecOperationVoList, List<AutoexecProfileParamVo> oldOperationParamList);

    void updateAutoexecCombopConfig(AutoexecCombopConfigVo config);

}
