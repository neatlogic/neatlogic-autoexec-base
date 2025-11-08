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

/**
 * @author longrf
 * @date 2022/10/14 12:15
 */

public class AUTOEXEC extends AuthBase {
    @Override
    public String getAuthDisplayName() {
        return "nfaa.autoexec.getauthdisplayname";
    }

    @Override
    public String getAuthIntroduction() {
        return "nfaa.autoexec.getauthintroduction";
    }

    @Override
    public String getAuthGroup() {
        return "autoexec";
    }

    @Override
    public Integer getSort() {
        return 12;
    }

    @Override
    public boolean isShow() {
        return false;
    }
}
