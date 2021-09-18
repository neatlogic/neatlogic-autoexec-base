/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.job;

import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;

/**
 * @author lvzk
 * @since 2021/9/18 14:26
 **/
public class AutoexecJobInvokeVo {
    @EntityField(name = "作业id", type = ApiParamType.LONG)
    private Long jobId;
    @EntityField(name = "来源id", type = ApiParamType.LONG)
    private Long invokeId;
    @EntityField(name = "来源", type = ApiParamType.STRING)
    private String source;

    public AutoexecJobInvokeVo() {
    }

    public AutoexecJobInvokeVo(Long invokeId, String source) {
        this.invokeId = invokeId;
        this.source = source;
    }

    public AutoexecJobInvokeVo(String source) {
        this.source = source;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Long getInvokeId() {
        return invokeId;
    }

    public void setInvokeId(Long invokeId) {
        this.invokeId = invokeId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
