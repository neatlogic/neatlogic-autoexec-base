/*
 * Copyright (C) 2025  深圳极向量科技有限公司 All Rights Reserved.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package neatlogic.framework.autoexec.dto.job;

import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;

import java.util.Date;

public class AutoexecJobExecVo {
    @EntityField(name = "作业id", type = ApiParamType.LONG)
    private Long jobId;
    @EntityField(name = "作业执行器id", type = ApiParamType.LONG)
    private Long runnerMapId;
    @EntityField(name = "作业执行id", type = ApiParamType.LONG)
    private Long execId;
    @EntityField(name = "作业执行动作", type = ApiParamType.STRING)
    private String action;
    @EntityField(name = "作业执行时间", type = ApiParamType.LONG)
    private Date fcd;

    public AutoexecJobExecVo(Long jobId, Long runnerMapId, Long execid, String action) {
        this.jobId = jobId;
        this.runnerMapId = runnerMapId;
        this.execId = execid;
        this.action = action;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Long getRunnerMapId() {
        return runnerMapId;
    }

    public void setRunnerMapId(Long runnerMapId) {
        this.runnerMapId = runnerMapId;
    }

    public Long getExecId() {
        return execId;
    }

    public void setExecId(Long execId) {
        this.execId = execId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Date getFcd() {
        return fcd;
    }

    public void setFcd(Date fcd) {
        this.fcd = fcd;
    }
}
