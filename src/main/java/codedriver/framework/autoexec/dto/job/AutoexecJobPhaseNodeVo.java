/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.job;

import codedriver.framework.autoexec.constvalue.JobNodeStatus;
import codedriver.framework.autoexec.dto.AutoexecRunnerVo;
import codedriver.framework.autoexec.dto.combop.AutoexecCombopParamVo;
import codedriver.framework.autoexec.dto.node.AutoexecNodeVo;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.common.dto.BasePageVo;
import codedriver.framework.restful.annotation.EntityField;
import codedriver.framework.util.SnowflakeUtil;
import codedriver.framework.util.TimeUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author lvzk
 * @since 2021/4/12 16:12
 **/
public class AutoexecJobPhaseNodeVo extends BasePageVo implements Serializable {
    private static final long serialVersionUID = -3975625036282871623L;
    @EntityField(name = "作业剧本节点id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "作业id", type = ApiParamType.LONG)
    private Long jobId;
    @EntityField(name = "作业剧本id", type = ApiParamType.LONG)
    private Long jobPhaseId;
    @EntityField(name = "作业剧本名", type = ApiParamType.STRING)
    private String jobPhaseName;
    @EntityField(name = "作业剧本主机", type = ApiParamType.STRING)
    private String host;
    @EntityField(name = "作业剧本主机端口", type = ApiParamType.INTEGER)
    private Integer port;
    @EntityField(name = "执行目标账号", type = ApiParamType.STRING)
    private String userName;
    @EntityField(name = "执行目标账号", type = ApiParamType.STRING)
    private String password;
    @EntityField(name = "作业剧本节点状态", type = ApiParamType.STRING)
    private String status;
    @EntityField(name = "作业剧本代理id", type = ApiParamType.LONG)
    private Long runnerId;
    @EntityField(name = "作业剧本代理", type = ApiParamType.JSONOBJECT)
    private AutoexecRunnerVo autoexecRunnerVo;
    @EntityField(name = "开始时间", type = ApiParamType.STRING)
    private Date startTime;
    @EntityField(name = "结束时间", type = ApiParamType.STRING)
    private Date endTime;
    @EntityField(name = "作业耗时", type = ApiParamType.STRING)
    private String costTime;
    @EntityField(name = "节点Id", type = ApiParamType.LONG)
    private Long nodeId;
    @EntityField(name = "节点名称", type = ApiParamType.STRING)
    private String nodeName;
    @EntityField(name = "节点连接类型", type = ApiParamType.STRING)
    private String nodeType;
    @EntityField(name = "代理信息", type = ApiParamType.STRING)
    private String runnerUrl;
    @EntityField(name = "完成率", type = ApiParamType.INTEGER)
    private Integer completionRate = 0;
    @JSONField(serialize = false)
    private List<String> statusList;
    @EntityField(name = "作业节点状态Vo", type = ApiParamType.JSONOBJECT)
    private AutoexecJobStatusVo statusVo;


    public AutoexecJobPhaseNodeVo() {
    }

    public AutoexecJobPhaseNodeVo(Long jobId, String jobPhaseName) {
        this.jobId = jobId;
        this.jobPhaseName = jobPhaseName;
    }

    public AutoexecJobPhaseNodeVo(Long jobId, Long jobPhaseId, String host, Integer port, String status, String userName) {
        this.jobId = jobId;
        this.jobPhaseId = jobPhaseId;
        this.status = status;
        this.userName = userName;
        this.host = host;
        this.port = port;
    }

    public AutoexecJobPhaseNodeVo(JSONObject jsonObj) {
        this.jobId = jsonObj.getLong("jobId");
        this.jobPhaseName = jsonObj.getString("phase");
        this.id = jsonObj.getLong("nodeId");
        this.host = jsonObj.getString("host");
        this.port = jsonObj.getInteger("port");
        this.status = jsonObj.getString("status");
    }

    public AutoexecJobPhaseNodeVo(AutoexecNodeVo nodeVo) {
        this.host = nodeVo.getHost();
        this.port = nodeVo.getPort();
    }

    public AutoexecJobPhaseNodeVo(AutoexecCombopParamVo paramVo) {

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

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Long getJobPhaseId() {
        return jobPhaseId;
    }

    public String getJobPhaseName() {
        return jobPhaseName;
    }

    public void setJobPhaseName(String jobPhaseName) {
        this.jobPhaseName = jobPhaseName;
    }

    public void setJobPhaseId(Long jobPhaseId) {
        this.jobPhaseId = jobPhaseId;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getRunnerId() {
        return runnerId;
    }

    public void setRunnerId(Long runnerId) {
        this.runnerId = runnerId;
    }

    public List<String> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<String> statusList) {
        this.statusList = statusList;
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

    public Long getNodeId() {
        return nodeId;
    }

    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getNodeType() {
        return nodeType;
    }

    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }

    public String getRunnerUrl() {
        return runnerUrl;
    }

    public void setRunnerUrl(String runnerUrl) {
        this.runnerUrl = runnerUrl;
    }

    public AutoexecRunnerVo getAutoexecRunnerVo() {
        return autoexecRunnerVo;
    }

    public void setAutoexecRunnerVo(AutoexecRunnerVo autoexecRunnerVo) {
        this.autoexecRunnerVo = autoexecRunnerVo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AutoexecJobPhaseNodeVo vo = (AutoexecJobPhaseNodeVo) o;
        return Objects.equals(vo.getHost(), host) && Objects.equals(vo.getPort(), port);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    public Integer getCompletionRate() {
        if (StringUtils.isNotBlank(status) && Objects.equals(JobNodeStatus.SUCCEED.getValue(), status)) {
            return 100;
        }
        return completionRate;
    }

    public void setCompletionRate(Integer completionRate) {
        this.completionRate = completionRate;
    }

    public AutoexecJobStatusVo getStatusVo() {
        if (statusVo == null && StringUtils.isNotBlank(status)) {
            return new AutoexecJobStatusVo(status, JobNodeStatus.getText(status), JobNodeStatus.getColor(status));
        }
        return statusVo;
    }
}
