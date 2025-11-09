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
 * @since 2022/3/29 14:40
 **/
public enum AutoexecJobPhaseExecutePolicy implements IEnum {
    FIRST_ROUND("firstRound", "first"),
    MIDDLE_ROUND("middleRound", "middle"),
    LAST_ROUND("lastRound", "last");
    private final String name;
    private final String value;

    AutoexecJobPhaseExecutePolicy(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    @Override
    public List getValueTextList() {
        JSONArray resultList = new JSONArray();
        for (AutoexecJobPhaseExecutePolicy e : values()) {
            JSONObject obj = new JSONObject();
            obj.put("value", e.getValue());
            obj.put("text", e.getName());
            resultList.add(obj);
        }
        return resultList;
    }
}
