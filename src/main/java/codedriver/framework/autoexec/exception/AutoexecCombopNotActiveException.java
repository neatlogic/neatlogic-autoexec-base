/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.exception;

import codedriver.framework.exception.core.ApiRuntimeException;

/**
 * @author: linbq
 * @since: 2021/4/13 14:50
 **/
public class AutoexecCombopNotActiveException extends ApiRuntimeException {

    private static final long serialVersionUID = 4233329054793152298L;

    public AutoexecCombopNotActiveException(Long id){
        super("组合工具：'" + id + "'已禁用");
    }

    public AutoexecCombopNotActiveException(String name){
        super("组合工具：'" + name + "'已禁用");
    }
}
