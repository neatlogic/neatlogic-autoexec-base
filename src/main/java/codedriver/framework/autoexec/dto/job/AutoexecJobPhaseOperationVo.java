/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.job;

import codedriver.framework.autoexec.constvalue.FailPolicy;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

/**
 * @author lvzk
 * @since 2021/4/12 16:22
 **/
public class AutoexecJobPhaseOperationVo {
    @EntityField(name = "作业剧本操作id", type = ApiParamType.LONG)
    private Long id;
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
    @EntityField(name = "全局参数Str", type = ApiParamType.STRING)
    private String paramStr;
    @EntityField(name = "全局参数JSON", type = ApiParamType.JSONOBJECT)
    private JSONObject param;
    @EntityField(name = "入参", type = ApiParamType.JSONARRAY)
    private JSONArray inputParamList;
    @EntityField(name = "出参", type = ApiParamType.JSONARRAY)
    private JSONArray outputParamList;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if(StringUtils.isNotBlank(paramStr)){
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
        if(StringUtils.isNotBlank(failPolicy)){
            if(FailPolicy.GOON.getValue().equalsIgnoreCase(failPolicy)){
                return 1;
            }else{
                return 0;
            }
        }
        return failIgnore;
    }
}
