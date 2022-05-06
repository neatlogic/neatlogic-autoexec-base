/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.job;

import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;

/**
 * @author lvzk
 * @since 2021/5/31 18:10
 **/
public class AutoexecJobPhaseNodeRunnerVo {
    @EntityField(name = "作业id", type = ApiParamType.LONG)
    private Long jobId;
    @EntityField(name = "作业剧本id", type = ApiParamType.LONG)
    private Long jobPhaseId;
    @EntityField(name = "作业剧本节点id", type = ApiParamType.LONG)
    private Long nodeId;
    @EntityField(name = "作业剧本runner 映射id", type = ApiParamType.LONG)
    private Long runnerMapId;

    public AutoexecJobPhaseNodeRunnerVo(AutoexecJobPhaseNodeVo nodeVo) {
        this.jobId = nodeVo.getJobId();
        this.jobPhaseId = nodeVo.getJobPhaseId();
        this.nodeId = nodeVo.getId();
        this.runnerMapId = nodeVo.getRunnerMapId();
    }

    public Long getNodeId() {
        return nodeId;
    }

    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }

    public Long getRunnerMapId() {
        return runnerMapId;
    }

    public void setRunnerMapId(Long runnerMapId) {
        this.runnerMapId = runnerMapId;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Long getJobPhaseId() {
        return jobPhaseId;
    }

    public void setJobPhaseId(Long jobPhaseId) {
        this.jobPhaseId = jobPhaseId;
    }
}
