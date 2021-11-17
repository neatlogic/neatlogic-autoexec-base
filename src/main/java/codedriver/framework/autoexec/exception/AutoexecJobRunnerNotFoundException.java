/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.exception;

import codedriver.framework.exception.core.ApiRuntimeException;

import java.util.List;
import java.util.stream.Collectors;

public class AutoexecJobRunnerNotFoundException extends ApiRuntimeException {

    private static final long serialVersionUID = 3593220313941443951L;

    public AutoexecJobRunnerNotFoundException(String msg) {
        super("Runner map id:" + msg + "不存在");
    }

    public AutoexecJobRunnerNotFoundException(List<String> phaseNameList) {
        super("匹配不到可执行runner,执行phaseName :" + phaseNameList.stream().map(Object::toString).collect(Collectors.joining("','")));
    }

}
