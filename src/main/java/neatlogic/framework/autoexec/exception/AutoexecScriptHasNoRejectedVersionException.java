/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.autoexec.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class AutoexecScriptHasNoRejectedVersionException extends ApiRuntimeException {

    private static final long serialVersionUID = 2800421302639213462L;

    public AutoexecScriptHasNoRejectedVersionException() {
        super("当前自定义工具没有已驳回版本");
    }


}
