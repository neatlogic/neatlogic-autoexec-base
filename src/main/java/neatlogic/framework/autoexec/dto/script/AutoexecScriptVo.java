/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.autoexec.dto.script;

import neatlogic.framework.autoexec.constvalue.ScriptVersionStatus;
import neatlogic.framework.autoexec.dto.AutoexecOperationVo;
import neatlogic.framework.autoexec.dto.AutoexecParamVo;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;
import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.collections4.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;
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

    @JSONField(serialize = false)
    private List<AutoexecScriptVersionParamVo> versionParamList;

    @JSONField(serialize = false)
    private AutoexecScriptArgumentVo versionArgument;

    @EntityField(name = "版本")
    private AutoexecScriptVersionVo versionVo;

    @EntityField(name = "当前版本")
    private AutoexecScriptVersionVo currentVersionVo;

    @EntityField(name = "版本状态", type = ApiParamType.ENUM, member = ScriptVersionStatus.class)
    private String versionStatus;

    private List<AutoexecScriptVersionVo> versionList;

    @EntityField(name = "所属工具目录名称", type = ApiParamType.STRING)
    private String catalogName;
    @EntityField(name = "所属工具目录完整路径", type = ApiParamType.STRING)
    private String catalogPath;


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

    public List<AutoexecParamVo> getParamList() {
        return super.getParamList();
    }

    public List<AutoexecScriptVersionParamVo> getVersionParamList() {
        List<AutoexecParamVo> paramList = getParamList();
        if (CollectionUtils.isNotEmpty(paramList)) {
            versionParamList = new ArrayList<>(paramList.size());
            for (AutoexecParamVo paramVo : paramList) {
                versionParamList.add(new AutoexecScriptVersionParamVo(paramVo));
            }
        }
        return versionParamList;
    }

    public AutoexecScriptArgumentVo getVersionArgument() {
        AutoexecParamVo argument = super.getArgument();
        if (argument != null) {
            versionArgument = new AutoexecScriptArgumentVo(argument);
        }
        return versionArgument;
    }

    public void setVersionArgument(AutoexecScriptArgumentVo versionArgument) {
        this.versionArgument = versionArgument;
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

    @Override
    public String getCatalogName() {
        return catalogName;
    }

    @Override
    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getCatalogPath() {
        return catalogPath;
    }

    public void setCatalogPath(String catalogPath) {
        this.catalogPath = catalogPath;
    }
}
