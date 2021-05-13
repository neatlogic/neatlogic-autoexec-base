/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.script;

import codedriver.framework.autoexec.dto.AutoexecRiskVo;
import codedriver.framework.autoexec.dto.combop.AutoexecCombopVo;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.common.dto.BaseEditorVo;
import codedriver.framework.restful.annotation.EntityField;
import codedriver.framework.util.SnowflakeUtil;
import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;

public class AutoexecScriptVo extends BaseEditorVo implements Serializable {

    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "唯一标识", type = ApiParamType.STRING)
    private String uk;
    @EntityField(name = "名称", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "执行方式", type = ApiParamType.STRING)
    private String execMode;
    @EntityField(name = "执行方式显示名", type = ApiParamType.STRING)
    private String execModeText;
    @EntityField(name = "分类ID", type = ApiParamType.LONG)
    private Long typeId;
    @EntityField(name = "操作级别ID", type = ApiParamType.LONG)
    private Long riskId;
    @EntityField(name = "操作级别名称", type = ApiParamType.STRING)
    private String riskName;

    @EntityField(name = "分类名称", type = ApiParamType.STRING)
    private String type;
    @EntityField(name = "操作级别")
    private AutoexecRiskVo riskVo;
    @EntityField(name = "当前激活版本号", type = ApiParamType.INTEGER)
    private Integer currentVersion;
    @EntityField(name = "版本总数", type = ApiParamType.INTEGER)
    private Integer versionCount;
    @EntityField(name = "待审批版本数", type = ApiParamType.INTEGER)
    private Integer submittedVersionCount;
    @EntityField(name = "已通过版本数", type = ApiParamType.INTEGER)
    private Integer passedVersionCount;

    @EntityField(name = "版本ID", type = ApiParamType.LONG)
    private Long versionId;
    @EntityField(name = "脚本解析器", type = ApiParamType.STRING)
    private String parser;
    @EntityField(name = "脚本配置信息", type = ApiParamType.STRING)
    private String config;
    @EntityField(name = "脚本内容行", type = ApiParamType.JSONARRAY)
    private List<AutoexecScriptLineVo> lineList;

    @EntityField(name = "版本号", type = ApiParamType.INTEGER)
    private Integer version;
    @EntityField(name = "参数列表", type = ApiParamType.JSONARRAY)
    private List<AutoexecScriptVersionParamVo> paramList;

    @EntityField(name = "版本")
    private AutoexecScriptVersionVo versionVo;

    @EntityField(name = "是否待审批", type = ApiParamType.INTEGER)
    private Integer isReviewing;

    @EntityField(name = "关联的组合工具", type = ApiParamType.JSONARRAY)
    private List<AutoexecCombopVo> combopList;

    @EntityField(name = "关联的组合工具数", type = ApiParamType.INTEGER)
    private Integer referenceCount;

    @JSONField(serialize = false)
    private transient List<Long> typeIdList;

    @JSONField(serialize = false)
    private transient List<Long> riskIdList;

    private List<AutoexecScriptVersionVo> versionList;


    public AutoexecScriptVo() {
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
        return execModeText;
    }

    public void setExecModeText(String execModeText) {
        this.execModeText = execModeText;
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

    public Integer getCurrentVersion() {
        return currentVersion;
    }

    public void setCurrentVersion(Integer currentVersion) {
        this.currentVersion = currentVersion;
    }

    public Integer getVersionCount() {
        return versionCount;
    }

    public void setVersionCount(Integer versionCount) {
        this.versionCount = versionCount;
    }

    public Integer getSubmittedVersionCount() {
        return submittedVersionCount;
    }

    public void setSubmittedVersionCount(Integer submittedVersionCount) {
        this.submittedVersionCount = submittedVersionCount;
    }

    public Integer getPassedVersionCount() {
        return passedVersionCount;
    }

    public void setPassedVersionCount(Integer passedVersionCount) {
        this.passedVersionCount = passedVersionCount;
    }

    public Long getVersionId() {
        return versionId;
    }

    public void setVersionId(Long versionId) {
        this.versionId = versionId;
    }

    public String getParser() {
        return parser;
    }

    public void setParser(String parser) {
        this.parser = parser;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public List<AutoexecScriptLineVo> getLineList() {
        return lineList;
    }

    public void setLineList(List<AutoexecScriptLineVo> lineList) {
        this.lineList = lineList;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public List<AutoexecScriptVersionParamVo> getParamList() {
        return paramList;
    }

    public void setParamList(List<AutoexecScriptVersionParamVo> paramList) {
        this.paramList = paramList;
    }

    public AutoexecScriptVersionVo getVersionVo() {
        return versionVo;
    }

    public void setVersionVo(AutoexecScriptVersionVo versionVo) {
        this.versionVo = versionVo;
    }

    public Integer getIsReviewing() {
        return isReviewing;
    }

    public void setIsReviewing(Integer isReviewing) {
        this.isReviewing = isReviewing;
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

    public List<AutoexecScriptVersionVo> getVersionList() {
        return versionList;
    }

    public void setVersionList(List<AutoexecScriptVersionVo> versionList) {
        this.versionList = versionList;
    }
}
