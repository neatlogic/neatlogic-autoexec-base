package neatlogic.framework.autoexec.dto.job;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;

/** 操作审计的独立数据快照，不持有执行过程中的业务对象。 */
public class AutoexecJobOperationAuditTargetVo {
    @EntityField(name = "autoexec.operationaudit.id", type = ApiParamType.LONG)
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long id;
    @EntityField(name = "autoexec.operationaudit.auditid", type = ApiParamType.LONG)
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long auditId;
    @EntityField(name = "autoexec.operationaudit.objectid", type = ApiParamType.LONG)
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long objectId;
    @EntityField(name = "autoexec.operationaudit.phaseid", type = ApiParamType.LONG)
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long phaseId;
    @EntityField(name = "autoexec.operationaudit.phasename", type = ApiParamType.STRING)
    private String phaseName;
    @EntityField(name = "autoexec.operationaudit.resourceid", type = ApiParamType.LONG)
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long resourceId;
    @EntityField(name = "autoexec.operationaudit.nodename", type = ApiParamType.STRING)
    private String nodeName;
    @EntityField(name = "autoexec.operationaudit.host", type = ApiParamType.STRING)
    private String host;
    @EntityField(name = "autoexec.operationaudit.sqlfile", type = ApiParamType.STRING)
    private String sqlFile;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getAuditId() { return auditId; }
    public void setAuditId(Long auditId) { this.auditId = auditId; }

    public Long getObjectId() { return objectId; }
    public void setObjectId(Long objectId) { this.objectId = objectId; }

    public Long getPhaseId() { return phaseId; }
    public void setPhaseId(Long phaseId) { this.phaseId = phaseId; }

    public String getPhaseName() { return phaseName; }
    public void setPhaseName(String phaseName) { this.phaseName = phaseName; }

    public Long getResourceId() { return resourceId; }
    public void setResourceId(Long resourceId) { this.resourceId = resourceId; }

    public String getNodeName() { return nodeName; }
    public void setNodeName(String nodeName) { this.nodeName = nodeName; }

    public String getHost() { return host; }
    public void setHost(String host) { this.host = host; }

    public String getSqlFile() { return sqlFile; }
    public void setSqlFile(String sqlFile) { this.sqlFile = sqlFile; }

}
