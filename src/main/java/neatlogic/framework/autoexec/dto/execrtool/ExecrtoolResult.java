package neatlogic.framework.autoexec.dto.execrtool;

import com.alibaba.fastjson.JSONObject;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;

/** 已受理的单目标结果；失败时仍可关联审计并取得原业务异常。 */
public record ExecrtoolResult(
        @EntityField(name = "term.autoexec.auditid", type = ApiParamType.LONG) Long auditId,
        @EntityField(name = "execrtoolinvoke.operation", type = ApiParamType.JSONOBJECT) JSONObject operation,
        @EntityField(name = "execrtoolinvoke.outputParam", type = ApiParamType.NOAUTH) Object outputParam,
        @EntityField(name = "execrtoolinvoke.outputLabels", type = ApiParamType.JSONOBJECT) JSONObject outputLabels,
        @EntityField(name = "execrtoolinvoke.failure", type = ApiParamType.NOAUTH) Exception failure) {
    /** 需要同步执行语义的入口继续抛出实际执行异常。 */
    public Object requireOutput() throws Exception {
        if (failure != null) throw failure;
        return outputParam;
    }
}
