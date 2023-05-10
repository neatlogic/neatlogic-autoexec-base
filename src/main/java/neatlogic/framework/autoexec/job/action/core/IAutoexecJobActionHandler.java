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

package neatlogic.framework.autoexec.job.action.core;

import neatlogic.framework.autoexec.dto.job.AutoexecJobVo;
import com.alibaba.fastjson.JSONObject;

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
