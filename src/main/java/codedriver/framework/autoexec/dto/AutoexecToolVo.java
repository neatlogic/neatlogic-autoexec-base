/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto;

import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;
import com.alibaba.fastjson.JSONObject;

public class AutoexecToolVo extends AutoexecOperationVo {
    @EntityField(name = "是否激活", type = ApiParamType.INTEGER)
    private Integer isActive;

    public AutoexecToolVo() {
    }

    public AutoexecToolVo(JSONObject object) {
        setName(object.getString("opName"));
        setExecMode(object.getString("opType"));
        setParser(object.getString("interpreter"));
        setDescription(object.getString("description"));
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

}
