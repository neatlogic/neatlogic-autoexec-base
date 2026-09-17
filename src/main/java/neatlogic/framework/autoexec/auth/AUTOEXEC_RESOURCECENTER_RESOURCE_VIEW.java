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
import neatlogic.framework.cmdb.auth.label.RESOURCECENTER_RESOURCE_VIEW;

import java.util.Collections;
import java.util.List;

/** 自动化模块资产清单查看权限，并授予对应的CMDB资产清单查看能力。 */
public class AUTOEXEC_RESOURCECENTER_RESOURCE_VIEW extends AuthBase {

    @Override
    public String getAuthDisplayName() {
        return "auth.autoexec_resourcecenter_resource_view.name";
    }

    @Override
    public String getAuthIntroduction() {
        return "auth.autoexec_resourcecenter_resource_view.description";
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
        return Collections.singletonList(RESOURCECENTER_RESOURCE_VIEW.class);
    }
}
