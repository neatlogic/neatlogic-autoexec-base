/*
 *
 * Copyright (C) 2025  TechSure Co., Ltd.  All Rights Reserved.
 * This file is part of the NeatLogic software.
 * Licensed under the NeatLogic Sustainable Use License (NSUL), Version 4.x – 2025.
 * You may use this file only in compliance with the License.
 * See the LICENSE file distributed with this work for the full license text.
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 */

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
    @EntityField(name = "其他场景过滤器", type = ApiParamType.JSONOBJECT)
    private JSONObject otherFilter;
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

    public JSONObject getOtherFilter() {
        return otherFilter;
    }

    public void setOtherFilter(JSONObject otherFilter) {
        this.otherFilter = otherFilter;
    }

    public List<String> getPreOutputList() {
        return preOutputList;
    }

    public void setPreOutputList(List<String> preOutputList) {
        this.preOutputList = preOutputList;
    }

    @JSONField(serialize = false)
    public boolean isNull(){
        return CollectionUtils.isEmpty(paramList) && CollectionUtils.isEmpty(selectNodeList) && CollectionUtils.isEmpty(inputNodeList) && MapUtils.isEmpty(filter)  && MapUtils.isEmpty(otherFilter) && CollectionUtils.isEmpty(preOutputList);
    }
}
