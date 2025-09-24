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
