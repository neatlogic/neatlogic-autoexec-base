/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto;

import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.common.dto.BaseEditorVo;
import codedriver.framework.restful.annotation.EntityField;
import codedriver.framework.util.SnowflakeUtil;

public class AutoexecTypeVo extends BaseEditorVo {

    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "分类名", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "描述", type = ApiParamType.STRING)
    private String description;

    @EntityField(name = "关联的工具数",type = ApiParamType.INTEGER)
    private Integer referenceCountForTool = 0;

    @EntityField(name = "关联的自定义工具数",type = ApiParamType.INTEGER)
    private Integer referenceCountForScript = 0;

    @EntityField(name = "关联的组合工具数",type = ApiParamType.INTEGER)
    private Integer referenceCountForCombop = 0;

    public AutoexecTypeVo() {
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Integer getReferenceCountForCombop() {
        return referenceCountForCombop;
    }

    public void setReferenceCountForCombop(Integer referenceCountForCombop) {
        this.referenceCountForCombop = referenceCountForCombop;
    }
}
