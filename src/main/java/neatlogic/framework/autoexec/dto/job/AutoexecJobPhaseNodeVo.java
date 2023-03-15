/*
Copyright(c) $today.year NeatLogic Co., Ltd. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package neatlogic.framework.autoexec.dto.job;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import neatlogic.framework.autoexec.constvalue.JobNodeStatus;
import neatlogic.framework.autoexec.dto.INodeDetail;
import neatlogic.framework.autoexec.dto.combop.AutoexecCombopParamVo;
import neatlogic.framework.cmdb.dto.resourcecenter.ResourceVo;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.dto.runner.RunnerVo;
import neatlogic.framework.restful.annotation.EntityField;
import neatlogic.framework.util.SnowflakeUtil;
import neatlogic.framework.util.TimeUtil;
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
public class AutoexecJobPhaseNodeVo extends AutoexecJobNodeVo implements INodeDetail, Serializable {
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
    @EntityField(name = "作业剧本节点状态名", type = ApiParamType.STRING)
    private String statusName;
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
    @EntityField(name = "作业节点工具状态Vo列表", type = ApiParamType.JSONOBJECT)
    private List<AutoexecJobPhaseNodeOperationStatusVo> operationStatusVoList;
    @EntityField(name = "作业节点等待输入渲染jsonStr", type = ApiParamType.JSONOBJECT)
    private String interactStr;
    @EntityField(name = "是否已删除", type = ApiParamType.INTEGER)
    private Integer isDelete;
    private Long resourceId;
    @EntityField(name = "执行目标配置来源", type = ApiParamType.STRING)
    private String nodeFrom;
    @EntityField(name = "执行用户来源", type = ApiParamType.STRING)
    private String userNameFrom;//node 协议来源 job|group|phase
    @EntityField(name = "执行协议来源", type = ApiParamType.STRING)
    private String protocolFrom;//node 协议来源 job|group|phase
    @JSONField(serialize = false)
    private Integer groupSort;//组排序用于节点过滤
    @JSONField(serialize = false)
    private List<Long> nodeIdList;
    @EntityField(name = "告警数量", type = ApiParamType.INTEGER)
    private Integer warnCount = 0;
    @EntityField(name = "sql名", type = ApiParamType.STRING)
    private String sqlFile;
    @JSONField(serialize = false)
    private Integer isExecuted;//是否执行过，用于标识执行过的节点不能删除
    @JSONField(serialize = false)
    private Integer isDownloadGroup;//是否下载组节点，用于下载节点接口

    public AutoexecJobPhaseNodeVo() {
    }

    public AutoexecJobPhaseNodeVo(Long jobId, Long jobPhaseId) {
        this.setJobId(jobId);
        this.jobPhaseId = jobPhaseId;
    }

    public AutoexecJobPhaseNodeVo(String host,Integer port , Long resourceId){
        this.setHost(host);
        this.setPort(port);
        this.setResourceId(resourceId);
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
        this.setResourceId(resourceVo.getId());
        this.setHost(resourceVo.getIp());
        this.setNodeName(resourceVo.getName());
        this.setPort(resourceVo.getPort());
        this.setJobId(jobId);
        this.jobPhaseId = jobPhaseVo.getId();
        this.jobGroupId = jobPhaseVo.getGroupId();
        this.setProtocolId(protocolId);
        this.status = status;
        this.setUserName(userName);
        this.resourceId = resourceVo.getId();
        this.setNodeType(resourceVo.getTypeName());
        this.setLcd(jobPhaseVo.getLcd());
    }

    public AutoexecJobPhaseNodeVo(AutoexecCombopParamVo paramVo) {

    }

    public AutoexecJobPhaseNodeVo(Long jobId, String phaseName, String host, Integer port, Long resourceId, String runnerUrl, Long runnerMapId) {
        this.setJobId(jobId);
        this.jobPhaseName = phaseName;
        this.setHost(host);
        this.setPort(port);
        this.resourceId = resourceId;
        this.runnerMapId = runnerMapId;
        this.runnerUrl = runnerUrl;
    }

    public AutoexecJobPhaseNodeVo(Long jobPhaseId, int isDelete) {
        this.jobPhaseId = jobPhaseId;
        this.isDelete = isDelete;
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

    public String getStatusName() {
        if (StringUtils.isBlank(statusName) && StringUtils.isNotBlank(status)) {
            statusName = JobNodeStatus.getText(status);
        }
        return statusName;
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

    public String getNodeFrom() {
        return nodeFrom;
    }

    public void setNodeFrom(String nodeFrom) {
        this.nodeFrom = nodeFrom;
    }

    public Integer getGroupSort() {
        return groupSort;
    }

    public void setGroupSort(Integer groupSort) {
        this.groupSort = groupSort;
    }

    public List<Long> getNodeIdList() {
        return nodeIdList;
    }

    public void setNodeIdList(List<Long> nodeIdList) {
        this.nodeIdList = nodeIdList;
    }

    public Integer getWarnCount() {
        return warnCount;
    }

    public void setWarnCount(Integer warnCount) {
        this.warnCount = warnCount;
    }

    public String getSqlFile() {
        return sqlFile;
    }

    public void setSqlFile(String sqlFile) {
        this.sqlFile = sqlFile;
    }

    public Integer getIsExecuted() {
        return isExecuted;
    }

    public void setIsExecuted(Integer isExecuted) {
        this.isExecuted = isExecuted;
    }

    public String getUserNameFrom() {
        return userNameFrom;
    }

    public void setUserNameFrom(String userNameFrom) {
        this.userNameFrom = userNameFrom;
    }

    public String getProtocolFrom() {
        return protocolFrom;
    }

    public void setProtocolFrom(String protocolFrom) {
        this.protocolFrom = protocolFrom;
    }

    public Integer getIsDownloadGroup() {
        return isDownloadGroup;
    }

    public void setIsDownloadGroup(Integer isDownloadGroup) {
        this.isDownloadGroup = isDownloadGroup;
    }

}
