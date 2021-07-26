/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto;

import codedriver.framework.autoexec.constvalue.CombopOperationType;
import codedriver.framework.autoexec.dto.script.AutoexecScriptVersionVo;
import codedriver.framework.autoexec.dto.script.AutoexecScriptVo;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lvzk
 * @since 2021/7/26 11:44
 **/
public class AutoexecPhaseOperationParamVo implements Serializable {
    private static final long serialVersionUID = 4715534326975961852L;
    private String name;
    private Long operationId;
    private String operationName;
    private String operationType;
    private String parser;
    private String execMode;
    private List<AutoexecParamVo> inputParamList;
    private List<AutoexecParamVo> outputParamList;

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
    }

    public AutoexecPhaseOperationParamVo(AutoexecScriptVo scriptVo, AutoexecScriptVersionVo scriptVersionVo) {
        this.name = scriptVo.getName();
        this.operationId = scriptVersionVo.getId();
        this.operationName = scriptVo.getName() + "_test";
        this.operationType = CombopOperationType.SCRIPT.getValue();
        this.parser = scriptVersionVo.getParser();
        this.inputParamList = scriptVersionVo.getInputParamList().stream().map(o->(AutoexecParamVo)o).collect(Collectors.toList());
        this.outputParamList = scriptVersionVo.getOutputParamList().stream().map(o->(AutoexecParamVo)o).collect(Collectors.toList());
        this.execMode = scriptVo.getExecMode();
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
}
