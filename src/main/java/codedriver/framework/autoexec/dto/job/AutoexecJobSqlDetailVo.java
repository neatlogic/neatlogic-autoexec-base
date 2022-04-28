package codedriver.framework.autoexec.dto.job;

import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;
import codedriver.framework.util.SnowflakeUtil;
import com.alibaba.fastjson.JSONObject;

/**
 * @author longrf
 * @date 2022/4/25 6:02 下午
 */
public class AutoexecJobSqlDetailVo {

    private static final long serialVersionUID = -3975625036032471623L;

    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "作业剧本节点id", type = ApiParamType.LONG)
    private Long nodeId;
    @EntityField(name = "作业剧本节点名称", type = ApiParamType.STRING)
    private String nodeName;
    @EntityField(name = "资源id", type = ApiParamType.LONG)
    private Long resourceId;
    @EntityField(name = "sql文件名", type = ApiParamType.STRING)
    private String sqlFile;
    @EntityField(name = "ip", type = ApiParamType.STRING)
    private String host;
    @EntityField(name = "端口", type = ApiParamType.INTEGER)
    private Integer port;
    @EntityField(name = "状态", type = ApiParamType.STRING)
    private String status;
    @EntityField(name = "md5", type = ApiParamType.STRING)
    private String md5;
    @EntityField(name = "作业id", type = ApiParamType.LONG)
    private Long jobId;
    @EntityField(name = "是否已经被删除", type = ApiParamType.INTEGER)
    private Integer isDelete = 0;


    public AutoexecJobSqlDetailVo(JSONObject paramObj) {
        this.jobId = (paramObj.getLong("jobId"));
        this.nodeId = (paramObj.getLong("nodeId"));
        this.resourceId = (paramObj.getLong("resourceId"));
        this.status = (paramObj.getString("status"));
        this.sqlFile = (paramObj.getString("sqlFile"));
        this.md5 = (paramObj.getString("md5"));
        this.host = (paramObj.getString("host"));
        this.port = (paramObj.getInteger("port"));
    }

    public AutoexecJobSqlDetailVo() {
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

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
}
