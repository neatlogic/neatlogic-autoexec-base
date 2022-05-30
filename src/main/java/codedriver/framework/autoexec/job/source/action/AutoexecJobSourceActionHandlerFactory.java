/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.job.source.action;

import codedriver.framework.applicationlistener.core.ModuleInitializedListenerBase;
import codedriver.framework.bootstrap.CodedriverWebApplicationContext;
import codedriver.framework.common.RootComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@RootComponent
public class AutoexecJobSourceActionHandlerFactory extends ModuleInitializedListenerBase {
    Logger logger = LoggerFactory.getLogger(AutoexecJobSourceActionHandlerFactory.class);

    private static final Map<String, IAutoexecJobSourceActionHandler> actionMap = new HashMap<>();

    public static IAutoexecJobSourceActionHandler getAction(String action) {
        return actionMap.get(action);
    }

    public static Map<String, IAutoexecJobSourceActionHandler> getActionMap(){
        return  actionMap;
    }

    @Override
    protected void onInitialized(CodedriverWebApplicationContext context) {
        Map<String, IAutoexecJobSourceActionHandler> myMap = context.getBeansOfType(IAutoexecJobSourceActionHandler.class);
        for (Map.Entry<String, IAutoexecJobSourceActionHandler> entry : myMap.entrySet()) {
            try {
                IAutoexecJobSourceActionHandler action = entry.getValue();
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
