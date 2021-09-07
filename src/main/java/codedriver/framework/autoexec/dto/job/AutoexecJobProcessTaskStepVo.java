/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.job;

import java.util.Date;

/**
 * @author linbq
 * @since 2021/9/7 14:14
 **/
public class AutoexecJobProcessTaskStepVo {
    private Long processTaskId;
    private Long processTaskStepId;
    private Long autoexecJobId;
    private Integer needMonitorStatus;

    public Long getProcessTaskId() {
        return processTaskId;
    }

    public void setProcessTaskId(Long processTaskId) {
        this.processTaskId = processTaskId;
    }

    public Long getProcessTaskStepId() {
        return processTaskStepId;
    }

    public void setProcessTaskStepId(Long processTaskStepId) {
        this.processTaskStepId = processTaskStepId;
    }

    public Long getAutoexecJobId() {
        return autoexecJobId;
    }

    public void setAutoexecJobId(Long autoexecJobId) {
        this.autoexecJobId = autoexecJobId;
    }

    public Integer getNeedMonitorStatus() {
        return needMonitorStatus;
    }

    public void setNeedMonitorStatus(Integer needMonitorStatus) {
        this.needMonitorStatus = needMonitorStatus;
    }
}
