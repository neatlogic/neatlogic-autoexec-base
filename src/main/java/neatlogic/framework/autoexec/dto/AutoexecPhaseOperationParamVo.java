/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.autoexec.dto;

import neatlogic.framework.autoexec.constvalue.CombopOperationType;
import neatlogic.framework.autoexec.dto.combop.ParamMappingVo;
import neatlogic.framework.autoexec.dto.script.AutoexecScriptVersionVo;
import neatlogic.framework.autoexec.dto.script.AutoexecScriptVo;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;
import org.apache.commons.collections4.CollectionUtils;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lvzk
 * @since 2021/7/26 11:44
 **/
public class AutoexecPhaseOperationParamVo implements Serializable {
    private static final long serialVersionUID = 4715534326975961852L;
    @EntityField(name = "参数名", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "工具id", type = ApiParamType.STRING)
    private Long operationId;
    @EntityField(name = "工具名", type = ApiParamType.STRING)
    private String operationName;
    @EntityField(name = "工具类型", type = ApiParamType.STRING)
    private String operationType;
    @EntityField(name = "解析器", type = ApiParamType.STRING)
    private String parser;
    @EntityField(name = "执行方式", type = ApiParamType.STRING)
    private String execMode;
    @EntityField(name = "入参列表", type = ApiParamType.JSONARRAY)
    private List<AutoexecParamVo> inputParamList;
    @EntityField(name = "出参列表", type = ApiParamType.JSONARRAY)
    private List<AutoexecParamVo> outputParamList;
    @EntityField(name = "自由参数映射列表", type = ApiParamType.JSONARRAY)
    private List<ParamMappingVo> argumentMappingList;
    @EntityField(name = "自由参数", type = ApiParamType.JSONOBJECT)
    private AutoexecParamVo argumentVo;
    @EntityField(name = "描述说明", type = ApiParamType.STRING)
    private String description;


    public AutoexecPhaseOperationParamVo() {
    }

    public AutoexecPhaseOperationParamVo(AutoexecToolVo toolVo) {
        this.name = toolVo.getName();
        this.operationId = toolVo.getId();
        this.operationName = toolVo.getName() + "_test";
        this.operationType = CombopOperationType.TOOL.getValue();
        this.parser = toolVo.getParser();
        this.inputParamList = toolVo.getInputParamList();
        this.outputParamList = toolVo.getOutputParamList();
        this.execMode = toolVo.getExecMode();
        this.argumentVo = toolVo.getArgument();
        this.description = toolVo.getDescription();
    }

    public AutoexecPhaseOperationParamVo(AutoexecScriptVo scriptVo, AutoexecScriptVersionVo scriptVersionVo) {
        this.name = scriptVo.getName();
        this.operationId = scriptVersionVo.getId();
        this.operationName = scriptVo.getName() + "_test";
        this.operationType = CombopOperationType.SCRIPT.getValue();
        this.parser = scriptVersionVo.getParser();
        if(CollectionUtils.isNotEmpty(scriptVersionVo.getInputParamList())) {
            this.inputParamList = scriptVersionVo.getInputParamList().stream().map(o -> (AutoexecParamVo) o).collect(Collectors.toList());
        }
        if(CollectionUtils.isNotEmpty(scriptVersionVo.getOutputParamList())) {
            this.outputParamList = scriptVersionVo.getOutputParamList().stream().map(o -> (AutoexecParamVo) o).collect(Collectors.toList());
        }
        this.execMode = scriptVo.getExecMode();
        this.argumentVo = scriptVo.getArgument();
        this.description = scriptVo.getDescription();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getOperationId() {
        return operationId;
    }

    public void setOperationId(Long operationId) {
        this.operationId = operationId;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getParser() {
        return parser;
    }

    public void setParser(String parser) {
        this.parser = parser;
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

    public String getExecMode() {
        return execMode;
    }

    public void setExecMode(String execMode) {
        this.execMode = execMode;
    }

    public List<ParamMappingVo> getArgumentMappingList() {
        return argumentMappingList;
    }

    public void setArgumentMappingList(List<ParamMappingVo> argumentMappingList) {
        this.argumentMappingList = argumentMappingList;
    }

    public AutoexecParamVo getArgumentVo() {
        return argumentVo;
    }

    public void setArgumentVo(AutoexecParamVo argumentVo) {
        this.argumentVo = argumentVo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
