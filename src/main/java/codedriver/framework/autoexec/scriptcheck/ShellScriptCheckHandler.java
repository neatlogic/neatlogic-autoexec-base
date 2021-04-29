/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.scriptcheck;

import codedriver.framework.autoexec.constvalue.ScriptParser;
import codedriver.framework.autoexec.dto.script.AutoexecScriptLineVo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShellScriptCheckHandler extends ScriptCheckHandlerBase {

    @Override
    protected void myCheck(List<AutoexecScriptLineVo> lineList) {
    }

    /**
     * 标记注释行
     * todo shell不止一种注释方式
     *
     * @param lineList
     */
    @Override
    protected void markAnnotationLines(List<AutoexecScriptLineVo> lineList) {
        for (int i = 0; i < lineList.size(); i++) {
            if (lineList.get(i).getContent().startsWith("#")) {
                lineList.get(i).setIsAnnotation(1);
            } else if (lineList.get(i).getContent().startsWith(":<<!")) {
                while (lineList.get(i).getContent().startsWith(":<<!")
                        || !lineList.get(i).getContent().endsWith("!")) {
                    lineList.get(i).setIsAnnotation(1);
                    i++;
                    if (lineList.get(i).getContent().endsWith("!")) {
                        lineList.get(i).setIsAnnotation(1);
                    }
                }
            }
        }
    }

    @Override
    public String getType() {
        return ScriptParser.SHELL.getValue();
    }
}
