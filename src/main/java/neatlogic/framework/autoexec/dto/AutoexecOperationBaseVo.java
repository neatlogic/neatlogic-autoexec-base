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

package neatlogic.framework.autoexec.dto;

import com.alibaba.fastjson.annotation.JSONField;
import neatlogic.framework.autoexec.constvalue.CombopOperationType;
import neatlogic.framework.autoexec.constvalue.ScriptExecMode;
import neatlogic.framework.autoexec.constvalue.ToolType;
import neatlogic.framework.autoexec.dto.catalog.AutoexecCatalogVo;
import neatlogic.framework.autoexec.dto.script.AutoexecScriptVo;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.common.dto.BaseEditorVo;
import neatlogic.framework.restful.annotation.EntityField;
import neatlogic.framework.util.SnowflakeUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Objects;

/**
 * @author laiwt
 * @since 2022/04/7 11:59
 **/
public class AutoexecOperationBaseVo extends BaseEditorVo {
    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "唯一标识", type = ApiParamType.STRING)
    private String uk;
    @EntityField(name = "名称", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "执行方式", type = ApiParamType.STRING)
    private String execMode;
    @EntityField(name = "执行方式显示文本", type = ApiParamType.STRING)
    private String execModeText;
    @EntityField(name = "分类ID", type = ApiParamType.LONG)
    private Long typeId;
    @EntityField(name = "工具目录ID", type = ApiParamType.LONG)
    private Long catalogId;
    @EntityField(name = "工具目录名称", type = ApiParamType.STRING)
    private String catalogName;
    @EntityField(name = "工具完整目录名称", type = ApiParamType.STRING)
    private String fullCatalogName;
    @EntityField(name = "操作级别ID", type = ApiParamType.LONG)
    private Long riskId;
    @EntityField(name = "操作级别名称", type = ApiParamType.STRING)
    private String riskName;
    @EntityField(name = "分类名称", type = ApiParamType.STRING)
    private String typeName;
    @EntityField(name = "分类描述", type = ApiParamType.STRING)
    private String typeDescription;
    @EntityField(name = "操作级别")
    private AutoexecRiskVo riskVo;
    @EntityField(name = "脚本编码", type = ApiParamType.STRING)
    private String encoding;
    @EntityField(name = "脚本解析器", type = ApiParamType.STRING)
    private String parser;
    @EntityField(name = "自定义模版ID", type = ApiParamType.LONG)
    private Long customTemplateId;
    @EntityField(name = "自定义模版名称", type = ApiParamType.STRING)
    private String customTemplateName;
    @EntityField(name = "描述说明", type = ApiParamType.STRING)
    private String description;
    @EntityField(name = "自由参数", type = ApiParamType.JSONOBJECT)
    private AutoexecParamVo argument;
    @EntityField(name = "参数列表", type = ApiParamType.JSONARRAY)
    private List<AutoexecParamVo> paramList;
    @EntityField(name = "输入参数列表", type = ApiParamType.JSONARRAY)
    private List<AutoexecParamVo> inputParamList;
    @EntityField(name = "输出参数列表", type = ApiParamType.JSONARRAY)
    private List<AutoexecParamVo> outputParamList;
    @EntityField(name = "类型(tool:工具;script:脚本)", type = ApiParamType.ENUM, member = ToolType.class)
    private String type;

    @JSONField(serialize = false)
    private String configStr;
    @JSONField(serialize = false)
    private List<Long> typeIdList;
    @JSONField(serialize = false)
    private List<Long> catalogIdList;
    @JSONField(serialize = false)
    private List<Long> riskIdList;
    @JSONField(serialize = false)
    private List<Long> customTemplateIdList;

    public AutoexecOperationBaseVo() {

    }

    public AutoexecOperationBaseVo(AutoexecToolVo autoexecToolVo) {
        this.id = autoexecToolVo.getId();
        this.uk = autoexecToolVo.getUk();
        this.name = autoexecToolVo.getName();
        this.type = CombopOperationType.TOOL.getValue();
        this.execMode = autoexecToolVo.getExecMode();
        this.typeId = autoexecToolVo.getTypeId();
        this.typeName = autoexecToolVo.getTypeName();
        this.riskId = autoexecToolVo.getRiskId();
        this.description = autoexecToolVo.getDescription();
    }

    public AutoexecOperationBaseVo(AutoexecScriptVo autoexecScriptVo) {
        this.id = autoexecScriptVo.getId();
        this.uk = autoexecScriptVo.getUk();
        this.name = autoexecScriptVo.getName();
        this.type = CombopOperationType.SCRIPT.getValue();
        this.execMode = autoexecScriptVo.getExecMode();
        this.typeId = autoexecScriptVo.getTypeId();
        this.typeName = autoexecScriptVo.getTypeName();
        this.riskId = autoexecScriptVo.getRiskId();
        this.description = autoexecScriptVo.getDescription();
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

    public String getUk() {
        return uk;
    }

    public void setUk(String uk) {
        this.uk = uk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExecMode() {
        return execMode;
    }

    public void setExecMode(String execMode) {
        this.execMode = execMode;
    }

    public String getExecModeText() {
        if (StringUtils.isNotBlank(execMode)) {
            ScriptExecMode mode = ScriptExecMode.getExecMode(this.execMode);
            if (mode != null) {
                execModeText = mode.getText();
            }
        }
        return execModeText;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Long catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        if (Objects.equals(catalogId, AutoexecCatalogVo.ROOT_ID)) {
            catalogName = AutoexecCatalogVo.ROOT_NAME;
        }
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public Long getRiskId() {
        return riskId;
    }

    public void setRiskId(Long riskId) {
        this.riskId = riskId;
    }

    public String getRiskName() {
        return riskName;
    }

    public void setRiskName(String riskName) {
        this.riskName = riskName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeDescription() {
        return typeDescription;
    }

    public void setTypeDescription(String typeDescription) {
        this.typeDescription = typeDescription;
    }

    public AutoexecRiskVo getRiskVo() {
        return riskVo;
    }

    public void setRiskVo(AutoexecRiskVo riskVo) {
        this.riskVo = riskVo;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String getParser() {
        return parser;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setParser(String parser) {
        this.parser = parser;
    }

    public Long getCustomTemplateId() {
        return customTemplateId;
    }

    public void setCustomTemplateId(Long customTemplateId) {
        this.customTemplateId = customTemplateId;
    }

    public String getCustomTemplateName() {
        return customTemplateName;
    }

    public void setCustomTemplateName(String customTemplateName) {
        this.customTemplateName = customTemplateName;
    }

    public AutoexecParamVo getArgument() {
        return argument;
    }

    public void setArgument(AutoexecParamVo argument) {
        this.argument = argument;
    }

    public List<AutoexecParamVo> getParamList() {
        return paramList;
    }

    public void setParamList(List<AutoexecParamVo> paramList) {
        this.paramList = paramList;
    }

    public List<AutoexecParamVo> getInputParamList() {
        return inputParamList;
    }

    public void setInputParamList(List<AutoexecParamVo> inputParamList) {
        this.inputParamList = inputParamList;
    }

    public List<AutoexecParamVo> getOutputParamList() {
        return outputParamList;
    }

    public void setOutputParamList(List<AutoexecParamVo> outputParamList) {
        this.outputParamList = outputParamList;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getConfigStr() {
        return configStr;
    }

    public void setConfigStr(String configStr) {
        this.configStr = configStr;
    }

    public List<Long> getTypeIdList() {
        return typeIdList;
    }

    public void setTypeIdList(List<Long> typeIdList) {
        this.typeIdList = typeIdList;
    }

    public List<Long> getCatalogIdList() {
        return catalogIdList;
    }

    public void setCatalogIdList(List<Long> catalogIdList) {
        this.catalogIdList = catalogIdList;
    }

    public List<Long> getRiskIdList() {
        return riskIdList;
    }

    public void setRiskIdList(List<Long> riskIdList) {
        this.riskIdList = riskIdList;
    }

    public List<Long> getCustomTemplateIdList() {
        return customTemplateIdList;
    }

    public void setCustomTemplateIdList(List<Long> customTemplateIdList) {
        this.customTemplateIdList = customTemplateIdList;
    }

    public String getFullCatalogName() {
        return fullCatalogName;
    }

    public void setFullCatalogName(String fullCatalogName) {
        this.fullCatalogName = fullCatalogName;
    }
}
