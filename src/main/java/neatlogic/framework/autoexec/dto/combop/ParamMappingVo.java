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
