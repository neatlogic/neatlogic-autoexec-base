/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.constvalue;

import codedriver.framework.common.constvalue.IEnum;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public enum JobTriggerType implements IEnum {
    AUTO("自动触发", "auto"),
    MANUAL("人工触发", "manual");
    private final String text;
    private final String value;

    JobTriggerType(String _text, String _value) {
        this.text = _text;
        this.value = _value;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    public static String getText(String _status) {
        for (JobTriggerType s : JobTriggerType.values()) {
            if (s.getValue().equals(_status)) {
                return s.getText();
            }
        }
        return "";
    }

    @Override
    public List getValueTextList() {
        JSONArray array = new JSONArray();
        for (JobTriggerType value : JobTriggerType.values()) {
            array.add(new JSONObject() {
                {
                    this.put("value", value.getValue());
                    this.put("text", value.getText());
                }
            });
        }
        return array;
    }

}
