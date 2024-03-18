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

package neatlogic.framework.autoexec.dto.combop;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import neatlogic.framework.autoexec.dto.node.AutoexecNodeVo;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;

import java.io.Serializable;
import java.util.List;

/**
 * @author: linbq
 * @since: 2021/4/23 11:57
 **/
public class AutoexecCombopExecuteNodeConfigVo implements Serializable {
    private static final long serialVersionUID = 2910089979265665028L;
    @EntityField(name = "参数列表", type = ApiParamType.JSONARRAY)
    private List<String> paramList;
    @EntityField(name = "选择节点列表", type = ApiParamType.JSONARRAY)
    private List<AutoexecNodeVo> selectNodeList;
    @EntityField(name = "输入节点列表", type = ApiParamType.JSONARRAY)
    private List<AutoexecNodeVo> inputNodeList;
    @EntityField(name = "过滤器选择条件", type = ApiParamType.JSONOBJECT)
    private JSONObject filter; // 过滤器
    @EntityField(name = "上游出参列表", type = ApiParamType.JSONARRAY)
    private List<String> preOutputList;

    public List<String> getParamList() {
        return paramList;
    }

    public void setParamList(List<String> paramList) {
        this.paramList = paramList;
    }

    public List<AutoexecNodeVo> getSelectNodeList() {
        return selectNodeList;
    }

    public void setSelectNodeList(List<AutoexecNodeVo> selectNodeList) {
        this.selectNodeList = selectNodeList;
    }

    public List<AutoexecNodeVo> getInputNodeList() {
        return inputNodeList;
    }

    public void setInputNodeList(List<AutoexecNodeVo> inputNodeList) {
        this.inputNodeList = inputNodeList;
    }

    public JSONObject getFilter() {
        return filter;
    }

    public void setFilter(JSONObject filter) {
        this.filter = filter;
    }

    public List<String> getPreOutputList() {
        return preOutputList;
    }

    public void setPreOutputList(List<String> preOutputList) {
        this.preOutputList = preOutputList;
    }

    @JSONField(serialize = false)
    public boolean isNull(){
        return CollectionUtils.isEmpty(paramList) && CollectionUtils.isEmpty(selectNodeList) && CollectionUtils.isEmpty(inputNodeList) && MapUtils.isEmpty(filter) && CollectionUtils.isEmpty(preOutputList);
    }
}
