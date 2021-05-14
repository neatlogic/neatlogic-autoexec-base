/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.exception;

import codedriver.framework.exception.core.ApiRuntimeException;

public class AutoexecRiskNotFoundException extends ApiRuntimeException {

    private static final long serialVersionUID = 3718741083995150834L;

    public AutoexecRiskNotFoundException(Long id) {
        super("操作级别：'" + id + "'不存在");
    }

    public AutoexecRiskNotFoundException(String name) {
        super("操作级别：'" + name + "'不存在");
    }


}
