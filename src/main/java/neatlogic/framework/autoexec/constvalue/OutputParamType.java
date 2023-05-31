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
    TEXT("text", "common.text", "common.textdesc"),
    PASSWORD("password", "common.password", "enum.autoexec.outputparamtype.password.b"),
    FILE("file", "common.file", "common.autoexec.file"),
    DATE("date", "common.date", "common.dateform"),
    DATETIME("datetime", "common.datatime", "common.datetimeform"),
    TIME("time", "common.time", "common.timeform"),
    JSON("json", "common.jsonobject", "enum.autoexec.outputparamtype.json.b"),
    SELECT("select", "common.single-selectdropdown", "common.selectform"),
    MULTISELECT("multiselect", "enum.autoexec.outputparamtype.multiselect.a", "common.multiselect"),
    RADIO("radio", "common.single-select", "common.single-selectselector"),
    CHECKBOX("checkbox", "common.checkbox", "common.checkboxselector"),
    NODE("node", "common.nodeinformation", "common.outputnode"),
    ACCOUNT("account", "common.account", "common.autoexec.account"),
    FILEPATH("filepath", "common.filepath", "common.canoutputfilepathparameter"),
    TEXTAREA("textarea", "common.textarea", "common.textdesc"),
    PHASE("phase", "common.phase", "enum.autoexec.outputparamtype.phase.b");

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
