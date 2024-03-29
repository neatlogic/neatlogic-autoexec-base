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

package neatlogic.framework.autoexec.dto.script;

import neatlogic.framework.autoexec.constvalue.ParamType;
import neatlogic.framework.autoexec.dto.AutoexecParamVo;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.lcs.constvalue.ChangeType;
import neatlogic.framework.restful.annotation.EntityField;

import java.util.Objects;

public class AutoexecScriptArgumentVo extends AutoexecParamVo {
    @EntityField(name = "脚本版本ID", type = ApiParamType.LONG)
    private Long scriptVersionId;
    @EntityField(name = "插入(insert)、删除(delete)、更新(update)", type = ApiParamType.ENUM, member = ChangeType.class)
    private String changeType;

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

    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType;
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
