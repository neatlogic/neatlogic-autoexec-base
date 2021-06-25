/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.exception;

import codedriver.framework.exception.core.ApiRuntimeException;

public class AutoexecScriptVersionCannotDeleteException extends ApiRuntimeException {

    private static final long serialVersionUID = -1077319266146492200L;

    public AutoexecScriptVersionCannotDeleteException() {
        super("当前自定义工具仅有一个版本，删除此版本将导致删除当前自定义工具。");
    }


}
