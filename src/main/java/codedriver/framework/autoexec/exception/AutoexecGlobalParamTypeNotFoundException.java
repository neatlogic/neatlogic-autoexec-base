/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.exception;

import codedriver.framework.exception.core.ApiRuntimeException;

/**
 * @author: linbq
 * @since: 2021/4/19 14:14
 **/
public class AutoexecGlobalParamTypeNotFoundException extends ApiRuntimeException {

    private static final long serialVersionUID = -4583004866563097713L;

    public AutoexecGlobalParamTypeNotFoundException(String paramKey, String paramType) {
        super("参数：" + paramKey + "的参数映射不正确，不存在'" + paramType + "'类型的全局参数");
    }
}
