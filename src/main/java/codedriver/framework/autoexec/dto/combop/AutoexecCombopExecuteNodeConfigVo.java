/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.combop;

import codedriver.framework.autoexec.dto.node.AutoexecNodeVo;
import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.List;

/**
 * @author: linbq
 * @since: 2021/4/23 11:57
 **/
public class AutoexecCombopExecuteNodeConfigVo implements Serializable {
    private List<Long> tagList;
    private List<String> paramList;
    private List<AutoexecNodeVo> selectNodeList;
    private List<AutoexecNodeVo> inputNodeList;
    private JSONObject filter; // 过滤器

    public List<Long> getTagList() {
        return tagList;
    }

    public void setTagList(List<Long> tagList) {
        this.tagList = tagList;
    }

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
}
