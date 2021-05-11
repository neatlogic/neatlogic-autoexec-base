/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.constvalue;

import codedriver.framework.common.constvalue.IEnum;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public enum ExecMode implements IEnum {
    RUNNER("runner", "runner执行", "无需指定执行目标，工具在runner执行，适用于数据汇总处理等"),
    TARGET("target", "target执行", "需指定执行目标，工具在指定的远程主机上执行，只适用于主机信息采集或命令下发"),
    RUNNER_TARGET("runner_target", "runner->target执行", "需指定执行目标，工具在runner上执行，适用于网络设备、存储设备、软件系统等的信息采集或命令下发");
    private final String value;
    private final String text;
    private final String description;

    private ExecMode(String value, String text, String description) {
        this.value = value;
        this.text = text;
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    public String getDescription() {
        return description;
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
        for (ExecMode e : values()) {
            JSONObject obj = new JSONObject();
            obj.put("value", e.getValue());
            obj.put("text", e.getText());
            obj.put("description", e.getDescription());
            resultList.add(obj);
        }
        return resultList;
    }
}
