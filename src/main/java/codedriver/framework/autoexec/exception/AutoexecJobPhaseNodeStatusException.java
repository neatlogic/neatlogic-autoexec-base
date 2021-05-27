/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.exception;

import codedriver.framework.exception.core.ApiRuntimeException;

public class AutoexecJobPhaseNodeStatusException extends ApiRuntimeException {

    private static final long serialVersionUID = 4522850144891547590L;

    public AutoexecJobPhaseNodeStatusException(String phase, String status, String nodeIds) {
        super("作业剧本：'" + phase + "',即将跟新状态为：'" + status + "' 节点'" + nodeIds + "'状态异常，请重跑");
    }


}
