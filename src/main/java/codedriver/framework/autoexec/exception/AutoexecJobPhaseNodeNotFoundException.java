/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.exception;

import codedriver.framework.cmdb.dto.resourcecenter.ResourceVo;
import codedriver.framework.exception.core.ApiRuntimeException;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

public class AutoexecJobPhaseNodeNotFoundException extends ApiRuntimeException {

    private static final long serialVersionUID = 4522850144891547590L;

    public AutoexecJobPhaseNodeNotFoundException(String phase, String node) {
        super("作业剧本：'" + phase + "' 节点'" + node + "'不存在");
    }

    public AutoexecJobPhaseNodeNotFoundException(String phase, Long nodeId) {
        super("作业阶段：'" + phase + "' 节点'" + nodeId.toString() + "'不存在");
    }

    public AutoexecJobPhaseNodeNotFoundException(String phase, boolean isPhaseConfig) {
        super("作业阶段'" + phase + "'" + (isPhaseConfig ? StringUtils.EMPTY : "|全局") + "： 缺少可执行节点.请确认所选择的执行目标是否在资产清单，重试");
    }

    public AutoexecJobPhaseNodeNotFoundException(String phase, List<ResourceVo> resourceVoList, boolean isPhaseConfig) {
        super("作业阶段：'" + phase + "'， 请确认选择的" + (isPhaseConfig ? "阶段" : "全局") + "执行目标：" + resourceVoList.stream().map(resource -> resource.getIp() + (resource.getPort() != null ? (":" + resource.getPort()) : StringUtils.EMPTY)).collect(Collectors.joining("','")) + " 是否在资产清单后，重试");
    }

}
