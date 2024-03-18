/*Copyright (C) $today.year  深圳极向量科技有限公司 All Rights Reserved.

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

package neatlogic.framework.autoexec.dto.combop;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import neatlogic.framework.autoexec.constvalue.CombopOperationType;
import neatlogic.framework.autoexec.constvalue.FailPolicy;
import neatlogic.framework.autoexec.constvalue.ParamMappingMode;
import neatlogic.framework.autoexec.dto.AutoexecOperationBaseVo;
import neatlogic.framework.autoexec.dto.AutoexecParamVo;
import neatlogic.framework.autoexec.dto.AutoexecPhaseOperationParamVo;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.exception.type.ParamIrregularException;
import neatlogic.framework.restful.annotation.EntityField;
import neatlogic.framework.util.SnowflakeUtil;
import org.apache.commons.collections4.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 组合工具阶段操作Vo类
 *
 * @author: linbq
 * @since: 2021/4/13 10:08
 **/
public class AutoexecCombopPhaseOperationVo implements Serializable {

    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "描述", type = ApiParamType.STRING)
    private String description;
    @EntityField(name = "操作id", type = ApiParamType.LONG)
    private Long operationId;
    @EntityField(name = "工具名", type = ApiParamType.STRING)
    private String operationName;
    @EntityField(name = "操作类型，自定义工具或工具", type = ApiParamType.STRING)
    private String operationType;
    @EntityField(name = "失败策略", type = ApiParamType.STRING)
    private String failPolicy;
    @EntityField(name = "配置信息", type = ApiParamType.JSONOBJECT)
    private AutoexecCombopPhaseOperationConfigVo config;
    @EntityField(name = "排序", type = ApiParamType.INTEGER)
    private Integer sort;
    @EntityField(name = "父工具id", type = ApiParamType.LONG)
    private Long parentOperationId;
    @EntityField(name = "父工具类型", type = ApiParamType.LONG)
    private String parentOperationType;
    @JSONField(serialize = false)
    private String configStr;
    @EntityField(name = "uuid", type = ApiParamType.STRING)
    private String uuid;
    private String letter;

    @EntityField(name = "工具信息", type = ApiParamType.JSONOBJECT)
    private AutoexecOperationBaseVo operation;

    @EntityField(name = "指定脚本版本Id", type = ApiParamType.LONG)
    private Long scriptVersionId;

    public AutoexecCombopPhaseOperationVo() {
    }

    //目前用于工具测试，构造组合工具
    public AutoexecCombopPhaseOperationVo(AutoexecPhaseOperationParamVo phaseOperationParamVo) {
        this.operationName = phaseOperationParamVo.getName().replaceAll("//", "_");
        if (Objects.equals(phaseOperationParamVo.getOperationType(), CombopOperationType.SCRIPT.getValue())) {
            this.setScriptVersionId(phaseOperationParamVo.getOperationId());
        } else {
            this.setOperationId(phaseOperationParamVo.getOperationId());
        }
        this.operationType = phaseOperationParamVo.getOperationType();
        this.operation = new AutoexecOperationBaseVo();
        this.operation.setExecMode(phaseOperationParamVo.getExecMode());
        this.failPolicy = FailPolicy.STOP.getValue();
        this.operation.setParser(phaseOperationParamVo.getParser());
        this.operation.setName(this.operationName);
        this.sort = 0;
        this.description = phaseOperationParamVo.getDescription();
        AutoexecCombopPhaseOperationConfigVo operationConfigVo = new AutoexecCombopPhaseOperationConfigVo();
        this.setConfig(operationConfigVo);
        List<ParamMappingVo> paramMappingVoList = new ArrayList<>();
        operationConfigVo.setParamMappingList(paramMappingVoList);
        if (CollectionUtils.isNotEmpty(phaseOperationParamVo.getInputParamList())) {
            for (AutoexecParamVo paramVo : phaseOperationParamVo.getInputParamList()) {
                ParamMappingVo paramMappingVo = new ParamMappingVo();
                paramMappingVo.setKey(paramVo.getKey());
                paramMappingVo.setMappingMode(ParamMappingMode.RUNTIME_PARAM.getValue());
                paramMappingVo.setValue(paramVo.getKey());
                paramMappingVo.setType(paramVo.getType());
                paramMappingVoList.add(paramMappingVo);
            }
            this.operation.setInputParamList(phaseOperationParamVo.getInputParamList());
            this.operation.setOutputParamList(phaseOperationParamVo.getOutputParamList());
        }
        if (phaseOperationParamVo.getArgumentVo() != null && CollectionUtils.isEmpty(phaseOperationParamVo.getArgumentMappingList())) {
            throw new ParamIrregularException("argumentMappingList");
        }
        operationConfigVo.setArgumentMappingList(phaseOperationParamVo.getArgumentMappingList());
    }

    public Long getOperationId() {
        return operationId;
    }

    public void setOperationId(Long operationId) {
        this.operationId = operationId;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOperationName() {
        if (operation != null) {
            return operation.getName();
        }
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public AutoexecOperationBaseVo getOperation() {
        return operation;
    }

    public void setOperation(AutoexecOperationBaseVo operation) {
        this.operation = operation;
    }

    public String getFailPolicy() {
        return failPolicy;
    }

    public void setFailPolicy(String failPolicy) {
        this.failPolicy = failPolicy;
    }

    public AutoexecCombopPhaseOperationConfigVo getConfig() {
        if (config == null && configStr != null) {
            config = JSONObject.parseObject(configStr, AutoexecCombopPhaseOperationConfigVo.class);
        }
        return config;
    }

    public void setConfig(AutoexecCombopPhaseOperationConfigVo config) {
        if (config != null) {
            configStr = null;
        }
        this.config = config;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getConfigStr() {
        if (configStr == null && config != null) {
            configStr = JSONObject.toJSONString(config);
        }
        return configStr;
    }

    public void setConfigStr(String configStr) {
        if (configStr != null) {
            config = null;
        }
        this.configStr = configStr;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
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

    public Long getScriptVersionId() {
        return scriptVersionId;
    }

    public void setScriptVersionId(Long scriptVersionId) {
        this.scriptVersionId = scriptVersionId;
    }
}
