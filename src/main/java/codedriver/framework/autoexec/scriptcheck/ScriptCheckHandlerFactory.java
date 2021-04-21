/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.scriptcheck;

import codedriver.framework.applicationlistener.core.ApplicationListenerBase;
import codedriver.framework.common.RootComponent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

@RootComponent
public class ScriptCheckHandlerFactory extends ApplicationListenerBase {

    private static Map<String, IScriptCheckHandler> scriptCheckHandlerMap = new HashMap<>();

    public static IScriptCheckHandler getHandler(String handler) {
        return scriptCheckHandlerMap.get(handler);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext context = event.getApplicationContext();
        Map<String, IScriptCheckHandler> map = context.getBeansOfType(IScriptCheckHandler.class);
        for (Entry<String, IScriptCheckHandler> entry : map.entrySet()) {
            scriptCheckHandlerMap.put(entry.getValue().getType(), entry.getValue());
        }
    }

    @Override
    protected void myInit() {

    }

}
