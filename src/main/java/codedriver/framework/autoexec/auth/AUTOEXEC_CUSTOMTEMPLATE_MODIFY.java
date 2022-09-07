/*
 * Copyright(c) 2022 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.auth;

import codedriver.framework.auth.core.AuthBase;

import java.util.Collections;
import java.util.List;

public class AUTOEXEC_CUSTOMTEMPLATE_MODIFY extends AuthBase {

    @Override
    public String getAuthDisplayName() {
        return "自定义模板管理权限";
    }

    @Override
    public String getAuthIntroduction() {
        return "对自定义模板进行新增、编辑、查看、删除";
    }

    @Override
    public String getAuthGroup() {
        return "autoexec";
    }

    @Override
    public Integer getSort() {
        return 8;
    }

    @Override
    public List<Class<? extends AuthBase>> getIncludeAuths() {
        return Collections.singletonList(AUTOEXEC_BASE.class);
    }
}
