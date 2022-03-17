/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.comboptemplate;

import codedriver.framework.autoexec.dto.AutoexecParamVo;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;

/**
 * 组合工具运行参数Vo类
 *
 * @author: linbq
 * @since: 2021/4/13 10:04
 **/
public class AutoexecCombopTemplateParamVo extends AutoexecParamVo {
    @EntityField(name = "组合工具模板id", type = ApiParamType.LONG)
    private Long combopTemplateId;

    public AutoexecCombopTemplateParamVo() {
    }

    public AutoexecCombopTemplateParamVo(AutoexecParamVo autoexecParamVo) {
        super(autoexecParamVo);
    }

    public Long getCombopTemplateId() {
        return combopTemplateId;
    }

    public void setCombopTemplateId(Long combopTemplateId) {
        this.combopTemplateId = combopTemplateId;
    }
}
