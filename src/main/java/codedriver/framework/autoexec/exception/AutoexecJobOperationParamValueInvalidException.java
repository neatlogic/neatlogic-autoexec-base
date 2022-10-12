/*
 * Copyright (c)  2022 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.exception;

import codedriver.framework.autoexec.dto.job.AutoexecJobPhaseOperationVo;
import codedriver.framework.autoexec.dto.job.AutoexecJobPhaseVo;
import codedriver.framework.exception.core.ApiRuntimeException;
import com.alibaba.fastjson.JSONObject;

public class AutoexecJobOperationParamValueInvalidException extends ApiRuntimeException {
    private static final long serialVersionUID = -3996827366716041804L;

    public AutoexecJobOperationParamValueInvalidException() {
    }

    public AutoexecJobOperationParamValueInvalidException(AutoexecJobPhaseVo jobPhaseVo, AutoexecJobPhaseOperationVo operationVo, JSONObject value) {
        super("阶段'" + jobPhaseVo.getName() + "' 工具'" + operationVo.getName() + "' 参数'" + value.getString("name") + "' 的值 '" + value.getString("value") + "' 不合法");
    }
}
