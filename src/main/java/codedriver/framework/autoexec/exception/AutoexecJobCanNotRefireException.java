/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.exception;

import codedriver.framework.exception.core.ApiRuntimeException;

public class AutoexecJobCanNotRefireException extends ApiRuntimeException {

    private static final long serialVersionUID = -7079932723076796784L;

    public AutoexecJobCanNotRefireException(String jobId) {
        super("无法重跑作业: "+jobId+"，请确保作业以及阶段不处于'运行中（running）'状态");
    }


}
