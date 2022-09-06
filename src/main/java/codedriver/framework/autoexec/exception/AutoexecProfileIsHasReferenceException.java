/*
 * Copyright(c) 2022 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */
package codedriver.framework.autoexec.exception;

import codedriver.framework.exception.core.ApiRuntimeException;

/**
 * @author longrf
 * @date 2022/9/5 23:41
 */

public class AutoexecProfileIsHasReferenceException extends ApiRuntimeException {
    public AutoexecProfileIsHasReferenceException(String name) {
        super("profile：" + name + "”已被引用，无法删除");
    }
}
