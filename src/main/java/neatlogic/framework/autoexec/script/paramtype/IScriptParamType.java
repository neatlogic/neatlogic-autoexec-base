/*Copyright (C) 2023  深圳极向量科技有限公司 All Rights Reserved.

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

package neatlogic.framework.autoexec.script.paramtype;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author lvzk
 * @since 2021/11/18 12:11
 **/
public interface IScriptParamType {
    /**
     * 获取参数类型
     * @return 类型
     */
    String getType();

    /**
     * 获取参数类型名
     * @return 类型名
     */
    String getTypeName();

    /**
     * 获取参数描述
     * @return
     */
    String getDescription();

    /**
     * 排序
     * @return
     */
    int getSort();
    /**
     * 是否需要配置数据源
     * @return true|false
     */
    Boolean needDataSource();

    /**
     * 获取前端初始化配置
     * @return 配置
     */
    JSONObject getConfig();

    /**
     * 根据参数值获取对应的text
     * @return text
     */
    Object getTextByValue(Object value, JSONObject config);

    /**
     * 根据参数值获取对应给autoexec执行的参数
     * @return param
     */
    Object getAutoexecParamByValue(Object value);

    /**
     * 将外部输入的参数的值转化为内部的值
     * @return param
     */
    Object getExchangeParamByValue(Object value);

    /**
     * 流程自动化节点，把表单表格组件中某列数据集合转换成作业参数对应的数据
     * @param jsonArray
     * @return
     */
    Object convertDataForProcessComponent(JSONArray jsonArray);
}
