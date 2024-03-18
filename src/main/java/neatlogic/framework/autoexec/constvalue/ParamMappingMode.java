/*Copyright (C) $today.year  深圳极向量科技有限公司 All Rights Reserved.

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.*/

package neatlogic.framework.autoexec.constvalue;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import neatlogic.framework.common.constvalue.IEnum;
import neatlogic.framework.util.$;

import java.util.List;

/**
 * 参数映射模式枚举类
 *
 * @author: linbq
 * @since: 2021/4/14 17:47
 **/
public enum ParamMappingMode implements IEnum {
    CONSTANT("constant", "常量"),
    RUNTIME_PARAM("runtimeparam", "作业参数"),
    PRE_NODE_OUTPUT_PARAM("prenodeoutputparam", "上游节点输出参数值"),
    PRE_NODE_OUTPUT_PARAM_KEY("prenodeoutputparamkey", "上游节点输出参数名"),
    IS_EMPTY("isempty", "为空"),
    PROFILE("profile", "预置参数集"),
    GLOBAL_PARAM("globalparam", "全局参数");

    private final String value;
    private final String text;

    private ParamMappingMode(String value, String text) {
        this.value = value;
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return $.t(text);
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
        for (ParamMappingMode e : values()) {
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("value", e.getValue());
            jsonObj.put("text", e.getText());
            resultList.add(jsonObj);
        }
        return resultList;
    }
}
