/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.job;

import codedriver.framework.autoexec.constvalue.JobNodeStatus;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;
import codedriver.framework.util.TimeUtil;
import com.alibaba.fastjson.JSONObject;
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

    public AutoexecJobNodeSqlVo(JSONObject statusJson) {
        this.interact = statusJson.getJSONObject("statusJson");
        this.status = statusJson.getString("status");
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
