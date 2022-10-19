/*
 * Copyright(c) 2022 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */
package codedriver.framework.autoexec.exception;

import codedriver.framework.exception.core.ApiRuntimeException;

/**
 * @author longrf
 * @date 2022/9/21 16:59
 */

public class AutoexecToolExportNotFoundToolException extends ApiRuntimeException {
    public AutoexecToolExportNotFoundToolException () {
        super("没有找到需要导出的工具");
    }
}