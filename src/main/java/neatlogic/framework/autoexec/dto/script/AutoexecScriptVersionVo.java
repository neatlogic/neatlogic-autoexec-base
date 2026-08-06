/*
 *
 * Copyright (C) 2025  TechSure Co., Ltd.  All Rights Reserved.
 * This file is part of the NeatLogic software.
 * Licensed under the NeatLogic Sustainable Use License (NSUL), Version 4.x – 2025.
 * You may use this file only in compliance with the License.
 * See the LICENSE file distributed with this work for the full license text.
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 */

package neatlogic.framework.autoexec.dto.script;

import com.alibaba.fastjson.annotation.JSONField;
import neatlogic.framework.autoexec.constvalue.ParamMode;
import neatlogic.framework.autoexec.constvalue.ScriptVersionStatus;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.common.dto.BaseEditorVo;
import neatlogic.framework.common.dto.ValueTextVo;
import neatlogic.framework.dto.OperateVo;
import neatlogic.framework.dto.UserVo;
import neatlogic.framework.dto.WorkAssignmentUnitVo;
import neatlogic.framework.file.dto.FileVo;
import neatlogic.framework.restful.annotation.EntityField;
import neatlogic.framework.util.SnowflakeUtil;
import org.apache.commons.collections4.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AutoexecScriptVersionVo extends BaseEditorVo implements Serializable {

    private static final long serialVersionUID = 541000255046247832L;
    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "term.autoexec.scriptid", type = ApiParamType.LONG)
    private Long scriptId;
    @EntityField(name = "common.title", type = ApiParamType.STRING)
    private String title;
    @EntityField(name = "common.versionnum", type = ApiParamType.INTEGER)
    private Integer version;
    @EntityField(name = "nfad.autoexecscriptversionvo.entityfield.status.name", type = ApiParamType.STRING)
    private String status;
    @EntityField(name = "common.status", type = ApiParamType.JSONOBJECT)
    private ValueTextVo statusVo;
    @EntityField(name = "nfad.autoexecscriptversionvo.entityfield.reviewer.name", type = ApiParamType.STRING)
    private String reviewer;
    @EntityField(name = "nfad.autoexecscriptversionvo.entityfield.reviewervo.name")
    private UserVo reviewerVo;
    @EntityField(name = "term.autoexec.encoding", type = ApiParamType.STRING)
    private String encoding;
    @EntityField(name = "term.autoexec.scriptparser", type = ApiParamType.STRING)
    private String parser;
    @EntityField(name = "common.config", type = ApiParamType.STRING)
    private String config;
    @EntityField(name = "common.isactive", type = ApiParamType.INTEGER)
    private Integer isActive;

    @EntityField(name = "term.autoexec.paramlist", type = ApiParamType.JSONARRAY)
    @JSONField(serialize = false)
    private List<AutoexecScriptVersionParamVo> paramList;
    @EntityField(name = "term.autoexec.linelist", type = ApiParamType.JSONARRAY)
    private List<AutoexecScriptLineVo> lineList;

    @EntityField(name = "term.autoexec.inputparamlist", type = ApiParamType.JSONARRAY)
    private List<AutoexecScriptVersionParamVo> inputParamList;
    @EntityField(name = "term.autoexec.outputparamlist", type = ApiParamType.JSONARRAY)
    private List<AutoexecScriptVersionParamVo> outputParamList;

    @EntityField(name = "term.autoexec.freeparam", type = ApiParamType.JSONOBJECT)
    private AutoexecScriptArgumentVo argument;

    @EntityField(name = "nfad.autoexecscriptversionvo.entityfield.rejectreason.name", type = ApiParamType.STRING)
    private String rejectReason;

    private Integer versionCount; // 版本数

    @EntityField(name = "term.autoexec.actionlist")
    private List<OperateVo> operateList;

    @EntityField(name = "nfad.autoexecscriptversionvo.entityfield.reviewervolist.name", type = ApiParamType.JSONARRAY)
    private List<WorkAssignmentUnitVo> reviewerVoList;

    @EntityField(name = "term.autoexec.dependenttool", type = ApiParamType.JSONARRAY)
    private List<Long> useLib = new ArrayList<>();
    @EntityField(name = "term.autoexec.dependenttoolname", type = ApiParamType.JSONARRAY)
    private List<String> useLibName = new ArrayList<>();
    @EntityField(name = "term.autoexec.packagefileid", type = ApiParamType.LONG)
    private Long packageFileId;
    @EntityField(name = "term.autoexec.packagefile", type = ApiParamType.JSONOBJECT)
    private FileVo packageFile;

    @JSONField(serialize = false)
    private List<Long> excludeList;

    public AutoexecScriptVersionVo() {
    }

    public AutoexecScriptVersionVo(Long scriptId, String status) {
        this.scriptId = scriptId;
        this.status = status;
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

    public Long getScriptId() {
        return scriptId;
    }

    public void setScriptId(Long scriptId) {
        this.scriptId = scriptId;
    }

    public String getTitle() {
//        if (StringUtils.isNotBlank(status)) {
//            if (Objects.equals(status, ScriptVersionStatus.PASSED.getValue())) {
//                title = "版本" + version;
//            }
//        }
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ValueTextVo getStatusVo() {
        if (status != null) {
            if (Objects.equals(status, ScriptVersionStatus.PASSED.getValue())) {
                if (Objects.equals(getIsActive(), 1)) {
                    statusVo = new ValueTextVo(ScriptVersionStatus.CURRENT.getValue(), ScriptVersionStatus.CURRENT.getText());
                } else {
                    statusVo = new ValueTextVo(ScriptVersionStatus.HISTORY.getValue(), ScriptVersionStatus.HISTORY.getText());
                }
            } else {
                statusVo = new ValueTextVo(status, ScriptVersionStatus.getText(status));
            }
        }
        return statusVo;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
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

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public List<AutoexecScriptVersionParamVo> getParamList() {
        if (CollectionUtils.isNotEmpty(inputParamList) || CollectionUtils.isNotEmpty(outputParamList)) {
            paramList = new ArrayList<>();
            if (inputParamList != null) {
                paramList.addAll(inputParamList);
            }
            if (outputParamList != null) {
                paramList.addAll(outputParamList);
            }
        }
        return paramList;
    }

    public void setParamList(List<AutoexecScriptVersionParamVo> paramList) {
        this.paramList = paramList;
    }

    public List<AutoexecScriptLineVo> getLineList() {
        return lineList;
    }

    public void setLineList(List<AutoexecScriptLineVo> lineList) {
        this.lineList = lineList;
    }

    public List<AutoexecScriptVersionParamVo> getInputParamList() {
        if (CollectionUtils.isNotEmpty(paramList) && CollectionUtils.isEmpty(inputParamList)) {
            inputParamList = paramList.stream()
                    .filter(o -> ParamMode.INPUT.getValue().equals(o.getMode()))
                    .sorted(Comparator.comparing(AutoexecScriptVersionParamVo::getSort))
                    .collect(Collectors.toList());
        }
        return inputParamList;
    }

    public List<AutoexecScriptVersionParamVo> getOutputParamList() {
        if (CollectionUtils.isNotEmpty(paramList) && CollectionUtils.isEmpty(outputParamList)) {
            outputParamList = paramList.stream()
                    .filter(o -> ParamMode.OUTPUT.getValue().equals(o.getMode()))
                    .sorted(Comparator.comparing(AutoexecScriptVersionParamVo::getSort))
                    .collect(Collectors.toList());
        }
        return outputParamList;
    }

    public AutoexecScriptArgumentVo getArgument() {
        return argument;
    }

    public void setArgument(AutoexecScriptArgumentVo argument) {
        this.argument = argument;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    public UserVo getReviewerVo() {
        return reviewerVo;
    }

    public void setReviewerVo(UserVo reviewerVo) {
        this.reviewerVo = reviewerVo;
    }

    public Integer getVersionCount() {
        return versionCount;
    }

    public void setVersionCount(Integer versionCount) {
        this.versionCount = versionCount;
    }

    public void setOperateList(List<OperateVo> operateList) {
        this.operateList = operateList;
    }

    public List<OperateVo> getOperateList() {
        return operateList;
    }

    public List<WorkAssignmentUnitVo> getReviewerVoList() {
        return reviewerVoList;
    }

    public void setReviewerVoList(List<WorkAssignmentUnitVo> reviewerVoList) {
        this.reviewerVoList = reviewerVoList;
    }

    public List<Long> getExcludeList() {
        return excludeList;
    }

    public void setExcludeList(List<Long> excludeList) {
        this.excludeList = excludeList;
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

    public FileVo getPackageFile() {
        return packageFile;
    }

    public void setPackageFile(FileVo packageFile) {
        this.packageFile = packageFile;
    }
}
