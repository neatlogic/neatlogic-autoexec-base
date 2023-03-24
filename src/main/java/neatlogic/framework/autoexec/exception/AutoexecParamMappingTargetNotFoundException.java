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

package neatlogic.framework.autoexec.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

/**
 * @author: linbq
 * @since: 2021/4/19 11:23
 **/
public class AutoexecParamMappingTargetNotFoundException extends ApiRuntimeException {

    private static final long serialVersionUID = -977868375722886184L;

    public AutoexecParamMappingTargetNotFoundException(String phaseName, String operationName, String key, String target) {
        super("exception.autoexec.autoexecparammappingtargetnotfoundexception", phaseName, operationName, key, target);
    }

    public AutoexecParamMappingTargetNotFoundException(String phaseName, String target) {
        super("exception.autoexec.autoexecparammappingtargetnotfoundexception.1", phaseName, target);
    }
    public AutoexecParamMappingTargetNotFoundException(Integer groupSort, String target) {
        super("exception.autoexec.autoexecparammappingtargetnotfoundexception.2", groupSort, target);
    }
    public AutoexecParamMappingTargetNotFoundException(String target) {
        super("exception.autoexec.autoexecparammappingtargetnotfoundexception.3", target);
    }

}
