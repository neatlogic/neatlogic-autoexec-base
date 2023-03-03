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
import java.util.Objects;

public enum ExecMode implements IEnum {
    RUNNER("runner", "runner执行", "无需指定执行目标，工具在runner执行，适用于数据汇总处理等"),
    TARGET("target", "target执行", "需指定执行目标，工具在指定的远程主机上执行，只适用于主机信息采集或命令下发"),
    RUNNER_TARGET("runner_target", "runner->target执行", "需指定执行目标，工具在runner上执行，适用于网络设备、存储设备、软件系统等的信息采集或命令下发"),
    SQL("sqlfile", "sql文件执行", "需选定DB执行目标，工具在runner上执行，适用于SQL文件的检查、执行等操作");
    private final String value;
    private final String text;
    private final String description;

    ExecMode(String value, String text, String description) {
        this.value = value;
        this.text = text;
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    public static ExecMode getExecMode(String _value) {
        for (ExecMode e : ExecMode.values()) {
            if (e.getValue().equals(_value)) {
                return e;
            }
        }
        return null;
    }

    public String getDescription() {
        return description;
    }

    public static String getText(String _value) {
        for (ExecMode e : values()) {
            if (Objects.equals(e.getValue(), _value)) {
                return e.getText();
            }
        }
        return "";
    }
    /**
     * @Description: 不同的枚举类，返回不同的枚举值，可自由组合成List<>或者JSONArray
     * @Author: laiwt
     * @Date: 2021/1/12 14:57
     * @Params: []
     * @Returns: java.util.List
     **/
    @Override
    public List getValueTextList() {
        JSONArray resultList = new JSONArray();
        for (ExecMode e : values()) {
            JSONObject obj = new JSONObject();
            obj.put("value", e.getValue());
            obj.put("text", e.getText());
            obj.put("description", e.getDescription());
            resultList.add(obj);
        }
        return resultList;
    }
}
