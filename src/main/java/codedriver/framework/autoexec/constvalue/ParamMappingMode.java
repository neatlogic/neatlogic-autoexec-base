/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.constvalue;

import codedriver.framework.common.constvalue.IEnum;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * 参数映射模式枚举类
 *
 * @author: linbq
 * @since: 2021/4/14 17:47
 **/
public enum ParamMappingMode implements IEnum {
    CONSTANT("constant", "常量"),
    GLOBAL_PARAM("globalparam", "全局参数"),
    PRE_NODE_OUTPUT_PARAM("prenodeoutputparam", "上游节点输出参数");

    private String value;
    private String text;
    private JSONObject config;

    private ParamMappingMode(String value, String text) {
        this.value = value;
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    public JSONObject getConfig(){
        return config;
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
        return null;
    }
}
