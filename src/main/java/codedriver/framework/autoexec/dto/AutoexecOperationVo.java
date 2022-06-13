/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto;

import codedriver.framework.autoexec.constvalue.ParamMode;
import codedriver.framework.autoexec.dto.combop.AutoexecCombopVo;
import codedriver.framework.autoexec.dto.script.AutoexecScriptVo;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.dto.OperateVo;
import codedriver.framework.restful.annotation.EntityField;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author lvzk
 * @since 2021/7/7 11:59
 **/
public class AutoexecOperationVo extends AutoexecOperationBaseVo {
    @EntityField(name = "操作类型", type = ApiParamType.STRING)
    private String operationType;
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
    @EntityField(name = "默认profileId", type = ApiParamType.LONG)
    private Long defaultProfileId; // 当前工具关联的profileId
    @EntityField(name = "默认默认profile名称", type = ApiParamType.STRING)
    private String defaultProfileName; // 当前工具关联的默认profile名称

    public AutoexecOperationVo() {

    }

    public AutoexecOperationVo(AutoexecToolVo autoexecToolVo) {
        super(autoexecToolVo);
    }

    public AutoexecOperationVo(AutoexecScriptVo autoexecScriptVo) {
        super(autoexecScriptVo);
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public JSONObject getConfig() {
        if (StringUtils.isNotBlank(super.getConfigStr())) {
            config = JSONObject.parseObject(super.getConfigStr());
        }
        return config;
    }

    public void setConfig(JSONObject config) {
        this.config = config;
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

    public Integer getHasBeenGeneratedToCombop() {
        return hasBeenGeneratedToCombop;
    }

    public void setHasBeenGeneratedToCombop(Integer hasBeenGeneratedToCombop) {
        this.hasBeenGeneratedToCombop = hasBeenGeneratedToCombop;
    }

    public AutoexecParamVo getArgument() {
        if (super.getArgument() == null && StringUtils.isNotBlank(super.getConfigStr())) {
            JSONObject toolConfig = JSONObject.parseObject(super.getConfigStr());
            JSONObject argumentJson = toolConfig.getJSONObject("argument");
            if (MapUtils.isNotEmpty(argumentJson)) {
                super.setArgument(argumentJson.toJavaObject(AutoexecParamVo.class));
            }
        }
        return super.getArgument();
    }

    public List<AutoexecParamVo> getParamList() {
        JSONObject config = getConfig();
        if (MapUtils.isNotEmpty(config)) {
            JSONArray paramList = config.getJSONArray("paramList");
            if (CollectionUtils.isNotEmpty(paramList)) {
                super.setParamList(paramList.toJavaList(AutoexecParamVo.class));
            }
        }
        return super.getParamList();
    }

    public List<AutoexecParamVo> getInputParamList() {
        List<AutoexecParamVo> paramList = getParamList();
        if (CollectionUtils.isNotEmpty(paramList)) {
            super.setInputParamList(paramList
                    .stream()
                    .filter(o -> Objects.equals(o.getMode(), ParamMode.INPUT.getValue()))
                    .sorted(Comparator.comparing(AutoexecParamVo::getSort))
                    .collect(Collectors.toList()));
        }
        return super.getInputParamList();
    }

    public List<AutoexecParamVo> getOutputParamList() {
        List<AutoexecParamVo> paramList = getParamList();
        if (CollectionUtils.isNotEmpty(paramList)) {
            super.setOutputParamList(paramList
                    .stream()
                    .filter(o -> Objects.equals(o.getMode(), ParamMode.OUTPUT.getValue()))
                    .sorted(Comparator.comparing(AutoexecParamVo::getSort))
                    .collect(Collectors.toList()));
        }
        return super.getOutputParamList();
    }

    public Long getDefaultProfileId() {
        return defaultProfileId;
    }

    public void setDefaultProfileId(Long defaultProfileId) {
        this.defaultProfileId = defaultProfileId;
    }

    public String getDefaultProfileName() {
        return defaultProfileName;
    }

    public void setDefaultProfileName(String defaultProfileName) {
        this.defaultProfileName = defaultProfileName;
    }
}
