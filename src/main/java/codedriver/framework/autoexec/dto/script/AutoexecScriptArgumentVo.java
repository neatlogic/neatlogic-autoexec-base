/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.script;

import codedriver.framework.autoexec.constvalue.ParamType;
import codedriver.framework.autoexec.dto.AutoexecParamVo;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;

import java.util.Objects;

public class AutoexecScriptArgumentVo extends AutoexecParamVo {
    @EntityField(name = "脚本版本ID", type = ApiParamType.LONG)
    private Long scriptVersionId;

    public AutoexecScriptArgumentVo() {

    }

    public AutoexecScriptArgumentVo(AutoexecParamVo vo) {
        super.setName(vo.getName());
        super.setDefaultValue(vo.getDefaultValue());
        super.setDescription(vo.getDescription());
        super.setIsRequired(vo.getIsRequired());
        super.setArgumentCount(vo.getArgumentCount());
    }

    public Long getScriptVersionId() {
        return scriptVersionId;
    }

    public void setScriptVersionId(Long scriptVersionId) {
        this.scriptVersionId = scriptVersionId;
    }

    public String getType() {
        return ParamType.TEXT.getValue();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (!(other instanceof AutoexecParamVo)) {
            return false;
        }
        final AutoexecParamVo paramVo = (AutoexecParamVo) other;
        return Objects.equals(getName(), paramVo.getName()) && Objects.equals(getDefaultValueStr(), paramVo.getDefaultValueStr())
                && Objects.equals(getArgumentCount(), paramVo.getArgumentCount()) && Objects.equals(getIsRequired(), paramVo.getIsRequired())
                && Objects.equals(getDescription(), paramVo.getDescription());
    }

    @Override
    public int hashCode() {
        String key = "";
        if (getName() != null) {
            key += getName() + "_";
        }
        if (getArgumentCount() != null) {
            key += getArgumentCount() + "_";
        }
        if (getDefaultValueStr() != null) {
            key += getDefaultValueStr() + "_";
        }
        if (getIsRequired() != null) {
            key += getIsRequired();
        }
        if (getDescription() != null) {
            key += getDescription();
        }
        return key.hashCode();
    }

}
