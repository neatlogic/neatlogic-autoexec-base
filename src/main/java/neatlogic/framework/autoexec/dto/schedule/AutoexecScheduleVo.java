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

package neatlogic.framework.autoexec.dto.schedule;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.common.dto.BaseEditorVo;
import neatlogic.framework.restful.annotation.EntityField;
import neatlogic.framework.scheduler.dto.JobStatusVo;
import neatlogic.framework.util.SnowflakeUtil;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.UUID;

/**
 * @author linbq
 * @since 2021/9/29 17:08
 **/
public class AutoexecScheduleVo extends BaseEditorVo {

    @EntityField(name = "定时作业id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "定时作业uuid", type = ApiParamType.STRING)
    private String uuid;
    @EntityField(name = "定时作业名称", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "组合工具id", type = ApiParamType.LONG)
    private Long autoexecCombopId;
    @EntityField(name = "组合工具名称", type = ApiParamType.STRING)
    private String autoexecCombopName;
    @EntityField(name = "cron表达式", type = ApiParamType.STRING)
    private String cron;
    @EntityField(name = "开始时间", type = ApiParamType.LONG)
    private Date beginTime;
    @EntityField(name = "结束时间", type = ApiParamType.LONG)
    private Date endTime;
    @EntityField(name = "状态(0:禁用，1：启用)", type = ApiParamType.INTEGER)
    private Integer isActive;
    @EntityField(name = "执行次数", type = ApiParamType.INTEGER)
    private Integer execCount;
    @EntityField(name = "执行配置信息", type = ApiParamType.JSONOBJECT)
    private JSONObject config;
    @JSONField(serialize = false)
    private String configStr;
    @EntityField(name = "是否可编辑", type = ApiParamType.INTEGER)
    private Integer editable;
    @EntityField(name = "是否可删除", type = ApiParamType.INTEGER)
    private Integer deletable;
    @EntityField(name = "执行情况", type = ApiParamType.JSONOBJECT)
    private JobStatusVo jobStatus;

    public Long getId() {
        if (id == null) {
            id = SnowflakeUtil.uniqueLong();
        }
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        if (StringUtils.isBlank(uuid)) {
            uuid = UUID.randomUUID().toString().replace("-", "");
        }
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAutoexecCombopId() {
        return autoexecCombopId;
    }

    public void setAutoexecCombopId(Long autoexecCombopId) {
        this.autoexecCombopId = autoexecCombopId;
    }

    public String getAutoexecCombopName() {
        return autoexecCombopName;
    }

    public void setAutoexecCombopName(String autoexecCombopName) {
        this.autoexecCombopName = autoexecCombopName;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public Integer getExecCount() {
        if (execCount == null) {
            execCount = 0;
        }
        return execCount;
    }

    public void setExecCount(Integer execCount) {
        this.execCount = execCount;
    }

    public JSONObject getConfig() {
        if (MapUtils.isEmpty(config) && StringUtils.isNotBlank(configStr)) {
            config = JSONObject.parseObject(configStr);
        }
        return config;
    }

    public void setConfig(JSONObject config) {
        this.config = config;
    }

    public String getConfigStr() {
        if (StringUtils.isEmpty(configStr) && MapUtils.isNotEmpty(config)) {
            configStr = config.toJSONString();
        }
        return configStr;
    }

    public void setConfigStr(String configStr) {
        this.configStr = configStr;
    }

    public Integer getEditable() {
        return editable;
    }

    public void setEditable(Integer editable) {
        this.editable = editable;
    }

    public Integer getDeletable() {
        return deletable;
    }

    public void setDeletable(Integer deletable) {
        this.deletable = deletable;
    }

    public JobStatusVo getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(JobStatusVo jobStatus) {
        this.jobStatus = jobStatus;
    }
}
