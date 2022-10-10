/*
 * Copyright (c)  2022 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.exception;

import codedriver.framework.exception.core.ApiRuntimeException;

public class AutoexecJobNodePreParamValueNotInvalidException extends ApiRuntimeException {
    private static final long serialVersionUID = 616139541025262810L;

    public AutoexecJobNodePreParamValueNotInvalidException() {
        super();
    }

    public AutoexecJobNodePreParamValueNotInvalidException(Long id, String phaseName) {
        super("作业'"+id+"'-阶段'"+phaseName+"' 根据上游参数初始化执行目标失败，上游出参不合法");
    }
}
