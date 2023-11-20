/*
Copyright(c) 2023 NeatLogic Co., Ltd. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License. 
 */

package neatlogic.framework.autoexec.script.paramtype;

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
}
