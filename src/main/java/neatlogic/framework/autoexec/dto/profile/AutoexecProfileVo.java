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
    @EntityField(name = "common.name", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "common.description", type = ApiParamType.STRING)
    private String description;
    @EntityField(name = "term.autoexec.operationtype", type = ApiParamType.STRING)
    private String type;
    @EntityField(name = "term.autoexec.sourcesystemid", type = ApiParamType.LONG)
    private Long fromSystemId;
    @EntityField(name = "nfad.autoexecprofilevo.entityfield.fromsystemname.name", type = ApiParamType.STRING)
    private String fromSystemName;
    @EntityField(name = "term.cmdb.cientityid", type = ApiParamType.LONG)
    private Long ciEntityId;
    @EntityField(name = "nfad.autoexecprofilevo.entityfield.cientityname.name", type = ApiParamType.STRING)
    private String ciEntityName;
    @EntityField(name = "nfad.autoexecprofilevo.entityfield.cientitylist.name", type = ApiParamType.JSONARRAY)
    private List<CiEntityVo> ciEntityList;
    @EntityField(name = "nfad.autoexecprofilevo.entityfield.operationid.name", type = ApiParamType.LONG)
    private Long operationId;
    @EntityField(name = "term.autoexec.associatedtoollist", type = ApiParamType.JSONARRAY)
    private List<AutoexecOperationVo> autoexecOperationVoList;
    @EntityField(name = "nfad.autoexecprofilevo.entityfield.autoexecoperationcount.name", type = ApiParamType.INTEGER)
    private Integer autoexecOperationCount = 0;
    @EntityField(name = "nfad.autoexecprofilevo.entityfield.operationidlist.name", type = ApiParamType.JSONARRAY)
    private List<Long> operationIdList;
    @EntityField(name = "nfad.autoexecprofilevo.entityfield.profileparamvolist.name", type = ApiParamType.JSONARRAY)
    private List<AutoexecProfileParamVo> profileParamVoList;
    @EntityField(name = "common.referencecount", type = ApiParamType.INTEGER)
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
