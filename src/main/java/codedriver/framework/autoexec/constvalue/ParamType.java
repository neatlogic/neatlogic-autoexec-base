/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.constvalue;

import codedriver.framework.common.constvalue.FormHandlerType;
import codedriver.framework.common.constvalue.IEnum;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

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
    TEXT("text", "文本", new JSONObject() {
        {
            this.put("type", "text");
            this.put("maxlength", 500);
            this.put("placeholder", "请输入");
        }
    },
            "文本说明"),
    PASSWORD("password", "密码", new JSONObject() {
        {
            this.put("type", "password");
            this.put("maxlength", 50);
            this.put("showPassword", true);
            this.put("placeholder", "请输入");
        }
    },
            "密码说明"),
    FILE("file", "文件", new JSONObject() {
        {
            this.put("type", "file");
            this.put("dataType", "autoexec");
            this.put("formatList", new ArrayList<>());
            this.put("placeholder", "请上传");
        }
    },
            "文件说明"),
    DATE("date", "日期", new JSONObject() {
        {
            this.put("type", "date");
            this.put("showType", "yyyy-MM-dd");
            this.put("placeholder", "请选择日期");
        }
    },
            "日期说明"),
    JSON("json", "json对象", new JSONObject() {
        {
            this.put("type", "json");
            this.put("placeholder", "请输入");
        }
    },
            "json对象说明");

    private String value;
    private String text;
    private JSONObject config;
    private String description;

    private ParamType(String value, String text, JSONObject config, String description) {
        this.value = value;
        this.text = text;
        this.config = config;
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
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
