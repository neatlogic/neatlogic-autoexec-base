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

package neatlogic.framework.autoexec.job.group.policy.core;

import neatlogic.framework.applicationlistener.core.ModuleInitializedListenerBase;
import neatlogic.framework.bootstrap.NeatLogicWebApplicationContext;
import neatlogic.framework.common.RootComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@RootComponent
public class AutoexecJobGroupPolicyHandlerFactory extends ModuleInitializedListenerBase {
    Logger logger = LoggerFactory.getLogger(AutoexecJobGroupPolicyHandlerFactory.class);

    private static final Map<String, IAutoexecJobGroupPolicyHandler> groupPolicyMap = new HashMap<>();

    public static IAutoexecJobGroupPolicyHandler getGroupPolicy(String groupPolicy) {
        return groupPolicyMap.get(groupPolicy);
    }

    public static Map<String, IAutoexecJobGroupPolicyHandler> getGroupPolicyMap(){
        return  groupPolicyMap;
    }

    @Override
    protected void onInitialized(NeatLogicWebApplicationContext context) {
        Map<String, IAutoexecJobGroupPolicyHandler> myMap = context.getBeansOfType(IAutoexecJobGroupPolicyHandler.class);
        for (Map.Entry<String, IAutoexecJobGroupPolicyHandler> entry : myMap.entrySet()) {
            try {
                IAutoexecJobGroupPolicyHandler groupPolicyHandler = entry.getValue();
                groupPolicyMap.put(groupPolicyHandler.getName(), groupPolicyHandler);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }
    }

    @Override
    protected void myInit() {
        // TODO Auto-generated method stub

    }
}
