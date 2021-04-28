/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.auth;

import codedriver.framework.auth.core.AuthBase;

public class AUTOEXEC_COMBOP_EXECUTE extends AuthBase {

    @Override
    public String getAuthDisplayName() {
        return "组合工具执行权限";
    }

    @Override
    public String getAuthIntroduction() {
        return "对组合工具进行查看、执行记录、添加定时任务、执行";
    }

    @Override
    public String getAuthGroup() {
        return "autoexec";
    }
}
