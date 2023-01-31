/*
 * Copyright(c) 2022 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.autoexec.crossover;

import neatlogic.framework.autoexec.dto.job.AutoexecJobVo;
import neatlogic.framework.crossover.ICrossoverService;

import java.util.List;

/**
 * @author longrf
 * @date 2022/5/23 7:00 下午
 */
public interface IAutoexecJobCrossoverService extends ICrossoverService {

    List<AutoexecJobVo> searchJob(AutoexecJobVo jobVo);

    void saveAutoexecCombopJob(AutoexecJobVo jobVo);
}
