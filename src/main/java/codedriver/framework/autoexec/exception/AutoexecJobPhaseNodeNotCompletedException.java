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

    public AutoexecJobPhaseNodeNotCompletedException(List<Long> nodeIdList) {
        super("无法inform下一个Round，因为存在未完成的Round node节点:"+ Strings.join("、",nodeIdList.toArray()));
    }


}
