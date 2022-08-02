/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.job.action.core;

import codedriver.framework.asynchronization.threadlocal.TenantContext;
import codedriver.framework.asynchronization.threadlocal.UserContext;
import codedriver.framework.auth.core.AuthActionChecker;
import codedriver.framework.autoexec.auth.AUTOEXEC_SCRIPT_MODIFY;
import codedriver.framework.autoexec.constvalue.*;
import codedriver.framework.autoexec.dao.mapper.AutoexecCombopMapper;
import codedriver.framework.autoexec.dao.mapper.AutoexecJobMapper;
import codedriver.framework.autoexec.dao.mapper.AutoexecScriptMapper;
import codedriver.framework.autoexec.dao.mapper.AutoexecToolMapper;
import codedriver.framework.autoexec.dto.AutoexecJobSourceVo;
import codedriver.framework.autoexec.dto.AutoexecOperationVo;
import codedriver.framework.autoexec.dto.AutoexecToolVo;
import codedriver.framework.autoexec.dto.job.*;
import codedriver.framework.autoexec.dto.script.AutoexecScriptVo;
import codedriver.framework.autoexec.exception.*;
import codedriver.framework.autoexec.job.source.type.AutoexecJobSourceTypeHandlerFactory;
import codedriver.framework.autoexec.job.source.type.IAutoexecJobSourceTypeHandler;
import codedriver.framework.autoexec.source.AutoexecJobSourceFactory;
import codedriver.framework.autoexec.util.AutoexecUtil;
import codedriver.framework.dao.mapper.runner.RunnerMapper;
import codedriver.framework.dto.RestVo;
import codedriver.framework.dto.runner.RunnerMapVo;
import codedriver.framework.exception.type.ParamIrregularException;
import codedriver.framework.integration.authentication.enums.AuthenticateType;
import codedriver.framework.util.HttpRequestUtil;
import codedriver.framework.util.RestUtil;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

/**
 * @author lvzk
 * @since 2021/11/9 11:31
 **/
public abstract class AutoexecJobActionHandlerBase implements IAutoexecJobActionHandler {
    Logger logger = LoggerFactory.getLogger(AutoexecJobActionHandlerBase.class);

    protected static AutoexecJobMapper autoexecJobMapper;

    @Autowired
    private void setAutoexecJobMapper(AutoexecJobMapper _autoexecJobMapper) {
        autoexecJobMapper = _autoexecJobMapper;
    }

    protected static AutoexecCombopMapper autoexecCombopMapper;

    @Autowired
    private void setAutoexecCombopMapper(AutoexecCombopMapper _autoexecCombopMapper) {
        autoexecCombopMapper = _autoexecCombopMapper;
    }

    protected static AutoexecScriptMapper autoexecScriptMapper;

    @Autowired
    private void setAutoexecScriptMapper(AutoexecScriptMapper _autoexecScriptMapper) {
        autoexecScriptMapper = _autoexecScriptMapper;
    }

    protected static AutoexecToolMapper autoexecToolMapper;

    @Autowired
    private void setAutoexecToolMapper(AutoexecToolMapper _autoexecToolMapper) {
        autoexecToolMapper = _autoexecToolMapper;
    }

    protected static RunnerMapper runnerMapper;

    @Autowired
    private void setRunnerMapper(RunnerMapper _runnerMapper) {
        runnerMapper = _runnerMapper;
    }

    /**
     * 执行操作前的验证
     *
     * @param jobVo 作业
     * @return 是否执行后续操作
     */
    @Override
    public boolean validate(AutoexecJobVo jobVo) {
        JSONObject actionParam = jobVo.getActionParam();
        /*if (actionParam != null && actionParam.containsKey("jobId")) {
            Long jobId = actionParam.getLong("jobId");
            if (jobId != null) {
                AutoexecJobVo jobVoTmp = autoexecJobMapper.getJobInfo(jobId);
                if (jobVoTmp == null) {
                    throw new AutoexecJobNotFoundException(jobId.toString());
                }
                jobVo.setStatus(jobVoTmp.getStatus());
            }
        }*/
        jobVo.setCurrentPhaseId(actionParam.getLong("jobPhaseId"));
        jobVo.setCurrentNodeResourceId(actionParam.getLong("resourceId"));
        if (isNeedExecuteAuthCheck()) {
            if (Objects.equals(jobVo.getSource(), JobSource.TEST.getValue())) {//测试仅需判断是否有脚本维护权限即可
                if (!AuthActionChecker.check(AUTOEXEC_SCRIPT_MODIFY.class)) {
                    throw new AutoexecOperationHasNoModifyAuthException();
                }
            } else {
                if (JobAction.FIRE.getValue().equals(jobVo.getAction()) || JobAction.ABORT.getValue().equals(jobVo.getAction())
                        || JobAction.DELETE.getValue().equals(jobVo.getAction()) || JobAction.REFIRE.getValue().equals(jobVo.getAction())
                        || JobAction.RESET_NODE.getValue().equals(jobVo.getAction()) || JobAction.REFIRE_NODE.getValue().equals(jobVo.getAction())
                        || JobAction.IGNORE_NODE.getValue().equals(jobVo.getAction()) || JobAction.SUBMIT_NODE_WAIT_INPUT.getValue().equals(jobVo.getAction())) {
                    //TODO 自动化和发布的权限
                    //executeAuthCheck(jobVo);
                }
            }
        }
        return myValidate(jobVo);
    }

    public boolean myValidate(AutoexecJobVo jobVo) {
        return true;
    }

    protected void currentPhaseIdValid(AutoexecJobVo jobVo) {
        if (jobVo.getCurrentPhaseId() != null) {
            //如果存在phaseId 则校验phase是否存在
            AutoexecJobPhaseVo phaseVo = autoexecJobMapper.getJobPhaseByPhaseId(jobVo.getCurrentPhaseId());
            if (phaseVo == null) {
                throw new AutoexecJobPhaseNotFoundException(jobVo.getCurrentPhaseId().toString());
            }
            AutoexecJobVo jobVoTmp = autoexecJobMapper.getJobInfo(phaseVo.getJobId());
            if (jobVoTmp == null) {
                throw new AutoexecJobNotFoundException(phaseVo.getJobId());
            }
            jobVo.setSource(jobVoTmp.getSource());
            jobVo.setCurrentPhase(phaseVo);
            jobVo.setId(phaseVo.getJobId());
        }

    }

    protected void currentResourceIdValid(AutoexecJobVo jobVo) {
        //如果nodeVo为null，说明phase是local模式,没有resourceId,phase只有唯一node
        //TODO 需要分拆接口
        Long nodeId = jobVo.getActionParam().getLong("nodeId");
        if (Objects.equals(ExecMode.SQL.getValue(), jobVo.getCurrentPhase().getExecMode()) && jobVo.getActionParam().getLong("resourceId") != null) {
            if (StringUtils.isBlank(jobVo.getActionParam().getString("sqlName"))) {
                throw new ParamIrregularException("sqlName");
            }
            AutoexecJobSourceVo jobSourceVo = AutoexecJobSourceFactory.getSourceMap().get(jobVo.getSource());
            if (jobSourceVo == null) {
                throw new AutoexecJobSourceInvalidException(jobVo.getSource());
            }
            IAutoexecJobSourceTypeHandler autoexecJobSourceActionHandler = AutoexecJobSourceTypeHandlerFactory.getAction(jobSourceVo.getType());
            AutoexecSqlDetailVo sqlDetailVo = autoexecJobSourceActionHandler.getSqlDetail(jobVo);
            if (sqlDetailVo == null) {
                throw new AutoexecJobSqlDetailNotFoundException();
            }
            RunnerMapVo runnerMapVo = runnerMapper.getRunnerMapByRunnerMapId(sqlDetailVo.getRunnerId());
            jobVo.setCurrentNode(new AutoexecJobPhaseNodeVo(sqlDetailVo.getJobId(), sqlDetailVo.getPhaseName(), sqlDetailVo.getHost(), sqlDetailVo.getPort(), sqlDetailVo.getResourceId(), runnerMapVo.getUrl(), sqlDetailVo.getRunnerId()));
        } else if (jobVo.getCurrentNodeResourceId() != null || (Objects.equals(ExecMode.SQL.getValue(), jobVo.getCurrentPhase().getExecMode()) && jobVo.getActionParam().getLong("resourceId") == null) || Objects.equals(ExecMode.RUNNER.getValue(), jobVo.getCurrentPhase().getExecMode())) {
            AutoexecJobPhaseNodeVo nodeVo = autoexecJobMapper.getJobPhaseNodeInfoByJobPhaseIdAndResourceId(jobVo.getCurrentPhaseId(), jobVo.getCurrentNodeResourceId());
            if (nodeVo == null) {
                throw new AutoexecJobPhaseNodeNotFoundException(jobVo.getCurrentPhaseId().toString(), jobVo.getCurrentNodeResourceId() == null ? StringUtils.EMPTY : jobVo.getCurrentNodeResourceId().toString());
            }
            if (StringUtils.isBlank(nodeVo.getRunnerUrl())) {
                throw new AutoexecJobHostPortRunnerNotFoundException(jobVo.getCurrentNode().getHost() + ":" + jobVo.getCurrentNode().getPort());
            }
            jobVo.setCurrentNode(nodeVo);
        }
    }

    protected void currentResourceIdListValid(AutoexecJobVo jobVo) {
        JSONObject jsonObj = jobVo.getActionParam();
        if (CollectionUtils.isEmpty(jsonObj.getJSONArray("resourceIdList"))) {
            throw new ParamIrregularException("resourceIdList");
        }
        List<Long> resourceIdList = JSONObject.parseArray(jsonObj.getJSONArray("resourceIdList").toJSONString(), Long.class);
        List<AutoexecJobPhaseNodeVo> nodeVoList = autoexecJobMapper.getJobPhaseNodeListByJobPhaseIdAndResourceIdList(jobVo.getCurrentPhaseId(), resourceIdList);
        if (CollectionUtils.isEmpty(nodeVoList)) {
            throw new AutoexecJobPhaseNodeNotFoundException(StringUtils.EMPTY, resourceIdList.stream().map(Object::toString).collect(Collectors.joining(",")));
        }
        jobVo.setExecuteJobNodeVoList(nodeVoList);
    }

    @Override
    public JSONObject doService(AutoexecJobVo jobVo) throws Exception {
        if (!validate(jobVo)) {
            throw new AutoexecJobCanNotFireException(jobVo.getId().toString());
        }
        return doMyService(jobVo);
    }

    public abstract JSONObject doMyService(AutoexecJobVo jobVo) throws Exception;


    /**
     * 检查执行权限
     *
     * @param jobVo
     */
    public void executeAuthCheck(AutoexecJobVo jobVo) {
        if (!UserContext.get().getUserUuid().equals(jobVo.getExecUser())) {
            throw new AutoexecJobExecutePermissionDeinedExcpetion(jobVo.getId());
        }
    }

    /**
     * 检查runner联通性
     */
    protected void checkRunnerHealth(List<RunnerMapVo> runnerVos) {
        RestVo restVo;
        String result;
        String url;
        for (RunnerMapVo runner : runnerVos) {
            if (runner.getRunnerMapId() == null) {
                throw new AutoexecJobRunnerMapNotMatchRunnerException(runner.getRunnerMapId());
            }
            if (StringUtils.isBlank(runner.getUrl())) {
                throw new AutoexecJobRunnerNotFoundException(runner.getRunnerMapId().toString());
            }
            url = runner.getUrl() + "api/rest/health/check";
            HttpRequestUtil requestUtil = HttpRequestUtil.post(url).setConnectTimeout(5000).setReadTimeout(5000).setPayload(new JSONObject().toJSONString()).setAuthType(AuthenticateType.BUILDIN).sendRequest();
            if (StringUtils.isNotBlank(requestUtil.getError())) {
                throw new AutoexecJobRunnerConnectRefusedException(url,requestUtil.getError());
            }
            JSONObject resultJson = requestUtil.getResultJson();
            if (!resultJson.containsKey("Status") || !"OK".equals(resultJson.getString("Status"))) {
                throw new AutoexecJobRunnerHttpRequestException(url + ":" + requestUtil.getError());
            }

        }
    }

    /**
     * 执行组
     *
     * @param jobVo 作业
     */
    protected void executeGroup(AutoexecJobVo jobVo) {
        List<RunnerMapVo> runnerVos = autoexecJobMapper.getJobRunnerListByJobIdAndGroupId(jobVo.getId(), jobVo.getExecuteJobGroupVo().getId());
        execute(jobVo, runnerVos);
    }

    /**
     * 执行组
     *
     * @param jobVo 作业
     */
    protected void executeNode(AutoexecJobVo jobVo) {
        List<RunnerMapVo> runnerVos = new ArrayList<>();
        if (Objects.equals(jobVo.getCurrentPhase().getExecMode(), ExecMode.SQL.getValue())) {
            for (AutoexecJobPhaseNodeVo nodeVo : jobVo.getExecuteJobNodeVoList()) {
                runnerVos.add(new RunnerMapVo(nodeVo.getRunnerUrl(), nodeVo.getRunnerMapId()));
            }
        } else {
            runnerVos = autoexecJobMapper.getJobRunnerListByJobIdAndJobNodeIdList(jobVo.getId(), jobVo.getExecuteNodeIdList());
        }
        execute(jobVo, runnerVos);
    }

    /**
     * 发起执行命令
     *
     * @param jobVo     作业
     * @param runnerVos runner列表
     */
    private void execute(AutoexecJobVo jobVo, List<RunnerMapVo> runnerVos) {
        if (CollectionUtils.isEmpty(runnerVos)) {
            throw new AutoexecJobRunnerNotMatchException();
        }
        //如果作业第一次或重跑，更新作业状态为running 和 作业开始时间
        if (Objects.equals(jobVo.getIsFirstFire(), 1)) {
            jobVo.setStatus(JobStatus.RUNNING.getValue());
            autoexecJobMapper.updateJobStatus(jobVo);
        }
        JSONObject paramJson = new JSONObject();
        paramJson.put("jobId", jobVo.getId());
        paramJson.put("tenant", TenantContext.get().getTenantUuid());
        paramJson.put("isNoFireNext", jobVo.getIsNoFireNext());
        paramJson.put("isFirstFire", jobVo.getIsFirstFire());
        if (CollectionUtils.isNotEmpty(jobVo.getExecuteJobPhaseList())) {
            paramJson.put("jobPhaseNameList", jobVo.getExecuteJobPhaseList().stream().map(AutoexecJobPhaseVo::getName).collect(Collectors.toList()));
        }
        if (jobVo.getExecuteJobGroupVo() != null) {
            paramJson.put("jobGroupIdList", Collections.singletonList(jobVo.getExecuteJobGroupVo().getSort()));
        }

        if (jobVo.getCurrentPhase() != null && Objects.equals(jobVo.getCurrentPhase().getExecMode(), ExecMode.SQL.getValue())) {
            paramJson.put("jobPhaseNodeSqlList", jobVo.getExecuteJobNodeVoList());
        } else {
            paramJson.put("jobPhaseResourceIdList", jobVo.getExecuteResourceIdList());
        }
        RestVo restVo = null;
        String result = StringUtils.EMPTY;
        String url = StringUtils.EMPTY;
        runnerVos = runnerVos.stream().filter(o -> StringUtils.isNotBlank(o.getUrl())).collect(collectingAndThen(toCollection(() -> new TreeSet<>(Comparator.comparing(RunnerMapVo::getUrl))), ArrayList::new));
        checkRunnerHealth(runnerVos);
        try {
            for (RunnerMapVo runner : runnerVos) {
                jobVo.getEnvironment().put("RUNNER_ID",runner.getRunnerMapId());
                url = runner.getUrl() + "api/rest/job/exec";
                paramJson.put("passThroughEnv", new JSONObject() {{
                    put("runnerId", runner.getRunnerMapId());
                    if (jobVo.getExecuteJobGroupVo() != null) {
                        put("groupSort", jobVo.getExecuteJobGroupVo().getSort());
                    }
                    if (CollectionUtils.isNotEmpty(jobVo.getExecuteJobPhaseList())) {
                        put("phaseSort", jobVo.getExecuteJobPhaseList().get(0).getSort());
                    }
                    put("isFirstFire", jobVo.getIsFirstFire());
                }});
                paramJson.put("environment",jobVo.getEnvironment());
                restVo = new RestVo.Builder(url, AuthenticateType.BUILDIN.getValue()).setPayload(paramJson).build();
                result = RestUtil.sendPostRequest(restVo);
                JSONObject resultJson = JSONObject.parseObject(result);
                if (!resultJson.containsKey("Status") || !"OK".equals(resultJson.getString("Status"))) {
                    throw new AutoexecJobRunnerHttpRequestException(restVo.getUrl() + ":" + resultJson.getString("Message"));
                }
            }
        } catch (Exception ex) {
            throw new AutoexecJobRunnerConnectRefusedException(url + " " + result);
        }
    }

    /**
     * 获取节点状态
     *
     * @param paramJson           入参
     * @param isNeedOperationList 是否需要操作列表信息
     * @return 节点状态
     */
    protected AutoexecJobPhaseNodeVo getNodeOperationStatus(JSONObject paramJson, boolean isNeedOperationList) {
        List<AutoexecJobPhaseNodeOperationStatusVo> statusList = new ArrayList<>();
        String url = paramJson.getString("runnerUrl") + "/api/rest/job/phase/node/status/get";
        JSONObject statusJson = JSONObject.parseObject(AutoexecUtil.requestRunner(url, paramJson));
        AutoexecJobPhaseNodeVo nodeVo = new AutoexecJobPhaseNodeVo(statusJson);
        if (isNeedOperationList) {
            List<AutoexecJobPhaseOperationVo> operationVoList = autoexecJobMapper.getJobPhaseOperationByJobIdAndPhaseId(paramJson.getLong("jobId"), paramJson.getLong("phaseId"));
            //补充工具description
            List<Long> scriptVersionIdList = operationVoList.stream().filter(o -> Objects.equals(o.getType(), CombopOperationType.SCRIPT.getValue())).map(AutoexecJobPhaseOperationVo::getVersionId).collect(Collectors.toList());
            List<String> toolNameList = operationVoList.stream().filter(o -> Objects.equals(o.getType(), CombopOperationType.TOOL.getValue())).map(AutoexecJobPhaseOperationVo::getName).collect(Collectors.toList());
            Map<Long, String> scriptDescriptionMap = new HashMap<>();
            Map<String, String> ToolDescriptionMap = new HashMap<>();
            if (CollectionUtils.isNotEmpty(scriptVersionIdList)) {
                List<AutoexecScriptVo> scriptVos = autoexecScriptMapper.getScriptByVersionIdList(scriptVersionIdList);
                if (CollectionUtils.isNotEmpty(scriptVos)) {
                    scriptDescriptionMap = scriptVos.stream().collect(Collectors.toMap(AutoexecScriptVo::getVersionId, AutoexecOperationVo::getDescription));
                }
            }
            if (CollectionUtils.isNotEmpty(toolNameList)) {
                List<AutoexecToolVo> toolVos = autoexecToolMapper.getToolByNameList(toolNameList);
                if (CollectionUtils.isNotEmpty(toolVos)) {
                    ToolDescriptionMap = toolVos.stream().collect(Collectors.toMap(AutoexecToolVo::getName, o -> o.getDescription() == null ? StringUtils.EMPTY : o.getDescription()));
                }
            }

            for (AutoexecJobPhaseOperationVo operationVo : operationVoList) {
                String description = StringUtils.EMPTY;
                if (Objects.equals(operationVo.getType(), CombopOperationType.SCRIPT.getValue())) {
                    description = scriptDescriptionMap.get(operationVo.getVersionId());
                } else if (Objects.equals(operationVo.getType(), CombopOperationType.TOOL.getValue())) {
                    description = ToolDescriptionMap.get(operationVo.getName());
                }
                statusList.add(new AutoexecJobPhaseNodeOperationStatusVo(operationVo, statusJson, description));
            }
            nodeVo.setOperationStatusVoList(statusList.stream().sorted(Comparator.comparing(AutoexecJobPhaseNodeOperationStatusVo::getSort)).collect(Collectors.toList()));
        }
        return nodeVo;
    }

    /**
     * 重置autoexec 作业节点状态
     *
     * @param jobVo      作业
     * @param nodeVoList 节点列表
     */
    public void resetJobNodeStatus(AutoexecJobVo jobVo, List<AutoexecJobPhaseNodeVo> nodeVoList) {
        //重置mongodb node 状态
        List<RunnerMapVo> runnerVos = new ArrayList<>();
        for (AutoexecJobPhaseNodeVo nodeVo : nodeVoList) {
            runnerVos.add(new RunnerMapVo(nodeVo.getRunnerUrl(), nodeVo.getRunnerMapId()));
        }
        runnerVos = runnerVos.stream().filter(o -> StringUtils.isNotBlank(o.getUrl())).collect(collectingAndThen(toCollection(() -> new TreeSet<>(Comparator.comparing(RunnerMapVo::getUrl))), ArrayList::new));
        checkRunnerHealth(runnerVos);
        RestVo restVo = null;
        String result = StringUtils.EMPTY;
        AutoexecJobPhaseVo currentPhaseVo = jobVo.getCurrentPhase();
        try {
            JSONObject paramJson = new JSONObject();
            paramJson.put("jobId", jobVo.getId());
            paramJson.put("tenant", TenantContext.get().getTenantUuid());
            paramJson.put("execUser", UserContext.get().getUserUuid(true));
            paramJson.put("phaseName", currentPhaseVo.getName());
            paramJson.put("execMode", currentPhaseVo.getExecMode());
            paramJson.put("phaseNodeList", jobVo.getExecuteJobNodeVoList());
            for (RunnerMapVo runner : runnerVos) {
                String url = runner.getUrl() + "api/rest/job/phase/node/status/reset";
                restVo = new RestVo.Builder(url, AuthenticateType.BUILDIN.getValue()).setPayload(paramJson).build();
                result = RestUtil.sendPostRequest(restVo);
                JSONObject resultJson = JSONObject.parseObject(result);
                if (!resultJson.containsKey("Status") || !"OK".equals(resultJson.getString("Status"))) {
                    throw new AutoexecJobRunnerHttpRequestException(restVo.getUrl() + ":" + resultJson.getString("Message"));
                }
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            assert restVo != null;
            throw new AutoexecJobRunnerConnectRefusedException(restVo.getUrl() + " " + result);
        }
    }
}
