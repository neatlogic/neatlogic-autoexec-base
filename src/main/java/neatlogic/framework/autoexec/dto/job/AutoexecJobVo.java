/*
 * Copyright(c) 2023 NeatLogic Co., Ltd. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package neatlogic.framework.autoexec.dto.job;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import neatlogic.framework.asynchronization.threadlocal.UserContext;
import neatlogic.framework.autoexec.constvalue.CombopOperationType;
import neatlogic.framework.autoexec.constvalue.JobStatus;
import neatlogic.framework.autoexec.constvalue.JobTriggerType;
import neatlogic.framework.autoexec.constvalue.ReviewStatus;
import neatlogic.framework.autoexec.dto.AutoexecParamVo;
import neatlogic.framework.autoexec.dto.combop.AutoexecCombopConfigVo;
import neatlogic.framework.autoexec.dto.combop.AutoexecCombopExecuteConfigVo;
import neatlogic.framework.autoexec.source.AutoexecJobSourceFactory;
import neatlogic.framework.autoexec.source.IAutoexecJobSource;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.common.constvalue.GroupSearch;
import neatlogic.framework.common.dto.BaseEditorVo;
import neatlogic.framework.dto.RoleVo;
import neatlogic.framework.dto.TeamVo;
import neatlogic.framework.dto.UserVo;
import neatlogic.framework.restful.annotation.EntityField;
import neatlogic.framework.util.SnowflakeUtil;
import neatlogic.framework.util.TimeUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author lvzk
 * @since 2021/4/12 11:48
 **/
public class AutoexecJobVo extends BaseEditorVo implements Serializable {
    private static final long serialVersionUID = -1382188874082154509L;
    @EntityField(name = "作业id(如果是人工发起则id正常生成，其它情况存放来源id)", type = ApiParamType.LONG)
    private Long id;

    @EntityField(name = "作业id列表", type = ApiParamType.JSONARRAY)
    private List<Long> idList;
    @EntityField(name = "排除作业id列表", type = ApiParamType.JSONARRAY)
    private List<Long> excludeIdList;
    @EntityField(name = "作业名称（唯一标识）", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "作业状态", type = ApiParamType.STRING)
    private String status;
    @EntityField(name = "作业状态Vo", type = ApiParamType.JSONOBJECT)
    private String statusName;
    @EntityField(name = "作业计划开始时间", type = ApiParamType.LONG)
    private Date planStartTime;
    @EntityField(name = "开始时间", type = ApiParamType.LONG)
    private Date startTime;
    @EntityField(name = "结束时间", type = ApiParamType.LONG)
    private Date endTime;

    @JSONField(serialize = false)
    private List<String> startTimeRange;
    @JSONField(serialize = false)
    private List<String> endTimeRange;
    @JSONField(serialize = false)
    private List<String> planStartTimeRange;
    @EntityField(name = "操作ID", type = ApiParamType.LONG)
    private Long operationId;
    @EntityField(name = "操作Name", type = ApiParamType.STRING)
    private String operationName;
    @EntityField(name = "操作类型", type = ApiParamType.STRING)
    private String operationType;
    @EntityField(name = "操作类型名", type = ApiParamType.STRING)
    private String operationTypeName;
    @EntityField(name = "组合工具版本ID", type = ApiParamType.LONG)
    private Long combopVersionId;
    @EntityField(name = "执行用户", type = ApiParamType.STRING)
    private String execUser;
    @EntityField(name = "执行用户类型", type = ApiParamType.STRING)
    private String execUserType;
    @EntityField(name = "执行用户对象", type = ApiParamType.JSONOBJECT)
    private UserVo execUserVo;
    @EntityField(name = "配置路由id", type = ApiParamType.STRING)
    private String routeId;
    @EntityField(name = "配置路由名称", type = ApiParamType.STRING)
    private String routeName;
    @EntityField(name = "来源id", type = ApiParamType.LONG)
    private Long invokeId;
    @EntityField(name = "来源", type = ApiParamType.STRING)
    private String source;
    @EntityField(name = "来源类型", type = ApiParamType.STRING)
    private String sourceType;
    @EntityField(name = "来源名", type = ApiParamType.STRING)
    private String sourceName;
    @EntityField(name = "并发线程数", type = ApiParamType.INTEGER)
    private Integer roundCount = 3;
    @JSONField(serialize = false)
    private String configStr;
    @EntityField(name = "作业其它配置", type = ApiParamType.JSONOBJECT)
    @JSONField(serialize = false)
    private AutoexecCombopConfigVo config;
    @EntityField(name = "触发方式", type = ApiParamType.STRING)
    private String triggerType = JobTriggerType.AUTO.getValue();
    @EntityField(name = "触发方式Vo", type = ApiParamType.JSONOBJECT)
    private String triggerTypeName;
    @EntityField(name = "作业剧本集合", type = ApiParamType.JSONARRAY)
    private List<AutoexecJobPhaseVo> phaseList;
    @EntityField(name = "作业剧本Id集合", type = ApiParamType.JSONARRAY)
    private List<Long> phaseIdList;
    @JSONField(serialize = false)
    private Boolean hasParent;//搜索条件，是否拥有父作业
    @EntityField(name = "作业剧本Name集合", type = ApiParamType.JSONARRAY)
    private List<String> phaseNameList;
    @EntityField(name = "作业耗时", type = ApiParamType.STRING)
    private String costTime;
    @EntityField(name = "运行参数hash", type = ApiParamType.STRING)
    private String paramHash;
    @EntityField(name = "完成率", type = ApiParamType.INTEGER)
    private Integer completionRate = 0;
    @EntityField(name = "是否拥有执行权限", type = ApiParamType.INTEGER)
    private Integer isCanExecute = 0;
    @EntityField(name = "是否拥有编辑权限", type = ApiParamType.INTEGER)
    private Integer isCanEdit = 0;
    @EntityField(name = "是否拥有接管权限", type = ApiParamType.INTEGER)
    private Integer isCanTakeOver = 0;
    @EntityField(name = "是否拥有验证权限", type = ApiParamType.INTEGER)
    private Integer isCanCheck = 0;
    @EntityField(name = "是否接管", type = ApiParamType.INTEGER)
    private Integer isTakeOver = 0;
    @EntityField(name = "最近一次节点变动时间", type = ApiParamType.STRING)
    private Date lncd;
    @EntityField(name = "场景id", type = ApiParamType.LONG)
    private Long scenarioId;
    @EntityField(name = "场景名", type = ApiParamType.STRING)
    private String scenarioName;
    @JSONField(serialize = false)
    private JSONObject actionParam;
    @JSONField(serialize = false)
    private Long nodeId;
    @JSONField(serialize = false)
    private List<Long> phaseNodeIdList;
    @JSONField(serialize = false)
    private List<Long> phaseResourceIdList;
    @JSONField(serialize = false)
    private Long currentPhaseId;
    @JSONField(serialize = false)
    private AutoexecJobPhaseVo currentPhase;
    @JSONField(serialize = false)
    private AutoexecJobPhaseVo preOutputPhase;
    @JSONField(serialize = false)
    private Long currentNodeResourceId;
    @JSONField(serialize = false)
    private AutoexecJobPhaseNodeVo currentNode;
    @JSONField(serialize = false)
    private Integer isNoFireNext = 0;
    @JSONField(serialize = false)
    private Integer isFirstFire;
    @JSONField(serialize = false)
    private String action;//fire|refire|goon
    @JSONField(serialize = false)
    private String nodeFrom = "0";//job|group|phase
    @JSONField(serialize = false)
    private String userNameFrom = "0";//node 协议来源 job|group|phase
    @JSONField(serialize = false)
    private String protocolFrom = "0";//node 协议来源 job|group|phase
    @JSONField(serialize = false)
    private List<AutoexecJobPhaseNodeVo> executeJobNodeVoList;//场景：工具库测试|重跑节点
    @JSONField(serialize = false)
    private AutoexecJobGroupVo executeJobGroupVo;
    @JSONField(serialize = false)
    private List<AutoexecJobPhaseVo> executeJobPhaseList;
    @JSONField(serialize = false)
    List<AutoexecParamVo> runTimeParamList = new ArrayList<>();
    @JSONField(serialize = false)
    String runTimeParamListStr;
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
    @JSONField(serialize = false)
    private JSONObject param;
    @JSONField(serialize = false)
    private JSONObject environment = new JSONObject();//runner 环境参数
    @JSONField(serialize = false)
    private Set<Long> invokeIdList = new HashSet<>();
    @JSONField(serialize = false)
    private String configHash;
    @EntityField(name = "父作业id", type = ApiParamType.LONG)
    private Long parentId;
    @EntityField(name = "排序", type = ApiParamType.INTEGER)
    private Integer sort;
    @EntityField(name = "额外信息，如发布的系统名等", type = ApiParamType.JSONOBJECT)
    private JSONObject extraInfo;
    @EntityField(name = "审核人", type = ApiParamType.STRING)
    private String reviewer;
    @EntityField(name = "审核状态", type = ApiParamType.ENUM, member = ReviewStatus.class)
    private String reviewStatus;

    @EntityField(name = "审核状态名称", type = ApiParamType.STRING)
    private String reviewStatusName;
    @EntityField(name = "审核时间", type = ApiParamType.LONG)
    private Date reviewTime;

    @JSONField(serialize = false)
    @EntityField(name = "贯穿作业的参数", type = ApiParamType.STRING)
    private JSONObject passThroughEnv = new JSONObject();

    @EntityField(name = "指定执行用户", type = ApiParamType.STRING)
    @JSONField(serialize = false)
    private String assignExecUser;
    @EntityField(name = "告警数量", type = ApiParamType.INTEGER)
    private Integer warnCount = 0;
    @EntityField(name = "是否含有已忽略节点", type = ApiParamType.INTEGER)
    private Integer isHasIgnored = 0;
    @JSONField(serialize = false)
    @EntityField(name = "作业执行参数", type = ApiParamType.JSONOBJECT)
    private AutoexecCombopExecuteConfigVo executeConfig;

    @EntityField(name = "子作业列表", type = ApiParamType.JSONARRAY)
    private List<AutoexecJobVo> children;

    @JSONField(serialize = false)
    @EntityField(name = "排序", type = ApiParamType.JSONOBJECT)
    private AutoexecJobSortVo sortOrder;

    @JSONField(serialize = false)
    private Map<Long, Long> nodeResourceIdRunnerIdMap = new HashMap<>();//用于缓存节点对应的runner，确保同一个节点用的是同一个runner
    @EntityField(name = "作业local 的runnerMapId", type = ApiParamType.LONG)
    private Long runnerMapId;

    public AutoexecJobVo() {
    }

    public AutoexecJobVo(Long jobId, String status) {
        this.id = jobId;
        this.status = status;
    }

    public AutoexecJobVo(Long id, Date planStartTime, String triggerType) {
        this.id = id;
        this.planStartTime = planStartTime;
        this.triggerType = triggerType;
    }

    public AutoexecJobVo(Long jobId, Long operationId, String operationType) {
        this.id = jobId;
        this.operationId = operationId;
        this.operationType = operationType;
    }

    public Boolean getHasParent() {
        return hasParent;
    }

    public void setHasParent(Boolean hasParent) {
        this.hasParent = hasParent;
    }

    public String getReviewStatusName() {
        if (StringUtils.isBlank(this.reviewStatusName) && StringUtils.isNotBlank(this.reviewStatus)) {
            this.reviewStatusName = ReviewStatus.getText(this.reviewStatus);
        }
        return this.reviewStatusName;
    }


    public List<String> getStartTimeRange() {
        return startTimeRange;
    }

    public void setStartTimeRange(List<String> startTimeRange) {
        this.startTimeRange = startTimeRange;
    }

    public List<String> getEndTimeRange() {
        return endTimeRange;
    }

    public void setEndTimeRange(List<String> endTimeRange) {
        this.endTimeRange = endTimeRange;
    }

    public List<String> getPlanStartTimeRange() {
        return planStartTimeRange;
    }

    public void setPlanStartTimeRange(List<String> planStartTimeRange) {
        this.planStartTimeRange = planStartTimeRange;
    }

    public List<Long> getExcludeIdList() {
        return excludeIdList;
    }

    public void setExcludeIdList(List<Long> excludeIdList) {
        this.excludeIdList = excludeIdList;
    }

    public Long getId() {
        if (id == null) {
            id = SnowflakeUtil.uniqueLong();
        }
        return id;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public String getReviewStatus() {
        return reviewStatus;
    }

    public void setReviewStatus(String reviewStatus) {
        this.reviewStatus = reviewStatus;
    }

    public Date getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(Date reviewTime) {
        this.reviewTime = reviewTime;
    }

    public List<Long> getIdList() {
        return idList;
    }

    public void setIdList(List<Long> idList) {
        this.idList = idList;
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
        if (StringUtils.isBlank(statusName) && StringUtils.isNotBlank(status)) {
            return JobStatus.getText(status);
        }
        return statusName;
    }

    public Date getPlanStartTime() {
        if (planStartTime == null && startTime == null) {
            planStartTime = new Date();
        }
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
        //优先使用指定执行用户
        if (StringUtils.isNotBlank(assignExecUser)) {
            return assignExecUser;
        }
        if (StringUtils.isBlank(execUser)) {
            return UserContext.get().getUserUuid();
        }
        return execUser;
    }

    public void setExecUser(String execUser) {
        this.execUser = execUser;
    }

    public String getExecUserType() {
        if (StringUtils.isBlank(execUserType)) {
            return GroupSearch.USER.getValue();
        }
        return execUserType;
    }

    public void setExecUserType(String execUserType) {
        this.execUserType = execUserType;
    }

    public Integer getRoundCount() {
        return roundCount;
    }

    public void setRoundCount(Integer roundCount) {
        this.roundCount = roundCount;
    }

    public String getConfigStr() {
        return configStr;
    }

    public void setConfigStr(String configStr) {
        this.configStr = configStr;
    }

    public AutoexecCombopConfigVo getConfig() {
        if (StringUtils.isNotBlank(configStr)) {
            config = JSONObject.parseObject(configStr, AutoexecCombopConfigVo.class);
        }
        return config;
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
            IAutoexecJobSource autoexecJobSource = AutoexecJobSourceFactory.getEnumInstance(this.source);
            if (autoexecJobSource != null) {
                return autoexecJobSource.getText();
            }
        }
        return sourceName;
    }

    public void setSourceList(List<String> sourceList) {
        this.sourceList = sourceList;
    }

    public List<String> getExecUserList() {
        if (CollectionUtils.isNotEmpty(execUserList)) {
            execUserList.replaceAll(s -> s.replaceAll(GroupSearch.USER.getValuePlugin(), StringUtils.EMPTY));
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

    public List<AutoexecParamVo> getRunTimeParamList() {
        return runTimeParamList;
    }

    public void setRunTimeParamList(List<AutoexecParamVo> runTimeParamList) {
        this.runTimeParamList = runTimeParamList;
    }


    public String getRunTimeParamListStr() {
        if (CollectionUtils.isNotEmpty(runTimeParamList)) {
            runTimeParamListStr = JSONArray.toJSONString(runTimeParamList);
        }
        return runTimeParamListStr;
    }

    public void setParamHash(String paramHash) {
        this.paramHash = paramHash;
    }

    public String getParamHash() {
        if (StringUtils.isBlank(paramHash) && StringUtils.isNotBlank(getRunTimeParamListStr())) {
            paramHash = DigestUtils.md5DigestAsHex(runTimeParamListStr.getBytes(StandardCharsets.UTF_8));
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
        return completionRate;
    }

    public void setCompletionRate(Integer completionRate) {
        this.completionRate = completionRate;
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

    public List<AutoexecJobPhaseNodeVo> getExecuteJobNodeVoList() {
        return executeJobNodeVoList;
    }

    public void setExecuteJobNodeVoList(List<AutoexecJobPhaseNodeVo> executeJobNodeVoList) {
        this.executeJobNodeVoList = executeJobNodeVoList;
    }

    public List<Long> getExecuteResourceIdList() {
        if (CollectionUtils.isNotEmpty(executeJobNodeVoList)) {
            phaseResourceIdList = executeJobNodeVoList.stream().map(AutoexecJobPhaseNodeVo::getResourceId).collect(Collectors.toList());
        }
        return phaseResourceIdList;
    }

    public List<Long> getExecuteNodeIdList() {
        if (CollectionUtils.isNotEmpty(executeJobNodeVoList)) {
            phaseNodeIdList = executeJobNodeVoList.stream().map(AutoexecJobPhaseNodeVo::getId).collect(Collectors.toList());
        }
        return phaseNodeIdList;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
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
        return isFirstFire;
    }

    public void setIsFirstFire(Integer isFirstFire) {
        this.isFirstFire = isFirstFire;
    }

    public Long getCurrentPhaseId() {
        return currentPhaseId;
    }

    public void setCurrentPhaseId(Long currentPhaseId) {
        this.currentPhaseId = currentPhaseId;
    }

    public JSONObject getActionParam() {
        return MapUtils.isEmpty(actionParam) ? new JSONObject() : actionParam;
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

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public String getOperationTypeName() {
        if (StringUtils.isNotBlank(operationType)) {
            return CombopOperationType.getText(operationType);
        }
        return operationTypeName;
    }

    public String getTriggerType() {
        return triggerType;
    }

    public void setTriggerType(String triggerType) {
        this.triggerType = triggerType;
    }

    public String getTriggerTypeName() {
        return JobTriggerType.getText(getTriggerType());
    }

    public AutoexecJobGroupVo getExecuteJobGroupVo() {
        return executeJobGroupVo;
    }

    public void setExecuteJobGroupVo(AutoexecJobGroupVo executeJobGroupVo) {
        this.executeJobGroupVo = executeJobGroupVo;
    }

    public List<AutoexecJobPhaseVo> getExecuteJobPhaseList() {
        return executeJobPhaseList;
    }

    public void setExecuteJobPhaseList(List<AutoexecJobPhaseVo> executeJobPhaseList) {
        this.executeJobPhaseList = executeJobPhaseList;
    }

    public String getNodeFrom() {
        return nodeFrom;
    }

    public void setNodeFrom(String nodeFrom) {
        this.nodeFrom = nodeFrom;
    }

    public String getUserNameFrom() {
        return userNameFrom;
    }

    public void setUserNameFrom(String userNameFrom) {
        this.userNameFrom = userNameFrom;
    }

    public String getProtocolFrom() {
        return protocolFrom;
    }

    public void setProtocolFrom(String protocolFrom) {
        this.protocolFrom = protocolFrom;
    }

    public Integer getIsCanTakeOver() {
        return isCanTakeOver;
    }

    public void setIsCanTakeOver(Integer isCanTakeOver) {
        this.isCanTakeOver = isCanTakeOver;
    }

    public Date getLncd() {
        return lncd;
    }

    public void setLncd(Date lncd) {
        this.lncd = lncd;
    }

    public AutoexecJobPhaseVo getCurrentPhase() {
        return currentPhase;
    }

    public void setCurrentPhase(AutoexecJobPhaseVo currentPhase) {
        this.currentPhase = currentPhase;
    }

    public JSONObject getParam() {
        return param;
    }

    public void setParam(JSONObject param) {
        this.param = param;
    }

    public Long getScenarioId() {
        return scenarioId;
    }

    public void setScenarioId(Long scenarioId) {
        this.scenarioId = scenarioId;
    }

    public String getScenarioName() {
        return scenarioName;
    }

    public void setScenarioName(String scenarioName) {
        this.scenarioName = scenarioName;
    }

    public JSONObject getEnvironment() {
        return environment;
    }

    public void setEnvironment(JSONObject environment) {
        this.environment = environment;
    }

    public Set<Long> getInvokeIdList() {
        if (invokeId != null) {
            invokeIdList.add(invokeId);
        }
        return invokeIdList;
    }

    public void setInvokeIdList(Set<Long> invokeIdList) {
        this.invokeIdList = invokeIdList;
    }

    public void addInvokeId(Long invokeId) {
        if (this.invokeIdList == null) {
            this.invokeIdList = new HashSet<>();
        }
        this.invokeIdList.add(invokeId);
    }

    public String getConfigHash() {
        if (StringUtils.isBlank(configHash) && StringUtils.isNotBlank(configStr)) {
            configHash = DigestUtils.md5DigestAsHex(configStr.getBytes(StandardCharsets.UTF_8));
        }
        return configHash;
    }

    public void setConfigHash(String configHash) {
        this.configHash = configHash;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public JSONObject getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(JSONObject extraInfo) {
        this.extraInfo = extraInfo;
    }

    public Integer getIsTakeOver() {
        return isTakeOver;
    }

    public void setIsTakeOver(Integer isTakeOver) {
        this.isTakeOver = isTakeOver;
    }

    public JSONObject getPassThroughEnv() {
        return passThroughEnv;
    }

    public void setPassThroughEnv(JSONObject passThroughEnv) {
        this.passThroughEnv = passThroughEnv;
    }

    public Integer getIsCanCheck() {
        return isCanCheck;
    }

    public void setIsCanCheck(Integer isCanCheck) {
        this.isCanCheck = isCanCheck;
    }

    public String getAssignExecUser() {
        return assignExecUser;
    }

    public void setAssignExecUser(String assignExecUser) {
        this.assignExecUser = assignExecUser;
    }

    public Integer getWarnCount() {
        return warnCount;
    }

    public void setWarnCount(Integer warnCount) {
        this.warnCount = warnCount;
    }

    public Integer getIsHasIgnored() {
        return isHasIgnored;
    }

    public void setIsHasIgnored(Integer isHasIgnored) {
        this.isHasIgnored = isHasIgnored;
    }

    public AutoexecCombopExecuteConfigVo getExecuteConfig() {
        return executeConfig;
    }

    public void setExecuteConfig(AutoexecCombopExecuteConfigVo executeConfig) {
        this.executeConfig = executeConfig;
    }

    public void setCombopId(Long combopId) {
        this.operationId = combopId;
    }

    public Long getCombopVersionId() {
        return combopVersionId;
    }

    public void setCombopVersionId(Long combopVersionId) {
        this.combopVersionId = combopVersionId;
    }

    public List<AutoexecJobVo> getChildren() {
        return children;
    }

    public void setChildren(List<AutoexecJobVo> children) {
        this.children = children;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public AutoexecJobPhaseVo getPreOutputPhase() {
        return preOutputPhase;
    }

    public void setPreOutputPhase(AutoexecJobPhaseVo preOutputPhase) {
        this.preOutputPhase = preOutputPhase;
    }

    public AutoexecJobSortVo getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(AutoexecJobSortVo sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Map<Long, Long> getNodeResourceIdRunnerIdMap() {
        return nodeResourceIdRunnerIdMap;
    }

    public void setNodeResourceIdRunnerIdMap(Map<Long, Long> nodeResourceIdRunnerIdMap) {
        this.nodeResourceIdRunnerIdMap = nodeResourceIdRunnerIdMap;
    }

    public Long getRunnerMapId() {
        return runnerMapId;
    }

    public void setRunnerMapId(Long runnerMapId) {
        this.runnerMapId = runnerMapId;
    }
}
