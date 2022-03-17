/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.comboptemplate;

/**
 * 组合工具授权Vo类
 * @author: linbq
 * @since: 2021/4/13 9:58
 **/
public class AutoexecCombopTemplateAuthorityVo {
    private Long combopTemplateId;
    private String type;
    private String uuid;
    private String action;

    public Long getCombopTemplateId() {
        return combopTemplateId;
    }

    public void setCombopTemplateId(Long combopTemplateId) {
        this.combopTemplateId = combopTemplateId;
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
