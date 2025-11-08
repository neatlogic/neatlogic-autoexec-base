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
import neatlogic.framework.cmdb.dto.resourcecenter.ResourceVo;
import neatlogic.framework.crossover.ICrossoverService;

import java.util.List;

/**
 * @author longrf
 * @date 2022/5/23 7:00 下午
 */
public interface IAutoexecJobCrossoverService extends ICrossoverService {

    List<AutoexecJobVo> searchJob(AutoexecJobVo jobVo);

    void saveAutoexecCombopJob(AutoexecJobVo jobVo);


    /**
     * 获取目标节点并入库
     * @param jobVo 作业
     * @param resourceVoList 资产列表
     * @param userName 执行用户
     * @param protocolId 协议id
     */
    void updateJobPhaseNode(AutoexecJobVo jobVo, List<ResourceVo> resourceVoList, String userName, Long protocolId);
}
