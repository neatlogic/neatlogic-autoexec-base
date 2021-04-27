/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.exception;

import codedriver.framework.exception.core.ApiRuntimeException;

public class AutoexecJobProxyConnectRefusedException extends ApiRuntimeException {


    private static final long serialVersionUID = 1799177301356468646L;

    public AutoexecJobProxyConnectRefusedException(String uk) {
        super("作业代理 url：'" + uk + "'拒绝连接");
    }


}
