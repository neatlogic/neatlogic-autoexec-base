/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.callback.core;

import codedriver.framework.applicationlistener.core.ModuleInitializedListenerBase;
import codedriver.framework.bootstrap.CodedriverWebApplicationContext;
import codedriver.framework.common.RootComponent;
import codedriver.framework.elasticsearch.core.ElasticSearchHandlerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@RootComponent
public class AutoexecJobCallbackFactory extends ModuleInitializedListenerBase {
    Logger logger = LoggerFactory.getLogger(ElasticSearchHandlerFactory.class);

    private static final Map<String, IAutoexecJobCallback> handlerMap = new HashMap<>();

    public static IAutoexecJobCallback getHandler(String handler) {
        return handlerMap.get(handler);
    }

    public static Map<String, IAutoexecJobCallback> getHandlerMap(){
        return  handlerMap;
    }

    @Override
    protected void onInitialized(CodedriverWebApplicationContext context) {
        Map<String, IAutoexecJobCallback> myMap = context.getBeansOfType(IAutoexecJobCallback.class);
        for (Map.Entry<String, IAutoexecJobCallback> entry : myMap.entrySet()) {
            try {
                IAutoexecJobCallback handler = entry.getValue();
                handlerMap.put(handler.getHandler(), handler);
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
