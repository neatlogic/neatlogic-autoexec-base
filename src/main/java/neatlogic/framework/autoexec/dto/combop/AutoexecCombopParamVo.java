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

package neatlogic.framework.autoexec.dto.combop;

import neatlogic.framework.autoexec.dto.AutoexecParamVo;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;

/**
 * 组合工具运行参数Vo类
 *
 * @author: linbq
 * @since: 2021/4/13 10:04
 **/
public class AutoexecCombopParamVo extends AutoexecParamVo {
    @EntityField(name = "组合工具id", type = ApiParamType.LONG)
    private Long combopId;

    public AutoexecCombopParamVo() {
    }

    public AutoexecCombopParamVo(AutoexecParamVo autoexecParamVo) {
        super(autoexecParamVo);
    }

    public Long getCombopId() {
        return combopId;
    }

    public void setCombopId(Long combopId) {
        this.combopId = combopId;
    }
}
