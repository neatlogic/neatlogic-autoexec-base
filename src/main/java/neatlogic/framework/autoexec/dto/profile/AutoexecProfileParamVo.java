package neatlogic.framework.autoexec.dto.profile;

import neatlogic.framework.autoexec.constvalue.AutoexecProfileParamInvokeType;
import neatlogic.framework.autoexec.dto.AutoexecParamVo;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;
import neatlogic.framework.util.SnowflakeUtil;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @author longrf
 * @date 2022/5/7 2:52 下午
 */
public class AutoexecProfileParamVo extends AutoexecParamVo {

    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
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

    public Long getId() {
        if (id == null) {
            id = SnowflakeUtil.uniqueLong();
        }
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }
}
