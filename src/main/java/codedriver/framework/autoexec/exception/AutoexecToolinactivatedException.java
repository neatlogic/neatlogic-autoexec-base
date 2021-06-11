/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.exception;

import codedriver.framework.exception.core.ApiRuntimeException;

public class AutoexecToolinactivatedException extends ApiRuntimeException {

    private static final long serialVersionUID = 1615696881289351556L;

    public AutoexecToolinactivatedException(String name) {
        super("工具：'" + name + "'未激活");
    }

}