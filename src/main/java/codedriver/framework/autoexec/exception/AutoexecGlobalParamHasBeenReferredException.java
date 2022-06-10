package codedriver.framework.autoexec.exception;

import codedriver.framework.exception.core.ApiRuntimeException;

import java.util.Objects;

/**
 * @author longrf
 * @date 2022/6/10 3:05 下午
 */
public class AutoexecGlobalParamHasBeenReferredException extends ApiRuntimeException {
    public AutoexecGlobalParamHasBeenReferredException(String name) {
        super("全局参数：被" + (Objects.equals(name, "profile") ? "预制参数集" : "组合工具") + " 引用,无法删除");
    }
}
