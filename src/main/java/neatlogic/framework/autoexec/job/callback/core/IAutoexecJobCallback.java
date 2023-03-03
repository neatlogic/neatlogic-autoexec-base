/*
Copyright(c) $today.year NeatLogic Co., Ltd. All Rights Reserved.

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
