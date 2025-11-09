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

import java.util.Collections;
import java.util.List;

public class AUTOEXEC_SCRIPT_MODIFY extends AuthBase {

    @Override
    public String getAuthDisplayName() {
        return "工具、自定义工具维护权限";
    }

    @Override
    public String getAuthIntroduction() {
        return "对工具和自定义工具进行查看、编辑、复制和测试";
    }

    @Override
    public String getAuthGroup() {
        return "autoexec";
    }

    @Override
    public Integer getSort() {
        return 4;
    }

    @Override
    public List<Class<? extends AuthBase>> getIncludeAuths(){
        return Collections.singletonList(AUTOEXEC_SCRIPT_SEARCH.class);
    }
}
