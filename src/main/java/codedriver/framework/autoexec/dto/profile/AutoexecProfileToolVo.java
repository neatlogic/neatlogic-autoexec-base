package codedriver.framework.autoexec.dto.profile;

import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.common.dto.BasePageVo;
import codedriver.framework.restful.annotation.EntityField;

/**
 * @author longrf
 * @date 2022/3/21 3:59 下午
 */
public class AutoexecProfileToolVo extends BasePageVo {
    @EntityField(name = "profileId", type = ApiParamType.LONG)
    private Long profileId;
    @EntityField(name = "toolId", type = ApiParamType.LONG)
    private Long toolId;

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public Long getToolId() {
        return toolId;
    }

    public void setToolId(Long toolId) {
        this.toolId = toolId;
    }
}
