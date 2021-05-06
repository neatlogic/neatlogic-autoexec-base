/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.auth;

import codedriver.framework.auth.core.AuthBase;

public class AUTOEXEC_BASE extends AuthBase {

    @Override
    public String getAuthDisplayName() {
        return "自动化基础权限";
    }

    @Override
    public String getAuthIntroduction() {
        return "查看组合工具";
    }

    @Override
    public String getAuthGroup() {
        return "autoexec";
    }

    @Override
    public Integer sort() {
        return 1;
    }
}