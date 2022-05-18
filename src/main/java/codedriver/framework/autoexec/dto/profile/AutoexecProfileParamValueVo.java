package codedriver.framework.autoexec.dto.profile;

import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;
import codedriver.framework.util.SnowflakeUtil;

/**
 * @author longrf
 * @date 2022/5/13 11:44 上午
 */
public class AutoexecProfileParamValueVo {

    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "引用id", type = ApiParamType.LONG)
    private Long invokeId;
    @EntityField(name = "profile参数id", type = ApiParamType.LONG)
    private Long profileParamId;
    @EntityField(name = "引用值", type = ApiParamType.NOAUTH)
    private Object invokeValue;

    public Long getId() {
        if (id == null) {
            id = SnowflakeUtil.uniqueLong();
        }
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInvokeId() {
        return invokeId;
    }

    public void setInvokeId(Long invokeId) {
        this.invokeId = invokeId;
    }

    public Long getProfileParamId() {
        return profileParamId;
    }

    public void setProfileParamId(Long profileParamId) {
        this.profileParamId = profileParamId;
    }

    public Object getInvokeValue() {
        return invokeValue;
    }

    public void setInvokeValue(String invokeValue) {
        this.invokeValue = invokeValue;
    }
}
