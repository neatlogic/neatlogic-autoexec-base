package codedriver.framework.autoexec.auth;

import codedriver.framework.auth.core.AuthBase;

import java.util.Collections;
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
    public List<Class<? extends AuthBase>> getIncludeAuths(){
        return Collections.singletonList(AUTOEXEC_BASE.class);
    }
}
