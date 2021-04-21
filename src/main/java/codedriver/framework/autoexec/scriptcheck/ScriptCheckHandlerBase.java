/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.scriptcheck;

import codedriver.framework.autoexec.dto.script.AutoexecScriptLineVo;

import java.util.List;

/**
 * @author: laiwt
 * @since: 2021/4/21 14:50
 **/
public abstract class ScriptCheckHandlerBase implements IScriptCheckHandler {
    @Override
    public void check(List<AutoexecScriptLineVo> lineList) {
        myCheck(lineList);
    }

    protected abstract void myCheck(List<AutoexecScriptLineVo> lineList);
}
