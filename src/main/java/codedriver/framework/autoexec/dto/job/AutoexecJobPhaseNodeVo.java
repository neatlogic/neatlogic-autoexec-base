/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.job;

import codedriver.framework.asynchronization.threadlocal.TenantContext;
import codedriver.framework.autoexec.constvalue.JobNodeStatus;
import codedriver.framework.dto.runner.RunnerVo;
import codedriver.framework.autoexec.dto.combop.AutoexecCombopParamVo;
import codedriver.framework.cmdb.dto.resourcecenter.ResourceVo;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;
import codedriver.framework.util.SnowflakeUtil;
import codedriver.framework.util.TimeUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author lvzk
 * @since 2021/4/12 16:12
 **/
public class AutoexecJobPhaseNodeVo extends AutoexecJobNodeVo implements Serializable {
    private static final long serialVersionUID = -3975625036282871623L;
    @EntityField(name = "作业剧本节点id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "作业组id", type = ApiParamType.LONG)
    private Long jobGroupId;
    @EntityField(name = "作业剧本id", type = ApiParamType.LONG)
    private Long jobPhaseId;
    @EntityField(name = "作业剧本名", type = ApiParamType.STRING)
    private String jobPhaseName;
    @EntityField(name = "作业剧本节点状态", type = ApiParamType.STRING)
    private String status;
    @EntityField(name = "作业剧本runner 映射id", type = ApiParamType.LONG)
    private Long runnerMapId;
    @EntityField(name = "作业剧本runner id", type = ApiParamType.LONG)
    private Long runnerId;
    @EntityField(name = "作业剧本runner ", type = ApiParamType.JSONOBJECT)
    private RunnerVo runnerVo;
    @EntityField(name = "开始时间", type = ApiParamType.STRING)
    private Date startTime;
    @EntityField(name = "结束时间", type = ApiParamType.STRING)
    private Date endTime;
    @EntityField(name = "作业耗时", type = ApiParamType.STRING)
    private String costTime;
    @EntityField(name = "节点Id", type = ApiParamType.LONG)
    private Long nodeId;
    @EntityField(name = "runner 信息", type = ApiParamType.STRING)
    private String runnerUrl;
    @EntityField(name = "runner IP", type = ApiParamType.STRING)
    private String runnerHost;
    @EntityField(name = "runner PORT", type = ApiParamType.INTEGER)
    private Integer runnerPort;
    @EntityField(name = "完成率", type = ApiParamType.INTEGER)
    private Integer completionRate = 0;
    @JSONField(serialize = false)
    private List<String> statusList;
    @JSONField(serialize = false)
    private List<String> statusBlackList;
    @EntityField(name = "作业节点状态Vo", type = ApiParamType.JSONOBJECT)
    private AutoexecJobStatusVo statusVo;
    @EntityField(name = "作业节点工具状态Vo列表", type = ApiParamType.JSONOBJECT)
    private List<AutoexecJobPhaseNodeOperationStatusVo> operationStatusVoList;
    @EntityField(name = "作业节点等待输入渲染jsonStr", type = ApiParamType.JSONOBJECT)
    private String interactStr;
    @EntityField(name = "是否已删除", type = ApiParamType.INTEGER)
    private Integer isDelete;
    private Long resourceId;

    private String schemaName;

    public AutoexecJobPhaseNodeVo() {
    }

    public AutoexecJobPhaseNodeVo(Long jobId, String jobPhaseName, Long runnerId, Integer isDelete) {
        this.setJobId(jobId);
        this.jobPhaseName = jobPhaseName;
        this.runnerMapId = runnerId;
        this.isDelete = isDelete;
    }

    public AutoexecJobPhaseNodeVo(Long jobId, String jobPhaseName, Integer isDelete) {
        this.setJobId(jobId);
        this.jobPhaseName = jobPhaseName;
        this.isDelete = isDelete;
    }

    public AutoexecJobPhaseNodeVo(Long jobId, AutoexecJobPhaseVo jobPhaseVo, String host, String status, String userName, Long protocolId) {
        this.setJobId(jobId);
        this.jobPhaseId = jobPhaseVo.getId();
        this.jobGroupId = jobPhaseVo.getGroupId();
        this.status = status;
        this.setUserName(userName);
        this.setHost(host);
        this.setProtocolId(protocolId);
        this.setLcd(jobPhaseVo.getLcd());
    }

    public AutoexecJobPhaseNodeVo(JSONObject jsonObj) {
        if (MapUtils.isNotEmpty(jsonObj)) {
            this.setJobId(jsonObj.getLong("jobId"));
            this.jobPhaseName = jsonObj.getString("phase");
            this.id = jsonObj.getLong("nodeId");
            this.setHost(jsonObj.getString("host"));
            this.setPort(jsonObj.getInteger("port"));
            this.status = jsonObj.getString("status");
            this.interactStr = jsonObj.getString("interact");
        }
    }

    public AutoexecJobPhaseNodeVo(ResourceVo resourceVo, Long jobId, AutoexecJobPhaseVo jobPhaseVo, String status, String userName, Long protocolId) {
        this.setHost(resourceVo.getIp());
        this.setNodeName(resourceVo.getName());
        this.setPort(resourceVo.getPort());
        this.setJobId(jobId);
        this.jobPhaseId = jobPhaseVo.getId();
        this.jobGroupId = jobPhaseVo.getJobGroupVo().getId();
        this.setProtocolId(protocolId);
        this.status = status;
        this.setUserName(userName);
        this.resourceId = resourceVo.getId();
        this.setNodeType(resourceVo.getTypeName());
        this.setLcd(jobPhaseVo.getLcd());
    }

    public AutoexecJobPhaseNodeVo(AutoexecCombopParamVo paramVo) {

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

    public Long getJobPhaseId() {
        return jobPhaseId;
    }

    public Long getJobGroupId() {
        return jobGroupId;
    }

    public String getJobPhaseName() {
        return jobPhaseName;
    }

    public void setJobPhaseName(String jobPhaseName) {
        this.jobPhaseName = jobPhaseName;
    }

    public void setJobPhaseId(Long jobPhaseId) {
        this.jobPhaseId = jobPhaseId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getRunnerMapId() {
        return runnerMapId;
    }

    public void setRunnerMapId(Long runnerMapId) {
        this.runnerMapId = runnerMapId;
    }

    public List<String> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<String> statusList) {
        this.statusList = statusList;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getCostTime() {
        if (startTime != null) {
            if (endTime != null) {
                return TimeUtil.millisecondsTransferMaxTimeUnit(endTime.getTime() - startTime.getTime());
            } else {
                return TimeUtil.millisecondsTransferMaxTimeUnit(new Date().getTime() - startTime.getTime());
            }
        }
        return costTime;
    }

    public Long getNodeId() {
        return nodeId;
    }

    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }

    public String getRunnerUrl() {
        return runnerUrl;
    }

    public void setRunnerUrl(String runnerUrl) {
        this.runnerUrl = runnerUrl;
    }

    public RunnerVo getRunnerVo() {
        return runnerVo;
    }

    public void setRunnerVo(RunnerVo runnerVo) {
        this.runnerVo = runnerVo;
    }

    public Integer getCompletionRate() {
        if (StringUtils.isNotBlank(status) && Objects.equals(JobNodeStatus.SUCCEED.getValue(), status)) {
            return 100;
        }
        return completionRate;
    }

    public void setCompletionRate(Integer completionRate) {
        this.completionRate = completionRate;
    }

    public AutoexecJobStatusVo getStatusVo() {
        if (statusVo == null && StringUtils.isNotBlank(status)) {
            return new AutoexecJobStatusVo(status, JobNodeStatus.getText(status), JobNodeStatus.getColor(status));
        }
        return statusVo;
    }

    public String getSchemaName() {
        return TenantContext.get().getDataDbName();
    }

    public Long getRunnerId() {
        return runnerId;
    }

    public void setRunnerId(Long runnerId) {
        this.runnerId = runnerId;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public String getRunnerHost() {
        return runnerHost;
    }

    public void setRunnerHost(String runnerHost) {
        this.runnerHost = runnerHost;
    }

    public Integer getRunnerPort() {
        return runnerPort;
    }

    public void setRunnerPort(Integer runnerPort) {
        this.runnerPort = runnerPort;
    }

    public List<AutoexecJobPhaseNodeOperationStatusVo> getOperationStatusVoList() {
        return operationStatusVoList;
    }

    public void setOperationStatusVoList(List<AutoexecJobPhaseNodeOperationStatusVo> operationStatusVoList) {
        this.operationStatusVoList = operationStatusVoList;
    }

    public String getInteractStr() {
        return interactStr;
    }

    public void setInteractStr(String interactStr) {
        this.interactStr = interactStr;
    }

    public JSONObject getInteract() {
        if (StringUtils.isNotBlank(interactStr)) {
            return JSONObject.parseObject(interactStr);
        }
        return null;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public List<String> getStatusBlackList() {
        return statusBlackList;
    }

    public void setStatusBlackList(List<String> statusBlackList) {
        this.statusBlackList = statusBlackList;
    }
}
