/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.constvalue;

import codedriver.framework.common.constvalue.ParamType;
import codedriver.framework.notify.core.INotifyParam;

/**
 * @author laiwt
 * @since 2022/11/14 14:02
 **/
public enum AutoexecJobNotifyParam implements INotifyParam {
    ID("id", "作业ID", ParamType.NUMBER),
    NAME("name", "作业名称", ParamType.STRING),
    STATUS("status", "作业状态", ParamType.STRING),
    PHASELIST("phaseList", "阶段列表", ParamType.ARRAY),
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
