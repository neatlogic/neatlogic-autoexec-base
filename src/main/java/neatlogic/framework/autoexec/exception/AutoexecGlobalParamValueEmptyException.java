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
public class AutoexecGlobalParamValueEmptyException extends ApiRuntimeException {

    private static final long serialVersionUID = 1084492354771333701L;

    public AutoexecGlobalParamValueEmptyException(String paramKey) {
        super("参数：" + paramKey + "的全局参数值为空'");
    }
}
