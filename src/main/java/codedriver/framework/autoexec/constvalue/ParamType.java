/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.constvalue;

import codedriver.framework.common.constvalue.IEnum;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.javers.common.collections.Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 全局参数类型枚举类
 *
 * @author: linbq
 * @since: 2021/4/15 14:26
 **/
public enum ParamType implements IEnum {
    TEXT("text", "文本", false, new JSONObject() {
        {
            this.put("type", "text");
            this.put("maxlength", 500);
            this.put("placeholder", "请输入");
        }
    },
            "文本参数，可输入字符串、数字"),
    PASSWORD("password", "密码", false, new JSONObject() {
        {
            this.put("type", "password");
            this.put("maxlength", 50);
            this.put("showPassword", true);
            this.put("placeholder", "请输入");
        }
    },
            "可输入数字或字符串，页面显示为密文"),
    FILE("file", "文件", false, new JSONObject() {
        {
            this.put("type", "file");
            this.put("dataType", "autoexec");
            this.put("formatList", new ArrayList<>());
            this.put("placeholder", "请上传");
        }
    },
            "支持多个文件同时上传，执行时，自动上传文件到目标主机特定目录下，保留原文件名"),
    DATE("date", "日期", false, new JSONObject() {
        {
            this.put("type", "date");
            this.put("format", "yyyy-MM-dd");
            this.put("placeholder", "请选择日期");
        }
    },
            "日期选择器"),
    DATETIME("datetime", "日期时间", false, new JSONObject() {
        {
            this.put("type", "datetime");
            this.put("format", "yyyy-MM-dd HH:mm:ss");
            this.put("placeholder", "请选择日期时间");
        }
    },
            "日期时间选择器"),
    TIME("time", "时间", false, new JSONObject() {
        {
            this.put("type", "time");
            this.put("format", "HH:mm:ss");
            this.put("placeholder", "请选择时间");
        }
    },
            "时间选择器"),
    JSON("json", "json对象", false, new JSONObject() {
        {
            this.put("type", "textarea");
            this.put("placeholder", "请输入");
        }
    },
            "支持json对象和json数组，输入内容需是合法Json格式"),
    SELECT("select", "单选下拉", true, new JSONObject() {
        {
            this.put("type", "select");
            this.put("placeholder", "请选择");
            this.put("dynamicUrl", "/api/rest/matrix/column/data/search/forselect/new");
            this.put("rootName", "columnDataList");
            this.put("multiple", false);
//            this.put("textName", "name");
//            this.put("valueName", "uuid");
//            List<String> validateList = new ArrayList<>();
//            validateList.add("required");
//            this.put("validateList", validateList);
        }
    }, "单选下拉选择器"),
    MULTISELECT("multiselect", "多选下拉", true, new JSONObject() {
        {
            this.put("type", "select");
            this.put("placeholder", "请选择");
            this.put("dynamicUrl", "/api/rest/matrix/column/data/search/forselect/new");
            this.put("rootName", "columnDataList");
            this.put("multiple", true);
//            this.put("textName", "name");
//            this.put("valueName", "uuid");
//            List<String> validateList = new ArrayList<>();
//            validateList.add("required");
//            this.put("validateList", validateList);
        }
    }, "多选下拉选择器"),
    RADIO("radio", "单选", true, new JSONObject() {
        {
            this.put("type", "radio");
            this.put("placeholder", "请选择");
            this.put("url", "/api/rest/matrix/column/data/search/forselect/new");
            this.put("rootName", "columnDataList");
//            this.put("textName", "name");
//            this.put("valueName", "uuid");
//            List<String> validateList = new ArrayList<>();
//            validateList.add("required");
//            this.put("validateList", validateList);
        }
    }, "单选选择器"),
    CHECKBOX("checkbox", "复选", true, new JSONObject() {
        {
            this.put("type", "checkbox");
            this.put("placeholder", "请选择");
            this.put("url", "/api/rest/matrix/column/data/search/forselect/new");
            this.put("rootName", "columnDataList");
//            this.put("textName", "name");
//            this.put("valueName", "uuid");
//            List<String> validateList = new ArrayList<>();
//            validateList.add("required");
//            this.put("validateList", validateList);
        }
    }, "复选选择器"),
    NODE("node", "节点信息", true, new JSONObject() {
        {
            this.put("type", "node");
            this.put("placeholder", "请选择");
        }
    }, "将节点的相关信息生成脚本变量，但不会分派到该节点执行");

    private final String value;
    private final String text;
    private final Boolean isDynamic;//是否是动态数据源
    private final JSONObject config;
    private final String description;

    private ParamType(String value, String text, Boolean isDynamic, JSONObject config, String description) {
        this.value = value;
        this.text = text;
        this.isDynamic = isDynamic;
        this.config = config;
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    public Boolean getIsDynamic() {
        return isDynamic;
    }

    public JSONObject getConfig() {
        return config;
    }

    public String getDescription() {
        return description;
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
            jsonObj.put("config", e.getConfig());
            jsonObj.put("description", e.getDescription());
            resultList.add(jsonObj);
        }
        return resultList;
    }
}
