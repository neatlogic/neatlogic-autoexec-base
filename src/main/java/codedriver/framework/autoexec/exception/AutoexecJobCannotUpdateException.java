/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.exception;

import codedriver.framework.exception.core.ApiRuntimeException;

public class AutoexecJobCannotUpdateException extends ApiRuntimeException {

    private static final long serialVersionUID = -8489927575933257393L;

    public AutoexecJobCannotUpdateException(Long jobId) {
        super("无法修改作业计划时间与触发方式: " + jobId + "，作业处于'已就绪'状态且执行用户才能修改");
    }


}
