/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto;

import codedriver.framework.autoexec.constvalue.ParamMode;
import codedriver.framework.autoexec.constvalue.ToolType;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.common.dto.BaseEditorVo;
import codedriver.framework.restful.annotation.EntityField;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AutoexecToolAndScriptVo extends BaseEditorVo {

    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "唯一标识", type = ApiParamType.STRING)
    private String uk;
    @EntityField(name = "名称", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "类型(tool:工具;script:脚本)", type = ApiParamType.ENUM, member = ToolType.class)
    private String type;
    @EntityField(name = "执行方式", type = ApiParamType.STRING)
    private String execMode;
    @EntityField(name = "分类ID", type = ApiParamType.LONG)
    private Long typeId;
    @EntityField(name = "分类名称", type = ApiParamType.STRING)
    private String typeName;
    @EntityField(name = "操作级别ID", type = ApiParamType.LONG)
    private Long riskId;
    @EntityField(name = "操作级别名称", type = ApiParamType.STRING)
    private String riskName;
    @EntityField(name = "操作级别颜色", type = ApiParamType.STRING)
    private String riskColor;
    @EntityField(name = "操作级别")
    private AutoexecRiskVo riskVo;

    @EntityField(name = "参数列表", type = ApiParamType.JSONARRAY)
    @JSONField(serialize = false)
    private transient List<AutoexecParamVo> paramList;
    @EntityField(name = "入参列表", type = ApiParamType.JSONARRAY)
    private List<AutoexecParamVo> inputParamList;
    @EntityField(name = "出参列表", type = ApiParamType.JSONARRAY)
    private List<AutoexecParamVo> outputParamList;

    @JSONField(serialize = false)
    private transient String configStr;//工具的参数配置

    @JSONField(serialize = false)
    private transient List<Long> typeIdList;

    @JSONField(serialize = false)
    private transient List<Long> riskIdList;

    public AutoexecToolAndScriptVo() {
    }

    public Long getId() {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExecMode() {
        return execMode;
    }

    public void setExecMode(String execMode) {
        this.execMode = execMode;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getRiskId() {
        return riskId;
    }

    public void setRiskId(Long riskId) {
        this.riskId = riskId;
    }

    public String getRiskColor() {
        return riskColor;
    }

    public void setRiskColor(String riskColor) {
        this.riskColor = riskColor;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getRiskName() {
        return riskName;
    }

    public void setRiskName(String riskName) {
        this.riskName = riskName;
    }

    public List<Long> getTypeIdList() {
        return typeIdList;
    }

    public void setTypeIdList(List<Long> typeIdList) {
        this.typeIdList = typeIdList;
    }

    public List<Long> getRiskIdList() {
        return riskIdList;
    }

    public void setRiskIdList(List<Long> riskIdList) {
        this.riskIdList = riskIdList;
    }

    public AutoexecRiskVo getRiskVo() {
        return riskVo;
    }

    public void setRiskVo(AutoexecRiskVo riskVo) {
        this.riskVo = riskVo;
    }

    public List<AutoexecParamVo> getParamList() {
        return paramList;
    }

    public void setParamList(List<AutoexecParamVo> paramList) {
        this.paramList = paramList;
    }

    public List<AutoexecParamVo> getInputParamList() {
        List<AutoexecParamVo> paramArray = null;
        if (CollectionUtils.isNotEmpty(paramList)) {
            paramArray = paramList;
        } else if (StringUtils.isNotBlank(configStr)) {
            paramArray = JSONArray.parseArray(configStr).toJavaList(AutoexecParamVo.class);
        }
        if (CollectionUtils.isNotEmpty(paramArray) && CollectionUtils.isEmpty(inputParamList)) {
            inputParamList = paramArray.stream()
                    .filter(o -> ParamMode.INPUT.getValue().equals(o.getMode()))
                    .sorted(Comparator.comparing(AutoexecParamVo::getSort))
                    .collect(Collectors.toList());
        }
        return inputParamList;
    }

    public void setInputParamList(List<AutoexecParamVo> inputParamList) {
        this.inputParamList = inputParamList;
    }

    public List<AutoexecParamVo> getOutputParamList() {
        List<AutoexecParamVo> paramArray = null;
        if (CollectionUtils.isNotEmpty(paramList) && CollectionUtils.isEmpty(outputParamList)) {
            outputParamList = paramList;
        } else if (StringUtils.isNotBlank(configStr) && CollectionUtils.isEmpty(outputParamList)) {
            paramArray = JSONArray.parseArray(configStr).toJavaList(AutoexecParamVo.class);
        }
        if (CollectionUtils.isNotEmpty(paramArray) && CollectionUtils.isEmpty(outputParamList)) {
            outputParamList = paramArray.stream()
                    .filter(o -> ParamMode.OUTPUT.getValue().equals(o.getMode()))
                    .sorted(Comparator.comparing(AutoexecParamVo::getSort))
                    .collect(Collectors.toList());
        }
        return outputParamList;
    }

    public void setOutputParamList(List<AutoexecParamVo> outputParamList) {
        this.outputParamList = outputParamList;
    }

    public String getConfigStr() {
        return configStr;
    }

    public void setConfigStr(String configStr) {
        this.configStr = configStr;
    }
}
