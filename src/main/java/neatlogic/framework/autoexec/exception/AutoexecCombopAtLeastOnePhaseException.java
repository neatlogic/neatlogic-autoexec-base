/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.autoexec.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

/**
 * 组合工具没有阶段异常
 * @author: linbq
 * @since: 2021/4/16 11:42
 **/
public class AutoexecCombopAtLeastOnePhaseException extends ApiRuntimeException {

    private static final long serialVersionUID = -977867274723886183L;

    public AutoexecCombopAtLeastOnePhaseException(){
        super("组合工具至少要有一个阶段");
    }
}
