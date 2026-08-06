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
import neatlogic.framework.util.$;

import java.util.List;

public enum AutoexecParallelPolicy implements IEnum {
    PARALLEL("parallel", "nfacv.autoexecparallelpolicy.text.parallel"),
    ROUND_COUNT("roundCount", "nfacv.autoexecparallelpolicy.text.round_count");
    private final String value;
    private final String name;

    AutoexecParallelPolicy(String _value, String _name) {
        this.value = _value;
        this.name = _name;
    }

    @Override
    public List getValueTextList() {
        JSONArray resultList = new JSONArray();
        for (AutoexecParallelPolicy e : values()) {
            JSONObject obj = new JSONObject();
            obj.put("value", e.getValue());
            obj.put("text", e.getName());
            resultList.add(obj);
        }
        return resultList;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String getEnumName() {
        return IEnum.super.getEnumName();
    }

    public String getName() {
        return $.t(name);
    }

    public static String getValue(String _value) {
        for (AutoexecParallelPolicy s : AutoexecParallelPolicy.values()) {
            if (s.getValue().equals(_value)) {
                return s.getValue();
            }
        }
        return null;
    }

    public static String getName(String _value) {
        for (AutoexecParallelPolicy s : AutoexecParallelPolicy.values()) {
            if (s.getValue().equals(_value)) {
                return s.getName();
            }
        }
        return "";
    }

}
