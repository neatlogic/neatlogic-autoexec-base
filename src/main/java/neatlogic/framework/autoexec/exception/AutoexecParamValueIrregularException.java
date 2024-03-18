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
