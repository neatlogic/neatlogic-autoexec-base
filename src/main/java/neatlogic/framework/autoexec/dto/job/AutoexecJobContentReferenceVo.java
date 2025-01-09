/*
 * Copyright (C) 2025  深圳极向量科技有限公司 All Rights Reserved.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
