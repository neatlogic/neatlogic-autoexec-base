/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.constvalue;

import codedriver.framework.common.constvalue.IEnum;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * 工具/自定义工具参数映射模式枚举类
 *
 * @author: laiwt
 * @since: 2022/6/7 17:47
 **/
public enum ScriptParamMappingMode implements IEnum {
    GLOBAL_PARAM("globalparam", "全局参数");

    private final String value;
    private final String text;

    ScriptParamMappingMode(String value, String text) {
        this.value = value;
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
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
        for (ScriptParamMappingMode e : values()) {
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("value", e.getValue());
            jsonObj.put("text", e.getText());
            resultList.add(jsonObj);
        }
        return resultList;
    }

    public static ScriptParamMappingMode getParamMappingMode(String value) {
        for (ScriptParamMappingMode mappingMode : ScriptParamMappingMode.values()) {
            if (mappingMode.value.equals(value)) {
                return mappingMode;
            }
        }
        return null;
    }
}
