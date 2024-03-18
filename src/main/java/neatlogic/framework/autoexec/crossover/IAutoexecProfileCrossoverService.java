/*Copyright (C) $today.year  深圳极向量科技有限公司 All Rights Reserved.

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.*/

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
