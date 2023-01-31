/*
 * Copyright(c) 2022 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.autoexec.constvalue;

import neatlogic.framework.common.constvalue.IEnum;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public enum ReviewStatus implements IEnum {
    WAITING("waiting", "待审核"), PASSED("passed", "已通过"), FAILED("failed", "审批未通过 ");
    private final String value;
    private final String text;

    private ReviewStatus(String _value, String _text) {
        this.value = _value;
        this.text = _text;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
    }


    public static String getText(String _status) {
        for (ReviewStatus s : ReviewStatus.values()) {
            if (s.getValue().equals(_status)) {
                return s.getText();
            }
        }
        return "";
    }


    @Override
    public List getValueTextList() {
        JSONArray array = new JSONArray();
        for (ReviewStatus status : ReviewStatus.values()) {
            array.add(new JSONObject() {
                {
                    this.put("value", status.getValue());
                    this.put("text", status.getText());
                }
            });
        }
        return array;
    }

}
