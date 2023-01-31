/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.autoexec.job.action.core;

import neatlogic.framework.auth.core.AuthActionChecker;
import neatlogic.framework.autoexec.auth.AUTOEXEC_SCRIPT_MODIFY;
import neatlogic.framework.autoexec.constvalue.ExecMode;
import neatlogic.framework.autoexec.constvalue.JobAction;
import neatlogic.framework.autoexec.constvalue.JobSource;
import neatlogic.framework.autoexec.constvalue.JobStatus;
import neatlogic.framework.autoexec.dao.mapper.AutoexecCombopMapper;
import neatlogic.framework.autoexec.dao.mapper.AutoexecJobMapper;
import neatlogic.framework.autoexec.dao.mapper.AutoexecScriptMapper;
import neatlogic.framework.autoexec.dao.mapper.AutoexecToolMapper;
import neatlogic.framework.autoexec.dto.AutoexecJobSourceVo;
import neatlogic.framework.autoexec.dto.job.AutoexecJobPhaseNodeVo;
import neatlogic.framework.autoexec.dto.job.AutoexecJobPhaseVo;
import neatlogic.framework.autoexec.dto.job.AutoexecJobVo;
import neatlogic.framework.autoexec.dto.job.AutoexecSqlNodeDetailVo;
import neatlogic.framework.autoexec.exception.*;
import neatlogic.framework.autoexec.job.source.type.AutoexecJobSourceTypeHandlerFactory;
import neatlogic.framework.autoexec.job.source.type.IAutoexecJobSourceTypeHandler;
import neatlogic.framework.autoexec.source.AutoexecJobSourceFactory;
import neatlogic.framework.dao.mapper.runner.RunnerMapper;
import neatlogic.framework.dto.runner.RunnerMapVo;
import neatlogic.framework.exception.type.ParamIrregularException;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
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
        jobVo.setCurrentPhaseId(actionParam.getLong("jobPhaseId"));
        jobVo.setCurrentNodeResourceId(actionParam.getLong("resourceId"));
        if (isNeedExecuteAuthCheck()) {
            if (Objects.equals(JobStatus.CHECKED.getValue(), jobVo.getStatus())) {
                throw new AutoexecJobCheckedException(jobVo.getId().toString());
            }
            if (Objects.equals(jobVo.getSource(), JobSource.TEST.getValue())) {//测试仅需判断是否有脚本维护权限即可
                if (!AuthActionChecker.check(AUTOEXEC_SCRIPT_MODIFY.class)) {
                    throw new AutoexecOperationHasNoModifyAuthException();
                }
            } else {
                AutoexecJobSourceVo jobSourceVo = AutoexecJobSourceFactory.getSourceMap().get(jobVo.getSource());
                if (jobSourceVo == null) {
                    throw new AutoexecJobSourceInvalidException(jobVo.getSource());
                }
                IAutoexecJobSourceTypeHandler autoexecJobSourceActionHandler = AutoexecJobSourceTypeHandlerFactory.getAction(jobSourceVo.getType());
                boolean isNeedCheckTakeOver = !Arrays.asList(JobAction.CHECK.getValue(), JobAction.TAKE_OVER.getValue()).contains(jobVo.getAction());
                autoexecJobSourceActionHandler.executeAuthCheck(jobVo, isNeedCheckTakeOver);
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
            AutoexecSqlNodeDetailVo sqlDetailVo = autoexecJobSourceActionHandler.getSqlDetail(jobVo);
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


}
