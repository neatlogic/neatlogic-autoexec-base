/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.exception;

import codedriver.framework.exception.core.ApiRuntimeException;

/**
 * 执行用户不能为空
 * @author: linbq
 * @since: 2021/4/25 15:04
 **/
public class AutoexecCombopExecuteUserCannotBeEmptyException extends ApiRuntimeException {

    private static final long serialVersionUID = -977868376722876383L;

    public AutoexecCombopExecuteUserCannotBeEmptyException(){
        super("执行用户不能为空");
    }
}