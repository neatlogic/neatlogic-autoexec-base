package neatlogic.framework.autoexec.dto.profile;

import neatlogic.framework.autoexec.dto.AutoexecOperationVo;
import neatlogic.framework.cmdb.dto.cientity.CiEntityVo;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.common.dto.BaseEditorVo;
import neatlogic.framework.restful.annotation.EntityField;
import neatlogic.framework.util.SnowflakeUtil;

import java.util.List;

/**
 * @author longrf
 * @date 2022/3/16 11:34 上午
 */
public class AutoexecProfileVo extends BaseEditorVo {

    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "名称", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "描述", type = ApiParamType.STRING)
    private String description;
    @EntityField(name = "工具类型", type = ApiParamType.STRING)
    private String type;
    @EntityField(name = "所属系统id", type = ApiParamType.LONG)
    private Long fromSystemId;
    @EntityField(name = "所属系统名称", type = ApiParamType.STRING)
    private String fromSystemName;
    @EntityField(name = "关联配置项id", type = ApiParamType.LONG)
    private Long ciEntityId;
    @EntityField(name = "关联配置项名称", type = ApiParamType.STRING)
    private String ciEntityName;
    @EntityField(name = "关联配置项列表", type = ApiParamType.JSONARRAY)
    private List<CiEntityVo> ciEntityList;
    @EntityField(name = "工具库工具id/脚本工具id", type = ApiParamType.LONG)
    private Long operationId;
    @EntityField(name = "关联的工具和脚本列表", type = ApiParamType.JSONARRAY)
    private List<AutoexecOperationVo> autoexecOperationVoList;
    @EntityField(name = "关联的工具和脚本列表", type = ApiParamType.INTEGER)
    private Integer autoexecOperationCount = 0;
    @EntityField(name = "工具库工具id/脚本工具id列表", type = ApiParamType.JSONARRAY)
    private List<Long> operationIdList;
    @EntityField(name = "profile参数列表", type = ApiParamType.JSONARRAY)
    private List<AutoexecProfileParamVo> profileParamVoList;
    @EntityField(name = "依赖数", type = ApiParamType.INTEGER)
    private Integer referredCount = 0;

    public AutoexecProfileVo() {
    }

    public AutoexecProfileVo(String name, Long fromSystemId) {
        this.name = name;
        this.fromSystemId = fromSystemId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getFromSystemId() {
        return fromSystemId;
    }

    public void setFromSystemId(Long fromSystemId) {
        this.fromSystemId = fromSystemId;
    }

    public String getFromSystemName() {
        return fromSystemName;
    }

    public void setFromSystemName(String fromSystemName) {
        this.fromSystemName = fromSystemName;
    }

    public Long getCiEntityId() {
        return ciEntityId;
    }

    public void setCiEntityId(Long ciEntityId) {
        this.ciEntityId = ciEntityId;
    }

    public String getCiEntityName() {
        return ciEntityName;
    }

    public void setCiEntityName(String ciEntityName) {
        this.ciEntityName = ciEntityName;
    }

    public List<CiEntityVo> getCiEntityList() {
        return ciEntityList;
    }

    public void setCiEntityList(List<CiEntityVo> ciEntityList) {
        this.ciEntityList = ciEntityList;
    }

    public Long getOperationId() {
        return operationId;
    }

    public void setOperationId(Long operationId) {
        this.operationId = operationId;
    }

    public List<AutoexecOperationVo> getAutoexecOperationVoList() {
        return autoexecOperationVoList;
    }

    public void setAutoexecOperationVoList(List<AutoexecOperationVo> autoexecOperationVoList) {
        this.autoexecOperationVoList = autoexecOperationVoList;
    }

    public Integer getAutoexecOperationCount() {
        return autoexecOperationCount;
    }

    public void setAutoexecOperationCount(Integer autoexecOperationCount) {
        this.autoexecOperationCount = autoexecOperationCount;
    }

    public List<Long> getOperationIdList() {
        return operationIdList;
    }

    public void setOperationIdList(List<Long> operationIdList) {
        this.operationIdList = operationIdList;
    }

    public List<AutoexecProfileParamVo> getProfileParamVoList() {
        return profileParamVoList;
    }

    public void setProfileParamVoList(List<AutoexecProfileParamVo> profileParamVoList) {
        this.profileParamVoList = profileParamVoList;
    }

    public Integer getReferredCount() {
        return referredCount;
    }

    public void setReferredCount(Integer referredCount) {
        this.referredCount = referredCount;
    }
}
