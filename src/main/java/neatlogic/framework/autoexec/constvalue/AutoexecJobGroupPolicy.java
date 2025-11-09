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

package neatlogic.framework.autoexec.constvalue;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import neatlogic.framework.common.constvalue.IEnum;

import java.util.List;

/**
 * @author lvzk
 * @since 2022/3/23 14:40
 **/
public enum AutoexecJobGroupPolicy implements IEnum {
    ONESHOT("oneShot"),
    GRAYSCALE("grayScale");
    private final String name;

    AutoexecJobGroupPolicy(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public List getValueTextList() {
        JSONArray resultList = new JSONArray();
        for (AutoexecJobGroupPolicy e : values()) {
            JSONObject obj = new JSONObject();
            obj.put("value", e.getName());
            obj.put("text", e.getName());
            resultList.add(obj);
        }
        return resultList;
    }
}
