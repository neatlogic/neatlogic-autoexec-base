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

import neatlogic.framework.autoexec.script.paramtype.ScriptParamTypeFactory;
import neatlogic.framework.common.constvalue.IEnum;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import neatlogic.framework.util.I18nUtils;

import java.util.List;
import java.util.Objects;

/**
 * 全局参数类型枚举类
 *
 * @author: linbq
 * @since: 2021/4/15 14:26
 **/
public enum OutputParamType implements IEnum {
    TEXT("text", "enum.autoexec.outputparamtype.text", "enum.autoexec.outputparamtype.text.1"),
    PASSWORD("password", "enum.autoexec.outputparamtype.password", "enum.autoexec.outputparamtype.password.1"),
    FILE("file", "enum.autoexec.outputparamtype.file", "enum.autoexec.outputparamtype.file.1"),
    DATE("date", "enum.autoexec.outputparamtype.date", "enum.autoexec.outputparamtype.date.1"),
    DATETIME("datetime", "enum.autoexec.outputparamtype.datetime", "enum.autoexec.outputparamtype.datetime.1"),
    TIME("time", "enum.autoexec.outputparamtype.time", "enum.autoexec.outputparamtype.time.1"),
    JSON("json", "enum.autoexec.outputparamtype.json", "enum.autoexec.outputparamtype.json.1"),
    SELECT("select", "enum.autoexec.outputparamtype.select", "enum.autoexec.outputparamtype.select.1"),
    MULTISELECT("multiselect", "enum.autoexec.outputparamtype.multiselect", "enum.autoexec.outputparamtype.multiselect.1"),
    RADIO("radio", "enum.autoexec.outputparamtype.radio", "enum.autoexec.outputparamtype.radio.1"),
    CHECKBOX("checkbox", "enum.autoexec.outputparamtype.checkbox", "enum.autoexec.outputparamtype.checkbox.1"),
    NODE("node", "enum.autoexec.outputparamtype.node", "enum.autoexec.outputparamtype.node.1"),
    ACCOUNT("account", "enum.autoexec.outputparamtype.account", "enum.autoexec.outputparamtype.account.1"),
    FILEPATH("filepath", "enum.autoexec.outputparamtype.filepath", "enum.autoexec.outputparamtype.filepath.1"),
    TEXTAREA("textarea", "enum.autoexec.outputparamtype.textarea", "enum.autoexec.outputparamtype.textarea.1"),
    PHASE("phase", "enum.autoexec.outputparamtype.phase", "enum.autoexec.outputparamtype.phase.1");

    private final String value;
    private final String text;
    private final String description;

    OutputParamType(String value, String text, String description) {
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

    public String getDescription() {
        return I18nUtils.getMessage(description);
    }

    public static OutputParamType getParamType(String _value) {
        for (OutputParamType e : values()) {
            if (Objects.equals(e.getValue(), _value)) {
                return e;
            }
        }
        return null;
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
        for (OutputParamType e : values()) {
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("value", e.getValue());
            jsonObj.put("text", e.getText());
            jsonObj.put("config", ScriptParamTypeFactory.getHandler(e.getValue()).getConfig());
            jsonObj.put("description", e.getDescription());
            resultList.add(jsonObj);
        }
        return resultList;
    }
}