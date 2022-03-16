package codedriver.framework.autoexec.dto.profile;

import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.common.dto.BasePageVo;
import codedriver.framework.restful.annotation.EntityField;
import codedriver.framework.util.SnowflakeUtil;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * @author longrf
 * @date 2022/3/16 11:34 上午
 */
public class AutoexecProfileVo extends BasePageVo {

    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "名称", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "描述", type = ApiParamType.STRING)
    private String description;
    @EntityField(name = "工具参数", type = ApiParamType.JSONOBJECT)
    private JSONObject config;
    @EntityField(name = "工具类型", type = ApiParamType.STRING)
    private String type;
    @EntityField(name = "脚本工具id", type = ApiParamType.LONG)
    private Long scriptId;
    @EntityField(name = "工具库工具id", type = ApiParamType.LONG)
    private Long toolId;
    @EntityField(name = "工具库工具id/脚本工具id", type = ApiParamType.LONG)
    private Long operateId;

    public Long getId() {
        if (id == null) {
            id = SnowflakeUtil.uniqueLong();
        }
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public JSONObject getConfig() {
        return config;
    }

    public void setConfig(JSONObject config) {
        this.config = config;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getScriptId() {
        if (Objects.isNull(scriptId) && StringUtils.equals(type, "script") && !Objects.isNull(operateId)) {
            scriptId = operateId;
        }
        return scriptId;
    }

    public void setScriptId(Long scriptId) {
        this.scriptId = scriptId;
    }

    public Long getToolId() {
        if (Objects.isNull(toolId) && StringUtils.equals(type, "tool") && !Objects.isNull(operateId)) {
            toolId = operateId;
        }
        return toolId;
    }

    public void setToolId(Long toolId) {
        this.toolId = toolId;
    }

    public Long getOperateId() {
        return operateId;
    }

    public void setOperateId(Long operateId) {
        this.operateId = operateId;
    }
}
