package codedriver.framework.autoexec.dto.profile;

import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;

import java.io.Serializable;

/**
 * @author longrf
 * @date 2022/5/7 2:52 下午
 */
public class AutoexecProfileParamVo implements Serializable {

    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "参数名", type = ApiParamType.STRING)
    private String key;
    @EntityField(name = "参数默认值", type = ApiParamType.NOAUTH)
    private Object defaultValue;
    @EntityField(name = "参数类型", type = ApiParamType.STRING)
    private String type;
    @EntityField(name = "profile id", type = ApiParamType.LONG)
    private Long profileId;
    @EntityField(name = "来源id", type = ApiParamType.LONG)
    private Long operationId;
    @EntityField(name = "来源类型", type = ApiParamType.STRING)
    private String operationType;
    @EntityField(name = "值引用id", type = ApiParamType.LONG)
    private Long valueInvokeId;
    @EntityField(name = "值引用类型", type = ApiParamType.STRING)
    private String valueInvokeType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(Object defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public Long getValueInvokeId() {
        return valueInvokeId;
    }

    public void setValueInvokeId(Long valueInvokeId) {
        this.valueInvokeId = valueInvokeId;
    }

    public String getValueInvokeType() {
        return valueInvokeType;
    }

    public void setValueInvokeType(String valueInvokeType) {
        this.valueInvokeType = valueInvokeType;
    }
}
