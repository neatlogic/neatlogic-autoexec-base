/*Copyright (C) $today.year  深圳极向量科技有限公司 All Rights Reserved.

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.*/

package neatlogic.framework.autoexec.dto.job;

import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;

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
    @EntityField(name = "配置路由id", type = ApiParamType.STRING)
    private String routeId;
    private int count;

    public AutoexecJobInvokeVo() {
    }

    public AutoexecJobInvokeVo(Long jobId,Long invokeId, String source, String type, String routeId) {
        this.jobId = jobId;
        this.invokeId = invokeId;
        this.source = source;
        this.type = type;
        this.routeId = routeId;
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

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }
}
