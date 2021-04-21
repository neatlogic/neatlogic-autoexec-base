/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.exception;

import codedriver.framework.exception.core.ApiRuntimeException;

public class AutoexecScriptCheckHandlerNotFoundException extends ApiRuntimeException {

    private static final long serialVersionUID = 8704155163065816926L;

    public AutoexecScriptCheckHandlerNotFoundException(String parser) {
        super("脚本校验器：'" + parser + "'不存在");
    }


}
