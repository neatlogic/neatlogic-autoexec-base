package codedriver.framework.autoexec.dto.job;

import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;
import codedriver.framework.util.SnowflakeUtil;

import java.io.Serializable;

/**
 * @author longrf
 * @date 2022/4/27 11:04 上午
 */
public class AutoexecJobSqlVo implements Serializable {
    private static final long serialVersionUID = -3975625036003451623L;

    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "作业id", type = ApiParamType.LONG)
    private Long jobId;
    @EntityField(name = "执行sql文件id", type = ApiParamType.LONG)
    private Long sqlId;

    public AutoexecJobSqlVo() {
    }

    public AutoexecJobSqlVo(Long jobId, Long sqlId) {
        this.jobId = jobId;
        this.sqlId = sqlId;
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

    public Long getSqlId() {
        return sqlId;
    }

    public void setSqlId(Long sqlId) {
        this.sqlId = sqlId;
    }
}
