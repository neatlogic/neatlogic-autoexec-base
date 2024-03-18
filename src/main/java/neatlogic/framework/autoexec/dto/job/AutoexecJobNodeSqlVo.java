/*Copyright (C) $today.year  深圳极向量科技有限公司 All Rights Reserved.

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.*/

package neatlogic.framework.autoexec.dto.job;

import com.alibaba.fastjson.JSONObject;
import neatlogic.framework.autoexec.constvalue.JobNodeStatus;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;
import neatlogic.framework.util.TimeUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * @author lvzk
 * @since 2021/8/4 15:14
 **/
public class AutoexecJobNodeSqlVo {
    @EntityField(name = "暂停输入初始化数据", type = ApiParamType.JSONOBJECT)
    private JSONObject interact;
    @EntityField(name = "sql执行状态", type = ApiParamType.STRING)
    private String status;
    @EntityField(name = "sql执行状态名", type = ApiParamType.STRING)
    private String statusName;
    @EntityField(name = "执行开始时间", type = ApiParamType.LONG)
    private Date startTime;
    @EntityField(name = "执行结束时间", type = ApiParamType.LONG)
    private Date endTime;
    @EntityField(name = "作业耗时", type = ApiParamType.STRING)
    private String costTime;
    @EntityField(name = "作业执行sql名", type = ApiParamType.STRING)
    private String sqlName;
    private Integer isModified;
    private String md5;

    public AutoexecJobNodeSqlVo() {
    }

    public JSONObject getInteract() {
        return interact;
    }

    public void setInteract(JSONObject interact) {
        this.interact = interact;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusName() {
        if(StringUtils.isNotBlank(status)){
            return JobNodeStatus.getText(status);
        }
        return statusName;
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

    public Integer getIsModified() {
        return isModified;
    }

    public void setIsModified(Integer isModified) {
        this.isModified = isModified;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getCostTime() {
        if (startTime != null) {
            if (endTime != null) {
                return TimeUtil.millisecondsTransferMaxTimeUnit(endTime.getTime() - startTime.getTime());
            } else {
                return TimeUtil.millisecondsTransferMaxTimeUnit(new Date().getTime() - startTime.getTime());
            }
        }
        return costTime;
    }

    public String getSqlName() {
        return sqlName;
    }

    public void setSqlName(String sqlName) {
        this.sqlName = sqlName;
    }
}
