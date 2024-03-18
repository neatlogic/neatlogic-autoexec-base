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

import com.alibaba.fastjson.JSONObject;

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
    public Object getTextByValue(Object value, JSONObject config) {
        return getMyTextByValue(value, config);
    }

    protected Object getMyTextByValue(Object value, JSONObject config){
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


    @Override
    public Object getExchangeParamByValue(Object value) {
        return getMyExchangeParamByValue(value);
    }
    protected Object getMyExchangeParamByValue(Object value){
        return value;
    }
}
