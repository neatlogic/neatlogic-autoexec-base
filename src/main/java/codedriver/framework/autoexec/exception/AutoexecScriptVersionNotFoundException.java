/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.exception;

import codedriver.framework.exception.core.ApiRuntimeException;

public class AutoexecScriptVersionNotFoundException extends ApiRuntimeException {

    private static final long serialVersionUID = 1348684378031136217L;

    public AutoexecScriptVersionNotFoundException(Long id) {
        super("版本：'" + id + "'不存在");
    }


}
