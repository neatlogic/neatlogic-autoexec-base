/*
Copyright(c) 2023 NeatLogic Co., Ltd. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package neatlogic.framework.autoexec.type;

import com.alibaba.fastjson.JSONArray;
import org.reflections.Reflections;

import java.util.Set;

public class AutoexecTypeFactory {
    private static final JSONArray autoexecTypeList = new JSONArray();

    static {
        Reflections reflections = new Reflections("neatlogic");
        Set<Class<? extends IAutoexecType>> autoexecTypeClass = reflections.getSubTypesOf(IAutoexecType.class);
        for (Class<? extends IAutoexecType> c : autoexecTypeClass) {
            try {
                Object[] objects = c.getEnumConstants();
                autoexecTypeList.addAll((JSONArray) c.getMethod("getValueTextList").invoke(objects[0]));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static JSONArray getAutoexecTypeList() {
        return autoexecTypeList;
    }

}
