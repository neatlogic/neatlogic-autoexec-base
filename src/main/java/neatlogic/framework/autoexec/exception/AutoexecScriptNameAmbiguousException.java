package neatlogic.framework.autoexec.exception;

import com.alibaba.fastjson.JSON;
import neatlogic.framework.exception.core.ApiRuntimeException;
import java.util.List;

/** A name identifies multiple tools; callers must supply a full catalog path to disambiguate. */
public class AutoexecScriptNameAmbiguousException extends ApiRuntimeException {
    private static final long serialVersionUID = 1L;

    /** Include every matching directory as a JSON array so delimiters inside names remain unambiguous. */
    public AutoexecScriptNameAmbiguousException(String name, List<String> catalogs) {
        super("nfae.autoexecscriptnameambiguousexception", name, JSON.toJSONString(catalogs));
    }
}
