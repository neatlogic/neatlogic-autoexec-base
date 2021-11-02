/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dao.mapper;

import codedriver.framework.autoexec.annotation.AutoexecJobCallback;
import codedriver.framework.autoexec.annotation.AutoexecJobCallbackParam;
import codedriver.framework.autoexec.dto.combop.AutoexecCombopVo;
import codedriver.framework.autoexec.dto.job.*;
import codedriver.framework.dto.runner.RunnerMapVo;
import codedriver.framework.dto.runner.RunnerVo;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface AutoexecJobMapper {
    //job
    List<Long> searchJobId(AutoexecJobVo jobVo);

    List<AutoexecJobVo> searchJob(List<Long> jobIdList);

    AutoexecJobVo getJobInfo(Long jobId);

    AutoexecJobVo getJobDetailByJobIdAndPhaseName(@Param("jobId") Long jobId, @Param("phaseName") String phaseName);

    Integer searchJobCount(AutoexecJobVo jobVo);

    List<AutoexecCombopVo> searchJobWithCombopView(AutoexecJobVo jobVo);

    Integer checkIsJobUser(@Param("jobId") Long jobId, @Param("userList") List<String> userList);

    AutoexecJobVo getJobLockByJobId(Long jobId);

    AutoexecJobParamContentVo getJobParamContentLock(String hash);

    AutoexecJobParamContentVo getJobParamContent(String hash);

    int checkIsJobParamReference(@Param("jobId") Long jobId, @Param("hash") String hash);

    AutoexecJobVo getJobLockByOperationId(Long operationId);

    //jobPhase
    List<AutoexecJobPhaseVo> getJobPhaseListByJobId(Long jobId);

    List<AutoexecJobPhaseVo> getJobPhaseListByJobIdAndPhaseStatus(@Param("jobId") Long jobId, @Param("statusList") List<String> statusList);

    List<AutoexecJobPhaseVo> getJobPhaseListByJobIdAndNodeStatusList(@Param("jobId") Long jobId, @Param("statusList") List<String> statusList);

    AutoexecJobPhaseVo getJobPhaseLockByPhaseId(Long jobPhaseId);

    AutoexecJobPhaseVo getJobPhaseByPhaseId(Long jobPhaseId);

    AutoexecJobPhaseVo getJobPhaseLockByJobIdAndPhaseName(@Param("jobId") Long jobId, @Param("jobPhaseName") String jobPhaseName);

    AutoexecJobPhaseVo getJobPhaseByJobIdAndPhaseId(@Param("jobId") Long jobId, @Param("jobPhaseId") Long jobPhaseId);

    AutoexecJobPhaseVo getFirstJobPhase(Long jobId);

    AutoexecJobPhaseVo getJobPhaseByJobIdAndPhaseName(@Param("jobId") Long jobId, @Param("jobPhaseName") String jobPhaseName);

    Integer getJobPhaseNotCompletedCountByJobIdAndSort(@Param("jobId") Long jobId, @Param("sort") Integer sort);

    List<AutoexecJobPhaseVo> getJobPhaseListByJobIdAndSort(@Param("jobId") Long jobId, @Param("sort") Integer sort);

    Integer checkIsHasActivePhaseFailed(Long jobId);

    int getJobPhaseRunnerByNotStatusCount(@Param("jobPhaseIdList") List<Long> jobPhaseIdList, @Param("status") String status);

    int getJobPhaseRunnerByStatusCount(@Param("jobPhaseIdList") List<Long> jobPhaseIdList, @Param("status") String status);

    List<AutoexecJobPhaseVo> getJobPhaseRunnerCountByJobIdAndStatus(@Param("jobId") Long jobId, @Param("status") String status);

    AutoexecJobPhaseVo getJobPhaseByJobIdAndPhaseStatus(@Param("jobId") Long id, @Param("status") String status);

    AutoexecJobPhaseVo getJobCurrentPhase(Long jobId);

    //jobPhaseNode
    List<AutoexecJobPhaseNodeVo> searchJobPhaseNode(AutoexecJobPhaseNodeVo jobPhaseNodeVo);

    int searchJobPhaseNodeCount(AutoexecJobPhaseNodeVo jobPhaseNodeVo);

    List<AutoexecJobPhaseNodeStatusCountVo> getJobPhaseNodeStatusCount(Long jobId);

    int checkIsJobPhaseNodeExist(AutoexecJobPhaseNodeVo nodeVo);

    @AutoexecJobCallback
    int updateJobStatus(@AutoexecJobCallbackParam() AutoexecJobVo jobVo);

    int updateJobPhaseNodeStatus(AutoexecJobPhaseNodeVo nodeVo);

    int updateJobPhaseNodeStatusByJobIdAndJobPhaseIdListAndRunnerId(@Param("jobId") Long jobId, @Param("jobPhaseIdList") List<Long> jobPhaseIdList, @Param("nodeStatusList") List<String> jobNodeStatusList,@Param("runnerId") Integer runnerId);

    AutoexecJobPhaseNodeVo getJobPhaseNodeInfoByJobNodeId(@Param("nodeId") Long nodeId);

    AutoexecJobPhaseNodeVo getJobPhaseNodeInfoByJobPhaseIdAndResourceId(@Param("jobPhaseId") Long jobPhaseId, @Param("resourceId") Long resourceId);

    AutoexecJobPhaseNodeVo getJobPhaseRunnerNodeByJobIdAndPhaseId(@Param("jobId") Long jobId, @Param("phaseId") Long phaseId);

    List<AutoexecJobPhaseNodeVo> getJobPhaseNodeListByJobIdAndPhaseNameAndExceptStatusAndRunnerId(@Param("jobId") Long jobId, @Param("phaseName") String phaseName, @Param("exceptStatus") List<String> exceptStatus, @Param("runnerId") Integer runnerId);

    List<AutoexecJobPhaseNodeVo> getJobPhaseNodeListByJobIdAndPhaseIdAndExceptStatus(@Param("jobId") Long jobId, @Param("phaseId") Long phaseId, @Param("exceptStatus") List<String> exceptStatus);

    List<AutoexecJobPhaseNodeVo> getJobPhaseNodeListByJobIdAndPhaseId(@Param("jobId") Long jobId, @Param("phaseId") Long phaseId);

    List<AutoexecJobPhaseNodeVo> getJobPhaseNodeListByNodeIdList(@Param("nodeIdList") List<Long> nodeIdList);

    List<AutoexecJobPhaseNodeVo> getJobPhaseNodeRunnerListByNodeIdList(@Param("nodeIdList") List<Long> nodeIdList);

    List<AutoexecJobPhaseNodeVo> getJobPhaseNodeListByJobIdAndNodeStatusList(@Param("jobId") Long jobId, @Param("statusList") List<String> statusList);

    int checkIsHasRunningNode(Long id);

    int updateJobPhaseNodeListStatus(@Param("nodeIdList") List<Long> jobPhaseNodeIdList, @Param("status") String status);

    //jobPhaseOperation
    List<AutoexecJobPhaseOperationVo> getJobPhaseOperationByJobId(Long jobId);

    List<AutoexecJobPhaseOperationVo> getJobPhaseOperationByJobIdAndPhaseId(@Param("jobId") Long jobId, @Param("phaseId") Long phaseId);

    AutoexecJobPhaseOperationVo getJobPhaseOperationByJobIdAndPhaseIdAndOperationId(@Param("jobId") Long jobId, @Param("jobPhaseId") Long jobPhaseId, @Param("jobPhaseOperationId") Long operationId);

    AutoexecJobPhaseOperationVo getJobPhaseOperationByOperationId(@Param("jobPhaseOperationId") Long operationId);

    int checkIsJobPhaseOperationParamReference(@Param("jobId") Long jobId, @Param("hash") String hash);

    //jobParamContent
    Integer getNextJobPhaseSortByJobId(@Param("jobId") Long jobId, @Param("sort") Integer sort);

    List<AutoexecJobParamContentVo> getJobParamContentList(@Param("hashList") List<String> hashList);

    //runner
    List<RunnerVo> getJobRunnerListByJobId(Long jobId);

    RunnerVo getJobRunnerById(Integer runnerId);

    List<RunnerMapVo> getJobPhaseRunnerByJobIdAndPhaseIdList(@Param("jobId") Long jobId, @Param("jobPhaseIdList") List<Long> jobPhaseId);

    List<RunnerMapVo> getJobPhaseRunnerByJobIdAndPhaseIdListAndStatus(@Param("jobId") Long jobId, @Param("jobPhaseIdList") List<Long> jobPhaseId, @Param("status") String status);

    //invoke
    AutoexecJobInvokeVo getJobInvokeByJobId(Long id);

    Long getJobIdByInvokeIdLimitOne(Long invokeId);

    List<AutoexecJobInvokeVo> getJobIdCountListByInvokeIdList(List<Long> invokeIdList);

    String getAutoexecJobEnvValueByJobIdAndName(AutoexecJobEnvVo autoexecJobEnvVo);

    List<AutoexecJobEnvVo> getAutoexecJobEnvListByJobId(Long jobId);

    Integer getJobPhaseRunnerNotCompletedCountByJobIdAndIsFireNext(@Param("jobId") Long jobId, @Param("isFireNext") int isFireNext,@Param("sort") int sort);

    List<HashMap<String,String>> getJobPhaseRunnerAbortingCountMapCountByJobId(@Param("jobId") Long jobId);

    List<AutoexecJobPhaseNodeVo> getAutoexecJobNodeListByJobPhaseIdListAndStatusAndRunnerId(@Param("jobPhaseIdList") List<Long> jobPhaseIdList,@Param("status") String status,@Param("runnerId") Integer runnerId);

    Integer getJobPhaseNotStatusCountByJobIdAndStatus(@Param("jobId") Long jobId,@Param("status") String status);

    int insertIgnoreIntoJobInvoke(AutoexecJobInvokeVo invokeVo);

    Integer insertJobPhaseNodeRunner(@Param("nodeId") Long nodeId, @Param("runnerMapId") Long runnerMapId);

    Integer insertJobPhaseRunner(@Param("jobId") Long jobId, @Param("jobPhaseId") Long jobPhaseId, @Param("runnerMapId") Long runnerMapId);

    Integer insertJob(AutoexecJobVo jobVo);

    Integer insertJobPhase(AutoexecJobPhaseVo jobVo);

    Integer insertJobPhaseNode(AutoexecJobPhaseNodeVo jobVo);

    Integer insertJobPhaseOperation(AutoexecJobPhaseOperationVo operationVo);

    Integer insertJobParamContent(AutoexecJobParamContentVo contentVo);

    Integer updateJobPhaseStatus(AutoexecJobPhaseVo autoexecJobPhaseVo);

    Integer updateJobPhaseFailedNodeStatusByJobId(@Param("jobId") Long id, @Param("status") String value);

    Integer updateJobPhaseRunnerStatusBatch(@Param("phaseIdList") List<Long> phaseIdList, @Param("status") String phaseStatus, @Param("runnerId") Integer runnerId);

    void updateJobPhaseStatusByJobId(@Param("jobId") Long id, @Param("status") String value);

    Integer updateJobPhaseRunnerStatus(@Param("jobPhaseIdList") List<Long> jobPhaseIdList, @Param("runnerId") Integer runnerId, @Param("status") String status);

    Integer updateBatchJobPhaseRunnerStatus(@Param("jobPhaseId") Long jobPhaseId, @Param("status") String status);

    Integer updateJobPhaseStatusByPhaseIdList(@Param("phaseIdList") List<Long> phaseIdList, @Param("status") String status);

    Integer updateJobPhaseNode(AutoexecJobPhaseNodeVo nodeVo);

    Integer updateJobPhaseRunnerFireNextByPhaseId(@Param("phaseId") Long phaseId, @Param("isFireNext") int isFireNext, @Param("runnerMapId") Integer runnerMapId);

    int replaceIntoJobEnv(AutoexecJobEnvVo jobEnvVo);

    void deleteJobParamContentByHash(String paramHash);

    void deleteJobPhaseOperationByJobId(Long jobId);

    void deleteJobPhaseNodeByJobId(Long jobId);

    void deleteJobPhaseByJobId(Long jobId);

    void deleteJobByJobId(Long jobId);

    void deleteJobPhaseNodeByJobPhaseIdList(@Param("jobPhaseIdList") List<Long> jobPhaseIdList);

    void deleteJobPhaseRunnerByJobId(Long jobId);

    void deleteJobPhaseNodeRunnerByJobId(Long jobId);

}
