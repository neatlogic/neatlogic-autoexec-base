/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.job;

import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.common.dto.BasePageVo;
import codedriver.framework.restful.annotation.EntityField;

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
    @EntityField(name = "作业状态", type = ApiParamType.STRING)
    private String status;
    @EntityField(name = "作业剧本开始时间", type = ApiParamType.STRING)
    private Date startTime;
    @EntityField(name = "作业剧本结束时间", type = ApiParamType.STRING)
    private Date endTime;
    @EntityField(name = "作业剧本执行用户", type = ApiParamType.STRING)
    private String execUser;
    @EntityField(name = "作业剧本执行方式", type = ApiParamType.STRING)
    private String execMode;
    @EntityField(name = "作业剧本操作集合", type = ApiParamType.JSONARRAY)
    private List<AutoexecJobPhaseOperationVo> jobPhaseOperationVoList;
    @EntityField(name = "作业剧本名", type = ApiParamType.STRING)
    private String combopPhaseName;
    @EntityField(name = "作业剧本唯一标识", type = ApiParamType.STRING)
    private String combopPhaseUk;
    @EntityField(name = "状态统计数量", type = ApiParamType.STRING)
    private List<AutoexecJobPhaseNodeStatusCountVo> statusCountVoList = new ArrayList<>();

    public Long getId() {
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

    public List<AutoexecJobPhaseOperationVo> getJobPhaseOperationVoList() {
        return jobPhaseOperationVoList;
    }

    public void setJobPhaseOperationVoList(List<AutoexecJobPhaseOperationVo> jobPhaseOperationVoList) {
        this.jobPhaseOperationVoList = jobPhaseOperationVoList;
    }

    public String getCombopPhaseName() {
        return combopPhaseName;
    }

    public void setCombopPhaseName(String combopPhaseName) {
        this.combopPhaseName = combopPhaseName;
    }

    public String getCombopPhaseUk() {
        return combopPhaseUk;
    }

    public void setCombopPhaseUk(String combopPhaseUk) {
        this.combopPhaseUk = combopPhaseUk;
    }

    public List<AutoexecJobPhaseNodeStatusCountVo> getStatusCountVoList() {
        return statusCountVoList;
    }

    public void setStatusCountVoList(List<AutoexecJobPhaseNodeStatusCountVo> statusCountVoList) {
        this.statusCountVoList = statusCountVoList;
    }

    public void addStatusCountVo(AutoexecJobPhaseNodeStatusCountVo statusCountVo){
        this.statusCountVoList.add(statusCountVo);
    }
}
