/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.job.source;

import codedriver.framework.applicationlistener.core.ModuleInitializedListenerBase;
import codedriver.framework.bootstrap.CodedriverWebApplicationContext;
import codedriver.framework.common.RootComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@RootComponent
public class AutoexecJobSourceHandlerFactory extends ModuleInitializedListenerBase {
    Logger logger = LoggerFactory.getLogger(AutoexecJobSourceHandlerFactory.class);

    private static final Map<String, IAutoexecJobSourceHandler> sourceMap = new HashMap<>();

    public static IAutoexecJobSourceHandler getJobSource(String source) {
        return sourceMap.get(source);
    }

    public static Map<String, IAutoexecJobSourceHandler> getSourceMap(){
        return sourceMap;
    }

    @Override
    protected void onInitialized(CodedriverWebApplicationContext context) {
        Map<String, IAutoexecJobSourceHandler> myMap = context.getBeansOfType(IAutoexecJobSourceHandler.class);
        for (Map.Entry<String, IAutoexecJobSourceHandler> entry : myMap.entrySet()) {
            try {
                IAutoexecJobSourceHandler source = entry.getValue();
                sourceMap.put(source.getName(), source);
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
