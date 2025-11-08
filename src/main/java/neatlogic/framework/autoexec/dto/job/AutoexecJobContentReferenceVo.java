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

package neatlogic.framework.autoexec.dto.job;

public class AutoexecJobContentReferenceVo {
    int isUsedInJobConfig = 0;

    int isUsedInJobParam = 0;

    int isUsedInPhaseOperation = 0;

    public int getIsUsedInJobConfig() {
        return isUsedInJobConfig;
    }

    public void setIsUsedInJobConfig(int isUsedInJobConfig) {
        this.isUsedInJobConfig = isUsedInJobConfig;
    }

    public int getIsUsedInJobParam() {
        return isUsedInJobParam;
    }

    public void setIsUsedInJobParam(int isUsedInJobParam) {
        this.isUsedInJobParam = isUsedInJobParam;
    }

    public int getIsUsedInPhaseOperation() {
        return isUsedInPhaseOperation;
    }

    public void setIsUsedInPhaseOperation(int isUsedInPhaseOperation) {
        this.isUsedInPhaseOperation = isUsedInPhaseOperation;
    }

    public boolean isReferenced(){
        return isUsedInJobConfig == 1 ||  isUsedInJobParam == 1 || isUsedInPhaseOperation == 1;
    }
}
