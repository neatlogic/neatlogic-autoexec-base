package codedriver.framework.autoexec.dto.global.param;

import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.common.dto.BaseEditorVo;
import codedriver.framework.restful.annotation.EntityField;
import codedriver.framework.util.SnowflakeUtil;

/**
 * @author longrf
 * @date 2022/4/18 6:59 下午
 */
public class AutoexecGlobalParamVo extends BaseEditorVo {
    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "参数名", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "显示名", type = ApiParamType.STRING)
    private String displayName;
    @EntityField(name = "参数值", type = ApiParamType.STRING)
    private String value;
    @EntityField(name = "类型", type = ApiParamType.STRING)
    private String Type;
    @EntityField(name = "描述", type = ApiParamType.STRING)
    private String description;

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

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getValue() {
        return value;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        this.Type = type;
    }

    public void setValue(String value) {
        this.value = value;

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
