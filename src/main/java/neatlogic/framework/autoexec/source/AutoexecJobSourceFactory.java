package neatlogic.framework.autoexec.source;

import neatlogic.framework.autoexec.dto.AutoexecJobSourceVo;
import org.reflections.Reflections;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AutoexecJobSourceFactory {
    private static final Map<String, AutoexecJobSourceVo> sourceMap = new HashMap<String, AutoexecJobSourceVo>();
    private static final Map<String, String> sourceValueMap = new HashMap<String, String>();

    static {
        Reflections reflections = new Reflections("neatlogic");
        Set<Class<? extends IAutoexecJobSource>> sourceClass = reflections.getSubTypesOf(IAutoexecJobSource.class);
        for (Class<? extends IAutoexecJobSource> c : sourceClass) {
            try {
                Object[] objects = c.getEnumConstants();
                @SuppressWarnings("unchecked")
                List<AutoexecJobSourceVo> sourceList = (List<AutoexecJobSourceVo>) c.getMethod("getSource").invoke(objects[0]);
                for (AutoexecJobSourceVo sourceVo : sourceList) {
                    sourceMap.put(sourceVo.getSource(), sourceVo);
                    sourceValueMap.put(sourceVo.getSource(), sourceVo.getSourceName());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static Map<String, AutoexecJobSourceVo> getSourceMap() {
        return sourceMap;
    }

    public static Map<String, String> getSourceValueMap() {
        return sourceValueMap;
    }

}
