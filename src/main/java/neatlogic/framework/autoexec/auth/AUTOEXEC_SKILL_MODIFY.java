package neatlogic.framework.autoexec.auth;

import neatlogic.framework.auth.core.AuthBase;

public class AUTOEXEC_SKILL_MODIFY extends AuthBase {
    @Override
    public String getAuthDisplayName() {
        return "Skill维护权限";
    }

    @Override
    public String getAuthIntroduction() {
        return "对自动化Skill进行查看、编辑、提交和测试";
    }

    @Override
    public String getAuthGroup() {
        return "autoexec";
    }

    @Override
    public Integer getSort() {
        return 6;
    }
}
