/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.operate;

import codedriver.framework.auth.core.AuthActionChecker;
import codedriver.framework.autoexec.auth.AUTOEXEC_COMBOP_MODIFY;
import codedriver.framework.autoexec.auth.AUTOEXEC_SCRIPT_MANAGE;
import codedriver.framework.autoexec.auth.AUTOEXEC_SCRIPT_MODIFY;
import codedriver.framework.autoexec.auth.AUTOEXEC_SCRIPT_SEARCH;
import codedriver.framework.autoexec.constvalue.ScriptVersionStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ScriptOperateBuilder {

    List<OperateVo> operateList; // 操作列表

    String userUuid; // 当前用户uuid

    String status; // 脚本版本状态

    Integer isActive; // 脚本版本是否激活

    Integer versionCount; // 脚本版本数

    Integer currentVersion; // 当前激活版本

    Integer hasBeenGeneratedToCombop; // 是否已经被发布为组合工具

    Integer referenceCount; // 被组合工具引用的次数

    public ScriptOperateBuilder(String userUuid, String status, Integer isActive, Integer versionCount) {
        operateList = new ArrayList<>();
        this.userUuid = userUuid;
        this.status = status;
        this.isActive = isActive;
        this.versionCount = versionCount;
    }

    public ScriptOperateBuilder(String userUuid, Integer currentVersion, Integer hasBeenGeneratedToCombop, Integer referenceCount) {
        operateList = new ArrayList<>();
        this.userUuid = userUuid;
        this.currentVersion = currentVersion;
        this.hasBeenGeneratedToCombop = hasBeenGeneratedToCombop;
        this.referenceCount = referenceCount;
    }

    public List<OperateVo> build() {
        return operateList;
    }

    public ScriptOperateBuilder setDelete() {
        if (AuthActionChecker.checkByUserUuid(userUuid, AUTOEXEC_SCRIPT_MANAGE.class.getSimpleName())) {
            OperateVo vo = new OperateVo("delete", "删除");
            if (referenceCount != null && referenceCount > 0) {
                vo.setDisabled(1);
                vo.setDisabledReason("已被组合工具引用");
            }
            operateList.add(vo);
        }
        return this;
    }

    public ScriptOperateBuilder setVersionDelete() {
        // 只剩一个版本或当前版本处于激活状态时，不可删除
        if (AuthActionChecker.checkByUserUuid(userUuid, AUTOEXEC_SCRIPT_MANAGE.class.getSimpleName())
                && versionCount != null && versionCount > 1 && !Objects.equals(isActive, 1)) {
            operateList.add(new OperateVo("delete", "删除"));
        }
        return this;
    }

    public ScriptOperateBuilder setCopy() {
        if (AuthActionChecker.checkByUserUuid(userUuid, AUTOEXEC_SCRIPT_MODIFY.class.getSimpleName())) {
            operateList.add(new OperateVo("copy", "复制"));
        }
        return this;
    }

    public ScriptOperateBuilder setTest() {
        if (AuthActionChecker.checkByUserUuid(userUuid, AUTOEXEC_SCRIPT_MODIFY.class.getSimpleName())) {
            operateList.add(new OperateVo("test", "测试"));
        }
        return this;
    }

    public ScriptOperateBuilder setCompare() {
        if (AuthActionChecker.checkByUserUuid(userUuid, AUTOEXEC_SCRIPT_SEARCH.class.getSimpleName())) {
            operateList.add(new OperateVo("compare", "版本对比"));
        }
        return this;
    }

    public ScriptOperateBuilder setValidate() {
        // 拥有脚本审核或维护权限，且处于编辑中、已驳回状态才能校验
        if (AuthActionChecker.checkByUserUuid(userUuid, AUTOEXEC_SCRIPT_MODIFY.class.getSimpleName())
                && (Objects.equals(ScriptVersionStatus.DRAFT.getValue(), status)
                || Objects.equals(ScriptVersionStatus.REJECTED.getValue(), status))) {
            operateList.add(new OperateVo("validate", "校验"));
        }
        return this;
    }

    public ScriptOperateBuilder setSave() {
        // 拥有脚本审核或维护权限，且处于编辑中、已驳回状态才能保存
        if (AuthActionChecker.checkByUserUuid(userUuid, AUTOEXEC_SCRIPT_MODIFY.class.getSimpleName())
                && (Objects.equals(ScriptVersionStatus.DRAFT.getValue(), status)
                || Objects.equals(ScriptVersionStatus.REJECTED.getValue(), status))) {
            operateList.add(new OperateVo("save", "保存"));
        }
        return this;
    }

    public ScriptOperateBuilder setSubmit() {
        // 拥有脚本审核或维护权限，且处于编辑中、已驳回状态才能提交审核
        if (AuthActionChecker.checkByUserUuid(userUuid, AUTOEXEC_SCRIPT_MODIFY.class.getSimpleName())
                && (Objects.equals(ScriptVersionStatus.DRAFT.getValue(), status)
                || Objects.equals(ScriptVersionStatus.REJECTED.getValue(), status))) {
            operateList.add(new OperateVo("submit", "提交审核"));
        }
        return this;
    }

    public ScriptOperateBuilder setPass() {
        // 拥有脚本审核权限，且处于待审核状态才能通过
        if (AuthActionChecker.checkByUserUuid(userUuid, AUTOEXEC_SCRIPT_MANAGE.class.getSimpleName())
                && Objects.equals(ScriptVersionStatus.SUBMITTED.getValue(), status)) {
            operateList.add(new OperateVo("pass", "通过"));
        }
        return this;
    }

    public ScriptOperateBuilder setReject() {
        // 拥有脚本审核权限，且处于待审核状态才能驳回
        if (AuthActionChecker.checkByUserUuid(userUuid, AUTOEXEC_SCRIPT_MANAGE.class.getSimpleName())
                && Objects.equals(ScriptVersionStatus.SUBMITTED.getValue(), status)) {
            operateList.add(new OperateVo("reject", "驳回"));
        }
        return this;
    }

    public ScriptOperateBuilder setGenerateToCombop() {
        if (AuthActionChecker.checkByUserUuid(userUuid, AUTOEXEC_COMBOP_MODIFY.class.getSimpleName())) {
            OperateVo vo = new OperateVo("generateToCombop", "发布为组合工具");
            if (Objects.equals(hasBeenGeneratedToCombop, 1)) {
                vo.setDisabled(1);
                vo.setDisabledReason("已经被发布为组合工具");
            } else if (currentVersion == null) {
                vo.setDisabled(1);
                vo.setDisabledReason("没有激活版本");
            }
            operateList.add(vo);
        }
        return this;
    }

    public ScriptOperateBuilder setExport() {
        if (AuthActionChecker.checkByUserUuid(userUuid, AUTOEXEC_SCRIPT_SEARCH.class.getSimpleName())) {
            operateList.add(new OperateVo("export", "导出"));
        }
        return this;
    }

    public ScriptOperateBuilder setVersionOperate() {
        setVersionDelete().setCopy().setCompare().setTest().setValidate().setSave().setSubmit().setPass().setReject();
        return this;
    }


}
