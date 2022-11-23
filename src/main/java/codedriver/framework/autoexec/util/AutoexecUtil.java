package codedriver.framework.autoexec.util;

import codedriver.framework.exception.runner.RunnerHttpRequestException;
import codedriver.framework.integration.authentication.enums.AuthenticateType;
import codedriver.framework.util.HttpRequestUtil;
import com.alibaba.fastjson.JSONObject;
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
        HttpRequestUtil requestUtil = HttpRequestUtil.post(runnerUrl).setPayload(paramJson.toJSONString()).setAuthType(AuthenticateType.BUILDIN).setConnectTimeout(5000).setReadTimeout(5000).sendRequest();
        if (StringUtils.isNotBlank(requestUtil.getError())) {
            throw new RunnerHttpRequestException(runnerUrl + ":" + requestUtil.getError());
        }
        JSONObject resultJson = requestUtil.getResultJson();
        if (!resultJson.containsKey("Status") || !"OK".equals(resultJson.getString("Status"))) {
            throw new RunnerHttpRequestException(runnerUrl + ":" + requestUtil.getError());
        }
        return resultJson.getString("Return");
    }
}
