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

package neatlogic.framework.autoexec.dto.customtemplate;

import com.alibaba.fastjson.annotation.JSONField;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.common.dto.BaseEditorVo;
import neatlogic.framework.restful.annotation.EntityField;
import neatlogic.framework.util.SnowflakeUtil;

public class CustomTemplateVo extends BaseEditorVo {
    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "名称", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "模板", type = ApiParamType.STRING)
    private String template;
    @EntityField(name = "配置文本", type = ApiParamType.STRING)
    private String config;
    @EntityField(name = "是否激活", type = ApiParamType.INTEGER)
    private Integer isActive;
    @EntityField(name = "关联的工具数", type = ApiParamType.INTEGER)
    private Integer referenceCount = 0;
    @JSONField(serialize = false)
    private Integer referenceCountForTool = 0;//关联的工具数
    @JSONField(serialize = false)
    private Integer referenceCountForScript = 0;//关联的自定义工具数
    @EntityField(name = "工具ID", type = ApiParamType.LONG)
    private Long operationId;

    public Long getId() {
        if (id == null) {
            id = SnowflakeUtil.uniqueLong();
        }
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

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public Integer getReferenceCount() {
        referenceCount = (referenceCountForTool + referenceCountForScript);
        return referenceCount;
    }

    public Integer getReferenceCountForTool() {
        return referenceCountForTool;
    }

    public void setReferenceCountForTool(Integer referenceCountForTool) {
        this.referenceCountForTool = referenceCountForTool;
    }

    public Integer getReferenceCountForScript() {
        return referenceCountForScript;
    }

    public void setReferenceCountForScript(Integer referenceCountForScript) {
        this.referenceCountForScript = referenceCountForScript;
    }

    public Long getOperationId() {
        return operationId;
    }

    public void setOperationId(Long operationId) {
        this.operationId = operationId;
    }
}
