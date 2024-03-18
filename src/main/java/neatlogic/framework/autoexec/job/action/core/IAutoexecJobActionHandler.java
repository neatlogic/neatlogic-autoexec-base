/*Copyright (C) 2023  深圳极向量科技有限公司 All Rights Reserved.

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

package neatlogic.framework.autoexec.job.action.core;

import com.alibaba.fastjson.JSONObject;
import neatlogic.framework.autoexec.dto.job.AutoexecJobVo;

/**
 * @author lvzk
 * @since 2021/11/9 11:29
 **/
public interface IAutoexecJobActionHandler {

    /**
     * 操作名
     * @return 操作名
     */
    String getName();

    /**
     * 执行操作前的验证
     * @param jobVo 作业
     * @return 是否执行后续操作
     */
    boolean validate(AutoexecJobVo jobVo);

    /**
     * 执行操作逻辑
     * @param jobVo 作业
     */
    JSONObject doService(AutoexecJobVo jobVo) throws Exception;

    /**
     * 是否需要校验是否拥有组合工具执行权限
     * @return true|false
     */
    default boolean isNeedExecuteAuthCheck(){
        return false;
    }
}
