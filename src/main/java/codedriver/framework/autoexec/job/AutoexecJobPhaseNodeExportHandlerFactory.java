/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.job;

import codedriver.framework.applicationlistener.core.ModuleInitializedListenerBase;
import codedriver.framework.bootstrap.CodedriverWebApplicationContext;
import codedriver.framework.common.RootComponent;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RootComponent
public class AutoexecJobPhaseNodeExportHandlerFactory extends ModuleInitializedListenerBase {
    Logger logger = LoggerFactory.getLogger(AutoexecJobPhaseNodeExportHandlerFactory.class);

    private static final Map<String, IAutoexecJobPhaseNodeExportHandler> handlerMap = new HashMap<>();

    public static IAutoexecJobPhaseNodeExportHandler getHandler(String name) {
        if (StringUtils.isNotBlank(name)) {
            Optional<String> first = handlerMap.keySet().stream().filter(name::contains).findFirst();
            return first.map(handlerMap::get).orElse(null);
        }
        return null;
    }

    @Override
    protected void onInitialized(CodedriverWebApplicationContext context) {
        Map<String, IAutoexecJobPhaseNodeExportHandler> myMap = context.getBeansOfType(IAutoexecJobPhaseNodeExportHandler.class);
        for (Map.Entry<String, IAutoexecJobPhaseNodeExportHandler> entry : myMap.entrySet()) {
            try {
                IAutoexecJobPhaseNodeExportHandler handler = entry.getValue();
                handlerMap.put(handler.getName(), handler);
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
