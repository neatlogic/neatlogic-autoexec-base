/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.autoexec.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class AutoexecJobCanNotRefireException extends ApiRuntimeException {

    private static final long serialVersionUID = -7079932723076796784L;

    public AutoexecJobCanNotRefireException(String jobId) {
        super("无法重跑作业: "+jobId+"，请确保作业不处于'运行中'、'中止中'、'待运行'状态");
    }


}
