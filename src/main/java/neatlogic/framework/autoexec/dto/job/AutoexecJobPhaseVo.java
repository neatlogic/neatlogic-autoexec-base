/*
Copyright(c) 2023 NeatLogic Co., Ltd. All Rights Reserved.

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

import neatlogic.framework.asynchronization.threadlocal.UserContext;
import neatlogic.framework.autoexec.constvalue.AutoexecJobPhaseExecutePolicy;
import neatlogic.framework.autoexec.constvalue.JobPhaseStatus;
import neatlogic.framework.autoexec.constvalue.JobStatus;
import neatlogic.framework.autoexec.dto.combop.AutoexecCombopPhaseVo;
import neatlogic.framework.autoexec.exception.AutoexecCombopPhaseGroupIdIsNullException;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.common.dto.BaseEditorVo;
import neatlogic.framework.restful.annotation.EntityField;
import neatlogic.framework.util.SnowflakeUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author lvzk
 * @since 2021/4/12 11:48
 **/
public class AutoexecJobPhaseVo extends BaseEditorVo implements Serializable {
    private static final long serialVersionUID = 7462993286745015121L;
    @EntityField(name = "作业剧本id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "作业id", type = ApiParamType.LONG)
    private Long jobId;
    @EntityField(name = "作业剧本状态", type = ApiParamType.STRING)
    private String status;
    @EntityField(name = "作业状态Vo", type = ApiParamType.JSONOBJECT)
    private AutoexecJobStatusVo statusVo;
    @EntityField(name = "作业剧本开始时间", type = ApiParamType.STRING)
    private Date startTime;
    @EntityField(name = "作业剧本结束时间", type = ApiParamType.STRING)
    private Date endTime;
    @EntityField(name = "作业剧本执行用户", type = ApiParamType.STRING)
    private String execUser;
    @EntityField(name = "作业剧本执行方式", type = ApiParamType.STRING)
    private String execMode;
    @EntityField(name = "作业剧本操作集合", type = ApiParamType.JSONARRAY)
    private List<AutoexecJobPhaseOperationVo> operationList;
    @EntityField(name = "作业剧本名", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "作业剧本唯一标识", type = ApiParamType.STRING)
    private String uk;
    @EntityField(name = "状态统计数量", type = ApiParamType.JSONARRAY)
    private List<AutoexecJobPhaseNodeStatusCountVo> statusCountVoList = new ArrayList<>();
    @EntityField(name = "执行顺序", type = ApiParamType.INTEGER)
    private Integer sort;
    @EntityField(name = "完成率", type = ApiParamType.INTEGER)
    private Integer completionRate = 0;
    @EntityField(name = "最近一次节点变动时间", type = ApiParamType.STRING)
    private Date lncd;
    @EntityField(name = "组id", type = ApiParamType.LONG)
    private Long groupId;
    @EntityField(name = "组vo", type = ApiParamType.JSONOBJECT)
    private AutoexecJobGroupVo jobGroupVo;
    @EntityField(name = "执行策略", type = ApiParamType.STRING)
    private String executePolicy;
    @EntityField(name = "是否当前步骤", type = ApiParamType.INTEGER)
    private Integer isActive;
    @EntityField(name = "当前阶段是否存在根据出参更新其他阶段执行节点", type = ApiParamType.INTEGER)
    private Integer isPreOutputUpdateNode = 0;
    @EntityField(name = "告警数量", type = ApiParamType.INTEGER)
    private Integer warnCount = 0;
    @EntityField(name = "分批数", type = ApiParamType.INTEGER)
    private Integer roundCount;
    @EntityField(name = "执行目标配置来源", type = ApiParamType.STRING)
    private String nodeFrom;
    @EntityField(name = "执行用户来源", type = ApiParamType.STRING)
    private String userNameFrom;//node 协议来源 job|group|phase
    @EntityField(name = "执行协议来源", type = ApiParamType.STRING)
    private String protocolFrom;//node 协议来源 job|group|phase

    @JSONField(serialize = false)
    private AutoexecJobNodeVo currentNode;
    @JSONField(serialize = false)
    private String uuid;
    @JSONField(serialize = false)
    private Long combopId;
    @JSONField(serialize = false)
    private Integer count;

    public AutoexecJobPhaseVo() {
    }

    public AutoexecJobPhaseVo(JSONObject phaseJson, Integer index, Long jobId) {
        this.name = phaseJson.getString("name");
        this.execMode = phaseJson.getString("execMode");
        this.status = JobStatus.PENDING.getValue();
        this.jobId = jobId;
        this.sort = index;
        this.execUser = UserContext.get().getUserUuid(true);
    }

    public AutoexecJobPhaseVo(AutoexecCombopPhaseVo autoexecCombopPhaseVo, Long jobId, Map<Long, AutoexecJobGroupVo> combopGroupJobMap) {
        this.name = autoexecCombopPhaseVo.getName();
        this.execMode = autoexecCombopPhaseVo.getExecMode();
        this.status = JobStatus.PENDING.getValue();
        this.jobId = jobId;
        this.sort = autoexecCombopPhaseVo.getSort();
        this.execUser = UserContext.get().getUserUuid(true);
        this.uuid = autoexecCombopPhaseVo.getUuid();
        if (autoexecCombopPhaseVo.getGroupId() == null) {
            throw new AutoexecCombopPhaseGroupIdIsNullException(autoexecCombopPhaseVo.getName());
        }
        this.jobGroupVo = combopGroupJobMap.get(autoexecCombopPhaseVo.getGroupId());
        this.groupId = jobGroupVo.getId();
        this.executePolicy = Arrays.stream(AutoexecJobPhaseExecutePolicy.values()).map(AutoexecJobPhaseExecutePolicy::getValue).collect(Collectors.toList()).contains(autoexecCombopPhaseVo.getPolicy()) ? autoexecCombopPhaseVo.getPolicy() : null;
        if (autoexecCombopPhaseVo.getConfig() != null && autoexecCombopPhaseVo.getConfig().getExecuteConfig() != null) {
            this.roundCount = autoexecCombopPhaseVo.getConfig().getExecuteConfig().getRoundCount();
        }
    }

    public AutoexecJobPhaseVo(Long _id, String _status, Integer _warnCount) {
        this.id = _id;
        this.status = _status;
        this.warnCount = _warnCount;
    }

    public AutoexecJobPhaseVo(Long _id, String _status) {
        this.id = _id;
        this.status = _status;
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

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getExecUser() {
        return execUser;
    }

    public void setExecUser(String execUser) {
        this.execUser = execUser;
    }

    public String getExecMode() {
        return execMode;
    }

    public void setExecMode(String execMode) {
        this.execMode = execMode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AutoexecJobPhaseNodeStatusCountVo> getStatusCountVoList() {
        return statusCountVoList;
    }

    public void setStatusCountVoList(List<AutoexecJobPhaseNodeStatusCountVo> statusCountVoList) {
        this.statusCountVoList = statusCountVoList;
    }

    public void addStatusCountVo(AutoexecJobPhaseNodeStatusCountVo statusCountVo) {
        this.statusCountVoList.add(statusCountVo);
    }

    public List<AutoexecJobPhaseOperationVo> getOperationList() {
        return operationList;
    }

    public void setOperationList(List<AutoexecJobPhaseOperationVo> operationList) {
        this.operationList = operationList;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getCompletionRate() {
        if (StringUtils.isNotBlank(status) && Objects.equals(JobStatus.COMPLETED.getValue(), status)) {
            return 100;
        }
        return completionRate;
    }

    public void setCompletionRate(Integer completionRate) {
        this.completionRate = completionRate;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Long getCombopId() {
        return combopId;
    }

    public void setCombopId(Long combopId) {
        this.combopId = combopId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getLncd() {
        return lncd;
    }

    public void setLncd(Date lncd) {
        this.lncd = lncd;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public AutoexecJobGroupVo getJobGroupVo() {
        return jobGroupVo;
    }

    public void setJobGroupVo(AutoexecJobGroupVo jobGroupVo) {
        this.jobGroupVo = jobGroupVo;
    }

    public String getExecutePolicy() {
        return executePolicy;
    }

    public void setExecutePolicy(String executePolicy) {
        this.executePolicy = executePolicy;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public Integer getWarnCount() {
        return warnCount;
    }

    public void setWarnCount(Integer warnCount) {
        this.warnCount = warnCount;
    }

    public AutoexecJobNodeVo getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(AutoexecJobNodeVo currentNode) {
        this.currentNode = currentNode;
    }

    public Integer getIsPreOutputUpdateNode() {
        return isPreOutputUpdateNode;
    }

    public void setIsPreOutputUpdateNode(Integer isPreOutputUpdateNode) {
        this.isPreOutputUpdateNode = isPreOutputUpdateNode;
    }

    public Integer getRoundCount() {
        return roundCount;
    }

    public void setRoundCount(Integer roundCount) {
        this.roundCount = roundCount;
    }

    public AutoexecJobStatusVo getStatusVo() {
        if (statusVo == null && StringUtils.isNotBlank(status)) {
            return new AutoexecJobStatusVo(status, JobPhaseStatus.getText(status));
        }
        return statusVo;
    }

    public String getNodeFrom() {
        return nodeFrom;
    }

    public void setNodeFrom(String nodeFrom) {
        this.nodeFrom = nodeFrom;
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
}
