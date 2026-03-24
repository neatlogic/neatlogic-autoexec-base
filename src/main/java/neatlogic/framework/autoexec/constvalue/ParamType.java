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
import neatlogic.framework.autoexec.exception.job.JobParamValidException;
import neatlogic.framework.autoexec.script.paramtype.ScriptParamTypeFactory;
import neatlogic.framework.common.constvalue.IEnum;
import neatlogic.framework.util.$;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;

/**
 * 全局参数类型枚举类
 *
 * @author: linbq
 * @since: 2021/4/15 14:26
 **/
public enum ParamType implements IEnum {
    TEXT("text", "common.text", "nfac.paramtype.text", v -> v == null || StringUtils.isBlank(v.toString())),
    PASSWORD("password", "common.password", "nfac.paramtype.password",v -> v == null || StringUtils.isBlank(v.toString())),
    FILE("file", "common.file", "common.file", v->v == null || MapUtils.isEmpty(JSONObject.parseObject(JSONObject.toJSONString(v))) || CollectionUtils.isEmpty(JSONObject.parseObject(JSONObject.toJSONString(v)).getJSONArray("fileIdList"))),
    DATE("date", "common.date", "nfac.paramtype.date", v -> v == null || StringUtils.isBlank(v.toString())),
    DATETIME("datetime", "common.datetime", "nfac.paramtype.desc.date", v -> v == null || StringUtils.isBlank(v.toString())),
    TIME("time", "common.time", "nfac.paramtype.desc.time", v -> v == null || StringUtils.isBlank(v.toString())),
    JSON("json", "common.jsonobject", "nfac.paramtype.desc.json", v -> v == null || StringUtils.isBlank(v.toString())),
    SELECT("select", "nfac.paramtype.select", "nfac.paramtype.desc.select",v -> v == null || StringUtils.isBlank(v.toString())),
    MULTISELECT("multiselect", "nfac.paramtype.multiselect", "nfac.paramtype.desc.multiselect", v -> v == null || CollectionUtils.isEmpty(JSONArray.parseArray((v instanceof String) ? v.toString() : JSONArray.toJSONString(v)))) ,
    RADIO("radio", "nfac.paramtype.radio", "nfac.paramtype.desc.radio",v -> v == null || StringUtils.isBlank(v.toString())),
    CHECKBOX("checkbox", "nfac.paramtype.checkbox", "nfac.paramtype.desc.checkbox", v -> v == null || CollectionUtils.isEmpty(JSONArray.parseArray((v instanceof String) ? v.toString() : JSONArray.toJSONString(v)))) ,
    NODE("node", "nfac.paramtype.node", "nfac.paramtype.desc.node", v -> v == null || CollectionUtils.isEmpty(JSONArray.parseArray((v instanceof String) ? v.toString() : JSONArray.toJSONString(v)))) ,
    ACCOUNT("account", "common.account", "common.account",v -> v == null || StringUtils.isBlank(v.toString())),
    USERSELECT("userselect", "nfac.paramtype.userselect", "nfac.paramtype.desc.userselect", v -> v == null || CollectionUtils.isEmpty(JSONArray.parseArray((v instanceof String) ? v.toString() : JSONArray.toJSONString(v)))) ,
    TEXTAREA("textarea", "nfac.paramtype.textarea", "nfac.paramtype.desc.textarea",v -> v == null || StringUtils.isBlank(v.toString())),
    PHASE("phase", "nfac.paramtype.phase", "nfac.paramtype.desc.phase",v -> v == null || StringUtils.isBlank(v.toString())),
    SWITCH("switch", "nfac.paramtype.switch", "nfac.paramtype.switch",v -> v == null || StringUtils.isBlank(v.toString())),
    FILEPATH("filepath", "common.filepath", "nfac.paramtype.desc.filepath",v -> v == null || StringUtils.isBlank(v.toString())),
    RUNNERGROUP("runnergroup", "nfac.paramtype.runnergroup", "nfac.paramtype.runnergroup",v -> v == null || StringUtils.isBlank(v.toString())),
    RUNNERGROUPTAG("runnergrouptag", "nfac.paramtype.runnergrouptag", "nfac.paramtype.runnergrouptag", v -> v == null || CollectionUtils.isEmpty(JSONArray.parseArray((v instanceof String) ? v.toString() : JSONArray.toJSONString(v))))
    ;

    private final String value;
    private final String text;
    private final String description;
    private final Function<Object, Boolean> emptyChecker;

    ParamType(String value, String text, String description, Function<Object, Boolean> emptyChecker) {
        this.value = value;
        this.text = text;
        this.description = description;
        this.emptyChecker = emptyChecker;
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

    public boolean isValueEmpty(Object value,String key,String name) {
        try {
            return emptyChecker.apply(value);
        }catch (Exception e) {
            throw new JobParamValidException(String.format("%s(%s)", name, key));
        }
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
