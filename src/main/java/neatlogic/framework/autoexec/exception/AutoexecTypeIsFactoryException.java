/*Copyright (C) 2024  深圳极向量科技有限公司 All Rights Reserved.

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
package neatlogic.framework.autoexec.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

/**
 * @author longrf
 * @date 2022/12/13 17:33
 */

public class AutoexecTypeIsFactoryException extends ApiRuntimeException {
    private static final long serialVersionUID = -1939208635453400846L;

    public AutoexecTypeIsFactoryException(Long id, String name) {
        super("工具分类:“{1}”（id:“{0}”）是出厂默认分类，不可删除", id, name);
    }
}
