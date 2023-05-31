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
    TEXT("text", "enum.autoexec.outputparamtype.text.a", "enum.autoexec.outputparamtype.text.b"),
    PASSWORD("password", "enum.autoexec.outputparamtype.password.a", "enum.autoexec.outputparamtype.password.b"),
    FILE("file", "enum.autoexec.outputparamtype.file.a", "enum.autoexec.outputparamtype.file.b"),
    DATE("date", "enum.autoexec.outputparamtype.date.a", "enum.autoexec.outputparamtype.date.b"),
    DATETIME("datetime", "enum.autoexec.outputparamtype.datetime.a", "enum.autoexec.outputparamtype.datetime.b"),
    TIME("time", "enum.autoexec.outputparamtype.time.a", "enum.autoexec.outputparamtype.time.b"),
    JSON("json", "enum.autoexec.outputparamtype.json.a", "enum.autoexec.outputparamtype.json.b"),
    SELECT("select", "enum.autoexec.outputparamtype.select.a", "enum.autoexec.outputparamtype.select.b"),
    MULTISELECT("multiselect", "enum.autoexec.outputparamtype.multiselect.a", "enum.autoexec.outputparamtype.multiselect.b"),
    RADIO("radio", "enum.autoexec.outputparamtype.radio.a", "enum.autoexec.outputparamtype.radio.b"),
    CHECKBOX("checkbox", "enum.autoexec.outputparamtype.checkbox.a", "enum.autoexec.outputparamtype.checkbox.b"),
    NODE("node", "enum.autoexec.outputparamtype.node.a", "enum.autoexec.outputparamtype.node.b"),
    ACCOUNT("account", "enum.autoexec.outputparamtype.account.a", "enum.autoexec.outputparamtype.account.b"),
    FILEPATH("filepath", "enum.autoexec.outputparamtype.filepath.a", "enum.autoexec.outputparamtype.filepath.b"),
    TEXTAREA("textarea", "enum.autoexec.outputparamtype.textarea.a", "enum.autoexec.outputparamtype.textarea.b"),
    PHASE("phase", "enum.autoexec.outputparamtype.phase.a", "enum.autoexec.outputparamtype.phase.b");

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
