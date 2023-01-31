/*
 * Copyright (c)  2022 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.autoexec.dto.job;

import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;

public class AutoexecJobSortVo {
    @EntityField(name = "排序字段", type = ApiParamType.STRING)
    private String key;
    @EntityField(name = "排序类型", type = ApiParamType.STRING)
    private String type;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        switch (key) {
            case "planStartTime":
                key = "plan_start_time";
                break;
            case "startTime":
                key = "start_time";
                break;
            default:
                break;
        }
        this.key = key;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
