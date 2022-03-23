/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.job.group.policy.core;

import codedriver.framework.applicationlistener.core.ModuleInitializedListenerBase;
import codedriver.framework.bootstrap.CodedriverWebApplicationContext;
import codedriver.framework.common.RootComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@RootComponent
public class AutoexecJobGroupPolicyHandlerFactory extends ModuleInitializedListenerBase {
    Logger logger = LoggerFactory.getLogger(AutoexecJobGroupPolicyHandlerFactory.class);

    private static final Map<String, IAutoexecJobGroupPolicyHandler> groupPolicyMap = new HashMap<>();

    public static IAutoexecJobGroupPolicyHandler getGroupPolicy(String action) {
        return groupPolicyMap.get(action);
    }

    public static Map<String, IAutoexecJobGroupPolicyHandler> getGroupPolicyMap(){
        return  groupPolicyMap;
    }

    @Override
    protected void onInitialized(CodedriverWebApplicationContext context) {
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
