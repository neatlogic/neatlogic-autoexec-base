/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.autoexec.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class AutoexecCombopVersionNotFoundException extends ApiRuntimeException {

    private static final long serialVersionUID = -977868275722896183L;

    public AutoexecCombopVersionNotFoundException(Long id){
        super("组合工具版本：'" + id + "'不存在");
    }

    public AutoexecCombopVersionNotFoundException(String name){
        super("组合工具版本：'" + name + "'不存在");
    }
}
