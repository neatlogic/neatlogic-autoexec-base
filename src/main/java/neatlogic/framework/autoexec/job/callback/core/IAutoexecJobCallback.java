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
