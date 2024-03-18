/*Copyright (C) 2023  深圳极向量科技有限公司 All Rights Reserved.

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

public class AutoexecJobPhaseRunnerNotFoundException extends ApiRuntimeException {
    private static final long serialVersionUID = 2559211960167897973L;

    public AutoexecJobPhaseRunnerNotFoundException(Long jobId, String phaseName, Long phaseId) {
        super("作业（{0}）阶段{1}（{2}） 找不到runner", jobId, phaseName, phaseId);
    }

    public AutoexecJobPhaseRunnerNotFoundException(String phaseNames) {
        super("匹配不到可执行runner,执行phaseName :{0}", phaseNames);
    }
}

