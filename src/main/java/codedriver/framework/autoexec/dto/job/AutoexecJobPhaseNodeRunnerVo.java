/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.job;

/**
 * @author lvzk
 * @since 2021/5/31 18:10
 **/
public class AutoexecJobPhaseNodeRunnerVo {
    private Long jobId;
    private Long nodeId;
    private Integer runnerId;

    public Long getNodeId() {
        return nodeId;
    }

    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getRunnerId() {
        return runnerId;
    }

    public void setRunnerId(Integer runnerId) {
        this.runnerId = runnerId;
    }
}
