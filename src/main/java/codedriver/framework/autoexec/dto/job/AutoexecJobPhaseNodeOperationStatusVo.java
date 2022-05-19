/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.job;

import codedriver.framework.autoexec.constvalue.JobNodeStatus;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @author lvzk
 * @since 2021/5/28 14:58
 **/
public class AutoexecJobPhaseNodeOperationStatusVo {
    @EntityField(name = "作业剧本操作id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "作业剧本操作名", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "作业剧本节点操作类型 script|tool", type = ApiParamType.STRING)
    private String type;
    @EntityField(name = "解析器 python|perl等", type = ApiParamType.STRING)
    private String parser;
    @EntityField(name = "执行状态", type = ApiParamType.STRING)
    private String status;
    @EntityField(name = "执行状态名", type = ApiParamType.STRING)
    private String statusName;
    @EntityField(name = "是否失败忽略", type = ApiParamType.INTEGER)
    private final Integer failIgnore;
    @EntityField(name = "描述说明", type = ApiParamType.STRING)
    private String description;
    private final Integer sort;

    public AutoexecJobPhaseNodeOperationStatusVo(AutoexecJobPhaseOperationVo operationVo, JSONObject statusJson,String description) {
        this.id = operationVo.getId();
        this.name = operationVo.getName();
        this.type = operationVo.getType();
        this.parser = operationVo.getParser();
        this.status = JobNodeStatus.PENDING.getValue();
        if(MapUtils.isNotEmpty(statusJson)) {
            this.status = statusJson.getString(this.name + "_" + this.id);
        }
        this.sort = operationVo.getSort();
        this.failIgnore = operationVo.getFailIgnore();
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getParser() {
        return parser;
    }

    public void setParser(String parser) {
        this.parser = parser;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusName() {
        if(StringUtils.isBlank(statusName)&&StringUtils.isNotBlank(status)){
            statusName = JobNodeStatus.getText(status);
        }
        return statusName;
    }

    public Integer getSort() {
        return sort;
    }

    public Integer getFailIgnore() {
        return failIgnore;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
