/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.autoexec.constvalue;

import neatlogic.framework.common.constvalue.IEnum;
import neatlogic.framework.common.dto.ValueTextVo;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public enum FailPolicy implements IEnum {
    STOP("stop", "失败停止"),
    GOON("goon", "失败继续");
    private final String value;
    private final String text;

    private FailPolicy(String value, String text) {
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
        for (FailPolicy e : values()) {
            JSONObject obj = new JSONObject();
            obj.put("value", e.getValue());
            obj.put("text", e.getText());
            resultList.add(obj);
        }
        return resultList;
    }
}
