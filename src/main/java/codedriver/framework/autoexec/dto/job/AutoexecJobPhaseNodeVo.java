/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.job;

import codedriver.framework.asynchronization.threadlocal.TenantContext;
import codedriver.framework.autoexec.constvalue.JobNodeStatus;
import codedriver.framework.autoexec.dto.AutoexecRunnerVo;
import codedriver.framework.autoexec.dto.combop.AutoexecCombopParamVo;
import codedriver.framework.cmdb.dto.resourcecenter.ResourceVo;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;
import codedriver.framework.util.SnowflakeUtil;
import codedriver.framework.util.TimeUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
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
    @EntityField(name = "作业剧本id", type = ApiParamType.LONG)
    private Long jobPhaseId;
    @EntityField(name = "作业剧本名", type = ApiParamType.STRING)
    private String jobPhaseName;
    @EntityField(name = "作业剧本节点状态", type = ApiParamType.STRING)
    private String status;
    @EntityField(name = "作业剧本代理映射id", type = ApiParamType.LONG)
    private Integer runnerMapId;
    @EntityField(name = "作业剧本代理id", type = ApiParamType.LONG)
    private Integer runnerId;
    @EntityField(name = "作业剧本代理", type = ApiParamType.JSONOBJECT)
    private AutoexecRunnerVo autoexecRunnerVo;
    @EntityField(name = "开始时间", type = ApiParamType.STRING)
    private Date startTime;
    @EntityField(name = "结束时间", type = ApiParamType.STRING)
    private Date endTime;
    @EntityField(name = "作业耗时", type = ApiParamType.STRING)
    private String costTime;
    @EntityField(name = "节点Id", type = ApiParamType.LONG)
    private Long nodeId;
    @EntityField(name = "节点连接类型", type = ApiParamType.STRING)
    private String protocol;
    @EntityField(name = "代理信息", type = ApiParamType.STRING)
    private String runnerUrl;
    @EntityField(name = "完成率", type = ApiParamType.INTEGER)
    private Integer completionRate = 0;
    @JSONField(serialize = false)
    private List<String> statusList;
    @EntityField(name = "作业节点状态Vo", type = ApiParamType.JSONOBJECT)
    private AutoexecJobStatusVo statusVo;

    private Long resourceId;

    private String schemaName;

    public AutoexecJobPhaseNodeVo() {
    }

    public AutoexecJobPhaseNodeVo(Long jobId, String jobPhaseName, Integer runnerId) {
        super.setJobId(jobId);
        this.jobPhaseName = jobPhaseName;
        this.runnerMapId = runnerId;
    }

    public AutoexecJobPhaseNodeVo(Long jobId, Long jobPhaseId, String host, String status, String userName) {
        super.setJobId(jobId);
        this.jobPhaseId = jobPhaseId;
        this.status = status;
        super.setUserName(userName);
        super.setHost(host);
    }

    public AutoexecJobPhaseNodeVo(JSONObject jsonObj) {
        super.setJobId(jsonObj.getLong("jobId"));
        this.jobPhaseName = jsonObj.getString("phase");
        this.id = jsonObj.getLong("nodeId");
        super.setHost(jsonObj.getString("host"));
        super.setPort(jsonObj.getInteger("port"));
        this.status = jsonObj.getString("status");
    }

    public AutoexecJobPhaseNodeVo(ResourceVo resourceVo, Long jobId, Long jobPhaseId, String status, String userName, String protocol, Integer protocolPort) {
        super.setHost(resourceVo.getIp());
        super.setNodeName(resourceVo.getName());
        super.setPort(resourceVo.getPort());
        super.setJobId(jobId);
        this.jobPhaseId = jobPhaseId;
        super.setProtocol(protocol);
        this.status = status;
        super.setUserName(userName);
        this.resourceId = resourceVo.getId();
        this.setProtocolPort(protocolPort);
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

    public Integer getRunnerMapId() {
        return runnerMapId;
    }

    public void setRunnerMapId(Integer runnerMapId) {
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

    public String getNodeType() {
        return protocol;
    }

    public void setNodeType(String nodeType) {
        this.protocol = nodeType;
    }

    public String getRunnerUrl() {
        return runnerUrl;
    }

    public void setRunnerUrl(String runnerUrl) {
        this.runnerUrl = runnerUrl;
    }

    public AutoexecRunnerVo getAutoexecRunnerVo() {
        return autoexecRunnerVo;
    }

    public void setAutoexecRunnerVo(AutoexecRunnerVo autoexecRunnerVo) {
        this.autoexecRunnerVo = autoexecRunnerVo;
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

    public Integer getRunnerId() {
        return runnerId;
    }

    public void setRunnerId(Integer runnerId) {
        this.runnerId = runnerId;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

}
