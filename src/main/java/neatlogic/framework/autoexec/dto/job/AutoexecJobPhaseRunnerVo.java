/*
 *
 * Copyright (C) 2025  TechSure Co., Ltd.  All Rights Reserved.
 * This file is part of the NeatLogic software.
 * Licensed under the NeatLogic Sustainable Use License (NSUL), Version 4.x – 2025.
 * You may use this file only in compliance with the License.
 * See the LICENSE file distributed with this work for the full license text.
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 */

package neatlogic.framework.autoexec.dto.job;

import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.dto.runner.RunnerMapVo;
import neatlogic.framework.restful.annotation.EntityField;

import java.util.Date;

/**
 * @author lvzk
 * @since 2021/6/17 11:10
 **/
public class AutoexecJobPhaseRunnerVo extends RunnerMapVo {
    @EntityField(name = "作业id", type = ApiParamType.LONG)
    private Long jobId;
    @EntityField(name = "作业组id", type = ApiParamType.LONG)
    private Long jobGroupId;
    @EntityField(name = "作业阶段id", type = ApiParamType.LONG)
    private Long jobPhaseId;
    @EntityField(name = "作业阶段runner状态", type = ApiParamType.STRING)
    private String status;
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
