/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.job.action.core;

import codedriver.framework.asynchronization.threadlocal.TenantContext;
import codedriver.framework.auth.core.AuthActionChecker;
import codedriver.framework.autoexec.auth.AUTOEXEC_SCRIPT_MODIFY;
import codedriver.framework.autoexec.constvalue.CombopOperationType;
import codedriver.framework.autoexec.constvalue.ExecMode;
import codedriver.framework.autoexec.constvalue.JobSource;
import codedriver.framework.autoexec.constvalue.JobStatus;
import codedriver.framework.autoexec.crossover.IAutoexecCombopCrossoverService;
import codedriver.framework.autoexec.dao.mapper.AutoexecCombopMapper;
import codedriver.framework.autoexec.dao.mapper.AutoexecJobMapper;
import codedriver.framework.autoexec.dto.combop.AutoexecCombopVo;
import codedriver.framework.autoexec.dto.job.*;
import codedriver.framework.autoexec.exception.*;
import codedriver.framework.autoexec.job.group.policy.core.AutoexecJobGroupPolicyHandlerFactory;
import codedriver.framework.autoexec.job.group.policy.core.IAutoexecJobGroupPolicyHandler;
import codedriver.framework.crossover.CrossoverServiceFactory;
import codedriver.framework.dto.RestVo;
import codedriver.framework.dto.runner.RunnerMapVo;
import codedriver.framework.integration.authentication.enums.AuthenticateType;
import codedriver.framework.util.RestUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONValidator;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.stream.Collectors;

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

    /**
     * 执行操作前的验证
     *
     * @param jobVo 作业
     * @return 是否执行后续操作
     */
    @Override
    public boolean validate(AutoexecJobVo jobVo) {
        JSONObject actionParam = jobVo.getActionParam();
        if (actionParam != null && actionParam.containsKey("jobId")) {
            Long jobId = actionParam.getLong("jobId");
            if (jobId != null) {
                AutoexecJobVo jobVoTmp = autoexecJobMapper.getJobInfo(jobId);
                if (jobVoTmp == null) {
                    throw new AutoexecJobNotFoundException(jobId.toString());
                }
                jobVo.setStatus(jobVoTmp.getStatus());
            }
        }
        if (jobVo.getCurrentPhaseId() != null) {
            //如果存在phaseId 则校验phase是否存在
            AutoexecJobPhaseVo phaseVo = autoexecJobMapper.getJobPhaseByPhaseId(jobVo.getCurrentPhaseId());
            if (phaseVo == null) {
                throw new AutoexecJobPhaseNotFoundException(jobVo.getCurrentPhaseId().toString());
            }
            jobVo.setId(phaseVo.getJobId());
            jobVo.setPhaseList(Collections.singletonList(phaseVo));
            //如果nodeVo为null，说明phase是local模式,没有resourceId,phase只有唯一node
            if (jobVo.getCurrentNodeResourceId() != null || Objects.equals(ExecMode.RUNNER.getValue(), phaseVo.getExecMode())) {
                AutoexecJobPhaseNodeVo nodeVo = autoexecJobMapper.getJobPhaseNodeInfoByJobPhaseIdAndResourceId(jobVo.getCurrentPhaseId(), jobVo.getCurrentNodeResourceId());
                if (nodeVo == null) {
                    throw new AutoexecJobPhaseNodeNotFoundException(jobVo.getCurrentPhaseId().toString(), jobVo.getCurrentNodeResourceId() == null ? StringUtils.EMPTY : jobVo.getCurrentNodeResourceId().toString());
                }
                jobVo.setCurrentNode(nodeVo);
            }
        }

        if (isNeedExecuteAuthCheck()) {
            if (Objects.equals(jobVo.getSource(), JobSource.TEST.getValue())) {//测试仅需判断是否有脚本维护权限即可
                if (!AuthActionChecker.check(AUTOEXEC_SCRIPT_MODIFY.class)) {
                    throw new AutoexecOperationHasNoModifyAuthException();
                }
            } else {
                executeAuthCheck(jobVo);
            }
        }
        return myValidate(jobVo);
    }

    public boolean myValidate(AutoexecJobVo jobVo) {
        return true;
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
        if (Objects.equals(jobVo.getOperationType(), CombopOperationType.COMBOP.getValue())) {
            AutoexecCombopVo combopVo = autoexecCombopMapper.getAutoexecCombopById(jobVo.getOperationId());
            if (combopVo == null) {
                throw new AutoexecCombopNotFoundException(jobVo.getOperationId());
            }
            IAutoexecCombopCrossoverService accountService = CrossoverServiceFactory.getApi(IAutoexecCombopCrossoverService.class);
            accountService.setOperableButtonList(combopVo);
            if (combopVo.getExecutable() != 1) {
                throw new AutoexecCombopCannotExecuteException(combopVo.getName());
            }
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
            url = runner.getUrl() + "api/rest/health/check";
            if (StringUtils.isBlank(url)) {
                throw new AutoexecJobRunnerNotFoundException(runner.getRunnerMapId().toString());
            }
            restVo = new RestVo.Builder(url, AuthenticateType.BUILDIN.getValue()).build();
            result = RestUtil.sendPostRequest(restVo);
            if (JSONValidator.from(result).validate()) {
                JSONObject resultJson = JSONObject.parseObject(result);
                if (!resultJson.containsKey("Status") || !"OK".equals(resultJson.getString("Status"))) {
                    throw new AutoexecJobRunnerHttpRequestException(restVo.getUrl() + ":" + resultJson.getString("Message"));
                }
            } else {
                throw new AutoexecJobRunnerHttpRequestException(restVo.getUrl() + ":" + result);
            }
        }
    }

    /**
     * 第一次执行作业阶段
     *
     * @param jobVo 作业
     */
    protected void firstExecute(AutoexecJobVo jobVo) {
        jobVo.setStatus(JobStatus.RUNNING.getValue());
        autoexecJobMapper.updateJobStatus(jobVo);
        IAutoexecJobGroupPolicyHandler groupPolicyHandler = AutoexecJobGroupPolicyHandlerFactory.getGroupPolicy(jobVo.getExecuteJobGroupVo().getPolicy());
        groupPolicyHandler.getExecutePhaseList(jobVo);
        groupPolicyHandler.updateExecutePhaseListStatus(jobVo);
        List<RunnerMapVo> runnerVos = groupPolicyHandler.getExecuteRunnerList(jobVo);
        executeRunnerRest(jobVo, runnerVos);
    }

    /**
     * 发起执行命令
     *
     * @param jobVo     作业
     * @param runnerVos runner列表
     */
    private void executeRunnerRest(AutoexecJobVo jobVo, List<RunnerMapVo> runnerVos) {
        JSONObject paramJson = new JSONObject();
        paramJson.put("jobId", jobVo.getId());
        paramJson.put("tenant", TenantContext.get().getTenantUuid());
        paramJson.put("isNoFireNext", jobVo.getIsNoFireNext());
        paramJson.put("isFirstFire", jobVo.getIsFirstFire());
        paramJson.put("jobPhaseNameList", jobVo.getExecuteJobPhaseList().stream().map(AutoexecJobPhaseVo::getName).collect(Collectors.toList()));
        paramJson.put("jobPhaseNodeIdList", jobVo.getPhaseNodeIdList());
        RestVo restVo = null;
        String result = StringUtils.EMPTY;
        String url = StringUtils.EMPTY;
        checkRunnerHealth(runnerVos);
        try {
            for (RunnerMapVo runner : runnerVos) {
                url = runner.getUrl() + "api/rest/job/exec";
                paramJson.put("passThroughEnv", new JSONObject() {{
                    put("runnerId", runner.getRunnerMapId());
                    put("groupSort", jobVo.getExecuteJobGroupVo().getSort());
                    put("phaseSort", jobVo.getExecuteJobPhaseList().get(0).getSort());
                }});
                restVo = new RestVo.Builder(url, AuthenticateType.BUILDIN.getValue()).setPayload(paramJson).build();
                result = RestUtil.sendPostRequest(restVo);
                JSONObject resultJson = JSONObject.parseObject(result);
                if (!resultJson.containsKey("Status") || !"OK".equals(resultJson.getString("Status"))) {
                    throw new AutoexecJobRunnerHttpRequestException(restVo.getUrl() + ":" + resultJson.getString("Message"));
                }
            }
        } catch (Exception ex) {
            assert restVo != null;
            throw new AutoexecJobRunnerConnectRefusedException(url + " " + result);
        }
    }

    /**
     * 请求runner
     *
     * @param runnerUrl runner 链接
     * @param paramJson 入参
     * @return runner response
     */
    protected String requestRunner(String runnerUrl, JSONObject paramJson) {
        RestVo restVo = new RestVo.Builder(runnerUrl, AuthenticateType.BUILDIN.getValue()).setPayload(paramJson).build();
        String restResult = RestUtil.sendPostRequest(restVo);
        JSONObject resultJson = null;
        try {
            resultJson = JSONObject.parseObject(restResult);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new AutoexecJobRunnerConnectRefusedException(restVo.getUrl() + " " + restResult);
        }
        if (!resultJson.containsKey("Status") || !"OK".equals(resultJson.getString("Status"))) {
            throw new AutoexecJobRunnerHttpRequestException(resultJson.getString("Message"));
        }
        return resultJson.getString("Return");
    }

    /**
     * 获取节点状态
     *
     * @param paramJson 入参
     * @return 节点状态
     */
    protected AutoexecJobPhaseNodeVo getNodeOperationStatus(JSONObject paramJson) {
        List<AutoexecJobPhaseNodeOperationStatusVo> statusList = new ArrayList<>();
        String url = paramJson.getString("runnerUrl") + "/api/rest/job/phase/node/status/get";
        JSONObject statusJson = JSONObject.parseObject(requestRunner(url, paramJson));
        AutoexecJobPhaseNodeVo nodeVo = new AutoexecJobPhaseNodeVo(statusJson);
        List<AutoexecJobPhaseOperationVo> operationVoList = autoexecJobMapper.getJobPhaseOperationByJobIdAndPhaseId(paramJson.getLong("jobId"), paramJson.getLong("phaseId"));
        for (AutoexecJobPhaseOperationVo operationVo : operationVoList) {
            statusList.add(new AutoexecJobPhaseNodeOperationStatusVo(operationVo, statusJson));
        }
        nodeVo.setOperationStatusVoList(statusList.stream().sorted(Comparator.comparing(AutoexecJobPhaseNodeOperationStatusVo::getSort)).collect(Collectors.toList()));
        return nodeVo;
    }

    /**
     * 获取执行sql状态
     *
     * @param paramJson 参数
     * @return sql执行状态
     */
    protected AutoexecJobNodeSqlVo getNodeSqlStatus(JSONObject paramJson) {
        String url = paramJson.getString("runnerUrl") + "/api/rest/job/phase/node/status/get";
        JSONObject statusJson = JSONObject.parseObject(requestRunner(url, paramJson));
        if (MapUtils.isNotEmpty(statusJson)) {
            return new AutoexecJobNodeSqlVo(statusJson);
        }
        return null;
    }

}
