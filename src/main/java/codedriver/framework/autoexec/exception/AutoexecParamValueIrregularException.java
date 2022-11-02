/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.exception;

import codedriver.framework.exception.core.ApiRuntimeException;

public class AutoexecParamValueIrregularException extends ApiRuntimeException {

    private static final long serialVersionUID = -977869375722886183L;

    public AutoexecParamValueIrregularException(String paramSource, String paramName, String paramKey, String paramValue) {
        super(paramSource + "：'" + paramName + "（" + paramKey + "）'的值：'" + paramValue + "'不符合格式要求");
    }
}
