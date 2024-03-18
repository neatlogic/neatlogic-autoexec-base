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

public class AutoexecToolParamValidateFieldLostException extends ApiRuntimeException {

    private static final long serialVersionUID = 5190517136889826388L;

    public AutoexecToolParamValidateFieldLostException(String param, String field, String lostField) {
        super("参数“{0}”的validate配置中，名称为“{1}”的规则缺少“{2}”字段", param, field, lostField);
    }

    public AutoexecToolParamValidateFieldLostException(String param, int fieldIndex, String lostField) {
        super("参数“{0}”的validate配置中，第：{1} 个的规则缺少“{2}”字段", param, fieldIndex, lostField);
    }


}
