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

package neatlogic.framework.autoexec.constvalue;

import neatlogic.framework.common.constvalue.IEnum;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import neatlogic.framework.util.I18nUtils;

import java.util.List;
import java.util.Objects;

public enum ScriptExecMode implements IEnum {
    RUNNER("runner", "enum.autoexec.scriptexecmode.runner", "enum.autoexec.scriptexecmode.runner.1"),
    TARGET("target", "enum.autoexec.scriptexecmode.target", "enum.autoexec.scriptexecmode.target.1"),
    RUNNER_TARGET("runner_target", "enum.autoexec.scriptexecmode.runner_target", "enum.autoexec.scriptexecmode.runner_target.1"),
    SQL("sqlfile", "enum.autoexec.scriptexecmode.sql", "enum.autoexec.scriptexecmode.sql.1"),
    NATIVE("native", "enum.autoexec.scriptexecmode.native", "");
    private final String value;
    private final String text;
    private final String description;

    ScriptExecMode(String value, String text, String description) {
        this.value = value;
        this.text = text;
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return I18nUtils.getMessage(text);
    }

    public static ScriptExecMode getExecMode(String _value) {
        for (ScriptExecMode e : ScriptExecMode.values()) {
            if (e.getValue().equals(_value)) {
                return e;
            }
        }
        return null;
    }

    public String getDescription() {
        return I18nUtils.getMessage(description);
    }

    public static String getText(String _value) {
        for (ScriptExecMode e : values()) {
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
        for (ScriptExecMode e : values()) {
            JSONObject obj = new JSONObject();
            obj.put("value", e.getValue());
            obj.put("text", e.getText());
            obj.put("description", e.getDescription());
            resultList.add(obj);
        }
        return resultList;
    }
}
