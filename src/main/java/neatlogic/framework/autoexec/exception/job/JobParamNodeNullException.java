/*
 * Copyright (C) 2025  深圳极向量科技有限公司 All Rights Reserved.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package neatlogic.framework.autoexec.exception.job;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class JobParamNodeNullException extends ApiRuntimeException {

    private static final long serialVersionUID = -5243209742690310814L;

    public JobParamNodeNullException(String phaseName, Object key) {
        super("执行目标非法，阶段“{0}”引用{1}", phaseName, key);
    }

    public JobParamNodeNullException(int groupId, Object key) {
        super("执行目标非法，阶段组“{0}”引用{1}", groupId, key);
    }

    public JobParamNodeNullException(String key, Integer isJob) {
        super("执行目标非法，引用{0}", key);
    }

    public JobParamNodeNullException(String key) {
        super("nfaej.jobparamnullexception.jobparamnullexception", key);
    }
}
