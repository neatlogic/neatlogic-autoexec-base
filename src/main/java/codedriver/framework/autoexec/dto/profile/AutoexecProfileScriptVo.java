package codedriver.framework.autoexec.dto.profile;

import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.common.dto.BasePageVo;
import codedriver.framework.restful.annotation.EntityField;

/**
 * @author longrf
 * @date 2022/3/21 3:59 下午
 */
public class AutoexecProfileScriptVo extends BasePageVo {

    @EntityField(name = "profileId", type = ApiParamType.LONG)
    private Long profileId;
    @EntityField(name = "scriptId", type = ApiParamType.LONG)
    private Long scriptId;

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public Long getScriptId() {
        return scriptId;
    }

    public void setScriptId(Long scriptId) {
        this.scriptId = scriptId;
    }
}
