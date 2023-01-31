/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.autoexec.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

/**
 * @author: linbq
 * @since: 2021/4/19 14:07
 **/
public class AutoexecParamMappingIncorrectException extends ApiRuntimeException{

    private static final long serialVersionUID = -977868375722886383L;

    public AutoexecParamMappingIncorrectException(String phaseName, String operationName, String key){
        super("阶段[" + phaseName + "]工具[" + operationName + "]的参数：'" + key + "'映射不正确");
    }

}
