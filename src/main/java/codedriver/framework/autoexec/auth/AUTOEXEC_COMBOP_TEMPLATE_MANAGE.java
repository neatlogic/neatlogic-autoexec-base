/*
 * Copyright(c) 2022 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.auth;

import codedriver.framework.auth.core.AuthBase;

/**
 * @author linbq
 * @since 2022/3/17 15:06
 **/
public class AUTOEXEC_COMBOP_TEMPLATE_MANAGE extends AuthBase {
    @Override
    public String getAuthDisplayName() {
        return "组合工具模板管理权限";
    }

    @Override
    public String getAuthIntroduction() {
        return "组合工具模板的添加，修改，删除，查看操作";
    }

    @Override
    public String getAuthGroup() {
        return "autoexec";
    }

    @Override
    public Integer getSort() {
        return 10;
    }
}
