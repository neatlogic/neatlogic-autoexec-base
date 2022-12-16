/*
 * Copyright(c) 2022 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */
package codedriver.framework.autoexec.dto;

import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;

import java.io.Serializable;

/**
 * @author longrf
 * @date 2022/11/29 16:40
 */

public class AutoexecTypeAuthVo implements Serializable {

    @EntityField(name = "工具分类id", type = ApiParamType.LONG)
    private Long typeId;
    @EntityField(name = "授权对象类型", type = ApiParamType.STRING)
    private String authType;
    @EntityField(name = "授权对象uuid", type = ApiParamType.STRING)
    private String authUuid;

    public AutoexecTypeAuthVo() {
    }

    public AutoexecTypeAuthVo(Long typeId, String authType, String authUuid) {
        this.typeId = typeId;
        this.authType = authType;
        this.authUuid = authUuid;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }

    public String getAuthUuid() {
        return authUuid;
    }

    public void setAuthUuid(String authUuid) {
        this.authUuid = authUuid;
    }
}
