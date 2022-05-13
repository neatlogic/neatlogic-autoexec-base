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
    @EntityField(name = "来源id", type = ApiParamType.LONG)
    private Long operationId;
    @EntityField(name = "来源类型", type = ApiParamType.STRING)
    private String operationType;
    @EntityField(name = "值引用参数列表", type = ApiParamType.JSONARRAY)
    private List<AutoexecProfileParamValueInvokeVo> valueInvokeVoList;

    public AutoexecProfileParamVo(AutoexecParamVo operationParamVo) {
        super.setKey(operationParamVo.getKey());
        super.setName(operationParamVo.getName());
        super.setDefaultValue(operationParamVo.getDefaultValue());
        super.setMode(operationParamVo.getMode());
        super.setType(operationParamVo.getType());
        super.setDescription(operationParamVo.getDescription());
        super.setSort(operationParamVo.getSort());
        super.setValidate(operationParamVo.getValidate());
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

    public List<AutoexecProfileParamValueInvokeVo> getValueInvokeVoList() {
        return valueInvokeVoList;
    }

    public void setValueInvokeVoList(List<AutoexecProfileParamValueInvokeVo> valueInvokeVoList) {
        this.valueInvokeVoList = valueInvokeVoList;
    }

}
