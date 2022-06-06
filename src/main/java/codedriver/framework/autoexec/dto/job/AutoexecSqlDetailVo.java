package codedriver.framework.autoexec.dto.job;

import codedriver.framework.autoexec.constvalue.JobNodeStatus;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.common.dto.BaseEditorVo;
import codedriver.framework.restful.annotation.EntityField;
import codedriver.framework.util.SnowflakeUtil;
import codedriver.framework.util.TimeUtil;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.Objects;

/**
 * @author longrf
 * @date 2022/4/25 6:02 下午
 */
public class AutoexecSqlDetailVo extends BaseEditorVo {

    private static final long serialVersionUID = -3975625036032471623L;

    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "作业剧本节点id", type = ApiParamType.LONG)
    private Long nodeId;
    @EntityField(name = "作业剧本节点名称", type = ApiParamType.STRING)
    private String nodeName;
    @EntityField(name = "资源id", type = ApiParamType.LONG)
    private Long resourceId;
    @EntityField(name = "作业剧本id", type = ApiParamType.LONG)
    private Long phaseId;
    @EntityField(name = "作业剧本名", type = ApiParamType.STRING)
    private String phaseName;
    @EntityField(name = "sql文件名", type = ApiParamType.STRING)
    private String sqlFile;
    @EntityField(name = "用户名", type = ApiParamType.STRING)
    private String userName;
    @EntityField(name = "ip", type = ApiParamType.STRING)
    private String host;
    @EntityField(name = "端口", type = ApiParamType.INTEGER)
    private Integer port;
    @EntityField(name = "runner id", type = ApiParamType.LONG)
    private Long runnerId;
    @EntityField(name = "runner IP", type = ApiParamType.STRING)
    private String runnerHost;
    @EntityField(name = "runner 端口", type = ApiParamType.INTEGER)
    private Integer runnerPort;
    @EntityField(name = "状态", type = ApiParamType.STRING)
    private String status;
    @EntityField(name = "状态名", type = ApiParamType.STRING)
    private String statusName;
    @EntityField(name = "完成率", type = ApiParamType.INTEGER)
    private Integer completionRate = 0;
    @EntityField(name = "md5", type = ApiParamType.STRING)
    private String md5;
    @EntityField(name = "作业id", type = ApiParamType.LONG)
    private Long jobId;
    @EntityField(name = "是否已经被删除", type = ApiParamType.INTEGER)
    private Integer isDelete = 0;
    @EntityField(name = "开始时间", type = ApiParamType.LONG)
    private Date startTime;
    @EntityField(name = "结束时间", type = ApiParamType.LONG)
    private Date endTime;
    @EntityField(name = "耗时", type = ApiParamType.STRING)
    private String costTime;

    public AutoexecSqlDetailVo(JSONObject paramObj) {
        this.jobId = (paramObj.getLong("jobId"));
        this.nodeId = (paramObj.getLong("nodeId"));
        this.resourceId = (paramObj.getLong("resourceId"));
        this.nodeName = (paramObj.getString("nodeName"));
        this.phaseName = (paramObj.getString("phaseName"));
        this.userName = (paramObj.getString("userName"));
        this.status = (paramObj.getString("status"));
        this.sqlFile = (paramObj.getString("sqlFile"));
        this.md5 = (paramObj.getString("md5"));
        this.host = (paramObj.getString("host"));
        this.port = (paramObj.getInteger("port"));
    }

    public AutoexecSqlDetailVo() {
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

    public Long getNodeId() {
        return nodeId;
    }

    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public Long getPhaseId() {
        return phaseId;
    }

    public void setPhaseId(Long phaseId) {
        this.phaseId = phaseId;
    }

    public String getPhaseName() {
        return phaseName;
    }

    public void setPhaseName(String phaseName) {
        this.phaseName = phaseName;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSqlFile() {
        return sqlFile;
    }

    public void setSqlFile(String sqlFile) {
        this.sqlFile = sqlFile;
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

    public Long getRunnerId() {
        return runnerId;
    }

    public void setRunnerId(Long runnerId) {
        this.runnerId = runnerId;
    }

    public String getRunnerHost() {
        return runnerHost;
    }

    public void setRunnerHost(String runnerHost) {
        this.runnerHost = runnerHost;
    }

    public Integer getRunnerPort() {
        return runnerPort;
    }

    public void setRunnerPort(Integer runnerPort) {
        this.runnerPort = runnerPort;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusName() {
        if (StringUtils.isBlank(statusName) && StringUtils.isNotBlank(status)) {
            statusName = JobNodeStatus.getText(status);
        }
        return statusName;
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

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
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
}
