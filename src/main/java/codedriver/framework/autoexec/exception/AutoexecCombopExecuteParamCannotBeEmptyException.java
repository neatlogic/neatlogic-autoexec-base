/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.exception;

import codedriver.framework.exception.core.ApiRuntimeException;

public class AutoexecCombopExecuteParamCannotBeEmptyException extends ApiRuntimeException {

    private static final long serialVersionUID = -8957247474043452349L;

    public AutoexecCombopExecuteParamCannotBeEmptyException(){
        super("选择运行参数作为执行目标时，运行参数不能为空");
    }
}
