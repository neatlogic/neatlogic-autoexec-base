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
    @EntityField(name = "term.autoexec.combopid", type = ApiParamType.LONG)
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
