/*
 * Copyright(c) 2022 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */
package neatlogic.framework.autoexec.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

/**
 * @author longrf
 * @date 2022/12/13 17:33
 */

public class AutoexecTypeIsFactoryException extends ApiRuntimeException {
    public AutoexecTypeIsFactoryException(Long id, String name) {
        super("工具分类:“" + name + "”（id:“" + id + "”）是出厂默认分类，不可删除");
    }
}
