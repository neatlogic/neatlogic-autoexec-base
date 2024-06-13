package neatlogic.framework.autoexec.dto.profile;

import com.alibaba.fastjson.JSONObject;
import neatlogic.framework.autoexec.dto.AutoexecParamVo;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;

/**
 * @author longrf
 * @date 2022/5/7 2:52 下午
 */
public class AutoexecProfileParamVo extends AutoexecParamVo {

    @EntityField(name = "profile id", type = ApiParamType.LONG)
    private Long profileId;

    public AutoexecProfileParamVo() {
    }

    public AutoexecProfileParamVo(AutoexecParamVo operationParamVo) {
        super.setKey(operationParamVo.getKey());
        super.setName(operationParamVo.getName());
        super.setDefaultValue(operationParamVo.getDefaultValue());
        super.setMode(operationParamVo.getMode());
        super.setType(operationParamVo.getType());
        super.setMappingMode(operationParamVo.getMappingMode());
        super.setDescription(operationParamVo.getDescription());
        super.setSort(operationParamVo.getSort());
        super.setValidate(operationParamVo.getValidate());
        super.setOperationId(operationParamVo.getOperationId());
        super.setOperationType(operationParamVo.getOperationType());
        if (operationParamVo.getConfig() != null) {
            super.setConfig(JSONObject.toJSONString(operationParamVo.getConfig()));
        }
        super.setArgumentCount(operationParamVo.getArgumentCount());
    }

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }
}
