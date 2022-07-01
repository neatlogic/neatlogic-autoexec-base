/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.job;

import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;

import java.util.Date;

/**
 * @author lvzk
 * @since 2021/6/17 11:10
 **/
public class AutoexecJobPhaseRunnerVo {
    @EntityField(name = "作业id", type = ApiParamType.LONG)
    private Long jobId;
    @EntityField(name = "作业组id", type = ApiParamType.LONG)
    private Long jobGroupId;
    @EntityField(name = "作业阶段id", type = ApiParamType.LONG)
    private Long jobPhaseId;
    @EntityField(name = "作业阶段runner状态", type = ApiParamType.STRING)
    private String status;
    @EntityField(name = "作业阶段runner 映射id", type = ApiParamType.LONG)
    private Long runnerMapId;
    @EntityField(name = "是否已经fireNext", type = ApiParamType.INTEGER)
    private Integer isFireNext;
    @EntityField(name = "最近一次更新时间", type = ApiParamType.STRING)
    private Date lcd;
    @EntityField(name = "告警数量", type = ApiParamType.INTEGER)
    private Integer warnCount = 0;

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Long getJobGroupId() {
        return jobGroupId;
    }

    public void setJobGroupId(Long jobGroupId) {
        this.jobGroupId = jobGroupId;
    }

    public Long getJobPhaseId() {
        return jobPhaseId;
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

    public Integer getIsFireNext() {
        return isFireNext;
    }

    public void setIsFireNext(Integer isFireNext) {
        this.isFireNext = isFireNext;
    }

    public Date getLcd() {
        return lcd;
    }

    public void setLcd(Date lcd) {
        this.lcd = lcd;
    }

    public Integer getWarnCount() {
        return warnCount;
    }

    public void setWarnCount(Integer warnCount) {
        this.warnCount = warnCount;
    }
}