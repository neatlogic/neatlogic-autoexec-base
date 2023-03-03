/*
Copyright(c) $today.year NeatLogic Co., Ltd. All Rights Reserved.

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

package neatlogic.framework.autoexec.constvalue;

import neatlogic.framework.common.constvalue.IEnum;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

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
