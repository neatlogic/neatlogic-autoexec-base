/*
Copyright(c) $today.year NeatLogic Co., Ltd. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
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
        return "auth.autoexec.autoexecmodify.name";
    }

    @Override
    public String getAuthIntroduction() {
        return "auth.autoexec.autoexecmodify.introduction";
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
        return list;
    }
}
