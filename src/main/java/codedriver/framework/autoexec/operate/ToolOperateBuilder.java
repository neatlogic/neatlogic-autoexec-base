/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.operate;

import codedriver.framework.auth.core.AuthActionChecker;
import codedriver.framework.autoexec.auth.AUTOEXEC_COMBOP_MODIFY;
import codedriver.framework.autoexec.auth.AUTOEXEC_SCRIPT_MANAGE;
import codedriver.framework.autoexec.auth.AUTOEXEC_SCRIPT_MODIFY;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ToolOperateBuilder {

    List<OperateVo> operateList; // 操作列表

    String userUuid; // 当前用户uuid

    Integer isActive; // 工具是否激活

    Integer hasBeenGeneratedToCombop; // 是否已经被发布为组合工具

    public ToolOperateBuilder(String userUuid, Integer isActive, Integer hasBeenGeneratedToCombop) {
        operateList = new ArrayList<>();
        this.userUuid = userUuid;
        this.isActive = isActive;
        this.hasBeenGeneratedToCombop = hasBeenGeneratedToCombop;
    }

    public List<OperateVo> build() {
        return operateList;
    }


    public ToolOperateBuilder setTest() {
        if (AuthActionChecker.checkByUserUuid(userUuid, AUTOEXEC_SCRIPT_MODIFY.class.getSimpleName())) {
            operateList.add(new OperateVo("test", "测试"));
        }
        return this;
    }

    public ToolOperateBuilder setGenerateToCombop() {
        if (AuthActionChecker.checkByUserUuid(userUuid, AUTOEXEC_COMBOP_MODIFY.class.getSimpleName())) {
            OperateVo vo = new OperateVo("generateToCombop", "发布为组合工具");
            if (Objects.equals(hasBeenGeneratedToCombop, 1)) {
                vo.setDisabled(1);
                vo.setDisabledReason("已经被发布为组合工具");
            } else if (!Objects.equals(isActive, 1)) {
                vo.setDisabled(1);
                vo.setDisabledReason("工具未激活");
            }
            operateList.add(vo);
        }
        return this;
    }

    public ToolOperateBuilder setActive() {
        if (AuthActionChecker.checkByUserUuid(userUuid, AUTOEXEC_SCRIPT_MANAGE.class.getSimpleName())) {
            operateList.add(new OperateVo("active", "启用/禁用"));
        }
        return this;
    }

    public ToolOperateBuilder setAll() {
        setTest().setActive().setGenerateToCombop();
        return this;
    }


}
