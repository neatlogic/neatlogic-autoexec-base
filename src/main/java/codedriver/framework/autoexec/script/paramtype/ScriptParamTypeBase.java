/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.script.paramtype;

/**
 * @author lvzk
 * @since 2021/11/18 12:22
 **/
public abstract class ScriptParamTypeBase implements IScriptParamType{
    /**
     * 是否需要配置数据源
     *
     * @return true|false
     */
    @Override
    public Boolean needDataSource() {
        return myNeedDataSource();
    }

    protected Boolean myNeedDataSource(){
        return false;
    }

    /**
     * 根据参数值获取对应的text
     *
     * @return text
     */
    @Override
    public Object getTextByValue(Object value) {
        return getMyTextByValue(value);
    }

    protected Object getMyTextByValue(Object value){
        return value;
    }

    /**
     * 根据参数值获取对应给autoexec执行的参数
     *
     * @return param
     */
    @Override
    public Object getAutoexecParamByValue(Object value) {
        return getMyAutoexecParamByValue(value);
    }

    protected Object getMyAutoexecParamByValue(Object value){
        return value;
    }
}
