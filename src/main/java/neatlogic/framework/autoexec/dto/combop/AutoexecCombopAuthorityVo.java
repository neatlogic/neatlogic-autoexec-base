/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.autoexec.dto.combop;

import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;

/**
 * 组合工具授权Vo类
 *
 * @author: linbq
 * @since: 2021/4/13 9:58
 **/
public class AutoexecCombopAuthorityVo {

    @EntityField(name = "组合工具id", type = ApiParamType.LONG)
    private Long combopId;

    @EntityField(name = "授权目标类型，用户、组、角色", type = ApiParamType.STRING)
    private String type;

    @EntityField(name = "授权目标uuid", type = ApiParamType.STRING)
    private String uuid;

    @EntityField(name = "权限类型，执行或编辑", type = ApiParamType.STRING)
    private String action;

    public Long getCombopId() {
        return combopId;
    }

    public void setCombopId(Long combopId) {
        this.combopId = combopId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
