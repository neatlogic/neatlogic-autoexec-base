/*
 *
 * Copyright (C) 2025  TechSure Co., Ltd.  All Rights Reserved.
 * This file is part of the NeatLogic software.
 * Licensed under the NeatLogic Sustainable Use License (NSUL), Version 4.x – 2025.
 * You may use this file only in compliance with the License.
 * See the LICENSE file distributed with this work for the full license text.
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 */

package neatlogic.framework.autoexec.crossover;

import neatlogic.framework.autoexec.dto.job.AutoexecJobVo;
import neatlogic.framework.crossover.ICrossoverService;

/**
 * @author laiwt
 * @since 2021/12/07 15:03
 **/
public interface IAutoexecJobActionCrossoverService extends ICrossoverService {
    /**
     * 校验根据组合工具创建的作业
     *
     */
    void validateAndCreateJobFromCombop(AutoexecJobVo autoexecJobParam);

    /**
     * 校验创建并激活作业
     *
     */
    void validateCreateJob(AutoexecJobVo autoexecJobParam) throws Exception;


    /**
     * 获取作业详细并激活作业
     * @param jobVo 作业vo
     */
    void getJobDetailAndFireJob(AutoexecJobVo jobVo) throws Exception;
}
