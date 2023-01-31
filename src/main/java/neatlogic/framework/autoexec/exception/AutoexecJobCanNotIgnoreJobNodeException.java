/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.autoexec.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class AutoexecJobCanNotIgnoreJobNodeException extends ApiRuntimeException {

    private static final long serialVersionUID = 2153466880058895866L;

    public AutoexecJobCanNotIgnoreJobNodeException(String jobId) {
        super("无法暂停作业: "+jobId+"，请确保作业存于'运行中（running）'状态");
    }


}
