/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.combop;

import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;

import java.io.Serializable;
import java.util.List;

/**
 * @author: linbq
 * @since: 2021/4/21 18:41
 **/
public class AutoexecCombopPhaseOperationConfigVo implements Serializable {
    @EntityField(name = "参数映射列表", type = ApiParamType.JSONARRAY)
    private List<ParamMappingVo> paramMappingList;
    @EntityField(name = "自由参数映射列表", type = ApiParamType.JSONARRAY)
    private List<ParamMappingVo> argumentMappingList;

    public List<ParamMappingVo> getParamMappingList() {
        return paramMappingList;
    }

    public void setParamMappingList(List<ParamMappingVo> paramMappingList) {
        this.paramMappingList = paramMappingList;
    }

    public List<ParamMappingVo> getArgumentMappingList() {
        return argumentMappingList;
    }

    public void setArgumentMappingList(List<ParamMappingVo> argumentMappingList) {
        this.argumentMappingList = argumentMappingList;
    }
}
