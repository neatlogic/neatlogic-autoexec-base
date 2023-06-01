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

public class AutoexecParamValueIrregularException extends ApiRuntimeException {

    private static final long serialVersionUID = -977869375722886183L;

    public AutoexecParamValueIrregularException(String phaseName, String operationName, String paramName, String paramKey, String paramValue) {
        super("阶段[{0}]工具[{1}]的参数：{2}（{3}）的值：“{4}”不符合格式要求", phaseName, operationName, paramName, paramKey, paramValue);
    }

    public AutoexecParamValueIrregularException(String operationName, String paramName, String paramKey, String paramValue) {
        super("{0}的参数：{1}（{2}）的值：“{3}”不符合格式要求", operationName, paramName, paramKey, paramValue);
    }

    public AutoexecParamValueIrregularException(String paramName, String paramKey, String paramValue) {
        super("参数“{0}（{1}）”的值“{2}”不符合格式要求", paramName, paramKey, paramValue);
    }
}
