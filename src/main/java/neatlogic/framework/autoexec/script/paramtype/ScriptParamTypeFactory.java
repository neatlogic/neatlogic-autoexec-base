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

package neatlogic.framework.autoexec.script.paramtype;

import com.alibaba.fastjson.JSONObject;
import neatlogic.framework.applicationlistener.core.ModuleInitializedListenerBase;
import neatlogic.framework.bootstrap.NeatLogicWebApplicationContext;
import neatlogic.framework.common.RootComponent;
import neatlogic.framework.common.constvalue.IEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@RootComponent
public class ScriptParamTypeFactory extends ModuleInitializedListenerBase implements IEnum {

    private static final Map<String, IScriptParamType> scriptParamTypeMap = new HashMap<>();

    public static IScriptParamType getHandler(String handler) {
        return scriptParamTypeMap.get(handler);
    }

    @Override
    public void onInitialized(NeatLogicWebApplicationContext context) {
        Map<String, IScriptParamType> map = context.getBeansOfType(IScriptParamType.class);
        for (Entry<String, IScriptParamType> entry : map.entrySet()) {
            scriptParamTypeMap.put(entry.getValue().getType(), entry.getValue());
        }
    }

    @Override
    protected void myInit() {

    }

    @Override
    public List getValueTextList() {
        int size = scriptParamTypeMap.size();
        List<JSONObject> resultList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            resultList.add(new JSONObject());
        }
        for (Map.Entry<String, IScriptParamType> entry : scriptParamTypeMap.entrySet()) {
            IScriptParamType paramType = entry.getValue();
            int sort = paramType.getSort();
            if (sort < size) {
                JSONObject jsonObj = resultList.get(sort);
                jsonObj.put("value", paramType.getType());
                jsonObj.put("text", paramType.getTypeName());
                jsonObj.put("config", paramType.getConfig());
                jsonObj.put("description", paramType.getDescription());
                jsonObj.put("sort", sort);
            }
        }
        return resultList;
    }
}
