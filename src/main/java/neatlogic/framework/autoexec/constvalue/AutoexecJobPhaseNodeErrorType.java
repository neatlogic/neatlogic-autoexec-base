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

package neatlogic.framework.autoexec.constvalue;

import neatlogic.framework.util.$;

public enum AutoexecJobPhaseNodeErrorType{
    IP_INVALID(1,"nfacv.autoexecjobphasenodeerrortype.text.ip_invalid"),
    RUNNER_NOT_MATCH(2,"nfacv.autoexecjobphasenodeerrortype.text.runner_not_match")
    ;

    private final int value;
    private final String text;

    AutoexecJobPhaseNodeErrorType(int value, String text) {
        this.value = value;
        this.text = text;
    }


    public Integer getValue() {
        return value;
    }

    public static AutoexecJobPhaseNodeErrorType getErrorType(int value){
        for (AutoexecJobPhaseNodeErrorType errorType : AutoexecJobPhaseNodeErrorType.values()){
            if(errorType.getValue() == value){
                return errorType;
            }
        }
        return null;
    }

    public String getText() {
        return $.t(text);
    }
}
