/*
 *
 * Copyright (C) 2025  TechSure Co., Ltd.  All Rights Reserved.
 * This file is part of the NeatLogic software.
 * Licensed under the NeatLogic Sustainable Use License (NSUL), Version 4.x – 2025.
 * You may use this file only in compliance with the License.
 * See the LICENSE file distributed with this work for the full license text.
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
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
        list.add(AUTOEXEC_SERVICE_MANAGE.class);
        list.add(AUTOEXEC_SCHEDULE_MODIFY.class);
        return list;
    }
}
