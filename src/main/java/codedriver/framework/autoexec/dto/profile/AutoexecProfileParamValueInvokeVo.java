package codedriver.framework.autoexec.dto.profile;

import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;
import codedriver.framework.util.SnowflakeUtil;

/**
 * @author longrf
 * @date 2022/5/13 11:44 上午
 */
public class AutoexecProfileParamValueInvokeVo {

    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "值引用id", type = ApiParamType.LONG)
    private Long valueInvokeId;
    @EntityField(name = "profile参数id", type = ApiParamType.LONG)
    private Long profileParamId;
    @EntityField(name = "值引用类型", type = ApiParamType.STRING)
    private String valueInvokeType;

    public Long getId() {
        if (id == null) {
            id = SnowflakeUtil.uniqueLong();
        }
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getValueInvokeId() {
        return valueInvokeId;
    }

    public void setValueInvokeId(Long valueInvokeId) {
        this.valueInvokeId = valueInvokeId;
    }

    public Long getProfileParamId() {
        return profileParamId;
    }

    public void setProfileParamId(Long profileParamId) {
        this.profileParamId = profileParamId;
    }

    public String getValueInvokeType() {
        return valueInvokeType;
    }

    public void setValueInvokeType(String valueInvokeType) {
        this.valueInvokeType = valueInvokeType;
    }
}
