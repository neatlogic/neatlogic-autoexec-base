package codedriver.framework.autoexec.util;

import codedriver.framework.exception.runner.RunnerConnectRefusedException;
import codedriver.framework.exception.runner.RunnerHttpRequestException;
import codedriver.framework.dto.RestVo;
import codedriver.framework.integration.authentication.enums.AuthenticateType;
import codedriver.framework.util.RestUtil;
import com.alibaba.fastjson.JSONObject;
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
        RestVo restVo = new RestVo.Builder(runnerUrl, AuthenticateType.BUILDIN.getValue()).setPayload(paramJson).build();
        String restResult = RestUtil.sendPostRequest(restVo);
        JSONObject resultJson = null;
        try {
            resultJson = JSONObject.parseObject(restResult);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new RunnerConnectRefusedException(restVo.getUrl() + " " + restResult);
        }
        if (!resultJson.containsKey("Status") || !"OK".equals(resultJson.getString("Status"))) {
            throw new RunnerHttpRequestException(resultJson.getString("Message"));
        }
        return resultJson.getString("Return");
    }
}
