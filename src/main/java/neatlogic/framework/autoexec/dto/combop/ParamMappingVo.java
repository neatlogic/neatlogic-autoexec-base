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

import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;

import java.io.Serializable;

/**
 * @author: linbq
 * @since: 2021/4/21 18:42
 **/
public class ParamMappingVo implements Serializable {
    @EntityField(name = "参数名", type = ApiParamType.STRING)
    private String key;
    @EntityField(name = "参数中文名", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "映射方式", type = ApiParamType.STRING)
    private String mappingMode;
    @EntityField(name = "值", type = ApiParamType.NOAUTH)
    private Object value;
    @EntityField(name = "参数表单类型", type = ApiParamType.STRING)
    private String type;
    @EntityField(name = "参数描述", type = ApiParamType.STRING)
    private String description;

    public ParamMappingVo() {
    }

    public ParamMappingVo(String key, String mappingMode, String value) {
        this.key = key;
        this.mappingMode = mappingMode;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMappingMode() {
        return mappingMode;
    }

    public void setMappingMode(String mappingMode) {
        this.mappingMode = mappingMode;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
