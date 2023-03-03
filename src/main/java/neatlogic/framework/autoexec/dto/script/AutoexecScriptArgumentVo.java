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

package neatlogic.framework.autoexec.dto.script;

import neatlogic.framework.lcs.constvalue.ChangeType;
import neatlogic.framework.autoexec.constvalue.ParamType;
import neatlogic.framework.autoexec.dto.AutoexecParamVo;
import neatlogic.framework.common.constvalue.ApiParamType;
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
