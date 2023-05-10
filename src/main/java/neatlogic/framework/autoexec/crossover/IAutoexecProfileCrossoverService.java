/*
Copyright(c) 2023 NeatLogic Co., Ltd. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package neatlogic.framework.autoexec.crossover;

import neatlogic.framework.autoexec.dto.combop.AutoexecCombopVo;
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
