/*Copyright (C) 2023  深圳极向量科技有限公司 All Rights Reserved.

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.*/

package neatlogic.framework.autoexec.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class AutoexecJobParamTypeChangedException extends ApiRuntimeException {

    private static final long serialVersionUID = 3718741083995150836L;

    public AutoexecJobParamTypeChangedException(String combopName, String keyName, String oldType, String newType) {
        super("组合工具“{0}”的作业参数“{1}“类型发生变化，由“{2}”变成“{3}”类型", combopName, keyName, oldType, newType);
    }
}
