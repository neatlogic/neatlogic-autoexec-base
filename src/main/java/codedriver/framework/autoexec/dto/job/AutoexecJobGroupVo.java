/*
 * Copyright (c)  2022 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.job;

import codedriver.framework.autoexec.dto.combop.AutoexecCombopGroupVo;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;
import codedriver.framework.util.SnowflakeUtil;
import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * 组合工具组Vo类
 *
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
        this.id = combopGroupVo.getId();
        this.sort = combopGroupVo.getSort();
        this.policy = combopGroupVo.getPolicy();
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
}
