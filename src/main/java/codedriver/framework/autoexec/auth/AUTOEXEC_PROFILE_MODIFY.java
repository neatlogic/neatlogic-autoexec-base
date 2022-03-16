package codedriver.framework.autoexec.auth;

import codedriver.framework.auth.core.AuthBase;

import java.util.Collections;
import java.util.List;

/**
 * @author longrf
 * @date 2022/3/16 11:24 上午
 */
public class AUTOEXEC_PROFILE_MODIFY extends AuthBase {
    @Override
    public String getAuthDisplayName() {
        return "Profile管理权限";
    }

    @Override
    public String getAuthIntroduction() {
        return "工具Profile的添加，修改，删除，查看操作";
    }

    @Override
    public String getAuthGroup() {
        return  "autoexec";
    }

    @Override
    public Integer getSort() {
        return 9;
    }

    @Override
    public List<Class<? extends AuthBase>> getIncludeAuths(){
        return Collections.singletonList(AUTOEXEC_BASE.class);
    }
}
