package neatlogic.framework.autoexec.auth;

import neatlogic.framework.auth.core.AuthBase;

public class AUTOEXEC_SKILL_MODIFY extends AuthBase {
    @Override
    public String getAuthDisplayName() {
        return "nfaa.autoexec_skill_modify.getauthdisplayname";
    }

    @Override
    public String getAuthIntroduction() {
        return "nfaa.autoexec_skill_modify.getauthintroduction";
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
