package neatlogic.framework.autoexec.dto.job;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;

/** 操作审计的独立数据快照，不持有执行过程中的业务对象。 */
public class AutoexecJobOperationAuditVo {
    @EntityField(name = "autoexec.operationaudit.id", type = ApiParamType.LONG)
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long id;
    @EntityField(name = "autoexec.operationaudit.jobid", type = ApiParamType.LONG)
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long jobId;
    @EntityField(name = "autoexec.operationaudit.operatetime", type = ApiParamType.LONG)
    private Long operateTime;
    @EntityField(name = "autoexec.operationaudit.operatoruuid", type = ApiParamType.STRING)
    private String operatorUuid;
    @EntityField(name = "autoexec.operationaudit.action.label", type = ApiParamType.STRING)
    private String action;
    @EntityField(name = "autoexec.operationaudit.objecttype", type = ApiParamType.STRING)
    private String objectType;
    @EntityField(name = "autoexec.operationaudit.targetname", type = ApiParamType.STRING)
    private String targetName;
    @EntityField(name = "autoexec.operationaudit.strategy.label", type = ApiParamType.STRING)
    private String strategy;
    @EntityField(name = "autoexec.operationaudit.previousexecuser", type = ApiParamType.STRING)
    private String previousExecUser;
    @EntityField(name = "autoexec.operationaudit.currentexecuser", type = ApiParamType.STRING)
    private String currentExecUser;
    @EntityField(name = "autoexec.operationaudit.interactiontype", type = ApiParamType.STRING)
    private String interactionType;
    @EntityField(name = "autoexec.operationaudit.interactionvalue", type = ApiParamType.STRING)
    private String interactionValue;
    @EntityField(name = "autoexec.operationaudit.targetcount", type = ApiParamType.INTEGER)
    private Integer targetCount;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getJobId() { return jobId; }
    public void setJobId(Long jobId) { this.jobId = jobId; }

    public Long getOperateTime() { return operateTime; }
    public void setOperateTime(Long operateTime) { this.operateTime = operateTime; }

    public String getOperatorUuid() { return operatorUuid; }
    public void setOperatorUuid(String operatorUuid) { this.operatorUuid = operatorUuid; }

    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }

    public String getObjectType() { return objectType; }
    public void setObjectType(String objectType) { this.objectType = objectType; }

    public String getTargetName() { return targetName; }
    public void setTargetName(String targetName) { this.targetName = targetName; }

    public String getStrategy() { return strategy; }
    public void setStrategy(String strategy) { this.strategy = strategy; }

    public String getPreviousExecUser() { return previousExecUser; }
    public void setPreviousExecUser(String previousExecUser) { this.previousExecUser = previousExecUser; }

    public String getCurrentExecUser() { return currentExecUser; }
    public void setCurrentExecUser(String currentExecUser) { this.currentExecUser = currentExecUser; }

    public String getInteractionType() { return interactionType; }
    public void setInteractionType(String interactionType) { this.interactionType = interactionType; }

    public String getInteractionValue() { return interactionValue; }
    public void setInteractionValue(String interactionValue) { this.interactionValue = interactionValue; }

    public Integer getTargetCount() { return targetCount; }
    public void setTargetCount(Integer targetCount) { this.targetCount = targetCount; }
}
