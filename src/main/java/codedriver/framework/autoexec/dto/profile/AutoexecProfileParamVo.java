package codedriver.framework.autoexec.dto.profile;

import codedriver.framework.autoexec.dto.AutoexecParamVo;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;
import codedriver.framework.util.SnowflakeUtil;

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
    @EntityField(name = "引用类型", type = ApiParamType.STRING)
    private String valueInvokeType;
    @EntityField(name = "值引用参数列表", type = ApiParamType.JSONARRAY)
    private List<AutoexecProfileParamValueVo> valueInvokeVoList;

    public AutoexecProfileParamVo() {
    }

    public AutoexecProfileParamVo(AutoexecParamVo operationParamVo) {
        super.setKey(operationParamVo.getKey());
        super.setName(operationParamVo.getName());
        super.setDefaultValue(operationParamVo.getDefaultValue());
        super.setMode(operationParamVo.getMode());
        super.setType(operationParamVo.getType());
        super.setDescription(operationParamVo.getDescription());
        super.setSort(operationParamVo.getSort());
        super.setValidate(operationParamVo.getValidate());
        super.setOperationId(operationParamVo.getOperationId());
        super.setOperationType(operationParamVo.getOperationType());
        if (operationParamVo.getConfig() != null) {
            super.setConfig(operationParamVo.getConfig().toJSONString());

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

    public String getValueInvokeType() {
        return valueInvokeType;
    }

    public void setValueInvokeType(String valueInvokeType) {
        this.valueInvokeType = valueInvokeType;
    }

    public List<AutoexecProfileParamValueVo> getValueInvokeVoList() {
        return valueInvokeVoList;
    }

    public void setValueInvokeVoList(List<AutoexecProfileParamValueVo> valueInvokeVoList) {
        this.valueInvokeVoList = valueInvokeVoList;
    }
}
