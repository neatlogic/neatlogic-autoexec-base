/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.autoexec.job.action.core;

import neatlogic.framework.applicationlistener.core.ModuleInitializedListenerBase;
import neatlogic.framework.bootstrap.CodedriverWebApplicationContext;
import neatlogic.framework.common.RootComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@RootComponent
public class AutoexecJobActionHandlerFactory extends ModuleInitializedListenerBase {
    Logger logger = LoggerFactory.getLogger(AutoexecJobActionHandlerFactory.class);

    private static final Map<String, IAutoexecJobActionHandler> actionMap = new HashMap<>();

    public static IAutoexecJobActionHandler getAction(String action) {
        return actionMap.get(action);
    }

    public static Map<String, IAutoexecJobActionHandler> getActionMap(){
        return  actionMap;
    }

    @Override
    protected void onInitialized(CodedriverWebApplicationContext context) {
        Map<String, IAutoexecJobActionHandler> myMap = context.getBeansOfType(IAutoexecJobActionHandler.class);
        for (Map.Entry<String, IAutoexecJobActionHandler> entry : myMap.entrySet()) {
            try {
                IAutoexecJobActionHandler action = entry.getValue();
                actionMap.put(action.getName(), action);
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
