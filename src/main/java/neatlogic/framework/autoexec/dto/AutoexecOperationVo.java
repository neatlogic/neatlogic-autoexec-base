/*
Copyright(c) $today.year NeatLogic Co., Ltd. All Rights Reserved.

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

package neatlogic.framework.autoexec.dto;

import neatlogic.framework.asynchronization.threadlocal.UserContext;
import neatlogic.framework.auth.core.AuthActionChecker;
import neatlogic.framework.autoexec.auth.AUTOEXEC_MODIFY;
import neatlogic.framework.autoexec.constvalue.ParamMode;
import neatlogic.framework.autoexec.dto.combop.AutoexecCombopVo;
import neatlogic.framework.autoexec.dto.script.AutoexecScriptVo;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.dto.OperateVo;
import neatlogic.framework.restful.annotation.EntityField;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
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

    @EntityField(name = "是否库文件", type = ApiParamType.INTEGER)
    private Integer isLib = 0;
    @EntityField(name = "是否库文件 名", type = ApiParamType.STRING)
    private String isLibName;

    @JSONField(serialize = false)
    private List<Long> excludeList;
    @JSONField(serialize = false)
    private Integer isNeedCheckDataAuth = 0; //是否校验数据权限（1：校验，0：不校验）

    public AutoexecOperationVo() {

    }

    public AutoexecOperationVo(AutoexecToolVo autoexecToolVo) {
        super(autoexecToolVo);
        this.defaultProfileId = autoexecToolVo.getDefaultProfileId();
        this.defaultProfileName = autoexecToolVo.getDefaultProfileName();
    }

    public AutoexecOperationVo(AutoexecScriptVo autoexecScriptVo) {
        super(autoexecScriptVo);
        this.defaultProfileId = autoexecScriptVo.getDefaultProfileId();
        this.defaultProfileName = autoexecScriptVo.getDefaultProfileName();
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

    public List<Long> getExcludeList() {
        return excludeList;
    }

    public void setExcludeList(List<Long> excludeList) {
        this.excludeList = excludeList;
    }

    public Integer getIsNeedCheckDataAuth() {
        if (isNeedCheckDataAuth == 1 && AuthActionChecker.check(AUTOEXEC_MODIFY.class)) {
            isNeedCheckDataAuth = 0;
        }
        return isNeedCheckDataAuth;
    }

    public void setIsNeedCheckDataAuth(Integer isNeedCheckDataAuth) {
        this.isNeedCheckDataAuth = isNeedCheckDataAuth;
    }

    public List<String> getAuthUuidList() {
        return UserContext.get().getUuidList();
    }

    public Integer getIsLib() {
        return isLib;
    }

    public void setIsLib(Integer isLib) {
        this.isLib = isLib;
    }

    public void setIsLibName(String isLibName) {
        this.isLibName = isLibName;
    }

    public String getIsLibName() {
        if (StringUtils.isBlank(isLibName)) {
            return isLib == 1 ? "是" : "否";
        }
        return isLibName;
    }
}
