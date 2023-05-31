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
public enum ParamType implements IEnum {
    TEXT("text", "enum.autoexec.paramtype.text.a", "enum.autoexec.paramtype.text.b"),
    PASSWORD("password", "enum.autoexec.paramtype.password.a", "enum.autoexec.paramtype.password.b"),
    FILE("file", "enum.autoexec.paramtype.file.a", "enum.autoexec.paramtype.file.b"),
    DATE("date", "enum.autoexec.paramtype.date.a", "enum.autoexec.paramtype.date.b"),
    DATETIME("datetime", "enum.autoexec.paramtype.datetime.a", "enum.autoexec.paramtype.datetime.b"),
    TIME("time", "enum.autoexec.paramtype.time.a", "enum.autoexec.paramtype.time.b"),
    JSON("json", "enum.autoexec.paramtype.json.a", "enum.autoexec.paramtype.json.b"),
    SELECT("select", "enum.autoexec.paramtype.select.a", "enum.autoexec.paramtype.select.b"),
    MULTISELECT("multiselect", "enum.autoexec.paramtype.multiselect.a", "enum.autoexec.paramtype.multiselect.b"),
    RADIO("radio", "enum.autoexec.paramtype.radio.a", "enum.autoexec.paramtype.radio.b"),
    CHECKBOX("checkbox", "enum.autoexec.paramtype.checkbox.a", "enum.autoexec.paramtype.checkbox.b"),
    NODE("node", "enum.autoexec.paramtype.node.a", "enum.autoexec.paramtype.node.b"),
    ACCOUNT("account", "enum.autoexec.paramtype.account.a", "enum.autoexec.paramtype.account.b"),
    USERSELECT("userselect", "enum.autoexec.paramtype.userselect.a", "enum.autoexec.paramtype.userselect.b"),
    TEXTAREA("textarea", "enum.autoexec.paramtype.textarea.a", "enum.autoexec.paramtype.textarea.b"),
    PHASE("phase", "enum.autoexec.paramtype.phase.a", "enum.autoexec.paramtype.phase.b"),
    SWITCH("switch", "enum.autoexec.paramtype.switch", "enum.autoexec.paramtype.switch"),
    FILEPATH("filepath", "enum.autoexec.paramtype.filepath.a", "enum.autoexec.paramtype.filepath.b");

    private final String value;
    private final String text;
    private final String description;

    ParamType(String value, String text, String description) {
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

    public static ParamType getParamType(String _value) {
        for (ParamType e : values()) {
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
        for (ParamType e : values()) {
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
