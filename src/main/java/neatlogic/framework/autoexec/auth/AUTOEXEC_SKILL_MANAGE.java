package neatlogic.framework.autoexec.auth;

import neatlogic.framework.auth.core.AuthBase;

import java.util.Collections;
import java.util.List;

public class AUTOEXEC_SKILL_MANAGE extends AuthBase {
    @Override
    public String getAuthDisplayName() {
        return "nfaa.autoexec_skill_manage.getauthdisplayname";
    }

    @Override
    public String getAuthIntroduction() {
        return "nfaa.autoexec_skill_manage.getauthintroduction";
    }

    @Override
    public String getAuthGroup() {
        return "autoexec";
    }

    @Override
    public Integer getSort() {
        return 7;
    }

    @Override
    public List<Class<? extends AuthBase>> getIncludeAuths() {
        return Collections.singletonList(AUTOEXEC_SKILL_MODIFY.class);
    }
}
