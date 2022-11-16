/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.exception;

import codedriver.framework.exception.core.ApiRuntimeException;

public class AutoexecParamValueIrregularException extends ApiRuntimeException {

    private static final long serialVersionUID = -977869375722886183L;

    public AutoexecParamValueIrregularException(String phaseName, String operationName, String paramName, String paramKey, String paramValue) {
        super("阶段[" + phaseName + "]工具[" + operationName + "]的参数：'" + paramName + "（" + paramKey + "）'的值：'" + paramValue + "'不符合格式要求");
    }

    public AutoexecParamValueIrregularException(String operationName, String paramName, String paramKey, String paramValue) {
        super(operationName + "的参数：'" + paramName + "（" + paramKey + "）'的值：'" + paramValue + "'不符合格式要求");
    }

    public AutoexecParamValueIrregularException(String paramName, String paramKey, String paramValue) {
        super("参数“" + paramName + "（" + paramKey + "）”的值“" + paramValue + "”不符合格式要求");
    }
}
