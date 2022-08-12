/*
 * Copyright(c) 2022 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dao.mapper;

import codedriver.framework.autoexec.annotation.AutoexecJobCallback;
import codedriver.framework.autoexec.annotation.AutoexecJobCallbackParam;
import codedriver.framework.autoexec.dto.combop.AutoexecCombopVo;
import codedriver.framework.autoexec.dto.job.*;
import codedriver.framework.dto.runner.RunnerMapVo;
import codedriver.framework.dto.runner.RunnerVo;
import com.alibaba.fastjson.JSONArray;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public interface AutoexecJobMapper {
    //job
    List<Long> getJobIdListByParentId(Long parentId);

    List<Long> searchJobId(AutoexecJobVo jobVo);

    List<AutoexecJobVo> searchJob(@Param("jobIdList") List<Long> jobIdList);

    List<AutoexecJobVo> getJobByExpiredDays(int expiredDays);

    AutoexecJobVo getJobInfo(Long jobId);

    AutoexecJobVo getJobDetailByJobIdAndPhaseName(@Param("jobId") Long jobId, @Param("phaseName") String phaseName);

    Integer searchJobCount(AutoexecJobVo jobVo);

    List<AutoexecCombopVo> searchJobWithCombopView(AutoexecJobVo jobVo);

    Integer checkIsJobUser(@Param("jobId") Long jobId, @Param("userList") List<String> userList);

    AutoexecJobVo getJobLockByJobId(Long jobId);

    List<AutoexecJobVo> getJobListLockByParentIdAndStatus(@Param("parentId") Long id, @Param("status") String status);

    List<AutoexecJobVo> getJobListByParentIdAndNotInStatus(@Param("parentId") Long id, @Param("status") String status);

    AutoexecJobContentVo getJobContentLock(String hash);

    AutoexecJobContentVo getJobContent(String hash);

    int checkIsJobParamReference(@Param("jobId") Long jobId, @Param("hash") String hash);

    AutoexecJobVo getJobLockByOperationId(Long operationId);

    //jobGroup
    AutoexecJobGroupVo getJobGroupByJobIdAndSort(@Param("jobId") Long id, @Param("sort") int sort);

    List<AutoexecJobGroupVo> getJobGroupByJobId(@Param("jobId") Long id);

    List<Long> getJobIdListByStatusAndTriggerType(@Param("status") String status, @Param("triggerType") String triggerType);

    AutoexecJobGroupVo getJobGroupById(Long groupId);

    //jobPhase
    List<AutoexecJobPhaseVo> getJobPhaseListByJobId(Long jobId);

    List<AutoexecJobPhaseVo> getJobPhaseListByJobIdAndPhaseStatus(@Param("jobId") Long jobId, @Param("statusList") List<String> statusList);

    List<AutoexecJobPhaseVo> getJobPhaseListByJobIdAndNodeStatusList(@Param("jobId") Long jobId, @Param("statusList") List<String> statusList);

    AutoexecJobPhaseVo getJobPhaseLockByPhaseId(Long jobPhaseId);

    AutoexecJobPhaseVo getJobPhaseByPhaseId(Long jobPhaseId);

    AutoexecJobPhaseVo getJobPhaseByJobIdAndPhaseId(@Param("jobId") Long jobId, @Param("jobPhaseId") Long jobPhaseId);

    AutoexecJobPhaseVo getFirstJobPhase(Long jobId);

    AutoexecJobPhaseVo getJobPhaseByJobIdAndPhaseName(@Param("jobId") Long jobId, @Param("jobPhaseName") String jobPhaseName);

    Integer getJobPhaseNotCompletedCountByJobIdAndGroupSort(@Param("jobId") Long jobId, @Param("groupSort") Integer groupSort);

    List<AutoexecJobPhaseVo> getJobPhaseListByJobIdAndGroupSort(@Param("jobId") Long jobId, @Param("sort") Integer sort);

    Integer checkIsHasActivePhaseFailed(Long jobId);

    int getJobPhaseRunnerCountByPhaseIdListAndRunnerNotStatus(@Param("jobPhaseIdList") List<Long> jobPhaseIdList, @Param("status") String status);

    int getJobPhaseRunnerCountByJobIdAndRunnerStatus(@Param("jobId") Long jobId, @Param("status") String status);

    int getJobPhaseRunnerByPhaseListAndStatusCount(@Param("jobPhaseIdList") List<Long> jobPhaseIdList, @Param("status") String status);

    List<AutoexecJobPhaseVo> getJobPhaseByJobIdAndRunnerStatus(@Param("jobId") Long jobId, @Param("status") String status);

    AutoexecJobPhaseVo getJobPhaseByJobIdAndPhaseStatus(@Param("jobId") Long id, @Param("status") String status);

    AutoexecJobPhaseVo getJobActivePhase(Long jobId);

    AutoexecJobPhaseVo getJobPhaseByJobIdAndGroupSortAndSort(@Param("jobId") Long jobId, @Param("groupSort") Integer groupSort, @Param("sort") int sort);

    List<AutoexecJobPhaseVo> getJobPhaseListByJobIdAndPhaseIdList(@Param("jobId") Long jobId, @Param("jobPhaseIdList") List<Long> jobPhaseIdList);

    //jobPhaseRunner
    List<AutoexecJobPhaseRunnerVo> getJobPhaseRunnerByJobIdAndPhaseIdList(@Param("jobId") Long jobId, @Param("jobPhaseIdList") List<Long> jobPhaseId);

    //jobPhaseNode
    List<AutoexecJobPhaseNodeVo> searchJobPhaseNodeWithResource(AutoexecJobPhaseNodeVo jobPhaseNodeVo);

    List<AutoexecJobPhaseNodeVo> searchJobPhaseNodeByDistinct(AutoexecJobPhaseNodeVo nodeParamVo);

    List<AutoexecJobPhaseNodeVo> searchJobPhaseNode(AutoexecJobPhaseNodeVo jobPhaseNodeVo);

    List<AutoexecJobPhaseNodeVo> getJobPhaseNodeIdListByNodeVoAndStartNum(@Param("nodeVo") AutoexecJobPhaseNodeVo jobPhaseNodeVo, @Param("startNum") Integer startNum);

    int searchJobPhaseNodeCountWithResource(AutoexecJobPhaseNodeVo jobPhaseNodeVo);

    int searchJobPhaseNodeCount(AutoexecJobPhaseNodeVo jobPhaseNodeVo);

    int searchJobPhaseNodeByDistinctResourceIdCount(AutoexecJobPhaseNodeVo jobPhaseNodeVo);

    List<AutoexecJobPhaseNodeStatusCountVo> getJobPhaseNodeStatusCount(Long jobId);

    int checkIsJobPhaseNodeExist(AutoexecJobPhaseNodeVo nodeVo);

    @AutoexecJobCallback
    int updateJobStatus(@AutoexecJobCallbackParam() AutoexecJobVo jobVo);

    int updateJobPhaseNodeStatus(AutoexecJobPhaseNodeVo nodeVo);

    int updateJobPhaseNodeStatusByJobIdAndJobPhaseIdListAndRunnerId(@Param("jobId") Long jobId, @Param("jobPhaseIdList") List<Long> jobPhaseIdList, @Param("nodeStatusList") List<String> jobNodeStatusList, @Param("runnerId") Long runnerId);

    int searchJobPhaseSqlCount(AutoexecJobPhaseNodeVo jobPhaseNodeVo);

    AutoexecJobPhaseNodeVo getJobPhaseNodeInfoByJobNodeId(@Param("nodeId") Long nodeId);

    AutoexecJobPhaseNodeVo getJobPhaseNodeInfoByJobPhaseIdAndResourceId(@Param("jobPhaseId") Long jobPhaseId, @Param("resourceId") Long resourceId);

    AutoexecJobPhaseNodeVo getJobPhaseNodeInfoByJobIdAndJobPhaseNameAndResourceId(@Param("jobId") Long jobId, @Param("jobPhaseName") String jobPhaseName, @Param("resourceId") Long resourceId);

    AutoexecJobPhaseNodeVo getJobPhaseRunnerNodeByJobIdAndPhaseId(@Param("jobId") Long jobId, @Param("phaseId") Long phaseId);

    List<AutoexecJobPhaseNodeVo> getJobPhaseNodeListByJobIdAndPhaseNameAndExceptStatusAndRunnerId(@Param("jobId") Long jobId, @Param("phaseName") String phaseName, @Param("exceptStatus") List<String> exceptStatus, @Param("runnerId") Long runnerId);

    List<AutoexecJobPhaseNodeVo> getJobPhaseNodeListByJobIdAndPhaseIdAndExceptStatus(@Param("jobId") Long jobId, @Param("phaseId") Long phaseId, @Param("exceptStatus") List<String> exceptStatus);

    List<AutoexecJobPhaseNodeVo> getJobPhaseNodeListByJobIdAndPhaseIdAndExceptStatusAndRunnerMapId(@Param("jobId") Long jobId, @Param("phaseId") Long phaseId, @Param("exceptStatus") List<String> exceptStatus, @Param("runnerMapId") Long runnerMapId);

    List<AutoexecJobPhaseNodeVo> getJobPhaseNodeListByJobIdAndPhaseId(@Param("jobId") Long jobId, @Param("phaseId") Long phaseId);

    List<AutoexecJobPhaseNodeVo> getJobPhaseNodeListByJobIdAndPhaseName(@Param("jobId") Long jobId, @Param("phaseName") String phaseName);

    List<AutoexecJobPhaseNodeVo> getJobPhaseNodeListByNodeIdList(@Param("nodeIdList") List<Long> nodeIdList);

    List<AutoexecJobPhaseNodeVo> getJobPhaseNodeListByJobPhaseIdAndResourceIdList(@Param("jobPhaseId") Long jobPhaseId, @Param("resourceIdList") List<Long> resourceIdList);

    List<AutoexecJobPhaseNodeVo> getJobPhaseNodeListByJobPhaseIdAndResourceIdListAndIsDelete(@Param("jobPhaseId") Long jobPhaseId, @Param("resourceIdList") List<Long> resourceIdList);

    List<AutoexecJobPhaseNodeVo> getJobPhaseNodeRunnerListByNodeIdList(@Param("nodeIdList") List<Long> nodeIdList);

    List<AutoexecJobPhaseNodeVo> getJobPhaseNodeListByJobIdAndNodeStatusList(@Param("jobId") Long jobId, @Param("statusList") List<String> statusList);

    int checkIsHasRunningNode(Long id);

    int updateJobPhaseNodeListStatus(@Param("nodeIdList") List<Long> jobPhaseNodeIdList, @Param("status") String status);

    List<AutoexecJobPhaseNodeVo> getJobPhaseNodeListBySqlIdList(@Param("sqlIdList") List<Long> sqlIdList);

    List<AutoexecJobPhaseNodeVo> getAutoexecJobNodeListByResourceIdList(List<Long> resourceIdList);

    List<AutoexecJobPhaseNodeVo> getAutoexecJobNodeListByJobIdAndResourceIdList(@Param("jobId") Long jobId, @Param("resourceIdList") List<Long> resourceIdList);

    //jobPhaseOperation
    List<AutoexecJobPhaseOperationVo> getJobPhaseOperationByJobId(Long jobId);

    List<AutoexecJobPhaseOperationVo> getJobPhaseOperationByJobIdAndPhaseId(@Param("jobId") Long jobId, @Param("phaseId") Long phaseId);

    AutoexecJobPhaseOperationVo getJobPhaseOperationByJobIdAndPhaseIdAndOperationId(@Param("jobId") Long jobId, @Param("jobPhaseId") Long jobPhaseId, @Param("jobPhaseOperationId") Long operationId);

    AutoexecJobPhaseOperationVo getJobPhaseOperationByOperationId(@Param("jobPhaseOperationId") Long operationId);

    int checkIsJobPhaseOperationParamReference(@Param("jobId") Long jobId, @Param("hash") String hash);

    //jobParamContent
    Integer getNextJobPhaseSortByJobId(@Param("jobId") Long jobId, @Param("sort") Integer sort);

    List<AutoexecJobContentVo> getJobContentList(@Param("hashList") List<String> hashList);

    //runner
    List<RunnerVo> getJobRunnerListByJobId(Long jobId);

    List<Long> getJobPhaseRunnerMapIdListByJobIdList(List<Long> jobIds);

    List<Long> getJobPhaseNodeRunnerMapIdListByNodeVo(AutoexecJobPhaseNodeVo nodeVo);

    RunnerVo getJobRunnerById(Long runnerId);

    List<RunnerMapVo> getJobPhaseRunnerMapByJobIdAndPhaseIdList(@Param("jobId") Long jobId, @Param("jobPhaseIdList") List<Long> jobPhaseId);

    List<RunnerMapVo> getJobPhaseRunnerByJobIdAndPhaseIdListAndStatus(@Param("jobId") Long jobId, @Param("jobPhaseIdList") List<Long> jobPhaseId, @Param("status") String status);

    List<RunnerMapVo> getJobRunnerListByJobIdAndGroupId(@Param("jobId") Long jobId, @Param("groupId") Long groupId);

    List<RunnerMapVo> getJobRunnerListByJobIdAndJobNodeIdList(@Param("jobId") Long jobId, @Param("nodeIdList") List<Long> nodeIdList);


    List<RunnerMapVo> getJobPhaseNodeRunnerListByJobPhaseId(Long jobPhaseId);

    //invoke
    AutoexecJobInvokeVo getJobInvokeByJobId(Long id);

    Long getJobIdByInvokeIdLimitOne(Long invokeId);

    List<AutoexecJobInvokeVo> getJobIdCountListByInvokeIdList(List<Long> invokeIdList);

    String getAutoexecJobEnvValueByJobIdAndName(AutoexecJobEnvVo autoexecJobEnvVo);

    List<AutoexecJobEnvVo> getAutoexecJobEnvListByJobId(Long jobId);

    Integer getJobPhaseRunnerNotCompletedCountByJobIdAndIsFireNextAndGroupSort(@Param("jobId") Long jobId, @Param("isFireNext") int isFireNext, @Param("groupSort") int groupSort);

    List<HashMap<String, String>> getJobPhaseRunnerAbortingCountMapCountByJobId(@Param("jobId") Long jobId);

    List<AutoexecJobPhaseNodeVo> getAutoexecJobNodeListByJobPhaseIdListAndStatusAndRunnerId(@Param("jobPhaseIdList") List<Long> jobPhaseIdList, @Param("status") String status, @Param("runnerId") Long runnerId);

    Integer getJobPhaseStatusCountByJobIdAndStatus(@Param("jobId") Long jobId, @Param("status") String status);

    //inspect
    List<AutoexecJobResourceInspectVo> getJobResourceInspectByResourceId(List<Long> resourceIdList);

    List<AutoexecJobPhaseVo> getJobPhaseListByJobIdAndNodeFromJob(Long jobId);

    //jobSql

    List<AutoexecSqlDetailVo> searchJobPhaseSql(AutoexecJobPhaseNodeVo jobPhaseNodeVo);

    List<AutoexecSqlDetailVo> getJobSqlDetailListByJobIdAndPhaseName(@Param("jobId") Long jobId, @Param("phaseName") String phaseName, @Param("sqlFileList") JSONArray sqlFileList);

    AutoexecSqlDetailVo getJobSqlByResourceIdAndJobIdAndJobPhaseNameAndSqlFile(@Param("resourceId") Long resourceId, @Param("jobId") Long jobId, @Param("phaseName") String phaseName, @Param("sqlFile") String sqlFile);

    AutoexecSqlDetailVo getJobSqlById(Long id);

    AutoexecSqlDetailVo getJobSqlByJobPhaseIdAndResourceIdAndSqlName(@Param("jobPhaseId") Long jobPhaseId, @Param("resourceId") Long resourceId, @Param("sqlName") String sqlName);

    List<Long> getSqlDetailIdListByJobIdAndPhaseNameAndResourceIdAndLcd(@Param("jobId") Long jobId, @Param("resourceId") Long resourceId, @Param("phaseName") String phaseName, @Param("lcd") Date lcd);

    List<Long> getJobSqlIdListByJobIdAndJobPhaseName(@Param("jobId") Long jobId, @Param("phaseName") String phaseName);

    List<AutoexecSqlDetailVo> getJobSqlListByJobIdAndJobPhaseName(@Param("jobId") Long jobId, @Param("phaseName") String phaseName);

    List<Long> getJobSqlIdListByJobIdAndJobPhaseNameList(@Param("jobId") Long jobId, @Param("jobPhaseNameList") List<String> jobPhaseNameList);

    List<AutoexecSqlDetailVo> getJobSqlDetailListByJobIdAndPhaseNameAndExceptStatusAndRunnerMapId(@Param("jobId") Long jobId, @Param("jobPhaseName") String jobPhaseName, @Param("exceptStatusList") List<String> exceptStatusList, @Param("runnerMapId") Long runnerMapId);

    int insertIgnoreIntoJobInvoke(AutoexecJobInvokeVo invokeVo);

    Integer insertIgnoreJobPhaseNodeRunner(AutoexecJobPhaseNodeRunnerVo nodeRunnerVo);

    Integer insertJobPhaseRunner(@Param("jobId") Long jobId, @Param("jobGroupId") Long jobGroupId, @Param("jobPhaseId") Long jobPhaseId, @Param("runnerMapId") Long runnerMapId, @Param("lcd") Date lcd);

    Integer insertJob(AutoexecJobVo jobVo);

    Integer insertJobGroup(AutoexecJobGroupVo autoexecJobGroupVo);

    Integer insertJobPhase(AutoexecJobPhaseVo jobVo);

    Integer insertJobPhaseNode(AutoexecJobPhaseNodeVo jobVo);

    Integer insertJobPhaseOperation(AutoexecJobPhaseOperationVo operationVo);

    Integer insertIgnoreJobContent(AutoexecJobContentVo contentVo);

    Integer updateJobLncdById(@Param("jobId") Long jobId, @Param("lcd") Date lcd);

    Integer updateJobGroupLncdById(@Param("jobGroupId") Long jobGroupId, @Param("lcd") Date lcd);

    Integer updateJobPhaseStatus(AutoexecJobPhaseVo autoexecJobPhaseVo);

    Integer updateJobPhaseStatusByJobIdAndPhaseStatus(@Param("jobId") Long jobId, @Param("whereStatus") String whereStatus, @Param("status") String status);

    Integer updateJobPhaseNodeStatusByJobIdAndIsDelete(@Param("jobId") Long id, @Param("status") String status, @Param("isDelete") Integer isDelete);

    Integer updateJobPhaseRunnerStatusBatch(@Param("phaseIdList") List<Long> phaseIdList, @Param("status") String phaseStatus, @Param("runnerId") Long runnerId);

    Integer updateJobPhaseStatusByJobId(@Param("jobId") Long id, @Param("status") String value);

    Integer updateJobPhaseRunnerStatus(@Param("jobPhaseIdList") List<Long> jobPhaseIdList, @Param("runnerId") Long runnerId, @Param("status") String status, @Param("warnCount") Integer warnCount);

    Integer updateJobPhaseRunnerStatusByJobIdAndRunnerIdAndStatus(@Param("jobId") Long jobId, @Param("runnerId") Long runnerId, @Param("status") String status);

    Integer updateBatchJobPhaseRunnerStatus(@Param("jobPhaseId") Long jobPhaseId, @Param("status") String status);

    Integer updateJobPhaseStatusByPhaseIdList(@Param("phaseIdList") List<Long> phaseIdList, @Param("status") String status);

    Integer updateJobPhaseNodeById(AutoexecJobPhaseNodeVo jobPhaseNodeVo);

    Integer updateJobPhaseNodeByJobIdAndPhaseIdAndResourceId(AutoexecJobPhaseNodeVo jobPhaseNodeVo);

    Integer updateJobPhaseRunnerFireNextByPhaseIdAndRunnerId(@Param("phaseId") Long phaseId, @Param("isFireNext") int isFireNext, @Param("runnerMapId") Long runnerMapId);

    Integer updateJobPhaseRunnerFireNextByJobIdAndGroupSortAndRunnerId(@Param("jobId") Long jobId, @Param("groupSort") Integer groupSort, @Param("isFireNext") int isFireNext, @Param("runnerMapId") Long runnerMapId);

    Integer updateJobPhaseLcdById(@Param("jobPhaseId") Long jobPhaseId, @Param("lcd") Date lcd);

    Integer updateJobPhaseLncdById(@Param("jobPhaseId") Long jobPhaseId, @Param("lcd") Date lcd);

    Integer updateJobPhaseNodeIsDeleteByJobPhaseIdAndLcd(@Param("jobPhaseId") Long jobPhaseId, @Param("lcd") Date lcd);

    Integer updateJobParamHashById(@Param("jobId") Long jobId, @Param("paramHash") String paramHash);

    Integer updateJobPhaseNodeFrom(@Param("jobPhaseId") Long id, @Param("nodeFrom") String nodeFrom);

    Integer updateJobPhaseNodeResetStartTimeAndEndTimeByNodeIdList(@Param("nodeIdList") List<Long> nodeIdList);

    Integer updateJobPhaseOperationVersionIdByJobIdAndOperationId(@Param("versionId") Long versionId, @Param("jobId") Long jobId, @Param("operationId") Long operationId);

    int updateJobPlanStartTimeAndTriggerTypeById(AutoexecJobVo vo);

    int updateJobExecUser(AutoexecJobVo vo);

    void updateSqlIsDeleteByIdList(@Param("idList") List<Long> idList);

    void updateSqlDetailById(AutoexecSqlDetailVo paramSqlVo);

    void resetJobSqlStatusBySqlIdList(@Param("idList") List<Long> idList);

    int insertDuplicateJobEnv(AutoexecJobEnvVo jobEnvVo);

    int insertDuplicateJobResourceInspect(@Param("jobId") Long jobId, @Param("resourceId") Long resourceId, @Param("phaseId") Long phaseId, @Param("lcd") Date lcd);

    void insertSqlDetail(AutoexecSqlDetailVo sqlFileDetailVo);

    void insertSqlDetailList(@Param("sqlList") List<AutoexecSqlDetailVo> sqlList, @Param("phaseName") String phaseName, @Param("phaseId") Long phaseId, @Param("runnerId") Long runnerId, @Param("lcd") Date lcd);

    void deleteJobContentByHash(String paramHash);

    void deleteJobPhaseOperationByJobId(Long jobId);

    void deleteJobPhaseNodeByJobId(Long jobId);

    void deleteJobPhaseByJobId(Long jobId);

    void deleteJobByJobId(Long jobId);

    void deleteJobPhaseNodeByJobPhaseIdList(@Param("jobPhaseIdList") List<Long> jobPhaseIdList);

    void deleteJobPhaseRunnerByJobId(Long jobId);

    void deleteJobPhaseNodeRunnerByJobId(Long jobId);

    void deleteJobPhaseNodeByJobPhaseIdAndLcd(@Param("jobPhaseId") Long jobPhaseId, @Param("lcd") Date lcd);

    Integer deleteJobPhaseNodeByJobPhaseIdAndLcdAndStatus(@Param("jobPhaseId") Long jobPhaseId, @Param("lcd") Date lcd, @Param("status") String status);

    void deleteJobPhaseNodeRunnerByJobPhaseIdAndLcdAndStatus(@Param("jobPhaseId") Long jobPhaseId, @Param("lcd") Date lcd, @Param("status") String status);

    void deleteJobEvnByJobId(Long jobId);

    void deleteJobInvokeByJobId(Long jobId);

    void deleteJobResourceInspectByJobId(Long jobId);

    void deleteJobPhaseRunnerByJobPhaseIdAndRunnerMapId(@Param("jobPhaseId") Long id, @Param("runnerMapId") Long runnerMapId);

}
