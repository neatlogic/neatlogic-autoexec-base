/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.exception;

import codedriver.framework.exception.core.ApiRuntimeException;

public class AutoexecScriptVersionHasNoActivedException extends ApiRuntimeException {


    private static final long serialVersionUID = -4515396010627822363L;

    public AutoexecScriptVersionHasNoActivedException(String name) {
        super("自定义工具'" + name + "'未设置激活版本");
    }

    public AutoexecScriptVersionHasNoActivedException() {
        super("当前自定义工具没有激活版本");
    }


}
