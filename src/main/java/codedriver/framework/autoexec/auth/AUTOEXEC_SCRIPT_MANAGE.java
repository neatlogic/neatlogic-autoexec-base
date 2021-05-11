/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.auth;

import codedriver.framework.auth.core.AuthBase;

import java.util.Collections;
import java.util.List;

public class AUTOEXEC_SCRIPT_MANAGE extends AuthBase {

    @Override
    public String getAuthDisplayName() {
        return "工具、自定义工具管理权限";
    }

    @Override
    public String getAuthIntroduction() {
        return "对工具和自定义工具进行查看、编辑、复制、测试、审核、激活和删除";
    }

    @Override
    public String getAuthGroup() {
        return "autoexec";
    }

    @Override
    public Integer getSort() {
        return 5;
    }

    @Override
    public List<Class<? extends AuthBase>> getIncludeAuths(){
        return Collections.singletonList(AUTOEXEC_SCRIPT_MODIFY.class);
    }
}
