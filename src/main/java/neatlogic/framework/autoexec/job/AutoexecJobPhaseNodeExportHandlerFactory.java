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
