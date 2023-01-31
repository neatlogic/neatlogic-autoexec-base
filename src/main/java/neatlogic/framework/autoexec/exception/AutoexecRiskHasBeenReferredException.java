/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.autoexec.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class AutoexecRiskHasBeenReferredException extends ApiRuntimeException {

    private static final long serialVersionUID = -5799704411927086048L;

    public AutoexecRiskHasBeenReferredException(String name) {
        super("操作级别：'" + name + "'被引用");
    }


}
