/*
Copyright(c) $today.year NeatLogic Co., Ltd. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package neatlogic.framework.autoexec.constvalue;

import neatlogic.framework.common.constvalue.ParamType;
import neatlogic.framework.notify.core.INotifyParam;

/**
 * @author laiwt
 * @since 2022/11/14 14:02
 **/
public enum AutoexecJobNotifyParam implements INotifyParam {
    ID("jobId", "作业ID", ParamType.NUMBER),
    NAME("jobName", "作业名称", ParamType.STRING),
    STATUS("jobStatus", "作业状态", ParamType.STRING),
    PHASELIST("jobPhaseList", "阶段列表", ParamType.ARRAY),
    ;
    private final String value;
    private final String text;
    private final ParamType paramType;

    AutoexecJobNotifyParam(String value, String text, ParamType paramType) {
        this.value = value;
        this.text = text;
        this.paramType = paramType;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public ParamType getParamType() {
        return paramType;
    }
}
