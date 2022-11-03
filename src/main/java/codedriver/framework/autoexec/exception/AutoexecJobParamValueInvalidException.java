/*
 * Copyright (c)  2022 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.exception;

import codedriver.framework.autoexec.dto.AutoexecParamVo;
import codedriver.framework.exception.core.ApiRuntimeException;

public class AutoexecJobParamValueInvalidException extends ApiRuntimeException {

    private static final long serialVersionUID = 6972470248227737992L;

    public AutoexecJobParamValueInvalidException() {
    }

    public AutoexecJobParamValueInvalidException(AutoexecParamVo paramVo) {
        super("参数'" + paramVo.getName() + "'值 '" + paramVo.getValue() + "' 不合法");
    }
}
