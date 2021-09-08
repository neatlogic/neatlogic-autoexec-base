/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto;

import codedriver.framework.autoexec.constvalue.ExecMode;
import codedriver.framework.autoexec.dto.combop.AutoexecCombopVo;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.common.dto.BaseEditorVo;
import codedriver.framework.dto.OperateVo;
import codedriver.framework.restful.annotation.EntityField;
import codedriver.framework.util.SnowflakeUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @author lvzk
 * @since 2021/7/7 11:59
 **/
public class AutoexecOperationVo extends BaseEditorVo {
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
    @EntityField(name = "操作级别ID", type = ApiParamType.LONG)
    private Long riskId;
    @EntityField(name = "操作级别名称", type = ApiParamType.STRING)
    private String riskName;
    @EntityField(name = "分类名称", type = ApiParamType.STRING)
    private String typeName;
    @EntityField(name = "操作类型", type = ApiParamType.STRING)
    private String operationType;
    @EntityField(name = "操作级别")
    private AutoexecRiskVo riskVo;
    @EntityField(name = "脚本解析器", type = ApiParamType.STRING)
    private String parser;
    @EntityField(name = "描述说明", type = ApiParamType.STRING)
    private String description;
    @EntityField(name = "脚本配置信息", type = ApiParamType.STRING)
    private JSONObject config;
    @EntityField(name = "关联的组合工具", type = ApiParamType.JSONARRAY)
    private List<AutoexecCombopVo> combopList;
    @EntityField(name = "关联的组合工具数", type = ApiParamType.INTEGER)
    private Integer referenceCount;
    @EntityField(name = "按钮列表")
    private List<OperateVo> operateList;
    @EntityField(name = "是否已经被发布为组合工具", type = ApiParamType.INTEGER)
    private Integer hasBeenGeneratedToCombop = 0;
    @JSONField(serialize = false)
    private transient String configStr;
    @JSONField(serialize = false)
    private transient List<Long> typeIdList;
    @JSONField(serialize = false)
    private transient List<Long> riskIdList;
    @EntityField(name = "自由参数", type = ApiParamType.JSONOBJECT)
    private AutoexecParamVo argument;

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
            ExecMode mode = ExecMode.getExecMode(this.execMode);
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

    public AutoexecRiskVo getRiskVo() {
        return riskVo;
    }

    public void setRiskVo(AutoexecRiskVo riskVo) {
        this.riskVo = riskVo;
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

    public void setOperateList(List<OperateVo> operateList) {
        this.operateList = operateList;
    }

    public List<OperateVo> getOperateList() {
        return operateList;
    }

    public List<AutoexecCombopVo> getCombopList() {
        return combopList;
    }

    public void setCombopList(List<AutoexecCombopVo> combopList) {
        this.combopList = combopList;
    }

    public Integer getReferenceCount() {
        return referenceCount;
    }

    public void setReferenceCount(Integer referenceCount) {
        this.referenceCount = referenceCount;
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

    public Integer getHasBeenGeneratedToCombop() {
        return hasBeenGeneratedToCombop;
    }

    public void setHasBeenGeneratedToCombop(Integer hasBeenGeneratedToCombop) {
        this.hasBeenGeneratedToCombop = hasBeenGeneratedToCombop;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public AutoexecParamVo getArgument() {
        if (argument == null && StringUtils.isNotBlank(configStr)) {
            JSONObject toolConfig = JSONObject.parseObject(configStr);
            JSONObject argumentJson = toolConfig.getJSONObject("argument");
            if (MapUtils.isNotEmpty(argumentJson)) {
                argument = new AutoexecParamVo(argumentJson);
            }
        }
        return argument;
    }

    public void setArgument(AutoexecParamVo argument) {
        this.argument = argument;
    }
}
