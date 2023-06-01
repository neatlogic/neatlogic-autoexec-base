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

package neatlogic.framework.autoexec.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class AutoexecToolParamValidateFieldLostException extends ApiRuntimeException {

    private static final long serialVersionUID = 5190517136889826388L;

    public AutoexecToolParamValidateFieldLostException(String param, String field, String lostField) {
        super("参数“{0}”的validate配置中，名称为“{1}”的规则缺少“{2}”字段", param, field, lostField);
    }

    public AutoexecToolParamValidateFieldLostException(String param, int fieldIndex, String lostField) {
        super("参数“{0}”的validate配置中，第：{1} 个的规则缺少“{2}”字段", param, fieldIndex, lostField);
    }


}
