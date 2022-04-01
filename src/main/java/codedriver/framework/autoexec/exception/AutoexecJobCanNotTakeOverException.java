/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.exception;

import codedriver.framework.exception.core.ApiRuntimeException;

public class AutoexecJobCanNotTakeOverException extends ApiRuntimeException {

    private static final long serialVersionUID = 3175429889181207833L;

    public AutoexecJobCanNotTakeOverException(Long jobId) {
        super("无法接管作业: " + jobId + "，请确保作业来源于组合工具，同时确保您拥有作业所属组合工具的执行权限");
    }


}
