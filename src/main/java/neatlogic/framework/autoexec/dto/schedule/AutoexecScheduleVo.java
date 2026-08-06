/*
 *
 * Copyright (C) 2025  TechSure Co., Ltd.  All Rights Reserved.
 * This file is part of the NeatLogic software.
 * Licensed under the NeatLogic Sustainable Use License (NSUL), Version 4.x – 2025.
 * You may use this file only in compliance with the License.
 * See the LICENSE file distributed with this work for the full license text.
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 */

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

    @EntityField(name = "term.autoexec.scheduleid", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "nfad.autoexecschedulevo.entityfield.uuid.name", type = ApiParamType.STRING)
    private String uuid;
    @EntityField(name = "term.autoexec.schedulename", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "term.autoexec.combopid", type = ApiParamType.LONG)
    private Long autoexecCombopId;
    @EntityField(name = "nfad.autoexecschedulevo.entityfield.autoexeccombopname.name", type = ApiParamType.STRING)
    private String autoexecCombopName;
    @EntityField(name = "nfad.autoexecschedulevo.entityfield.cron.name", type = ApiParamType.STRING)
    private String cron;
    @EntityField(name = "common.starttime", type = ApiParamType.LONG)
    private Date beginTime;
    @EntityField(name = "common.endtime", type = ApiParamType.LONG)
    private Date endTime;
    @EntityField(name = "nfad.autoexecschedulevo.entityfield.isactive.name", type = ApiParamType.INTEGER)
    private Integer isActive;
    @EntityField(name = "nfad.autoexecschedulevo.entityfield.execcount.name", type = ApiParamType.INTEGER)
    private Integer execCount;
    @EntityField(name = "nfad.autoexecschedulevo.entityfield.config.name", type = ApiParamType.JSONOBJECT)
    private JSONObject config;
    @JSONField(serialize = false)
    private String configStr;
    @EntityField(name = "common.editable", type = ApiParamType.INTEGER)
    private Integer editable;
    @EntityField(name = "nfad.autoexecschedulevo.entityfield.deletable.name", type = ApiParamType.INTEGER)
    private Integer deletable;
    @EntityField(name = "nfad.autoexecschedulevo.entityfield.jobstatus.name", type = ApiParamType.JSONOBJECT)
    private JobStatusVo jobStatus;

    // 记录定时作业配置最初由哪个应用服务器创建，用于按应用服务分组过滤管理页数据。
    private Integer sourceServerId;
    private String sourceServerGroup;

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

    public Integer getSourceServerId() {
        return sourceServerId;
    }

    public void setSourceServerId(Integer sourceServerId) {
        this.sourceServerId = sourceServerId;
    }

    public String getSourceServerGroup() {
        return sourceServerGroup;
    }

    public void setSourceServerGroup(String sourceServerGroup) {
        this.sourceServerGroup = sourceServerGroup;
    }
}
