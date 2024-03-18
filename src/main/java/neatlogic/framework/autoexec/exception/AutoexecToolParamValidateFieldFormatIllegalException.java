/*Copyright (C) $today.year  深圳极向量科技有限公司 All Rights Reserved.

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

public class AutoexecToolParamValidateFieldFormatIllegalException extends ApiRuntimeException {

    private static final long serialVersionUID = 5118560220174183144L;

    public AutoexecToolParamValidateFieldFormatIllegalException(String param, String fieldContent) {
        super("参数“{0}”的validate配置中，“{1}”的格式不正确，应该为JSON对象", param, fieldContent);
    }


}
