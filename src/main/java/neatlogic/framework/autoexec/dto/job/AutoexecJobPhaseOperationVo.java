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

package neatlogic.framework.autoexec.dto.job;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import neatlogic.framework.autoexec.constvalue.CombopOperationType;
import neatlogic.framework.autoexec.constvalue.FailPolicy;
import neatlogic.framework.autoexec.constvalue.ParamMappingMode;
import neatlogic.framework.autoexec.dto.AutoexecOperationBaseVo;
import neatlogic.framework.autoexec.dto.AutoexecOperationVo;
import neatlogic.framework.autoexec.dto.AutoexecParamVo;
import neatlogic.framework.autoexec.dto.AutoexecToolVo;
import neatlogic.framework.autoexec.dto.combop.AutoexecCombopPhaseOperationConfigVo;
import neatlogic.framework.autoexec.dto.combop.AutoexecCombopPhaseOperationVo;
import neatlogic.framework.autoexec.dto.combop.ParamMappingVo;
import neatlogic.framework.autoexec.dto.script.AutoexecScriptLineVo;
import neatlogic.framework.autoexec.dto.script.AutoexecScriptVersionVo;
import neatlogic.framework.autoexec.dto.script.AutoexecScriptVo;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.exception.type.ParamIrregularException;
import neatlogic.framework.restful.annotation.EntityField;
import neatlogic.framework.util.SnowflakeUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @author lvzk
 * @since 2021/4/12 16:22
 **/
public class AutoexecJobPhaseOperationVo implements Serializable {
    private static final long serialVersionUID = 5504642984478163497L;
    @EntityField(name = "作业剧本操作id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "作业id", type = ApiParamType.LONG)
    private Long jobId;
    @EntityField(name = "作业剧本id", type = ApiParamType.LONG)
    private Long jobPhaseId;
    @EntityField(name = "作业剧本操作唯一标识", type = ApiParamType.STRING)
    private String uk;
    @EntityField(name = "作业剧本操作名", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "作业剧本操作名后缀", type = ApiParamType.STRING)
    private String letter;
    @EntityField(name = "工具描述", type = ApiParamType.STRING)
    private String description;
    @EntityField(name = "作业剧本节点操作类型 script|tool", type = ApiParamType.STRING)
    private String type;
    @EntityField(name = "执行方式 local|remote", type = ApiParamType.STRING)
    private String execMode;
    @EntityField(name = "失败策略 stop|goon", type = ApiParamType.STRING)
    private String failPolicy;
    @EntityField(name = "失败跳过 1：是 0：否", type = ApiParamType.STRING)
    private Integer failIgnore;
    @EntityField(name = "解析器 python|perl等", type = ApiParamType.STRING)
    private String parser;
    @EntityField(name = "参数Str", type = ApiParamType.STRING)
    private String paramStr;
    @EntityField(name = "参数JSON", type = ApiParamType.JSONOBJECT)
    private JSONObject param;
    @EntityField(name = "入参", type = ApiParamType.JSONARRAY)
    private JSONArray inputParamList;
    @EntityField(name = "出参", type = ApiParamType.JSONARRAY)
    private JSONArray outputParamList;
    @EntityField(name = "顺序", type = ApiParamType.INTEGER)
    private Integer sort;
    @EntityField(name = "父工具id", type = ApiParamType.LONG)
    private Long parentOperationId;
    @EntityField(name = "父工具类型", type = ApiParamType.LONG)
    private String parentOperationType;
    private Long operationId;
    private Long versionId;
    private String paramHash;
    private String uuid;

    private String script;
    private Long scriptId;
    private String scriptHash;
    @EntityField(name = "预制参数集id", type = ApiParamType.LONG)
    private Long profileId;

    public AutoexecJobPhaseOperationVo() {
    }

    public AutoexecJobPhaseOperationVo(JSONObject operationJson, Integer i, AutoexecJobPhaseVo phaseVo, AutoexecScriptVo scriptVo, AutoexecScriptVersionVo scriptVersionVo, List<AutoexecScriptLineVo> scriptLineVoList) {
        this.execMode = phaseVo.getExecMode();
        this.uk = scriptVo.getUk();
        this.name = scriptVo.getName();
        this.jobPhaseId = phaseVo.getId();
        this.type = CombopOperationType.SCRIPT.getValue();
        this.execMode = scriptVo.getExecMode();
        this.failPolicy = operationJson.getString("failPolicy");
        this.parser = scriptVersionVo.getParser();
        //拼接操作脚本到config
        JSONObject operationConfigJson = operationJson.getJSONObject("config");
        this.paramStr = operationConfigJson.toString();
        this.scriptId = scriptVo.getId();

    }

    public AutoexecJobPhaseOperationVo(AutoexecCombopPhaseOperationVo autoexecCombopPhaseOperationVo, AutoexecJobPhaseVo phaseVo, AutoexecOperationVo scriptVo, AutoexecScriptVersionVo scriptVersionVo, String script, List<AutoexecJobPhaseVo> jobPhaseVoList, Map<String, String> preOperationNameMap) {
        scriptVo.setParser(scriptVersionVo.getParser());
        scriptVo.setOperationType(CombopOperationType.SCRIPT.getValue());
        this.versionId = scriptVersionVo.getId();
        this.scriptId = scriptVo.getId();
        construct(autoexecCombopPhaseOperationVo, phaseVo, jobPhaseVoList, scriptVo, preOperationNameMap);
    }

    public AutoexecJobPhaseOperationVo(AutoexecCombopPhaseOperationVo autoexecCombopPhaseOperationVo, AutoexecJobPhaseVo phaseVo, AutoexecToolVo toolVo, List<AutoexecJobPhaseVo> jobPhaseVoList, Map<String, String> preOperationNameMap) {
        toolVo.setOperationType(CombopOperationType.TOOL.getValue());
        construct(autoexecCombopPhaseOperationVo, phaseVo, jobPhaseVoList, toolVo, preOperationNameMap);
    }

    private void construct(AutoexecCombopPhaseOperationVo autoexecCombopPhaseOperationVo, AutoexecJobPhaseVo phaseVo, List<AutoexecJobPhaseVo> jobPhaseVoList, AutoexecOperationVo operationVo, Map<String, String> preOperationNameMap) {
        this.jobId = phaseVo.getJobId();
        this.execMode = phaseVo.getExecMode();
        this.uk = operationVo.getUk();
        this.name = autoexecCombopPhaseOperationVo.getOperationName();
        this.jobPhaseId = phaseVo.getId();
        this.type = operationVo.getOperationType();
        this.execMode = operationVo.getExecMode();
        this.failPolicy = autoexecCombopPhaseOperationVo.getFailPolicy();
        this.parser = operationVo.getParser();
        this.sort = autoexecCombopPhaseOperationVo.getSort() == null ? 0 : autoexecCombopPhaseOperationVo.getSort();//兼容operation sort 为null bug
        this.operationId = autoexecCombopPhaseOperationVo.getOperationId();
        this.letter = autoexecCombopPhaseOperationVo.getLetter();
        this.setParentOperationId(autoexecCombopPhaseOperationVo.getParentOperationId());
        this.setParentOperationType(autoexecCombopPhaseOperationVo.getParentOperationType());
        //拼接操作脚本到config
        JSONObject paramObj = new JSONObject();
        AutoexecCombopPhaseOperationConfigVo operationConfigVo = autoexecCombopPhaseOperationVo.getConfig();
        List<ParamMappingVo> paramMappingVos = operationConfigVo.getParamMappingList();
        List<ParamMappingVo> argumentMappingVos = operationConfigVo.getArgumentMappingList();
        AutoexecOperationBaseVo autoexecOperationBaseVo = autoexecCombopPhaseOperationVo.getOperation();
        List<AutoexecParamVo> inputParamList = autoexecOperationBaseVo.getInputParamList();
        AutoexecParamVo argumentParam = autoexecOperationBaseVo.getArgument();
        //替换输入参数（上游参数）
        if (CollectionUtils.isNotEmpty(paramMappingVos)) {
            for (ParamMappingVo paramMappingVo : paramMappingVos) {
                for (AutoexecParamVo input : inputParamList) {
                    exchangeParam(paramMappingVo, input, phaseVo, jobPhaseVoList, operationVo, preOperationNameMap);
                }
            }
        }
        //替换自由参数（上游参数）
        if (CollectionUtils.isNotEmpty(argumentMappingVos)) {
            for (ParamMappingVo argumentMappingVo : argumentMappingVos) {
                if (argumentParam != null) {
                    exchangeParam(argumentMappingVo, argumentParam, phaseVo, jobPhaseVoList, operationVo, preOperationNameMap);
                }
            }
        }
        paramObj.put("outputParamList", autoexecOperationBaseVo.getOutputParamList());
        paramObj.put("inputParamList", paramMappingVos);
        paramObj.put("argumentList", argumentMappingVos);
        this.paramStr = paramObj.toString();
        this.scriptId = operationVo.getId();
        this.uuid = autoexecCombopPhaseOperationVo.getUuid();
        //profileId
        this.profileId = autoexecCombopPhaseOperationVo.getConfig().getProfileId();
    }

    /**
     * 替换参数值（上游参数）
     *
     * @param paramMappingVo      输入值
     * @param param               定义的参数
     * @param phaseVo             阶段
     * @param jobPhaseVoList      所有阶段
     * @param operationVo         工具
     * @param preOperationNameMap 记录上游阶段工具uuid对应的名称
     */
    private void exchangeParam(ParamMappingVo paramMappingVo, AutoexecParamVo param, AutoexecJobPhaseVo phaseVo, List<AutoexecJobPhaseVo> jobPhaseVoList, AutoexecOperationVo operationVo, Map<String, String> preOperationNameMap) {
        if (Objects.equals(paramMappingVo.getKey(), param.getKey())) {
            paramMappingVo.setType(param.getType());
            paramMappingVo.setName(param.getName());
            paramMappingVo.setDescription(param.getDescription());
            Object value = paramMappingVo.getValue();
            if (Arrays.asList(ParamMappingMode.PRE_NODE_OUTPUT_PARAM.getValue(), ParamMappingMode.PRE_NODE_OUTPUT_PARAM_KEY.getValue()).contains(paramMappingVo.getMappingMode())) {
                if (value instanceof JSONArray) {
                    JSONArray values = (JSONArray) value;
                    if (values.size() == 3) {
                        String phaseUuid = values.getString(0);
                        String opUuid = values.getString(1);
                        value = values.getString(2);
                        Optional<AutoexecJobPhaseVo> phaseVoOptional = jobPhaseVoList.parallelStream().filter(o -> Objects.equals(o.getUuid(), phaseUuid)).findFirst();
                        if (phaseVoOptional.isPresent()) {
                            Optional<AutoexecJobPhaseOperationVo> operationVoOptional = phaseVoOptional.get().getOperationList().parallelStream().filter(o -> Objects.equals(o.getUuid(), opUuid)).findFirst();
                            if (operationVoOptional.isPresent()) {
                                String valueFormat = "${%s.%s_%d.%s}";
                                if (Objects.equals(paramMappingVo.getMappingMode(), ParamMappingMode.PRE_NODE_OUTPUT_PARAM_KEY.getValue())) {
                                    valueFormat = "#{%s.%s_%d.%s}";
                                }
                                paramMappingVo.setValue(String.format(valueFormat, phaseVoOptional.get().getName(), preOperationNameMap.get(opUuid), operationVoOptional.get().getId(), value));
                            } else {
                                throw new ParamIrregularException(phaseVo.getName() + ":" + operationVo.getName() + ":" + param.getName() + " operation");
                            }
                        } else {
                            throw new ParamIrregularException(phaseVo.getName() + ":" + operationVo.getName() + ":" + param.getName() + " phase");
                        }
                    } else {
                        throw new ParamIrregularException(phaseVo.getName() + ":" + operationVo.getName() + ":" + param.getName());
                    }
                } else {
                    throw new ParamIrregularException(phaseVo.getName() + ":" + operationVo.getName() + ":" + param.getName());
                }
            }
        }
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

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Long getJobPhaseId() {
        return jobPhaseId;
    }

    public void setJobPhaseId(Long jobPhaseId) {
        this.jobPhaseId = jobPhaseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getParamStr() {
        return paramStr;
    }

    public void setParamStr(String paramStr) {
        this.paramStr = paramStr;
    }

    public JSONObject getParam() {
        if (StringUtils.isNotBlank(paramStr)) {
            return JSONObject.parseObject(paramStr);
        }
        return param;
    }

    public String getExecMode() {
        return execMode;
    }

    public void setExecMode(String execMode) {
        this.execMode = execMode;
    }

    public String getFailPolicy() {
        return failPolicy;
    }

    public void setFailPolicy(String failPolicy) {
        this.failPolicy = failPolicy;
    }

    public String getParser() {
        return parser;
    }

    public void setParser(String parser) {
        this.parser = parser;
    }

    public JSONArray getInputParamList() {
        return inputParamList;
    }

    public JSONArray getOutputParamList() {
        return outputParamList;
    }

    public String getUk() {
        return uk;
    }

    public void setUk(String uk) {
        this.uk = uk;
    }

    public Integer getFailIgnore() {
        if (StringUtils.isNotBlank(failPolicy)) {
            if (FailPolicy.GOON.getValue().equalsIgnoreCase(failPolicy)) {
                return 1;
            } else {
                return 0;
            }
        }
        return failIgnore;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public String getScriptHash() {
        if (StringUtils.isNotBlank(script)) {
            scriptHash = DigestUtils.md5DigestAsHex(script.getBytes(StandardCharsets.UTF_8));
        }
        return scriptHash;
    }

    public String getParamHash() {
        if (StringUtils.isNotBlank(paramStr)) {
            paramHash = DigestUtils.md5DigestAsHex(paramStr.getBytes(StandardCharsets.UTF_8));
        }
        return paramHash;
    }

    public Long getScriptId() {
        return scriptId;
    }

    public void setScriptId(Long scriptId) {
        this.scriptId = scriptId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Long getVersionId() {
        return versionId;
    }

    public void setVersionId(Long versionId) {
        this.versionId = versionId;
    }

    public Long getOperationId() {
        return operationId;
    }

    public void setOperationId(Long operationId) {
        this.operationId = operationId;
    }

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public Long getParentOperationId() {
        return parentOperationId;
    }

    public void setParentOperationId(Long parentOperationId) {
        this.parentOperationId = parentOperationId;
    }

    public String getParentOperationType() {
        return parentOperationType;
    }

    public void setParentOperationType(String parentOperationType) {
        this.parentOperationType = parentOperationType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }
}
