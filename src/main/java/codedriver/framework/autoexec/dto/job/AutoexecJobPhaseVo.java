/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.job;

import codedriver.framework.asynchronization.threadlocal.UserContext;
import codedriver.framework.autoexec.constvalue.JobStatus;
import codedriver.framework.autoexec.dto.combop.AutoexecCombopPhaseVo;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.common.dto.BasePageVo;
import codedriver.framework.restful.annotation.EntityField;
import codedriver.framework.util.SnowflakeUtil;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author lvzk
 * @since 2021/4/12 11:48
 **/
public class AutoexecJobPhaseVo extends BasePageVo {
    @EntityField(name = "作业剧本id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "作业id", type = ApiParamType.LONG)
    private Long jobId;
    @EntityField(name = "作业剧本状态", type = ApiParamType.STRING)
    private String status;
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
    @EntityField(name = "状态统计数量", type = ApiParamType.STRING)
    private List<AutoexecJobPhaseNodeStatusCountVo> statusCountVoList = new ArrayList<>();
    @EntityField(name = "执行顺序", type = ApiParamType.INTEGER)
    private Integer sort;
    @EntityField(name = "完成率", type = ApiParamType.INTEGER)
    private Integer completionRate;

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

    public AutoexecJobPhaseVo(AutoexecCombopPhaseVo autoexecCombopPhaseVo, Integer index, Long jobId) {
        this.uk = autoexecCombopPhaseVo.getUk();
        this.name = autoexecCombopPhaseVo.getName();
        this.execMode = autoexecCombopPhaseVo.getExecMode();
        this.status = JobStatus.PENDING.getValue();
        this.jobId = jobId;
        this.sort = index;
        this.execUser = UserContext.get().getUserUuid(true);
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
        return completionRate;
    }

    public void setCompletionRate(Integer completionRate) {
        this.completionRate = completionRate;
    }
}
