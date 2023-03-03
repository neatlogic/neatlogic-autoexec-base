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

package neatlogic.framework.autoexec.dto.combop;

import neatlogic.framework.autoexec.dto.node.AutoexecNodeVo;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
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
