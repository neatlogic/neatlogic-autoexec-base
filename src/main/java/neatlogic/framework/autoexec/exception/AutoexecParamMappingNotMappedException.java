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

/**
 * @author: linbq
 * @since: 2021/4/19 14:14
 **/
public class AutoexecParamMappingNotMappedException extends ApiRuntimeException {

    private static final long serialVersionUID = -977878375722886383L;

    public AutoexecParamMappingNotMappedException(String phaseName, String operationName, String key) {
        super("阶段[{0}]工具[{1}]的新增必填参数：“{2}”没有默认值", phaseName, operationName, key);
    }
    public AutoexecParamMappingNotMappedException(String key) {
        super("作业参数：“{0}”未映射", key);
    }
}
