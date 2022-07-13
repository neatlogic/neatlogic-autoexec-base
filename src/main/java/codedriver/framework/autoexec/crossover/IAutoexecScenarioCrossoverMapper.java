/*
 * Copyright (c)  2022 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.crossover;

import codedriver.framework.autoexec.dto.scenario.AutoexecScenarioVo;
import codedriver.framework.crossover.ICrossoverService;

public interface IAutoexecScenarioCrossoverMapper extends ICrossoverService {

    AutoexecScenarioVo getScenarioById(Long paramId);

    AutoexecScenarioVo getScenarioByName(String scenarioName);
}
