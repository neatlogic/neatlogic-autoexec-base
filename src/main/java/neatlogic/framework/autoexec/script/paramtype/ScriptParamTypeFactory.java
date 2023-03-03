/*
 * Copyright(c) 2023 NeatLogic Co., Ltd. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package neatlogic.framework.autoexec.script.paramtype;

import neatlogic.framework.applicationlistener.core.ModuleInitializedListenerBase;
import neatlogic.framework.bootstrap.NeatLogicWebApplicationContext;
import neatlogic.framework.common.RootComponent;
import neatlogic.framework.common.constvalue.IEnum;
import com.alibaba.fastjson.JSONObject;

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
