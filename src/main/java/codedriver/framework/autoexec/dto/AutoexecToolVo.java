/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto;

import codedriver.framework.autoexec.constvalue.ExecMode;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.common.dto.BaseEditorVo;
import codedriver.framework.restful.annotation.EntityField;
import codedriver.framework.util.SnowflakeUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

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
    private String type;
    @EntityField(name = "操作级别ID", type = ApiParamType.LONG)
    private Long riskId;
    @EntityField(name = "操作级别")
    private AutoexecRiskVo riskVo;
    @EntityField(name = "描述说明", type = ApiParamType.STRING)
    private String description;
    @EntityField(name = "是否激活", type = ApiParamType.INTEGER)
    private Integer isActive;
    @EntityField(name = "是否已经被发布为组合工具", type = ApiParamType.INTEGER)
    private Integer hasBeenGeneratedToCombop = 0;
    @EntityField(name = "是否可以发布为组合工具", type = ApiParamType.INTEGER)
    private Integer canGeneratedToCombop = 0;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public Integer getHasBeenGeneratedToCombop() {
        return hasBeenGeneratedToCombop;
    }

    public void setHasBeenGeneratedToCombop(Integer hasBeenGeneratedToCombop) {
        this.hasBeenGeneratedToCombop = hasBeenGeneratedToCombop;
    }

    public Integer getCanGeneratedToCombop() {
        if (isActive != null && isActive == 1 && hasBeenGeneratedToCombop == 0) {
            canGeneratedToCombop = 1;
        }
        return canGeneratedToCombop;
    }

    public void setOperateList(List<OperateVo> operateList) {
        this.operateList = operateList;
    }

    public List<OperateVo> getOperateList() {
        return operateList;
    }
}
