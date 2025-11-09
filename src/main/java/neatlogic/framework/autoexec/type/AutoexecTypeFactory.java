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
