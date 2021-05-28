/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.job;

import codedriver.framework.autoexec.constvalue.JobNodeStatus;
import codedriver.framework.dto.UserVo;
import codedriver.framework.util.TimeUtil;
import com.alibaba.fastjson.JSONObject;

import java.text.ParseException;
import java.util.Date;

/**
 * @author lvzk
 * @since 2021/5/28 14:58
 **/
public class AutoexecJobPhaseNodeAuditVo {
    private Date startTime;
    private Date endTime;
    private String execUser;
    private UserVo execUserVo;
    private String status;
    private String downloadPath;

    public AutoexecJobPhaseNodeAuditVo(JSONObject audit) throws ParseException {
        String fileName = audit.getString("fileName");
        String[] fileNames = fileName.split("\\.");
        String startTimeStr = String.format("%s-%s-%s %s:%s:%s",fileNames[0].substring(0,4),fileNames[0].substring(4,6),fileNames[0].substring(6,8),fileNames[0].substring(7,9),fileNames[0].substring(9,11),fileNames[0].substring(11,13));
        this.endTime = TimeUtil.convertStringToDate(audit.getString("lastModified"),TimeUtil.YYYY_MM_DD_HH_MM_SS);
        this.startTime = TimeUtil.convertStringToDate(startTimeStr,TimeUtil.YYYY_MM_DD_HH_MM_SS);
        this.execUser = fileNames[1];
        //TODO status
        this.status = JobNodeStatus.SUCCEED.getValue();
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDownloadPath() {
        return downloadPath;
    }

    public void setDownloadPath(String downloadPath) {
        this.downloadPath = downloadPath;
    }
}
