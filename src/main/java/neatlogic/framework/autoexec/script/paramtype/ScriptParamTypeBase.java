/*
Copyright(c) $today.year NeatLogic Co., Ltd. All Rights Reserved.

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
