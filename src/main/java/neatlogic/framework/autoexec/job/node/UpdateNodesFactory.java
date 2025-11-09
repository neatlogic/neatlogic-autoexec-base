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

package neatlogic.framework.autoexec.job.node;

import neatlogic.framework.applicationlistener.core.ModuleInitializedListenerBase;
import neatlogic.framework.autoexec.dto.combop.AutoexecCombopConfigVo;
import neatlogic.framework.autoexec.dto.combop.AutoexecCombopExecuteConfigVo;
import neatlogic.framework.autoexec.dto.job.AutoexecJobVo;
import neatlogic.framework.bootstrap.NeatLogicWebApplicationContext;
import neatlogic.framework.common.RootComponent;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RootComponent
public class UpdateNodesFactory extends ModuleInitializedListenerBase {

    private static final List<IUpdateNodes> updateNodeList = new ArrayList<>();


    @Override
    protected void onInitialized(NeatLogicWebApplicationContext context) {
        Map<String, IUpdateNodes> beansOfTypeMap = context.getBeansOfType(IUpdateNodes.class);
        if (beansOfTypeMap.size() == 0) {
            return;
        }
        if (CollectionUtils.isNotEmpty(beansOfTypeMap.values())) {
            updateNodeList.addAll(beansOfTypeMap.values());
        }
    }

    @Override
    protected void myInit() {
        //ignored
    }

    /**
     * 遍历所有获取目标的方式，获取到就退出
     *
     * @param jobVo           作业
     * @param executeConfigVo 执行目标配置
     * @param userName        执行用户
     * @param protocolId      协议id
     */
    public static boolean updateNodes(AutoexecCombopExecuteConfigVo executeConfigVo, AutoexecJobVo jobVo, String userName, Long protocolId) {
        boolean isHasNode = false;
        for (IUpdateNodes updateNode : updateNodeList) {
            AutoexecCombopConfigVo config = jobVo.getConfig();
            //如果局部不存在前置过滤器，则使用全局的
            if (executeConfigVo == null || executeConfigVo.getExecuteNodeConfig() == null) {
               return false;
            } else {
                if (MapUtils.isEmpty(executeConfigVo.getPreCondition()) && config != null && config.getExecuteConfig() != null
                        && MapUtils.isNotEmpty(config.getExecuteConfig().getPreCondition())
                ) {
                    executeConfigVo.setPreCondition(config.getExecuteConfig().getPreCondition());
                }
            }
            isHasNode = updateNode.update(executeConfigVo, jobVo, userName, protocolId);
            if (isHasNode) {
                break;
            }
        }
        return isHasNode;
    }
}
