/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.job;

import codedriver.framework.autoexec.constvalue.JobNodeStatus;
import codedriver.framework.common.dto.BasePageVo;
import org.apache.commons.lang3.StringUtils;

/**
 * @author lvzk
 * @since 2021/4/12 16:12
 **/
public class AutoexecJobPhaseNodeStatusCountVo extends BasePageVo {
    private Long jobPhaseId;
    private String status;
    private AutoexecJobStatusVo statusVo;
    private Integer count;
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public AutoexecJobStatusVo getStatusVo() {
        if (statusVo == null && StringUtils.isNotBlank(status)) {
            return new AutoexecJobStatusVo(status, JobNodeStatus.getText(status), JobNodeStatus.getColor(status));
        }
        return statusVo;
    }
}
