/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.job;

import codedriver.framework.asynchronization.threadlocal.UserContext;
import codedriver.framework.autoexec.constvalue.JobStatus;
import codedriver.framework.autoexec.dto.combop.AutoexecCombopVo;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.common.constvalue.GroupSearch;
import codedriver.framework.common.dto.BasePageVo;
import codedriver.framework.dto.RoleVo;
import codedriver.framework.dto.TeamVo;
import codedriver.framework.dto.UserVo;
import codedriver.framework.restful.annotation.EntityField;
import codedriver.framework.util.SnowflakeUtil;
import codedriver.framework.util.TimeUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.text.ParseException;
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
    @EntityField(name = "作业状态名", type = ApiParamType.STRING)
    private String statusName;
    @EntityField(name = "作业错误信息", type = ApiParamType.STRING)
    private String error;
    @EntityField(name = "作业计划开始时间", type = ApiParamType.LONG)
    private Date planStartTime;
    @EntityField(name = "开始时间", type = ApiParamType.LONG)
    private Date startTime;
    @EntityField(name = "结束时间", type = ApiParamType.LONG)
    private Date endTime;
    @EntityField(name = "操作ID", type = ApiParamType.LONG)
    private Long operationId;
    @EntityField(name = "操作类型", type = ApiParamType.STRING)
    private String operationType;
    @EntityField(name = "执行用户", type = ApiParamType.STRING)
    private String execUser;
    @EntityField(name = "执行用户类型", type = ApiParamType.STRING)
    private String execUserType;
    @EntityField(name = "执行用户对象", type = ApiParamType.JSONOBJECT)
    private UserVo execUserVo;
    @EntityField(name = "来源", type = ApiParamType.STRING)
    private String source;
    @EntityField(name = "并发线程数", type = ApiParamType.INTEGER)
    private Integer threadCount;
    @EntityField(name = "作业其它配置", type = ApiParamType.LONG)
    private String config;
    @EntityField(name = "作业剧本集合", type = ApiParamType.JSONARRAY)
    private List<AutoexecJobPhaseVo> phaseList;
    @EntityField(name = "作业耗时", type = ApiParamType.STRING)
    private String costTime;
    @EntityField(name = "运行参数Str", type = ApiParamType.STRING)
    private String paramStr;
    @EntityField(name = "运行参数JSON", type = ApiParamType.JSONOBJECT)
    private JSONArray param;
    private String paramHash;
    @EntityField(name = "是否允许执行作业", type = ApiParamType.INTEGER)
    private Integer isCanJobExec;
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
    private List<String> typeIdList;

    public AutoexecJobVo() {
    }

    public AutoexecJobVo(AutoexecCombopVo combopVo, String operationType, String source, Integer threadCount, JSONObject paramJson) {
        this.operationId = combopVo.getId();
        this.operationType = operationType;
        this.name = combopVo.getName();
        this.status = JobStatus.PENDING.getValue();
        this.source = source;
        this.threadCount = threadCount;
        JSONArray combopParams = JSONArray.parseArray(JSONArray.toJSONString(combopVo.getRuntimeParamList()));
        JSONArray combopParamsResult = new JSONArray();
        for (Object combopParam : combopParams) {
            JSONObject combopParamJson = JSONObject.parseObject(combopParam.toString());
            String value = paramJson.getString(combopParamJson.getString("key"));
            combopParamJson.put("value", value);
            combopParamsResult.add(combopParamJson);
        }
        this.execUser = UserContext.get().getUserUuid();
        this.execUserType = GroupSearch.USER.getValue();
        this.paramStr = combopParamsResult.toJSONString();
    }


    public AutoexecJobVo(JSONObject jsonObj) throws ParseException {
        JSONObject startTimeJson = jsonObj.getJSONObject("startTime");
        Long operationId = jsonObj.getLong("combopId");
        jsonObj.remove("startTime");
        AutoexecJobVo jobVo = JSONObject.toJavaObject(jsonObj, AutoexecJobVo.class);
        this.setCombopName(jobVo.getCombopName());
        this.setTypeIdList(jobVo.getTypeIdList());
        this.setSourceList(jobVo.getSourceList());
        this.setStatusList(jobVo.getStatusList());
        this.setExecUserList(jobVo.getExecUserList());
        if (MapUtils.isNotEmpty(startTimeJson)) {
            JSONObject timeJson = TimeUtil.getStartTimeAndEndTimeByDateJson(startTimeJson);
            this.setStartTime(timeJson.getDate("startTime"));
            this.setEndTime(timeJson.getDate("endTime"));
        }
        this.setCurrentPage(jobVo.getCurrentPage());
        this.setPageSize(jobVo.getPageSize());
        this.setOperationId(operationId);
    }

    public Long getId() {
        if (id == null) {
            id = SnowflakeUtil.uniqueLong();
        }
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

    public String getStatusName() {
        if(StringUtils.isBlank(statusName) && StringUtils.isNotBlank(status)) {
            return JobStatus.getText(status);
        }
        return statusName;
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

    public String getExecUser() {
        return execUser;
    }

    public void setExecUser(String execUser) {
        this.execUser = execUser;
    }

    public String getExecUserType() {
        return execUserType;
    }

    public void setExecUserType(String execUserType) {
        this.execUserType = execUserType;
    }

    public Integer getThreadCount() {
        return threadCount;
    }

    public void setThreadCount(Integer threadCount) {
        this.threadCount = threadCount;
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

    public List<String> getTypeIdList() {
        return typeIdList;
    }

    public void setTypeIdList(List<String> typeIdList) {
        this.typeIdList = typeIdList;
    }

    public String getCombopName() {
        return combopName;
    }

    public void setCombopName(String combopName) {
        this.combopName = combopName;
    }

    public List<AutoexecJobPhaseVo> getPhaseList() {
        return phaseList;
    }

    public void setPhaseList(List<AutoexecJobPhaseVo> phaseList) {
        this.phaseList = phaseList;
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

    public Integer getIsCanJobExec() {
        return isCanJobExec;
    }

    public void setIsCanJobExec(Integer isCanJobExec) {
        this.isCanJobExec = isCanJobExec;
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

    public String getParamStr() {
        return paramStr;
    }

    public void setParamStr(String paramStr) {
        this.paramStr = paramStr;
    }

    public JSONArray getParam() {
        if (StringUtils.isNotBlank(paramStr)) {
            return JSONObject.parseArray(paramStr);
        }
        return null;
    }

    public String getParamHash() {
        if (StringUtils.isNotBlank(paramStr)) {
            paramHash = DigestUtils.md5DigestAsHex(paramStr.getBytes(StandardCharsets.UTF_8));
        }
        return paramHash;
    }

    public Object getExecUserVo() {
        if (execUserVo == null && StringUtils.isNotBlank(this.execUser)) {
            if (GroupSearch.USER.getValue().equalsIgnoreCase(execUserType)) {
                return new UserVo(execUser);
            } else if (GroupSearch.TEAM.getValue().equalsIgnoreCase(execUserType)) {
                return new TeamVo(execUser);
            } else if (GroupSearch.ROLE.getValue().equalsIgnoreCase(execUserType)) {
                return new RoleVo(execUser);
            }

        }
        return execUserVo;
    }

    public void setExecUserVo(UserVo execUserVo) {
        this.execUserVo = execUserVo;
    }
}
