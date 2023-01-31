/*
 * Copyright (c)  2022 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.autoexec.constvalue;

import neatlogic.framework.common.constvalue.IEnum;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @author lvzk
 * @since 2022/3/23 14:40
 **/
public enum AutoexecJobGroupPolicy implements IEnum {
    ONESHOT("oneShot"),
    GRAYSCALE("grayScale");
    private final String name;

    AutoexecJobGroupPolicy(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public List getValueTextList() {
        JSONArray resultList = new JSONArray();
        for (AutoexecJobGroupPolicy e : values()) {
            JSONObject obj = new JSONObject();
            obj.put("value", e.getName());
            obj.put("text", e.getName());
            resultList.add(obj);
        }
        return resultList;
    }
}
