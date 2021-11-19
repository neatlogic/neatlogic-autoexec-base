/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.script.paramtype;

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
    Object getTextByValue(Object value);

    /**
     * 根据参数值获取对应给autoexec执行的参数
     * @return param
     */
    Object getAutoexecParamByValue(Object value);
}
