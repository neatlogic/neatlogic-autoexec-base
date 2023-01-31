/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.autoexec.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class AutoexecJobNotFoundException extends ApiRuntimeException {


    private static final long serialVersionUID = 8277880771507304406L;

    public AutoexecJobNotFoundException(String uk) {
        super("作业：'" + uk + "'不存在");
    }

    public AutoexecJobNotFoundException(Long id) {
        super("作业：'" + id + "'不存在");
    }


}
