/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.autoexec.dto.script;

import neatlogic.framework.autoexec.constvalue.ParamMode;
import neatlogic.framework.autoexec.constvalue.ScriptVersionStatus;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.common.dto.BaseEditorVo;
import neatlogic.framework.common.dto.ValueTextVo;
import neatlogic.framework.dto.OperateVo;
import neatlogic.framework.dto.UserVo;
import neatlogic.framework.dto.WorkAssignmentUnitVo;
import neatlogic.framework.restful.annotation.EntityField;
import neatlogic.framework.util.SnowflakeUtil;
import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

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
    @EntityField(name = "脚本ID", type = ApiParamType.LONG)
    private Long scriptId;
    @EntityField(name = "标题", type = ApiParamType.STRING)
    private String title;
    @EntityField(name = "版本号", type = ApiParamType.INTEGER)
    private Integer version;
    @EntityField(name = "状态(draft:草稿、rejected:已驳回、passed:已通过、submitted:待审批)", type = ApiParamType.STRING)
    private String status;
    @EntityField(name = "状态", type = ApiParamType.JSONOBJECT)
    private ValueTextVo statusVo;
    @EntityField(name = "审批人", type = ApiParamType.STRING)
    private String reviewer;
    @EntityField(name = "审批用户")
    private UserVo reviewerVo;
    @EntityField(name = "脚本编码", type = ApiParamType.STRING)
    private String encoding;
    @EntityField(name = "脚本解析器", type = ApiParamType.STRING)
    private String parser;
    @EntityField(name = "脚本配置信息", type = ApiParamType.STRING)
    private String config;
    @EntityField(name = "是否激活", type = ApiParamType.INTEGER)
    private Integer isActive;

    @EntityField(name = "参数列表", type = ApiParamType.JSONARRAY)
    @JSONField(serialize = false)
    private List<AutoexecScriptVersionParamVo> paramList;
    @EntityField(name = "脚本内容行列表", type = ApiParamType.JSONARRAY)
    private List<AutoexecScriptLineVo> lineList;

    @EntityField(name = "入参列表", type = ApiParamType.JSONARRAY)
    private List<AutoexecScriptVersionParamVo> inputParamList;
    @EntityField(name = "出参列表", type = ApiParamType.JSONARRAY)
    private List<AutoexecScriptVersionParamVo> outputParamList;

    @EntityField(name = "自由参数", type = ApiParamType.JSONOBJECT)
    private AutoexecScriptArgumentVo argument;

    @EntityField(name = "驳回原因", type = ApiParamType.STRING)
    private String rejectReason;

    private Integer versionCount; // 版本数

    @EntityField(name = "操作列表")
    private List<OperateVo> operateList;

    @EntityField(name = "审核人列表", type = ApiParamType.JSONARRAY)
    private List<WorkAssignmentUnitVo> reviewerVoList;

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
        if (StringUtils.isNotBlank(status)) {
            if (Objects.equals(status, ScriptVersionStatus.PASSED.getValue())) {
                title = "版本" + version;
            }
        }
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
}
