package neatlogic.framework.autoexec.util;

import com.alibaba.fastjson.JSONObject;
import neatlogic.framework.exception.core.ApiRuntimeException;
import neatlogic.framework.integration.authentication.enums.AuthenticateType;
import neatlogic.framework.util.HttpRequestUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author longrf
 * @date 2022/6/1 11:51 上午
 */
public class AutoexecUtil {

    static Logger logger = LoggerFactory.getLogger(AutoexecUtil.class);

    /**
     * 请求runner
     *
     * @param runnerUrl runner 链接
     * @param paramJson 入参
     * @return runner response
     */
    public static String requestRunner(String runnerUrl, JSONObject paramJson) {
        HttpRequestUtil requestUtil = HttpRequestUtil.post(runnerUrl).setPayload(paramJson.toJSONString()).setAuthType(AuthenticateType.BUILDIN).sendRequest();
        if (requestUtil.getResponseCode() != 200 || StringUtils.isNotBlank(requestUtil.getError())) {
            throw new ApiRuntimeException(String.format("Request to %s failed, result: %s, ResponseCode: %s, ErrorMsg: %s, Exception %s",
                    runnerUrl, requestUtil.getResult(), requestUtil.getResponseCode(), requestUtil.getErrorMsg(), requestUtil.getError()));
        }
        JSONObject resultJson = requestUtil.getResultJson();
        return resultJson.getString("Return");
    }
}
