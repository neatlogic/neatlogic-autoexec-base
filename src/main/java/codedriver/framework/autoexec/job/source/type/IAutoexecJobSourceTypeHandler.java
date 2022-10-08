/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.job.source.type;

import codedriver.framework.autoexec.dto.INodeDetail;
import codedriver.framework.autoexec.dto.combop.AutoexecCombopPhaseVo;
import codedriver.framework.autoexec.dto.combop.AutoexecCombopVo;
import codedriver.framework.autoexec.dto.job.AutoexecJobPhaseNodeVo;
import codedriver.framework.autoexec.dto.job.AutoexecJobPhaseVo;
import codedriver.framework.autoexec.dto.job.AutoexecJobVo;
import codedriver.framework.autoexec.dto.job.AutoexecSqlNodeDetailVo;
import codedriver.framework.dto.runner.RunnerMapVo;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @author lvzk
 * @since 2022/05/30 11:29
 **/
public interface IAutoexecJobSourceTypeHandler {

    /**
     * 来源
     *
     * @return 来源
     */
    String getName();

    /**
     * 保存作业阶段
     *
     * @param combopPhaseVo 组合工具｜流水线阶段
     */
    void saveJobPhase(AutoexecCombopPhaseVo combopPhaseVo);

    /**
     * 获取作业sql内容
     *
     * @param jobVo 作业vo
     * @return sql内容
     */
    JSONObject getJobSqlContent(AutoexecJobVo jobVo);

    /**
     * 下载作业sql文件
     *
     * @param jobVo 作业vo
     * @throws Exception 异常
     */
    void downloadJobSqlFile(AutoexecJobVo jobVo) throws Exception;

    /**
     * 重置sql文件状态
     *
     * @param paramObj 入参
     */
    void resetSqlStatus(JSONObject paramObj, AutoexecJobVo jobVo);

    /**
     * 获取作业sqlIdList 和 执行节点list
     *
     * @param paramObj 入参
     * @param jobVo    作业
     * @return sqlIdList
     */
    List<Long> getSqlIdsAndExecuteJobNodes(JSONObject paramObj, AutoexecJobVo jobVo);

    int searchJobPhaseSqlCount(AutoexecJobPhaseNodeVo jobPhaseNodeVo);

    /**
     * 查询作业剧本sql（管理页）
     *
     * @param jobPhaseNodeVo 节点vo
     * @return sql列表和分页数据
     */
    JSONObject searchJobPhaseSql(AutoexecJobPhaseNodeVo jobPhaseNodeVo);

    List<? extends INodeDetail> searchJobPhaseSqlForExport(AutoexecJobPhaseNodeVo jobPhaseNodeVo);

    /**
     * 检查作业执行sql文件状态(多删少补，不更新状态)
     *
     * @param paramObj 入参
     */
    void checkinSqlList(JSONObject paramObj);

    /**
     * 更新sql文件状态(存在则更新，不存在则新增)
     *
     * @param paramObj 入参
     */
    void updateSqlStatus(JSONObject paramObj);


    /**
     * 获取sql详情
     *
     * @param jobVo 作业入参
     * @return sql详情
     */
    AutoexecSqlNodeDetailVo getSqlDetail(AutoexecJobVo jobVo);

    /**
     * 获取runnerMapList
     *
     * @param jobVo 作业参数
     */
    List<RunnerMapVo> getRunnerMapList(AutoexecJobVo jobVo);

    /**
     * @param jobId       作业id
     * @param runnerMapId runner映射id
     */
    default void updateJobRunnerMap(Long jobId, Long runnerMapId) {
    }

    /**
     * 获取组合工具｜流水线
     *
     * @param autoexecJobParam 入参
     * @return 组合工具｜流水线
     */
    AutoexecCombopVo getAutoexecCombop(AutoexecJobVo autoexecJobParam);

    /**
     * 更新作业关系表，如：发布作业表
     *
     * @param paramJson 入参
     * @param jobVo     作业
     */
    default void updateInvokeJob(AutoexecJobVo jobVo) {
    }

    ;

    /**
     * 获取 params.json
     *
     * @param jsonObject params
     * @param jobVo      作业
     */
    void getFireParamJson(JSONObject jsonObject, AutoexecJobVo jobVo);


    /**
     * 获取 sqlId 对应的node节点List
     *
     * @param sqlIdList sqlId列表
     * @return node节点List
     */
    List<AutoexecJobPhaseNodeVo> getJobNodeListBySqlIdList(List<Long> sqlIdList);


    /**
     * 是否可以更新阶段runner
     *
     * @param jobPhaseVo  作业阶段
     * @param runnerMapId 执行器id
     * @return 是｜否
     */
    boolean getIsCanUpdatePhaseRunner(AutoexecJobPhaseVo jobPhaseVo, Long runnerMapId);

    /**
     * 执行用户是否可以执行作业
     *
     * @param jobVo 作业
     */
    void executeAuthCheck(AutoexecJobVo jobVo, boolean isNeedCheckTakeOver);

    /**
     * 获取对应管理员权限
     *
     * @return 管理员权限列表
     */
    List<String> getModifyAuthList();

    /**
     * 补充作业权限 目前用于前端控制按钮
     *
     * @param jobVo 作业
     */
    void getJobActionAuth(AutoexecJobVo jobVo);

    /**
     * 获取 组合工具｜流水线快照
     *
     * @param autoexecJobParam 作业
     * @return 快照
     */
    AutoexecCombopVo getSnapshotAutoexecCombop(AutoexecJobVo autoexecJobParam);

    /**
     * 更新sql状态
     *
     * @param sqlIdList sqlId
     * @param status    状态
     */
    void updateSqlStatus(List<Long> sqlIdList, String status);

    /**
     * 获取创建作业的payload
     *
     * @param jobVo  作业
     * @param result payload
     */
    void getCreatePayload(AutoexecJobVo jobVo, JSONObject result);
}
