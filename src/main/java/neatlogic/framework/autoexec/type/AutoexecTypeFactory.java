/*
 * Copyright (c)  2022 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.autoexec.type;

import com.alibaba.fastjson.JSONArray;
import org.reflections.Reflections;

import java.util.Set;

public class AutoexecTypeFactory {
    private static final JSONArray autoexecTypeList = new JSONArray();

    static {
        Reflections reflections = new Reflections("neatlogic");
        Set<Class<? extends IAutoexecType>> autoexecTypeClass = reflections.getSubTypesOf(IAutoexecType.class);
        for (Class<? extends IAutoexecType> c : autoexecTypeClass) {
            try {
                Object[] objects = c.getEnumConstants();
                autoexecTypeList.addAll((JSONArray) c.getMethod("getValueTextList").invoke(objects[0]));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static JSONArray getAutoexecTypeList() {
        return autoexecTypeList;
    }

}
