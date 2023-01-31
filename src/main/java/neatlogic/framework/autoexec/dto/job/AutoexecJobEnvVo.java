/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.autoexec.dto.job;

import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;

/**
 * @author lvzk
 * @since 2021/9/16 15:35
 **/
public class AutoexecJobEnvVo {
    @EntityField(name = "作业id", type = ApiParamType.LONG)
    private Long jobId;
    @EntityField(name = "作业环境变量名", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "作业环境变量值", type = ApiParamType.STRING)
    private String value;

    public AutoexecJobEnvVo() {
    }

    public AutoexecJobEnvVo(Long jobId, String name, String value) {
        this.jobId = jobId;
        this.name = name;
        this.value = value;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
