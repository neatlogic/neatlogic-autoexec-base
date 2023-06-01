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

public class AutoexecJobParamTypeChangedException extends ApiRuntimeException {

    private static final long serialVersionUID = 3718741083995150836L;

    public AutoexecJobParamTypeChangedException(String combopName, String keyName, String oldType, String newType) {
        super("组合工具“{0}”的作业参数“{1}“类型发生变化，由“{2}”变成“{3}”类型", combopName, keyName, oldType, newType);
    }
}
