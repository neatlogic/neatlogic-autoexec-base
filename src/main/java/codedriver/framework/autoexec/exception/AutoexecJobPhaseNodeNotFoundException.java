/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.exception;

import codedriver.framework.exception.core.ApiRuntimeException;

public class AutoexecJobPhaseNodeNotFoundException extends ApiRuntimeException {

    private static final long serialVersionUID = 4522850144891547590L;

    public AutoexecJobPhaseNodeNotFoundException(String phase,String node) {
        super("作业剧本：'" + phase + "' 节点'"+node+"'不存在");
    }

    public AutoexecJobPhaseNodeNotFoundException(String phase,Long nodeId) {
        super("作业阶段：'" + phase + "' 节点'"+nodeId.toString()+"'不存在");
    }

    public AutoexecJobPhaseNodeNotFoundException(String phase) {
        super("作业阶段：'" + phase + "' 缺少可执行节点（需绑定账号）");
    }

}
