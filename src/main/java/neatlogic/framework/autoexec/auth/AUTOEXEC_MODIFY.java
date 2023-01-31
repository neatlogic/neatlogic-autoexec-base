/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.autoexec.auth;

import neatlogic.framework.auth.core.AuthBase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author longrf
 * @date 2022/4/25 10:15 上午
 */
public class AUTOEXEC_MODIFY extends AuthBase {
    @Override
    public String getAuthDisplayName() {
        return "自动化管理员权限";
    }

    @Override
    public String getAuthIntroduction() {
        return "自动化菜单下，【配置】子菜单下的所有功能";
    }

    @Override
    public String getAuthGroup() {
        return "autoexec";
    }

    @Override
    public Integer getSort() {
        return 11;
    }

    @Override
    public List<Class<? extends AuthBase>> getIncludeAuths() {
        List<Class<? extends AuthBase>> list = new ArrayList<>();
        list.add(AUTOEXEC_COMBOP_ADD.class);
        list.add(AUTOEXEC_CUSTOMTEMPLATE_MODIFY.class);
        list.add(AUTOEXEC_JOB_MODIFY.class);
        list.add(AUTOEXEC_SCRIPT_MANAGE.class);
        return list;
    }
}
