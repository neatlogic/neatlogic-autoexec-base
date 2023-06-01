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
 * @since: 2021/4/19 11:23
 **/
public class AutoexecParamMappingTargetNotFoundException extends ApiRuntimeException {

    private static final long serialVersionUID = -977868375722886184L;

    public AutoexecParamMappingTargetNotFoundException(String phaseName, String operationName, String key, String target) {
        super("阶段[{0}]工具[{1}]的参数：“{2}”映射目标“{3}”不存在", phaseName, operationName, key, target);
    }

    public AutoexecParamMappingTargetNotFoundException(String phaseName, String target) {
        super("阶段[{0}]的执行用户映射作业参数“{1}”不存在", phaseName, target);
    }
    public AutoexecParamMappingTargetNotFoundException(Integer groupSort, String target) {
        super("阶段组[{0}]的执行用户映射作业参数“{1}”不存在", groupSort, target);
    }
    public AutoexecParamMappingTargetNotFoundException(String target) {
        super("执行目标的执行用户映射作业参数“{0}”不存在", target);
    }

}
