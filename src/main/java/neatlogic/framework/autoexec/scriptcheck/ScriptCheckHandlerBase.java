/*
Copyright(c) $today.year NeatLogic Co., Ltd. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
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