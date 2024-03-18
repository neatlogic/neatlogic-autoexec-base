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

package neatlogic.framework.autoexec.job.callback.core;

import neatlogic.framework.autoexec.dto.job.AutoexecJobVo;

/**
 * @author lvzk
 * @since 2021/9/17 19:16
 **/
public interface IAutoexecJobCallback {
    /**
     * 处理器
     * @return 处理器
     */
    String getHandler();

    /**
     * 是否需要回调
     * @param jobVo 自动化作业
     * @return true|false
     */
    Boolean getIsNeedCallback(AutoexecJobVo jobVo);

    /**
     * 需要执行的逻辑
     * @param invokeId 来源id
     * @param jobVo 自动化作业
     */
    void doService(Long invokeId,AutoexecJobVo jobVo);
}
