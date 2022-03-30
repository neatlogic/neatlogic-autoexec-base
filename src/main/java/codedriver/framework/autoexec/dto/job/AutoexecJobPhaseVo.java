/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.job;

import codedriver.framework.asynchronization.threadlocal.UserContext;
import codedriver.framework.autoexec.constvalue.AutoexecJobPhaseExecutePolicy;
import codedriver.framework.autoexec.constvalue.JobPhaseStatus;
import codedriver.framework.autoexec.constvalue.JobStatus;
import codedriver.framework.autoexec.dto.combop.AutoexecCombopPhaseVo;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.common.dto.BaseEditorVo;
import codedriver.framework.restful.annotation.EntityField;
import codedriver.framework.util.SnowflakeUtil;
import com.alibaba.fastjson.JSONObject;
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
    @EntityField(name = "失败原因", type = ApiParamType.STRING)
    private String errorMsg;
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

    private String uuid;
    private Long combopId;
    private Integer count;

    public AutoexecJobPhaseVo() {
    }

    public AutoexecJobPhaseVo(JSONObject phaseJson, Integer index, Long jobId) {
        this.uk = phaseJson.getString("uk");
        this.name = phaseJson.getString("name");
        this.execMode = phaseJson.getString("execMode");
        this.status = JobStatus.PENDING.getValue();
        this.jobId = jobId;
        this.sort = index;
        this.execUser = UserContext.get().getUserUuid(true);
    }

    public AutoexecJobPhaseVo(AutoexecCombopPhaseVo autoexecCombopPhaseVo, Long jobId, Map<Long, AutoexecJobGroupVo> combopGroupJobMap) {
        this.uk = autoexecCombopPhaseVo.getUk();
        this.name = autoexecCombopPhaseVo.getName();
        this.execMode = autoexecCombopPhaseVo.getExecMode();
        this.status = JobStatus.PENDING.getValue();
        this.jobId = jobId;
        this.sort = autoexecCombopPhaseVo.getSort();
        this.execUser = UserContext.get().getUserUuid(true);
        this.uuid = autoexecCombopPhaseVo.getUuid();
        this.jobGroupVo = combopGroupJobMap.get(autoexecCombopPhaseVo.getGroupId());
        this.groupId = jobGroupVo.getId();
        this.executePolicy = Arrays.stream(AutoexecJobPhaseExecutePolicy.values()).map(AutoexecJobPhaseExecutePolicy::getValue).collect(Collectors.toList()).contains( autoexecCombopPhaseVo.getPolicy())?autoexecCombopPhaseVo.getPolicy():null;
    }

    public AutoexecJobPhaseVo(Long _id, String _status) {
        this.id = _id;
        this.status = _status;
    }

    public AutoexecJobPhaseVo(Long _id, String _status, String _errorMsg) {
        this.id = _id;
        this.status = _status;
        this.errorMsg = _errorMsg;
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

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
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

    public String getUk() {
        return uk;
    }

    public void setUk(String uk) {
        this.uk = uk;
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

    public AutoexecJobStatusVo getStatusVo() {
        if (statusVo == null && StringUtils.isNotBlank(status)) {
            return new AutoexecJobStatusVo(status, JobPhaseStatus.getText(status), JobPhaseStatus.getColor(status));
        }
        return statusVo;
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
}
