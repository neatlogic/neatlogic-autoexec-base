/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.script;

import codedriver.framework.autoexec.constvalue.ScriptVersionStatus;
import codedriver.framework.autoexec.dto.AutoexecOperationVo;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;

import java.io.Serializable;
import java.util.List;

public class AutoexecScriptVo extends AutoexecOperationVo implements Serializable {

    private static final long serialVersionUID = -4568586521653070167L;

    @EntityField(name = "当前激活版本号", type = ApiParamType.INTEGER)
    private Integer currentVersion;
    @EntityField(name = "版本总数", type = ApiParamType.INTEGER)
    private Integer versionCount;
    @EntityField(name = "待审批版本ID", type = ApiParamType.LONG)
    private Long submittedVersionId;
    @EntityField(name = "已通过版本数", type = ApiParamType.INTEGER)
    private Integer passedVersionCount;

    @EntityField(name = "版本ID", type = ApiParamType.LONG)
    private Long versionId;

    @EntityField(name = "脚本内容行", type = ApiParamType.JSONARRAY)
    private List<AutoexecScriptLineVo> lineList;

    @EntityField(name = "版本号", type = ApiParamType.INTEGER)
    private Integer version;
    @EntityField(name = "参数列表", type = ApiParamType.JSONARRAY)
    private List<AutoexecScriptVersionParamVo> paramList;

    @EntityField(name = "版本")
    private AutoexecScriptVersionVo versionVo;

    @EntityField(name = "当前版本")
    private AutoexecScriptVersionVo currentVersionVo;

    @EntityField(name = "版本状态", type = ApiParamType.ENUM, member = ScriptVersionStatus.class)
    private String versionStatus;

    private List<AutoexecScriptVersionVo> versionList;

    @EntityField(name = "url序列", type = ApiParamType.STRING)
    private String urlSequence;


    public AutoexecScriptVo() {
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

    public Long getSubmittedVersionId() {
        return submittedVersionId;
    }

    public void setSubmittedVersionId(Long submittedVersionId) {
        this.submittedVersionId = submittedVersionId;
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

    public AutoexecScriptVersionVo getCurrentVersionVo() {
        return currentVersionVo;
    }

    public void setCurrentVersionVo(AutoexecScriptVersionVo currentVersionVo) {
        this.currentVersionVo = currentVersionVo;
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

    public String getVersionStatus() {
        return versionStatus;
    }

    public void setVersionStatus(String versionStatus) {
        this.versionStatus = versionStatus;
    }

    public List<AutoexecScriptVersionVo> getVersionList() {
        return versionList;
    }

    public void setVersionList(List<AutoexecScriptVersionVo> versionList) {
        this.versionList = versionList;
    }

    public String getUrlSequence() {
        return urlSequence;
    }

    public void setUrlSequence(String urlSequence) {
        this.urlSequence = urlSequence;
    }
}
