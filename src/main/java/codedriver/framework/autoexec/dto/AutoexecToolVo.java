/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto;

import codedriver.framework.autoexec.constvalue.ExecMode;
import codedriver.framework.autoexec.constvalue.ParamMode;
import codedriver.framework.autoexec.dto.combop.AutoexecCombopVo;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.common.dto.BaseEditorVo;
import codedriver.framework.dto.OperateVo;
import codedriver.framework.restful.annotation.EntityField;
import codedriver.framework.util.SnowflakeUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AutoexecToolVo extends BaseEditorVo {

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
    @EntityField(name = "解析器", type = ApiParamType.STRING)
    private String parser;
    @EntityField(name = "分类ID", type = ApiParamType.LONG)
    private Long typeId;
    @EntityField(name = "分类名称", type = ApiParamType.STRING)
    private String typeName;
    @EntityField(name = "操作级别ID", type = ApiParamType.LONG)
    private Long riskId;
    @EntityField(name = "操作级别名称", type = ApiParamType.STRING)
    private String riskName;
    @EntityField(name = "操作级别")
    private AutoexecRiskVo riskVo;
    @EntityField(name = "描述说明", type = ApiParamType.STRING)
    private String description;
    @EntityField(name = "是否激活", type = ApiParamType.INTEGER)
    private Integer isActive;
    @EntityField(name = "是否已经被发布为组合工具", type = ApiParamType.INTEGER)
    private Integer hasBeenGeneratedToCombop = 0;

    @EntityField(name = "输入参数列表", type = ApiParamType.JSONARRAY)
    private List<AutoexecParamVo> inputParamList;

    @EntityField(name = "输出参数列表", type = ApiParamType.JSONARRAY)
    private List<AutoexecParamVo> outputParamList;

    @EntityField(name = "关联的组合工具", type = ApiParamType.JSONARRAY)
    private List<AutoexecCombopVo> combopList;

    @EntityField(name = "操作列表")
    private List<OperateVo> operateList;

    @JSONField(serialize = false)
    private transient JSONObject config;// 参数配置

    @JSONField(serialize = false)
    private transient String configStr;

    @JSONField(serialize = false)
    private transient List<Long> typeIdList;

    @JSONField(serialize = false)
    private transient List<Long> riskIdList;

    @JSONField(serialize = false)
    private transient Integer referenceCount; // 被组合工具引用次数

    public AutoexecToolVo() {
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

    public String getUk() {
        return uk;
    }

    public void setUk(String uk) {
        this.uk = uk;
    }

    public String getExecMode() {
        return execMode;
    }

    public void setExecMode(String execMode) {
        this.execMode = execMode;
    }

    public String getExecModeText() {
        if (StringUtils.isNotBlank(execMode)) {
            execModeText = ExecMode.getExecMode(execMode).getText();
        }
        return execModeText;
    }

    public String getParser() {
        return parser;
    }

    public void setParser(String parser) {
        this.parser = parser;
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

    public String getRiskName() {
        return riskName;
    }

    public void setRiskName(String riskName) {
        this.riskName = riskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public AutoexecRiskVo getRiskVo() {
        return riskVo;
    }

    public void setRiskVo(AutoexecRiskVo riskVo) {
        this.riskVo = riskVo;
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

    public JSONObject getConfig() {
        if (StringUtils.isNotBlank(configStr)) {
            config = JSONObject.parseObject(configStr);
        }
        return config;
    }

    public void setConfig(JSONObject config) {
        this.config = config;
    }

    public String getConfigStr() {
        return configStr;
    }

    public void setConfigStr(String configStr) {
        this.configStr = configStr;
    }

    public List<AutoexecParamVo> getInputParamList() {
        getConfig();
        if (MapUtils.isNotEmpty(config)) {
            JSONArray paramList = config.getJSONArray("paramList");
            if (CollectionUtils.isNotEmpty(paramList)) {
                inputParamList = paramList.toJavaList(AutoexecParamVo.class)
                        .stream()
                        .filter(o -> Objects.equals(o.getMode(), ParamMode.INPUT.getValue()))
                        .sorted(Comparator.comparing(AutoexecParamVo::getSort))
                        .collect(Collectors.toList());
            }
        }
        return inputParamList;
    }

    public List<AutoexecParamVo> getOutputParamList() {
        getConfig();
        if (MapUtils.isNotEmpty(config)) {
            JSONArray paramList = config.getJSONArray("paramList");
            if (CollectionUtils.isNotEmpty(paramList)) {
                outputParamList = paramList.toJavaList(AutoexecParamVo.class)
                        .stream()
                        .filter(o -> Objects.equals(o.getMode(), ParamMode.OUTPUT.getValue()))
                        .sorted(Comparator.comparing(AutoexecParamVo::getSort))
                        .collect(Collectors.toList());
            }
        }
        return outputParamList;
    }

    public Integer getHasBeenGeneratedToCombop() {
        return hasBeenGeneratedToCombop;
    }

    public void setHasBeenGeneratedToCombop(Integer hasBeenGeneratedToCombop) {
        this.hasBeenGeneratedToCombop = hasBeenGeneratedToCombop;
    }

    public List<AutoexecCombopVo> getCombopList() {
        return combopList;
    }

    public void setCombopList(List<AutoexecCombopVo> combopList) {
        this.combopList = combopList;
    }

    public void setOperateList(List<OperateVo> operateList) {
        this.operateList = operateList;
    }

    public List<OperateVo> getOperateList() {
        return operateList;
    }

    public Integer getReferenceCount() {
        return referenceCount;
    }

    public void setReferenceCount(Integer referenceCount) {
        this.referenceCount = referenceCount;
    }
}
