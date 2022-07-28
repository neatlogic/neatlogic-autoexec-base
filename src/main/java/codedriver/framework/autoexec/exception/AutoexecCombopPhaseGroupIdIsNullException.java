/*
 * Copyright (c)  2022 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.exception;

import codedriver.framework.exception.core.ApiRuntimeException;

/**
 * @author: lvzk
 * @since: 2022/7/28 14:49
 **/
public class AutoexecCombopPhaseGroupIdIsNullException extends ApiRuntimeException {

    private static final long serialVersionUID = 553543046178336220L;

    public AutoexecCombopPhaseGroupIdIsNullException(String name){
        super("阶段：'" + name + "' GroupId 为 null");
    }
}
