/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.job;

import codedriver.framework.autoexec.constvalue.JobNodeStatus;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.dto.UserVo;
import codedriver.framework.restful.annotation.EntityField;
import codedriver.framework.util.TimeUtil;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.util.Date;

/**
 * @author lvzk
 * @since 2021/5/28 14:58
 **/
public class AutoexecJobPhaseNodeAuditVo {
    @EntityField(name = "执行开始时间", type = ApiParamType.LONG)
    private Date startTime;
    @EntityField(name = "执行结束时间", type = ApiParamType.LONG)
    private Date endTime;
    @EntityField(name = "执行用户Uuid", type = ApiParamType.STRING)
    private String execUser;
    @EntityField(name = "执行用户对象", type = ApiParamType.JSONOBJECT)
    private UserVo execUserVo;
    @EntityField(name = "执行状态", type = ApiParamType.STRING)
    private String status;
    @EntityField(name = "执行状态名", type = ApiParamType.STRING)
    private String statusName;
    @EntityField(name = "记录下载链接", type = ApiParamType.STRING)
    private String downloadPath;
    @EntityField(name = "执行状态名", type = ApiParamType.LONG)
    private Long costTime;

    public AutoexecJobPhaseNodeAuditVo(JSONObject audit) throws ParseException {
        String fileName = audit.getString("fileName");
        String[] fileNames = fileName.split("\\.");
        String startTimeStr = String.format("%s-%s-%s %s:%s:%s",fileNames[0].substring(0,4),fileNames[0].substring(4,6),fileNames[0].substring(6,8),fileNames[0].substring(9,11),fileNames[0].substring(11,13),fileNames[0].substring(13,15));
        this.endTime = TimeUtil.convertStringToDate(audit.getString("lastModified"),TimeUtil.YYYY_MM_DD_HH_MM_SS);
        this.startTime = TimeUtil.convertStringToDate(startTimeStr,TimeUtil.YYYY_MM_DD_HH_MM_SS);
        this.execUser = fileNames[1];
        //TODO status
        this.status = JobNodeStatus.SUCCEED.getValue();
        if(this.endTime != null && this.startTime != null) {
            this.costTime = this.endTime.getTime() - this.startTime.getTime();
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

    public Long getCostTime() {
        return costTime;
    }

    public String getStatusName() {
        if(StringUtils.isBlank(statusName)&&StringUtils.isNotBlank(status)){
            statusName = JobNodeStatus.getText(status);
        }
        return statusName;
    }
}