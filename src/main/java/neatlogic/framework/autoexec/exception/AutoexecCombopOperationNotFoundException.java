/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.autoexec.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class AutoexecCombopOperationNotFoundException extends ApiRuntimeException {

    private static final long serialVersionUID = 8558127374403255939L;

    public AutoexecCombopOperationNotFoundException(String phaseName, String operationName) {
        super("阶段[" + phaseName + "]工具[" + operationName+ "]已被删除，请在组合工具中清理该工具并保存");
    }


}
