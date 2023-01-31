/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.autoexec.scriptcheck;

import neatlogic.framework.autoexec.dto.script.AutoexecScriptLineVo;
import org.springframework.util.ClassUtils;

import java.util.List;

public interface IScriptCheckHandler {

    /**
     * 校验脚本内容
     *
     * @param lineList
     */
    void check(List<AutoexecScriptLineVo> lineList);

    /**
     * 脚本类型
     *
     * @return
     */
    String getType();

    default String getClassName() {
        return ClassUtils.getUserClass(this.getClass()).getName();
    }
}
