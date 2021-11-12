/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.job;

import codedriver.framework.asynchronization.threadlocal.UserContext;
import codedriver.framework.autoexec.constvalue.JobSource;
import codedriver.framework.autoexec.constvalue.JobStatus;
import codedriver.framework.autoexec.dto.combop.AutoexecCombopVo;
import codedriver.framework.autoexec.dto.script.AutoexecScriptVersionVo;
import codedriver.framework.autoexec.source.AutoexecJobSourceFactory;
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
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author lvzk
 * @since 2021/4/12 11:48
 **/
public class AutoexecJobVo extends BasePageVo implements Serializable {
    private static final long serialVersionUID = -1382188874082154509L;
    @EntityField(name = "作业id(如果是人工发起则id正常生成，其它情况存放来源id)", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "作业名称（唯一标识）", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "作业状态", type = ApiParamType.STRING)
    private String status;
    @EntityField(name = "作业状态Vo", type = ApiParamType.JSONOBJECT)
    private AutoexecJobStatusVo statusVo;
    @EntityField(name = "作业错误信息", type = ApiParamType.STRING)
    private String errorMsg;
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
    @EntityField(name = "来源id", type = ApiParamType.STRING)
    private Long invokeId;
    @EntityField(name = "来源", type = ApiParamType.STRING)
    private String source;
    @EntityField(name = "来源名", type = ApiParamType.STRING)
    private String sourceName;
    @EntityField(name = "并发线程数", type = ApiParamType.INTEGER)
    private Integer threadCount;
    @EntityField(name = "作业其它配置", type = ApiParamType.STRING)
    private String configStr;
    @EntityField(name = "作业其它配置", type = ApiParamType.JSONOBJECT)
    private JSONObject config;
    @EntityField(name = "作业剧本集合", type = ApiParamType.JSONARRAY)
    private List<AutoexecJobPhaseVo> phaseList;
    @EntityField(name = "作业剧本Id集合", type = ApiParamType.JSONARRAY)
    private List<Long> phaseIdList;
    @EntityField(name = "作业剧本Name集合", type = ApiParamType.JSONARRAY)
    private List<String> phaseNameList;
    @EntityField(name = "作业耗时", type = ApiParamType.STRING)
    private String costTime;
    @EntityField(name = "运行参数Str", type = ApiParamType.STRING)
    private String paramStr;
    @EntityField(name = "运行参数JSON", type = ApiParamType.JSONOBJECT)
    private JSONObject actionParam;
    private String paramHash;
    @EntityField(name = "完成率", type = ApiParamType.INTEGER)
    private Integer completionRate = 0;
    @EntityField(name = "是否拥有执行权限", type = ApiParamType.INTEGER)
    private Integer isCanExecute = 0;
    @EntityField(name = "是否拥有编辑权限", type = ApiParamType.INTEGER)
    private Integer isCanEdit = 0;
    private Long nodeId;
    private List<AutoexecJobPhaseNodeVo> phaseNodeVoList;//场景：工具库测试|重跑节点
    private List<Long> phaseNodeIdList;
    private Integer currentPhaseSort;
    private Long currentPhaseId;
    private Long currentNodeResourceId;
    private AutoexecJobPhaseNodeVo currentNode;
    private Integer isNoFireNext = 0;
    private Integer isFirstFire;
    private String action;//fire|refire|goon

    private List<AutoexecJobPhaseNodeVo> jobPhaseNodeList;

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

    public AutoexecJobVo(AutoexecCombopVo combopVo, String source, Integer threadCount, JSONObject paramJson) {
        this.operationId = combopVo.getId();
        this.operationType = combopVo.getOperationType();
        this.name = combopVo.getName();
        this.status = JobStatus.PENDING.getValue();
        this.source = source;
        this.threadCount = threadCount;
        JSONArray combopParams = JSONArray.parseArray(JSONArray.toJSONString(combopVo.getRuntimeParamList()));
        JSONArray combopParamsResult = new JSONArray();
        for (Object combopParam : combopParams) {
            JSONObject combopParamJson = JSONObject.parseObject(combopParam.toString());

            Object value = paramJson.get(combopParamJson.getString("key"));
            combopParamJson.put("value", value);
            combopParamsResult.add(combopParamJson);
        }
        this.execUser = UserContext.get().getUserUuid();
        this.execUserType = GroupSearch.USER.getValue();
        this.paramStr = combopParamsResult.toJSONString();
        this.configStr = combopVo.getConfigStr();
        if (combopVo.getIsTest() != null && combopVo.getIsTest()) {
            this.source = JobSource.TEST.getValue();
        }
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
        this.invokeId = jsonObj.getLong("scheduleId");
    }

    public AutoexecJobVo(Long jobId, String status) {
        this.id = jobId;
        this.status = status;
    }

    public AutoexecJobVo(Long jobId) {
        this.id = jobId;
    }

    public AutoexecJobVo(AutoexecScriptVersionVo scriptVersionVo, String value, String source, JSONObject paramJson) {
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

    public AutoexecJobStatusVo getStatusVo() {
        if (statusVo == null && StringUtils.isNotBlank(status)) {
            return new AutoexecJobStatusVo(status, JobStatus.getText(status), JobStatus.getColor(status));
        }
        return statusVo;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
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

    public String getConfigStr() {
        return configStr;
    }

    public void setConfigStr(String configStr) {
        this.configStr = configStr;
    }

    public JSONObject getConfig() {
        if (StringUtils.isNotBlank(configStr)) {
            return JSONObject.parseObject(configStr);
        }
        return null;
    }

    public String getSource() {
        return this.source;
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

    public String getSourceName() {
        if (StringUtils.isNotBlank(source)) {
            return AutoexecJobSourceFactory.getSourceValueMap().get(this.source);
        }
        return sourceName;
    }

    public void setSourceList(List<String> sourceList) {
        this.sourceList = sourceList;
    }

    public List<String> getExecUserList() {
        if (CollectionUtils.isNotEmpty(execUserList)) {
            for (int i = 0; i < execUserList.size(); i++) {
                String tmpUser = execUserList.get(i).replaceAll(GroupSearch.USER.getValuePlugin(), StringUtils.EMPTY);
                execUserList.set(i, tmpUser);
            }
        }
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

    public Integer getCompletionRate() {
        if (StringUtils.isNotBlank(status) && Objects.equals(JobStatus.COMPLETED.getValue(), status)) {
            return 100;
        }
        return completionRate;
    }

    public void setCompletionRate(Integer completionRate) {
        this.completionRate = completionRate;
    }

    public Integer getCurrentPhaseSort() {
        return currentPhaseSort;
    }

    public void setCurrentPhaseSort(Integer currentPhaseSort) {
        this.currentPhaseSort = currentPhaseSort;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Long getNodeId() {
        return nodeId;
    }

    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getIsCanExecute() {
        return isCanExecute;
    }

    public void setIsCanExecute(Integer isCanExecute) {
        this.isCanExecute = isCanExecute;
    }

    public List<AutoexecJobPhaseNodeVo> getJobPhaseNodeList() {
        return jobPhaseNodeList;
    }

    public void setJobPhaseNodeList(List<AutoexecJobPhaseNodeVo> jobPhaseNodeList) {
        this.jobPhaseNodeList = jobPhaseNodeList;
    }

    public List<Long> getPhaseIdList() {
        if (CollectionUtils.isNotEmpty(phaseList)) {
            phaseIdList = phaseList.stream().map(AutoexecJobPhaseVo::getId).collect(Collectors.toList());
        }
        return phaseIdList;
    }

    public List<String> getPhaseNameList() {
        if (CollectionUtils.isNotEmpty(phaseList)) {
            phaseNameList = phaseList.stream().map(AutoexecJobPhaseVo::getName).collect(Collectors.toList());
        }
        return phaseNameList;
    }

    public void setPhaseIdList(List<Long> phaseIdList) {
        this.phaseIdList = phaseIdList;
    }

    public Integer getIsCanEdit() {
        return isCanEdit;
    }

    public void setIsCanEdit(Integer isCanEdit) {
        this.isCanEdit = isCanEdit;
    }

    public List<AutoexecJobPhaseNodeVo> getPhaseNodeVoList() {
        return phaseNodeVoList;
    }

    public void setPhaseNodeVoList(List<AutoexecJobPhaseNodeVo> phaseNodeVoList) {
        this.phaseNodeVoList = phaseNodeVoList;
    }

    public List<Long> getPhaseNodeIdList() {
        if (CollectionUtils.isNotEmpty(phaseNodeVoList)) {
            phaseNodeIdList = phaseNodeVoList.stream().map(AutoexecJobPhaseNodeVo::getId).collect(Collectors.toList());
        }
        return phaseNodeIdList;
    }

    public Long getInvokeId() {
        return invokeId;
    }

    public void setInvokeId(Long invokeId) {
        this.invokeId = invokeId;
    }

    public Integer getIsNoFireNext() {
        return isNoFireNext;
    }

    public void setIsNoFireNext(Integer isNoFireNext) {
        this.isNoFireNext = isNoFireNext;
    }

    public Integer getIsFirstFire() {
        if(currentPhaseSort != null && currentPhaseSort == 0){
            return 1;
        }
        return 0;
    }

    public Long getCurrentPhaseId() {
        return currentPhaseId;
    }

    public void setCurrentPhaseId(Long currentPhaseId) {
        this.currentPhaseId = currentPhaseId;
    }

    public JSONObject getActionParam() {
        return actionParam;
    }

    public void setActionParam(JSONObject actionParam) {
        this.actionParam = actionParam;
    }

    public Long getCurrentNodeResourceId() {
        return currentNodeResourceId;
    }

    public void setCurrentNodeResourceId(Long currentNodeResourceId) {
        this.currentNodeResourceId = currentNodeResourceId;
    }

    public AutoexecJobPhaseNodeVo getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(AutoexecJobPhaseNodeVo currentNode) {
        this.currentNode = currentNode;
    }
}
