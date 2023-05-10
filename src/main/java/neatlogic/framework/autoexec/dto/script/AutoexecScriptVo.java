/*
Copyright(c) 2023 NeatLogic Co., Ltd. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License. 
 */

package neatlogic.framework.autoexec.dto.script;

import neatlogic.framework.autoexec.constvalue.ScriptVersionStatus;
import neatlogic.framework.autoexec.dto.AutoexecOperationVo;
import neatlogic.framework.autoexec.dto.AutoexecParamVo;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.file.dto.FileVo;
import neatlogic.framework.restful.annotation.EntityField;
import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

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

    @EntityField(name = "是否作为库文件被依赖", type = ApiParamType.INTEGER)
    private Integer isLibReference = 0;
    @EntityField(name = "依赖工具", type = ApiParamType.JSONARRAY)
    private List<Long> useLib = new ArrayList<>();
    @EntityField(name = "依赖工具名", type = ApiParamType.JSONARRAY)
    private List<String> useLibName;
    @EntityField(name = "包文件id", type = ApiParamType.LONG)
    private Long packageFileId;
    @EntityField(name = "包文件名", type = ApiParamType.STRING)
    private String packageFileName;
    @EntityField(name = "包文件", type = ApiParamType.JSONOBJECT)
    private FileVo packageFile;


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
}
