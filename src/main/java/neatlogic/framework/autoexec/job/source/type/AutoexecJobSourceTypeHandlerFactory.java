/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.autoexec.job.source.type;

import neatlogic.framework.applicationlistener.core.ModuleInitializedListenerBase;
import neatlogic.framework.bootstrap.CodedriverWebApplicationContext;
import neatlogic.framework.common.RootComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@RootComponent
public class AutoexecJobSourceTypeHandlerFactory extends ModuleInitializedListenerBase {
    Logger logger = LoggerFactory.getLogger(AutoexecJobSourceTypeHandlerFactory.class);

    private static final Map<String, IAutoexecJobSourceTypeHandler> sourceTypeMap = new HashMap<>();

    public static IAutoexecJobSourceTypeHandler getAction(String action) {
        return sourceTypeMap.get(action);
    }

    public static Map<String, IAutoexecJobSourceTypeHandler> getSourceTypeMap(){
        return sourceTypeMap;
    }

    @Override
    protected void onInitialized(CodedriverWebApplicationContext context) {
        Map<String, IAutoexecJobSourceTypeHandler> myMap = context.getBeansOfType(IAutoexecJobSourceTypeHandler.class);
        for (Map.Entry<String, IAutoexecJobSourceTypeHandler> entry : myMap.entrySet()) {
            try {
                IAutoexecJobSourceTypeHandler action = entry.getValue();
                sourceTypeMap.put(action.getName(), action);
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
