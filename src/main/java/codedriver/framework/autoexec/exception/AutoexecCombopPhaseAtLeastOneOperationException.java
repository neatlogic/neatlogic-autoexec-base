/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.exception;

import codedriver.framework.exception.core.ApiRuntimeException;

/**
 * 组合工具阶段没有操作工具异常
 * @author: linbq
 * @since: 2021/4/16 11:42
 **/
public class AutoexecCombopPhaseAtLeastOneOperationException extends ApiRuntimeException {

    private static final long serialVersionUID = -978867274723886183L;

    public AutoexecCombopPhaseAtLeastOneOperationException(){
        super("组合工具的每一个阶段至少要有一个操作工具");
    }
}
