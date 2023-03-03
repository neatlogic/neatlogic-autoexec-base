/*
Copyright(c) $today.year NeatLogic Co., Ltd. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package neatlogic.framework.autoexec.dto.job;

import neatlogic.framework.autoexec.constvalue.JobSource;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;
import org.apache.commons.lang3.StringUtils;

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
    @EntityField(name = "来源类型", type = ApiParamType.STRING)
    private String type;
    private int count;

    public AutoexecJobInvokeVo() {
    }

    public AutoexecJobInvokeVo(Long jobId,Long invokeId, String source, String type) {
        this.jobId = jobId;
        this.invokeId = invokeId;
        this.source = source;
        this.type = type;
    }

    public AutoexecJobInvokeVo(String source) {
        if (StringUtils.isBlank(source)) {
            this.source = JobSource.HUMAN.getValue();
        }
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
