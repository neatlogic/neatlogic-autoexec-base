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

public class AutoexecJobNodePreParamValueNotInvalidException extends ApiRuntimeException {
    private static final long serialVersionUID = 616139541025262810L;

    public AutoexecJobNodePreParamValueNotInvalidException(Long id, String phaseName) {
        super("作业“{0}”-阶段“{1}” 根据上游参数初始化执行目标失败，上游出参的值不存在或不合法", id, phaseName);
    }

}
