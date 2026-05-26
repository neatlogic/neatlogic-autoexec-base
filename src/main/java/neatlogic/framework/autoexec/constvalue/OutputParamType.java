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
import neatlogic.framework.autoexec.script.paramtype.ScriptParamTypeFactory;
import neatlogic.framework.common.constvalue.IEnum;
import neatlogic.framework.util.$;

import java.util.List;
import java.util.Objects;

/**
 * 全局参数类型枚举类
 *
 * @author: linbq
 * @since: 2021/4/15 14:26
 **/
public enum OutputParamType implements IEnum {
    TEXT("text", "common.text", "nfac.outputparamtype.desc.text"),
    PASSWORD("password", "common.password", "nfac.outputparamtype.desc.password"),
    FILE("file", "common.file", "common.file"),
    DATE("date", "common.date", "nfac.paramtype.date"),
    DATETIME("datetime", "common.datetime", "nfac.paramtype.desc.date"),
    TIME("time", "common.time", "nfac.paramtype.desc.time"),
    JSON("json", "common.jsonobject", "nfac.outputparamtype.desc.jsonobject"),
    SELECT("select", "common.singleselect", "nfac.paramtype.desc.select"),
    MULTISELECT("multiselect", "common.multiselect", "common.multiselect"),
    RADIO("radio", "common.radio", "nfac.paramtype.desc.radio"),
    CHECKBOX("checkbox", "common.checkbox", "nfac.paramtype.desc.checkbox"),
    NODE("node", "common.nodeinfo", "nfac.paramtype.desc.node"),
    ACCOUNT("account", "common.account", "common.account"),
    FILEPATH("filepath", "common.filepath", "nfac.paramtype.desc.filepath"),
    TEXTAREA("textarea", "common.textarea", "nfac.outputparamtype.desc.text"),
    PHASE("phase", "common.phase", "nfac.outputparamtype.desc.phase");

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
        return $.t(text);
    }

    public String getDescription() {
        return $.t(description);
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
