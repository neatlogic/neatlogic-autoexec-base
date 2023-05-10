/*
Copyright(c) 2023 NeatLogic Co., Ltd. All Rights Reserved.

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
import neatlogic.framework.autoexec.dto.AutoexecParamVo;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;

import java.util.Objects;

public class AutoexecScriptVersionParamVo extends AutoexecParamVo {

    private static final long serialVersionUID = 8243453082594614181L;
    @EntityField(name = "脚本版本ID", type = ApiParamType.LONG)
    private Long scriptVersionId;
    @EntityField(name = "插入(insert)、删除(delete)、更新(update)", type = ApiParamType.ENUM, member = ChangeType.class)
    private String changeType;

    public AutoexecScriptVersionParamVo() {
    }

    public AutoexecScriptVersionParamVo(AutoexecParamVo autoexecParamVo) {
        super(autoexecParamVo);
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
                && Objects.equals(this.getMappingMode(), other.getMappingMode())
                && Objects.equals(this.getIsRequired(), other.getIsRequired())
                && Objects.equals(this.getDescription(), other.getDescription())
                && Objects.equals(this.getConfigStr(), other.getConfigStr())
                ;
    }

    @Override
    public int hashCode() {
        String _key = "";
        _key += (getKey() != null ? getKey() : "undefined") + "_";
        _key += (getName() != null ? getName() : "undefined") + "_";
        _key += (getDefaultValueStr() != null ? getDefaultValueStr() : "undefined") + "_";
        _key += (getType() != null ? getType() : "undefined") + "_";
        _key += (getMode() != null ? getMode() : "undefined") + "_";
        _key += (getMappingMode() != null ? getMappingMode() : "undefined") + "_";
        _key += (getIsRequired() != null ? getIsRequired() : "undefined") + "_";
        _key += (getDescription() != null ? getDescription() : "undefined") + "_";
        _key += (getConfigStr() != null ? getConfigStr() : "undefined") + "_";
        return _key.hashCode();
    }
}
