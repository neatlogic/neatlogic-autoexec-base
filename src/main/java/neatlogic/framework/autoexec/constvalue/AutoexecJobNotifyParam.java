/*
 *
 * Copyright (C) 2025  TechSure Co., Ltd.  All Rights Reserved.
 * This file is part of the NeatLogic software.
 * Licensed under the NeatLogic Sustainable Use License (NSUL), Version 4.x – 2025.
 * You may use this file only in compliance with the License.
 * See the LICENSE file distributed with this work for the full license text.
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 */

package neatlogic.framework.autoexec.constvalue;

import neatlogic.framework.common.constvalue.ParamType;
import neatlogic.framework.notify.core.INotifyParam;
import neatlogic.framework.util.$;

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
        return $.t(text);
    }

    @Override
    public ParamType getParamType() {
        return paramType;
    }
}
