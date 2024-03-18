/*Copyright (C) $today.year  深圳极向量科技有限公司 All Rights Reserved.

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.*/

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
