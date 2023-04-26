package neatlogic.framework.autoexec.source;

import neatlogic.framework.applicationlistener.core.ModuleInitializedListenerBase;
import neatlogic.framework.bootstrap.NeatLogicWebApplicationContext;
import neatlogic.framework.common.RootComponent;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;

@RootComponent
public class AutoexecJobSourceFactory extends ModuleInitializedListenerBase {
    Logger logger = LoggerFactory.getLogger(AutoexecJobSourceFactory.class);
    private static final List<IAutoexecJobSource> enumInstanceList = new ArrayList<>();
    private static final Map<String, IAutoexecJobSource> enumInstanceMap = new HashMap<>();
    private static final Map<String, IAutoexecJobSource> handlerMap = new HashMap<>();

    static {
        Reflections reflections = new Reflections("neatlogic");
        Set<Class<? extends IAutoexecJobSource>> sourceClass = reflections.getSubTypesOf(IAutoexecJobSource.class);
        for (Class<? extends IAutoexecJobSource> c : sourceClass) {
            try {
                if (!c.isEnum()) {
                    continue;
                }
                IAutoexecJobSource[] jobSourceList = c.getEnumConstants();
                for (IAutoexecJobSource jobSource : jobSourceList) {
                    enumInstanceMap.put(jobSource.getValue(), jobSource);
                    enumInstanceList.add(jobSource);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static IAutoexecJobSource getHandler(String handler) {
        return handlerMap.get(handler);
    }

    public static IAutoexecJobSource getEnumInstance(String value) {
        return enumInstanceMap.get(value);
    }

    public static List<IAutoexecJobSource> getEnumInstanceList() {
        return enumInstanceList.stream().collect(Collectors.toList());
    }

    @Override
    protected void onInitialized(NeatLogicWebApplicationContext context) {
        Map<String, IAutoexecJobSource> myMap = context.getBeansOfType(IAutoexecJobSource.class);
        for (Map.Entry<String, IAutoexecJobSource> entry : myMap.entrySet()) {
            try {
                IAutoexecJobSource handler = entry.getValue();
                if (handlerMap.containsKey(handler.getValue())) {
                    logger.error("IAutoexecJobSource '" + handler.getClass().getSimpleName() + "(" + handler.getValue() + ")' repeat");
                    System.exit(1);
                }
                handlerMap.put(handler.getValue(), handler);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }
    }

    @Override
    protected void myInit() {

    }
}
