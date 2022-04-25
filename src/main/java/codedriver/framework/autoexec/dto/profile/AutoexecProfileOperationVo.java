package codedriver.framework.autoexec.dto.profile;

import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.common.dto.BasePageVo;
import codedriver.framework.restful.annotation.EntityField;

/**
 * @author longrf
 * @date 2022/3/21 3:59 下午
 */
public class AutoexecProfileOperationVo extends BasePageVo {

    @EntityField(name = "profileId", type = ApiParamType.LONG)
    private Long profileId;
    @EntityField(name = "operationId", type = ApiParamType.LONG)
    private Long operationId;
    @EntityField(name = "type", type = ApiParamType.STRING)
    private String type;

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public Long getOperationId() {
        return operationId;
    }

    public void setOperationId(Long operationId) {
        this.operationId = operationId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
