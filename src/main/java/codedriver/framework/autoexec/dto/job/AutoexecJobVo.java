/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.job;

import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.common.dto.BasePageVo;
import codedriver.framework.restful.annotation.EntityField;
import codedriver.framework.util.TimeUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.collections4.MapUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author lvzk
 * @since 2021/4/12 11:48
 **/
public class AutoexecJobVo extends BasePageVo {
    @EntityField(name = "作业id(如果是人工发起则id正常生成，其它情况存放来源id)", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "作业名称（唯一标识）", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "作业状态", type = ApiParamType.STRING)
    private String status;
    @EntityField(name = "作业错误信息", type = ApiParamType.STRING)
    private String error;
    @EntityField(name = "作业计划开始时间", type = ApiParamType.STRING)
    private Date planStartTime;
    @EntityField(name = "开始时间", type = ApiParamType.STRING)
    private Date startTime;
    @EntityField(name = "结束时间", type = ApiParamType.STRING)
    private Date endTime;
    @EntityField(name = "操作ID", type = ApiParamType.LONG)
    private Long operationId;
    @EntityField(name = "操作类型", type = ApiParamType.STRING)
    private String operationType;
    @EntityField(name = "执行用户", type = ApiParamType.STRING)
    private String exec_user;
    @EntityField(name = "来源", type = ApiParamType.STRING)
    private String source;
    @EntityField(name = "并发线程数", type = ApiParamType.INTEGER)
    private Integer thread_count;
    @EntityField(name = "作业其它配置", type = ApiParamType.LONG)
    private String config;
    @EntityField(name = "作业剧本集合", type = ApiParamType.JSONARRAY)
    private List<AutoexecJobPhaseVo> jobPhaseVoList;
    @EntityField(name = "作业耗时", type = ApiParamType.STRING)
    private String costTime;
    @EntityField(name = "是否允许暂停作业", type = ApiParamType.INTEGER)
    private Integer isCanJobPause;
    @EntityField(name = "是否允许停止作业", type = ApiParamType.INTEGER)
    private Integer isCanJobStop;
    @EntityField(name = "是否允许继续作业", type = ApiParamType.INTEGER)
    private Integer isCanJobGoon;
    @EntityField(name = "是否允许重跑作业", type = ApiParamType.INTEGER)
    private Integer isCanJobRedo;
    @EntityField(name = "是否允许重置节点", type = ApiParamType.INTEGER)
    private Integer isCanJobNodeReset;
    @EntityField(name = "是否允许忽略节点", type = ApiParamType.INTEGER)
    private Integer isCanJobNodeIgnore;

    //param
    @JSONField(serialize = false)
    private String combopName;
    @JSONField(serialize = false)
    private List<String> statusList;
    @JSONField(serialize = false)
    private List<String> sourceList;
    @JSONField(serialize = false)
    private List<String> execUserList;
    @JSONField(serialize = false)
    private List<String> combopOperationTypeList;

    public AutoexecJobVo() {
    }

    public AutoexecJobVo(JSONObject jsonObj) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        JSONObject startTimeJson = jsonObj.getJSONObject("startTime");
        jsonObj.remove("startTime");
        AutoexecJobVo jobVo = JSONObject.toJavaObject(jsonObj, AutoexecJobVo.class);
        this.setCombopName(jobVo.getCombopName());
        this.setCombopOperationTypeList(jobVo.getCombopOperationTypeList());
        this.setSourceList(jobVo.getSourceList());
        this.setStatusList(jobVo.getStatusList());
        if (MapUtils.isNotEmpty(startTimeJson)) {
            JSONObject timeJson = TimeUtil.getStartTimeAndEndTimeByDateJson(startTimeJson);
            this.setStartTime(TimeUtil.convertStringToDate(timeJson.getString("startTime"), TimeUtil.YYYY_MM_DD_HH_MM_SS));
            this.setEndTime(TimeUtil.convertStringToDate(timeJson.getString("endTime"), TimeUtil.YYYY_MM_DD_HH_MM_SS));
        }
        this.setCurrentPage(jobVo.getCurrentPage());
        this.setPageSize(jobVo.getPageSize());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Date getPlanStartTime() {
        return planStartTime;
    }

    public void setPlanStartTime(Date planStartTime) {
        this.planStartTime = planStartTime;
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

    public Long getOperationId() {
        return operationId;
    }

    public void setOperationId(Long operationId) {
        this.operationId = operationId;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getExec_user() {
        return exec_user;
    }

    public void setExec_user(String exec_user) {
        this.exec_user = exec_user;
    }

    public Integer getThread_count() {
        return thread_count;
    }

    public void setThread_count(Integer thread_count) {
        this.thread_count = thread_count;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public List<String> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<String> statusList) {
        this.statusList = statusList;
    }

    public List<String> getSourceList() {
        return sourceList;
    }

    public void setSourceList(List<String> sourceList) {
        this.sourceList = sourceList;
    }

    public List<String> getExecUserList() {
        return execUserList;
    }

    public void setExecUserList(List<String> execUserList) {
        this.execUserList = execUserList;
    }

    public List<String> getCombopOperationTypeList() {
        return combopOperationTypeList;
    }

    public void setCombopOperationTypeList(List<String> combopOperationTypeList) {
        this.combopOperationTypeList = combopOperationTypeList;
    }

    public String getCombopName() {
        return combopName;
    }

    public void setCombopName(String combopName) {
        this.combopName = combopName;
    }

    public List<AutoexecJobPhaseVo> getJobPhaseVoList() {
        return jobPhaseVoList;
    }

    public void setJobPhaseVoList(List<AutoexecJobPhaseVo> jobPhaseVoList) {
        this.jobPhaseVoList = jobPhaseVoList;
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

    public void setCostTime(String costTime) {
        this.costTime = costTime;
    }

    public Integer getIsCanJobPause() {
        return isCanJobPause;
    }

    public void setIsCanJobPause(Integer isCanJobPause) {
        this.isCanJobPause = isCanJobPause;
    }

    public Integer getIsCanJobStop() {
        return isCanJobStop;
    }

    public void setIsCanJobStop(Integer isCanJobStop) {
        this.isCanJobStop = isCanJobStop;
    }

    public Integer getIsCanJobGoon() {
        return isCanJobGoon;
    }

    public void setIsCanJobGoon(Integer isCanJobGoon) {
        this.isCanJobGoon = isCanJobGoon;
    }

    public Integer getIsCanJobRedo() {
        return isCanJobRedo;
    }

    public void setIsCanJobRedo(Integer isCanJobRedo) {
        this.isCanJobRedo = isCanJobRedo;
    }

    public Integer getIsCanJobNodeReset() {
        return isCanJobNodeReset;
    }

    public void setIsCanJobNodeReset(Integer isCanJobNodeReset) {
        this.isCanJobNodeReset = isCanJobNodeReset;
    }

    public Integer getIsCanJobNodeIgnore() {
        return isCanJobNodeIgnore;
    }

    public void setIsCanJobNodeIgnore(Integer isCanJobNodeIgnore) {
        this.isCanJobNodeIgnore = isCanJobNodeIgnore;
    }
}
