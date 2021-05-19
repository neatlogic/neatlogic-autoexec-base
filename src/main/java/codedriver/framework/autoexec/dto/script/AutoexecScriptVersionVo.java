/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.script;

import codedriver.framework.autoexec.constvalue.ParamMode;
import codedriver.framework.autoexec.constvalue.ScriptVersionStatus;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.common.dto.BaseEditorVo;
import codedriver.framework.restful.annotation.EntityField;
import codedriver.framework.util.SnowflakeUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.collections4.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AutoexecScriptVersionVo extends BaseEditorVo implements Serializable {

    private static final long serialVersionUID = 541000255046247832L;
    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "脚本ID", type = ApiParamType.LONG)
    private Long scriptId;
    @EntityField(name = "版本号", type = ApiParamType.INTEGER)
    private Integer version;
    @EntityField(name = "状态(draft:编辑中、rejected:已驳回、passed:已通过、submitted:待审批)", type = ApiParamType.STRING)
    private String status;
    @EntityField(name = "状态", type = ApiParamType.JSONOBJECT)
    private JSONObject statusVo;
    @EntityField(name = "审批人", type = ApiParamType.STRING)
    private String reviewer;
    @EntityField(name = "脚本解析器", type = ApiParamType.STRING)
    private String parser;
    @EntityField(name = "脚本配置信息", type = ApiParamType.STRING)
    private String config;
    @EntityField(name = "是否激活", type = ApiParamType.INTEGER)
    private Integer isActive;

    @EntityField(name = "参数列表", type = ApiParamType.JSONARRAY)
    @JSONField(serialize = false)
    private transient List<AutoexecScriptVersionParamVo> paramList;
    @EntityField(name = "脚本内容行列表", type = ApiParamType.JSONARRAY)
    private List<AutoexecScriptLineVo> lineList;

    @EntityField(name = "入参列表", type = ApiParamType.JSONARRAY)
    private List<AutoexecScriptVersionParamVo> inputParamList;
    @EntityField(name = "出参列表", type = ApiParamType.JSONARRAY)
    private List<AutoexecScriptVersionParamVo> outputParamList;

    @EntityField(name = "驳回原因", type = ApiParamType.STRING)
    private String rejectReason;

    public AutoexecScriptVersionVo() {
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

    public JSONObject getStatusVo() {
        if (status != null) {
            statusVo = new JSONObject();
            statusVo.put("value", status);
            statusVo.put("text", ScriptVersionStatus.getText(status));
            statusVo.put("color", ScriptVersionStatus.getColor(status));
        }
        return statusVo;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
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

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }
}
