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

package neatlogic.framework.autoexec.job;

import neatlogic.framework.applicationlistener.core.ModuleInitializedListenerBase;
import neatlogic.framework.autoexec.constvalue.ExecMode;
import neatlogic.framework.bootstrap.NeatLogicWebApplicationContext;
import neatlogic.framework.common.RootComponent;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@RootComponent
public class AutoexecJobPhaseNodeExportHandlerFactory extends ModuleInitializedListenerBase {
    Logger logger = LoggerFactory.getLogger(AutoexecJobPhaseNodeExportHandlerFactory.class);

    private static final Map<String, IAutoexecJobPhaseNodeExportHandler> handlerMap = new HashMap<>();

    public static IAutoexecJobPhaseNodeExportHandler getHandler(String name) {
        if (StringUtils.isNotBlank(name)) {
            if (name.contains(ExecMode.TARGET.getValue())) {
                return handlerMap.get(ExecMode.TARGET.getValue());
            } else {
                return handlerMap.get(name);
            }
        }
        return null;
    }

    @Override
    protected void onInitialized(NeatLogicWebApplicationContext context) {
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
