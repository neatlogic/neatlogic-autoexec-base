/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.autoexec.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class AutoexecJobCanNotFireException extends ApiRuntimeException {

    private static final long serialVersionUID = 2079904496159378555L;

    public AutoexecJobCanNotFireException(String jobId) {
        super("无法激活作业: "+jobId+"，请确保作业以及作业所有阶段处于'未开始（pending）'状态");
    }


}
