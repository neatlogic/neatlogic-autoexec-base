/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.exception;

import codedriver.framework.exception.core.ApiRuntimeException;

/**
 * @author: linbq
 * @since: 2021/4/19 14:14
 **/
public class AutoexecParamMappingNotMappedException extends ApiRuntimeException {

    private static final long serialVersionUID = -977878375722886383L;

    public AutoexecParamMappingNotMappedException(String key){
        super("参数：'" + key +  "'未映射");
    }
}