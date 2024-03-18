/*Copyright (C) 2024  深圳极向量科技有限公司 All Rights Reserved.

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

package neatlogic.framework.autoexec.scriptcheck;

import neatlogic.framework.applicationlistener.core.ModuleInitializedListenerBase;
import neatlogic.framework.bootstrap.NeatLogicWebApplicationContext;
import neatlogic.framework.common.RootComponent;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

@RootComponent
public class ScriptCheckHandlerFactory extends ModuleInitializedListenerBase {

    private static final Map<String, IScriptCheckHandler> scriptCheckHandlerMap = new HashMap<>();

    public static IScriptCheckHandler getHandler(String handler) {
        return scriptCheckHandlerMap.get(handler);
    }

    @Override
    public void onInitialized(NeatLogicWebApplicationContext context) {
        Map<String, IScriptCheckHandler> map = context.getBeansOfType(IScriptCheckHandler.class);
        for (Entry<String, IScriptCheckHandler> entry : map.entrySet()) {
            scriptCheckHandlerMap.put(entry.getValue().getType(), entry.getValue());
        }
    }

    @Override
    protected void myInit() {

    }

}
