/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.script.paramtype;

import codedriver.framework.applicationlistener.core.ModuleInitializedListenerBase;
import codedriver.framework.bootstrap.CodedriverWebApplicationContext;
import codedriver.framework.common.RootComponent;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

@RootComponent
public class ScriptParamTypeFactory extends ModuleInitializedListenerBase {

    private static final Map<String, IScriptParamType> scriptParamTypeMap = new HashMap<>();

    public static IScriptParamType getHandler(String handler) {
        return scriptParamTypeMap.get(handler);
    }

    @Override
    public void onInitialized(CodedriverWebApplicationContext context) {
        Map<String, IScriptParamType> map = context.getBeansOfType(IScriptParamType.class);
        for (Entry<String, IScriptParamType> entry : map.entrySet()) {
            scriptParamTypeMap.put(entry.getValue().getType(), entry.getValue());
        }
    }

    @Override
    protected void myInit() {

    }

}
