/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.exception;

import codedriver.framework.exception.core.ApiRuntimeException;

public class AutoexecScriptHasReferenceException extends ApiRuntimeException {

    private static final long serialVersionUID = 3538560927410813515L;

    public AutoexecScriptHasReferenceException(String combopName) {
        super("当前自定义工具已经被组合工具：'" + combopName + "'引用，不可删除或无激活版本，如需切换激活版本，请激活其他版本");
    }


}
