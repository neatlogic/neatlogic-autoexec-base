/*Copyright (C) 2023  深圳极向量科技有限公司 All Rights Reserved.

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

package neatlogic.framework.autoexec.dto.script;

import com.alibaba.fastjson.annotation.JSONField;
import neatlogic.framework.autoexec.constvalue.ScriptVersionStatus;
import neatlogic.framework.autoexec.dto.AutoexecOperationVo;
import neatlogic.framework.autoexec.dto.AutoexecParamVo;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.file.dto.FileVo;
import neatlogic.framework.restful.annotation.EntityField;
import org.apache.commons.collections4.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AutoexecScriptVo extends AutoexecOperationVo implements Serializable {

    private static final long serialVersionUID = -4568586521653070167L;

    @EntityField(name = "nfad.autoexecscriptvo.entityfield.currentversion.name", type = ApiParamType.INTEGER)
    private Integer currentVersion;
    @EntityField(name = "nfad.autoexecscriptvo.entityfield.versioncount.name", type = ApiParamType.INTEGER)
    private Integer versionCount;
    @EntityField(name = "nfad.autoexecscriptvo.entityfield.submittedversionid.name", type = ApiParamType.LONG)
    private Long submittedVersionId;
    @EntityField(name = "nfad.autoexecscriptvo.entityfield.passedversioncount.name", type = ApiParamType.INTEGER)
    private Integer passedVersionCount;

    @EntityField(name = "common.versionid", type = ApiParamType.LONG)
    private Long versionId;

    @EntityField(name = "nfad.autoexecscriptvo.entityfield.linelist.name", type = ApiParamType.JSONARRAY)
    private List<AutoexecScriptLineVo> lineList;

    @EntityField(name = "common.versionnum", type = ApiParamType.INTEGER)
    private Integer version;

    @JSONField(serialize = false)
    private List<AutoexecScriptVersionParamVo> versionParamList;

    @JSONField(serialize = false)
    private AutoexecScriptArgumentVo versionArgument;

    @EntityField(name = "term.autoexec.version")
    private AutoexecScriptVersionVo versionVo;

    @EntityField(name = "nfad.autoexecscriptvo.entityfield.currentversionvo.name")
    private AutoexecScriptVersionVo currentVersionVo;

    @EntityField(name = "term.autoexec.versionstatus", type = ApiParamType.ENUM, member = ScriptVersionStatus.class)
    private String versionStatus;

    private List<AutoexecScriptVersionVo> versionList;

    @EntityField(name = "nfad.autoexecscriptvo.entityfield.catalogname.name", type = ApiParamType.STRING)
    private String catalogName;
    @EntityField(name = "nfad.autoexecscriptvo.entityfield.catalogpath.name", type = ApiParamType.STRING)
    private String catalogPath;

    @EntityField(name = "nfad.autoexecscriptvo.entityfield.islibreference.name", type = ApiParamType.INTEGER)
    private Integer isLibReference = 0;
    @EntityField(name = "term.autoexec.dependenttool", type = ApiParamType.JSONARRAY)
    private List<Long> useLib = new ArrayList<>();
    @EntityField(name = "term.autoexec.dependenttoolname", type = ApiParamType.JSONARRAY)
    private List<String> useLibName;
    @EntityField(name = "term.autoexec.packagefileid", type = ApiParamType.LONG)
    private Long packageFileId;
    @EntityField(name = "nfad.autoexecscriptvo.entityfield.packagefilename.name", type = ApiParamType.STRING)
    private String packageFileName;
    @EntityField(name = "term.autoexec.packagefile", type = ApiParamType.JSONOBJECT)
    private FileVo packageFile;

    @EntityField(name = "common.referencecount", type = ApiParamType.INTEGER)
    private Integer referenceCount;

    // 直接执行权限过滤参数仅用于列表 Mapper 动态拼接，不直接输出给调用方。
    @JSONField(serialize = false)
    private String execrtoolAuthorityStatus;
    @JSONField(serialize = false)
    private List<String> execrtoolAuthorityUuidList;
    @EntityField(name = "common.executeauthoritylist", type = ApiParamType.JSONARRAY)
    private List<AutoexecScriptExecrtoolAuthorityVo> execrtoolAuthorityList;


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

    public Integer getIsLibReference() {
        return isLibReference;
    }

    public void setIsLibReference(Integer isLibReference) {
        this.isLibReference = isLibReference;
    }

    public List<Long> getUseLib() {
        return useLib;
    }

    public void setUseLib(List<Long> useLib) {
        this.useLib = useLib;
    }

    public List<String> getUseLibName() {
        return useLibName;
    }

    public void setUseLibName(List<String> useLibName) {
        this.useLibName = useLibName;
    }

    public Long getPackageFileId() {
        return packageFileId;
    }

    public void setPackageFileId(Long packageFileId) {
        this.packageFileId = packageFileId;
    }

    public String getPackageFileName() {
        return packageFileName;
    }

    public void setPackageFileName(String packageFileName) {
        this.packageFileName = packageFileName;
    }

    public FileVo getPackageFile() {
        return packageFile;
    }

    public void setPackageFile(FileVo packageFile) {
        this.packageFile = packageFile;
    }

    @Override
    public Integer getReferenceCount() {
        return referenceCount;
    }

    @Override
    public void setReferenceCount(Integer referenceCount) {
        this.referenceCount = referenceCount;
    }

    public String getExecrtoolAuthorityStatus() {
        return execrtoolAuthorityStatus;
    }

    public void setExecrtoolAuthorityStatus(String execrtoolAuthorityStatus) {
        this.execrtoolAuthorityStatus = execrtoolAuthorityStatus;
    }

    public List<String> getExecrtoolAuthorityUuidList() {
        return execrtoolAuthorityUuidList;
    }

    public void setExecrtoolAuthorityUuidList(List<String> execrtoolAuthorityUuidList) {
        this.execrtoolAuthorityUuidList = execrtoolAuthorityUuidList;
    }

    public List<AutoexecScriptExecrtoolAuthorityVo> getExecrtoolAuthorityList() {
        return execrtoolAuthorityList;
    }

    public void setExecrtoolAuthorityList(List<AutoexecScriptExecrtoolAuthorityVo> execrtoolAuthorityList) {
        this.execrtoolAuthorityList = execrtoolAuthorityList;
    }
}
