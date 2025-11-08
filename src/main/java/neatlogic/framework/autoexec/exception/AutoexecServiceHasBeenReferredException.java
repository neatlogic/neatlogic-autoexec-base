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

/**
 * @author longrf
 * @date 2023/2/21 12:17
 */

public class AutoexecServiceHasBeenReferredException extends ApiRuntimeException {

    private static final long serialVersionUID = -928903159471839786L;

    public AutoexecServiceHasBeenReferredException(String name) {
        super("目录：“{0}”或其子目录中还有服务，不可删除", name);
    }
}
