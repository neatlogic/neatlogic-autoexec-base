/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.exception;

import codedriver.framework.exception.core.ApiRuntimeException;

/**
 * @author linbq
 * @since 2021/5/25 18:14
 **/
public class AutoexecCombopCannotBeRepeatReleaseExcepiton extends ApiRuntimeException {
    public AutoexecCombopCannotBeRepeatReleaseExcepiton(String name){
        super("'"  + name + "'不能重复发布为组合工具");
    }
}
