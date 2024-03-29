/*Copyright (C) 2023  深圳极向量科技有限公司 All Rights Reserved.

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
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.dto.UserVo;
import neatlogic.framework.restful.annotation.EntityField;
import neatlogic.framework.util.TimeUtil;

import java.text.ParseException;
import java.util.Date;

/**
 * @author lvzk
 * @since 2021/12/08 10:58
 **/
public class AutoexecJobConsoleLogAuditVo {
    @EntityField(name = "执行开始时间", type = ApiParamType.LONG)
    private Date startTime;
    @EntityField(name = "执行结束时间", type = ApiParamType.LONG)
    private Date endTime;
    @EntityField(name = "执行用户Uuid", type = ApiParamType.STRING)
    private String execUser;
    @EntityField(name = "执行用户对象", type = ApiParamType.JSONOBJECT)
    private UserVo execUserVo;
    @EntityField(name = "记录下载链接", type = ApiParamType.STRING)
    private String downloadPath;
    @EntityField(name = "耗时", type = ApiParamType.STRING)
    private String costTime;

    public AutoexecJobConsoleLogAuditVo(JSONObject audit) throws ParseException {
        String fileName = audit.getString("fileName");
        String[] fileNames = fileName.split("\\.");
        String startTimeStr = String.format("%s-%s-%s %s:%s:%s", fileNames[0].substring(0, 4), fileNames[0].substring(4, 6), fileNames[0].substring(6, 8), fileNames[0].substring(9, 11), fileNames[0].substring(11, 13), fileNames[0].substring(13, 15));
        this.endTime = TimeUtil.convertStringToDate(audit.getString("lastModified"), TimeUtil.YYYY_MM_DD_HH_MM_SS);
        this.startTime = TimeUtil.convertStringToDate(startTimeStr, TimeUtil.YYYY_MM_DD_HH_MM_SS);
        this.execUser = fileNames[1];
        if (this.endTime != null && this.startTime != null) {
            this.costTime = TimeUtil.millisecondsTransferMaxTimeUnit(this.endTime.getTime() - this.startTime.getTime());
        }
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

    public UserVo getExecUserVo() {
        return execUserVo;
    }

    public void setExecUserVo(UserVo execUserVo) {
        this.execUserVo = execUserVo;
    }

    public String getExecUser() {
        return execUser;
    }

    public void setExecUser(String execUser) {
        this.execUser = execUser;
    }

    public String getDownloadPath() {
        return downloadPath;
    }

    public void setDownloadPath(String downloadPath) {
        this.downloadPath = downloadPath;
    }

    public String getCostTime() {
        return costTime;
    }
}
