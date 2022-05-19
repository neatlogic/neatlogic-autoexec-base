/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.combop;

import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;

import java.util.List;

public class AutoexecCombopScenarioVo {
    @EntityField(name = "场景id", type = ApiParamType.LONG)
    private Long ScenarioId;
    @EntityField(name = "阶段id", type = ApiParamType.JSONARRAY)
    private List<Long> combopPhaseIdList;
}
