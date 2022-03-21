/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.exception;

import codedriver.framework.exception.core.ApiRuntimeException;

/**
 * @author: linbq
 * @since: 2021/4/13 14:49
 **/
public class AutoexecCombopTemplatePhaseNameRepeatException extends ApiRuntimeException {

    private static final long serialVersionUID = -977867274723885183L;

    public AutoexecCombopTemplatePhaseNameRepeatException(String name) {
        super("组合工具模板阶段名称'" + name + "'已存在");
    }
}
