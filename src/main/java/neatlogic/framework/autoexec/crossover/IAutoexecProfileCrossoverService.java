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

import neatlogic.framework.autoexec.dto.profile.AutoexecProfileParamVo;
import neatlogic.framework.autoexec.dto.profile.AutoexecProfileVo;
import neatlogic.framework.crossover.ICrossoverService;

import java.util.List;

/**
 * @author lvzk
 * @since 2021/11/9 15:03
 **/
public interface IAutoexecProfileCrossoverService extends ICrossoverService {

    List<AutoexecProfileParamVo> getProfileParamListById(Long id);

    /**
     * 批量根据profileId列表获取对应的profile列表
     *
     * @param idList profile id列表
     * @return profile列表
     */
    List<AutoexecProfileVo> getProfileVoListByIdList(List<Long> idList);
}
