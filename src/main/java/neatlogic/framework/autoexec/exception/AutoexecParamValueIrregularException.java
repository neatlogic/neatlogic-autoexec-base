/*
 *
 * Copyright (C) 2025  TechSure Co., Ltd.  All Rights Reserved.
 * This file is part of the NeatLogic software.
 * Licensed under the NeatLogic Sustainable Use License (NSUL), Version 4.x – 2025.
 * You may use this file only in compliance with the License.
 * See the LICENSE file distributed with this work for the full license text.
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 */

package neatlogic.framework.autoexec.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class AutoexecParamValueIrregularException extends ApiRuntimeException {

    private static final long serialVersionUID = -977869375722886183L;

    public AutoexecParamValueIrregularException(String phaseName, String operationName, String paramName, String paramKey, String paramValue) {
        super("nfae.autoexecparamvalueirregularexception.autoexecparamvalueirregularexception_a", phaseName, operationName, paramName, paramKey, paramValue);
    }

    public AutoexecParamValueIrregularException(String operationName, String paramName, String paramKey, String paramValue) {
        super("nfae.autoexecparamvalueirregularexception.autoexecparamvalueirregularexception_b", operationName, paramName, paramKey, paramValue);
    }

    public AutoexecParamValueIrregularException(String paramName, String paramKey, String paramValue) {
        super("nfae.autoexecparamvalueirregularexception.autoexecparamvalueirregularexception_c", paramName, paramKey, paramValue);
    }
}
