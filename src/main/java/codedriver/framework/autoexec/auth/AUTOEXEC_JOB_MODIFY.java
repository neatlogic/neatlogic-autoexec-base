/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.auth;

import codedriver.framework.auth.core.AuthBase;

import java.util.Collections;
import java.util.List;

public class AUTOEXEC_JOB_MODIFY extends AuthBase {

    @Override
    public String getAuthDisplayName() {
        return "作业维护权限";
    }

    @Override
    public String getAuthIntroduction() {
        return "拥有作业删除权限";
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
    public List<Class<? extends AuthBase>> getIncludeAuths(){
        return Collections.singletonList(AUTOEXEC_BASE.class);
    }
}
