/*
 * Copyright(c) 2022 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */
package neatlogic.framework.autoexec.auth;

import neatlogic.framework.auth.core.AuthBase;

/**
 * @author longrf
 * @date 2022/10/14 12:15
 */

public class AUTOEXEC extends AuthBase {
    @Override
    public String getAuthDisplayName() {
        return "自动化数据消费权限";
    }

    @Override
    public String getAuthIntroduction() {
        return "查询工具库、自定义工具库相关数据";
    }

    @Override
    public String getAuthGroup() {
        return "autoexec";
    }

    @Override
    public Integer getSort() {
        return 12;
    }
}
