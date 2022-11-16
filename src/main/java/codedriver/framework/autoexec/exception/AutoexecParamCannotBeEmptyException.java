/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.exception;

import codedriver.framework.exception.core.ApiRuntimeException;

/**
 * @author: linbq
 * @since: 2021/4/19 11:23
 **/
public class AutoexecParamCannotBeEmptyException extends ApiRuntimeException {

    private static final long serialVersionUID = -977868375722886186L;

    public AutoexecParamCannotBeEmptyException(String phaseName, String operationName, String key) {
        super("阶段[" + phaseName + "]工具[" + operationName + "]的参数：'" + key + "'不能为空");
    }

}
