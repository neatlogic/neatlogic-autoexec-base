/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.job;

import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;

/**
 * @author lvzk
 * @since 2021/4/27 16:39
 **/
public class AutoexecJobStatusVo {
    @EntityField(name = "作业状态", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "作业状态名", type = ApiParamType.STRING)
    private String text;
    @EntityField(name = "作业状态颜色", type = ApiParamType.STRING)
    private String color;

    public AutoexecJobStatusVo() {
    }

    public AutoexecJobStatusVo(String name, String text, String color) {
        this.name = name;
        this.text = text;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
