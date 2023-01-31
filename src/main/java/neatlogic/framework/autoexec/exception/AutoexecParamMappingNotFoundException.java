/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.autoexec.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

/**
 * @author: linbq
 * @since: 2021/4/19 14:14
 **/
public class AutoexecParamMappingNotFoundException extends ApiRuntimeException {

    private static final long serialVersionUID = 1133160768855803018L;

    public AutoexecParamMappingNotFoundException(String paramName, String paramMappingMode) {
        super("参数：'" + paramName + "'的映射模式：" + paramMappingMode + "不存在");
    }
}
