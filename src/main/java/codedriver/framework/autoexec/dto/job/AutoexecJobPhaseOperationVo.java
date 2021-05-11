/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.job;

import codedriver.framework.autoexec.constvalue.CombopOperationType;
import codedriver.framework.autoexec.constvalue.FailPolicy;
import codedriver.framework.autoexec.dto.combop.AutoexecCombopPhaseOperationConfigVo;
import codedriver.framework.autoexec.dto.combop.AutoexecCombopPhaseOperationVo;
import codedriver.framework.autoexec.dto.combop.ParamMappingVo;
import codedriver.framework.autoexec.dto.script.AutoexecScriptLineVo;
import codedriver.framework.autoexec.dto.script.AutoexecScriptVersionParamVo;
import codedriver.framework.autoexec.dto.script.AutoexecScriptVersionVo;
import codedriver.framework.autoexec.dto.script.AutoexecScriptVo;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;
import codedriver.framework.util.SnowflakeUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author lvzk
 * @since 2021/4/12 16:22
 **/
public class AutoexecJobPhaseOperationVo {
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
    private String paramHash;

    private String script;
    private String scriptHash;

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
        StringBuilder scriptSb = new StringBuilder();
        for (AutoexecScriptLineVo lineVo : scriptLineVoList) {
            scriptSb.append(lineVo.getContent());
        }
        String script = scriptSb.toString();
        operationConfigJson.put("script", script);
        this.script = script;
        this.paramStr = operationConfigJson.toString();

    }

    public AutoexecJobPhaseOperationVo(AutoexecCombopPhaseOperationVo autoexecCombopPhaseOperationVo, AutoexecJobPhaseVo phaseVo, AutoexecScriptVo scriptVo, AutoexecScriptVersionVo scriptVersionVo, List<AutoexecScriptLineVo> scriptLineVoList) {
        this.jobId = phaseVo.getJobId();
        this.execMode = phaseVo.getExecMode();
        this.uk = scriptVo.getUk();
        this.name = scriptVo.getName();
        this.jobPhaseId = phaseVo.getId();
        this.type = CombopOperationType.SCRIPT.getValue();
        this.execMode = scriptVo.getExecMode();
        this.failPolicy = autoexecCombopPhaseOperationVo.getFailPolicy();
        this.parser = scriptVersionVo.getParser();
        //拼接操作脚本到config
        JSONObject paramObj = new JSONObject();
        AutoexecCombopPhaseOperationConfigVo operationConfigVo = autoexecCombopPhaseOperationVo.getConfig();
        List<ParamMappingVo> paramMappingVos = operationConfigVo.getParamMappingList();

        List<AutoexecScriptVersionParamVo> inputParamList = autoexecCombopPhaseOperationVo.getInputParamList();

        StringBuilder scriptSb = new StringBuilder();
        for (AutoexecScriptLineVo lineVo : scriptLineVoList) {
            scriptSb.append(lineVo.getContent());
        }
        String script = scriptSb.toString();
        paramObj.put("script", script);
        this.script = script;
        paramObj.put("outputParamList",autoexecCombopPhaseOperationVo.getOutputParamList());
        this.paramStr = paramObj.toString();

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
        if(StringUtils.isNotBlank(script)){
            scriptHash = DigestUtils.md5DigestAsHex(script.getBytes(StandardCharsets.UTF_8));
        }
        return scriptHash;
    }

    public String getParamHash() {
        if(StringUtils.isNotBlank(paramStr)){
            paramHash = DigestUtils.md5DigestAsHex(paramStr.getBytes(StandardCharsets.UTF_8));
        }
        return paramHash;
    }
}
