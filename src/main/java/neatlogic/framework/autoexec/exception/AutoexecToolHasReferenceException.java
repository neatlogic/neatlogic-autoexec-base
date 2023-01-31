/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.autoexec.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class AutoexecToolHasReferenceException extends ApiRuntimeException {

    private static final long serialVersionUID = -4921403033283566956L;

    public AutoexecToolHasReferenceException(String combopName) {
        super("当前工具已经被组合工具：'" + combopName + "'引用，不可禁用");
    }
}
