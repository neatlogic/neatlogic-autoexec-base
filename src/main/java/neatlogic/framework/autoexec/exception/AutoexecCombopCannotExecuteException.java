/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.autoexec.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

/**
 * @author: linbq
 * @since: 2021/4/13 14:49
 **/
public class AutoexecCombopCannotExecuteException extends ApiRuntimeException {


    private static final long serialVersionUID = 8178730734144911652L;

    public AutoexecCombopCannotExecuteException(String name){
        super("组合工具：'" + name + "'没执行权限");
    }
}
