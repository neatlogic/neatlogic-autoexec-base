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

import neatlogic.framework.autoexec.constvalue.JobNodeStatus;
import neatlogic.framework.common.dto.BasePageVo;
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
            return new AutoexecJobStatusVo(status, JobNodeStatus.getText(status));
        }
        return statusVo;
    }
}
