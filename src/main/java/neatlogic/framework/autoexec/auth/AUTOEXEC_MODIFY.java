/*Copyright (C) $today.year  深圳极向量科技有限公司 All Rights Reserved.

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.*/

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
        return list;
    }
}
