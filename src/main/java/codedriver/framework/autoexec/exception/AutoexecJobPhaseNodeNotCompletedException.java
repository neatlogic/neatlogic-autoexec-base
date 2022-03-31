/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.exception;

import codedriver.framework.exception.core.ApiRuntimeException;
import com.beust.jcommander.Strings;

import java.util.List;

public class AutoexecJobPhaseNodeNotCompletedException extends ApiRuntimeException {

    private static final long serialVersionUID = 7399677354381263348L;

    public AutoexecJobPhaseNodeNotCompletedException(String phaseName, int roundNo, List<Long> nodeIdList) {
        super("无法inform下一个phase Round，因为该phase("+phaseName+")存在未完成的Round("+roundNo+")node节:"+ Strings.join("、",nodeIdList.toArray()));
    }


}
