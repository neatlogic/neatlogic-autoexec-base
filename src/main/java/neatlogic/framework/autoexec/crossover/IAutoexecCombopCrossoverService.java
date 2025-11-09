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

import neatlogic.framework.autoexec.dto.combop.AutoexecCombopConfigVo;
import neatlogic.framework.autoexec.dto.combop.AutoexecCombopVersionVo;
import neatlogic.framework.autoexec.dto.combop.AutoexecCombopVo;
import neatlogic.framework.crossover.ICrossoverService;

/**
 * @author lvzk
 * @since 2021/11/9 15:03
 **/
public interface IAutoexecCombopCrossoverService extends ICrossoverService {
    /**
     * 设置当前用户可操作按钮权限列表
     *
     * @param autoexecCombopVo 组合工具Vo对象
     */
    void setOperableButtonList(AutoexecCombopVo autoexecCombopVo);
    /**
     * 校验组合工具每个阶段是否配置正确
     * 校验规则
     * 1.每个阶段至少选择了一个工具
     * 2.引用上游出参或顶层参数，能找到来源（防止修改顶层参数或插件排序、或修改顶层参数带来的影响）
     *
     * @param autoexecCombopConfigVo 组合工具Vo对象配置信息
     * @param isExecuteJob     是否执行创建作业
     * @return 是否合法
     */
    boolean verifyAutoexecCombopConfig(AutoexecCombopConfigVo autoexecCombopConfigVo, boolean isExecuteJob);
    /**
     * 判断是否需要设置执行目标、执行用户、连接协议、分批数量
     *
     * @param autoexecCombopVersionVo      组合工具版本信息
     */
    void needExecuteConfig(AutoexecCombopVersionVo autoexecCombopVersionVo);
}
