/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.script;

import codedriver.framework.autoexec.constvalue.ChangeType;
import codedriver.framework.autoexec.dto.AutoexecParamVo;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;

import java.util.Objects;

public class AutoexecScriptVersionParamVo extends AutoexecParamVo {

    private static final long serialVersionUID = 8243453082594614181L;
    @EntityField(name = "脚本版本ID", type = ApiParamType.LONG)
    private Long scriptVersionId;
    @EntityField(name = "插入(insert)、删除(delete)、更新(update)", type = ApiParamType.ENUM, member = ChangeType.class)
    private String changeType;

    public AutoexecScriptVersionParamVo() {
    }

    public Long getScriptVersionId() {
        return scriptVersionId;
    }

    public void setScriptVersionId(Long scriptVersionId) {
        this.scriptVersionId = scriptVersionId;
    }

    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(o instanceof AutoexecScriptVersionParamVo)) {
            return false;
        }
        final AutoexecScriptVersionParamVo other = (AutoexecScriptVersionParamVo) o;
        return Objects.equals(this.getKey(), other.getKey())
                && Objects.equals(this.getName(), other.getName())
                && Objects.equals(this.getDefaultValueStr(), other.getDefaultValueStr())
                && Objects.equals(this.getType(), other.getType())
                && Objects.equals(this.getMode(), other.getMode())
                && Objects.equals(this.getIsRequired(), other.getIsRequired())
                && Objects.equals(this.getDescription(), other.getDescription());
    }

    @Override
    public int hashCode() {
        String _key = "";
        _key += (getKey() != null ? getKey() : "undefined") + "_";
        _key += (getName() != null ? getName() : "undefined") + "_";
        _key += (getDefaultValueStr() != null ? getDefaultValueStr() : "undefined") + "_";
        _key += (getType() != null ? getType() : "undefined") + "_";
        _key += (getMode() != null ? getMode() : "undefined") + "_";
        _key += (getIsRequired() != null ? getIsRequired() : "undefined") + "_";
        _key += (getDescription() != null ? getDescription() : "undefined") + "_";
        return _key.hashCode();
    }
}
