package neatlogic.framework.autoexec.exception;

import com.alibaba.fastjson.JSONObject;
import neatlogic.framework.exception.core.ApiRuntimeException;

/** 作业交互失败，向调用方提供操作和目标标识。 */
public class AutoexecJobInteractException extends ApiRuntimeException {

    private static final long serialVersionUID = 3024745064863084481L;

    public AutoexecJobInteractException() {
        super("interact is null");
    }

    public AutoexecJobInteractException(String msg) {
        super("interact failed! {0}", msg);
    }

    /** 只取定位字段，避免将交互输入或凭据写入异常。 */
    public AutoexecJobInteractException(String operation, JSONObject params, String reason) {
        super("autoexec.waitinput.failed", operation, params.getString("jobId"), params.getString("nodeId"), reason);
    }
}
