/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.autoexec.scriptcheck;

import neatlogic.framework.autoexec.dto.script.AutoexecScriptLineVo;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

public abstract class ScriptCheckHandlerBase implements IScriptCheckHandler {

    @Override
    public void check(List<AutoexecScriptLineVo> lineList) {
        if (CollectionUtils.isNotEmpty(lineList)) {
//            markAnnotationLines(lineList);
            myCheck(lineList);
        }
    }

    /**
     * 标记注释行
     *
     * @param lineList
     */
    protected abstract void markAnnotationLines(List<AutoexecScriptLineVo> lineList);

    protected abstract void myCheck(List<AutoexecScriptLineVo> lineList);
}
