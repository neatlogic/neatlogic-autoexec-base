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

package neatlogic.framework.autoexec.dto.job;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import neatlogic.framework.autoexec.dto.combop.AutoexecCombopGroupConfigVo;
import neatlogic.framework.autoexec.dto.combop.AutoexecCombopGroupVo;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;
import neatlogic.framework.util.SnowflakeUtil;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * 组合工具组Vo类
 **/
public class AutoexecJobGroupVo implements Serializable {
    private static final long serialVersionUID = 485296946031942137L;
    @EntityField(name = "作业id", type = ApiParamType.LONG)
    private Long jobId;
    @EntityField(name = "组id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "阶段序号", type = ApiParamType.INTEGER)
    private Integer sort;
    @EntityField(name = "策略", type = ApiParamType.STRING)
    private String policy;
    @EntityField(name = "执行目标配置", type = ApiParamType.JSONOBJECT)
    private AutoexecCombopGroupConfigVo config;
    @EntityField(name = "最近一次节点变动时间", type = ApiParamType.STRING)
    private Date lncd;
    @EntityField(name = "分批数", type = ApiParamType.INTEGER)
    private Integer roundCount;
    @EntityField(name = "并发数", type = ApiParamType.INTEGER)
    private Integer parallelCount;
    @EntityField(name = "并发策略", type = ApiParamType.STRING)
    private String parallelPolicy;
    @EntityField(name = "并发策略来源", type = ApiParamType.STRING)
    private String parallelFrom;
    @JSONField(serialize = false)
    private String configStr;

    public Long getId() {
        if (id == null) {
            id = SnowflakeUtil.uniqueLong();
        }
        return id;
    }

    public AutoexecJobGroupVo() {
    }

    public AutoexecJobGroupVo(AutoexecCombopGroupVo combopGroupVo) {
        this.sort = combopGroupVo.getSort();
        this.policy = combopGroupVo.getPolicy();
        this.config = combopGroupVo.getConfig();
        if (combopGroupVo.getConfig() != null && combopGroupVo.getConfig().getExecuteConfig() != null) {
            this.roundCount = combopGroupVo.getConfig().getExecuteConfig().getRoundCount();
        }
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public String getConfigStr() {
        if (config != null) {
            configStr = JSON.toJSONString(config);
        }
        return configStr;
    }

    public void setConfigStr(String configStr) {
        this.configStr = configStr;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public AutoexecCombopGroupConfigVo getConfig() {
        if (StringUtils.isNotBlank(configStr)) {
            config = JSON.parseObject(configStr, AutoexecCombopGroupConfigVo.class);
        }
        return config;
    }

    public Date getLncd() {
        return lncd;
    }

    public void setLncd(Date lncd) {
        this.lncd = lncd;
    }

    public Integer getRoundCount() {
        return roundCount;
    }

    public void setRoundCount(Integer roundCount) {
        this.roundCount = roundCount;
    }

    public void setConfig(AutoexecCombopGroupConfigVo config) {
        this.config = config;
    }

    public Integer getParallelCount() {
        return parallelCount;
    }

    public void setParallelCount(Integer parallelCount) {
        this.parallelCount = parallelCount;
    }

    public String getParallelPolicy() {
        return parallelPolicy;
    }

    public void setParallelPolicy(String parallelPolicy) {
        this.parallelPolicy = parallelPolicy;
    }

    public String getParallelFrom() {
        return parallelFrom;
    }

    public void setParallelFrom(String parallelFrom) {
        this.parallelFrom = parallelFrom;
    }
}
