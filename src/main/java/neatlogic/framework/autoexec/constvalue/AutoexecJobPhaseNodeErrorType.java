/*
 * Copyright (C) 2024  深圳极向量科技有限公司 All Rights Reserved.
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

package neatlogic.framework.autoexec.constvalue;

import neatlogic.framework.util.$;

public enum AutoexecJobPhaseNodeErrorType{
    IP_INVALID(1,"ip不合法"),
    RUNNER_NOT_MATCH(2,"根据ip找不到匹配的runner，请核对runner组配置")
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
