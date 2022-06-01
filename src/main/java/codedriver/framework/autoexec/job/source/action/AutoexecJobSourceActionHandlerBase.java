package codedriver.framework.autoexec.job.source.action;

import codedriver.framework.autoexec.exception.AutoexecJobRunnerConnectRefusedException;
import codedriver.framework.autoexec.exception.AutoexecJobRunnerHttpRequestException;
import codedriver.framework.dto.RestVo;
import codedriver.framework.integration.authentication.enums.AuthenticateType;
import codedriver.framework.util.RestUtil;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author longrf
 * @date 2022/5/31 5:12 下午
 */
public abstract class AutoexecJobSourceActionHandlerBase implements IAutoexecJobSourceActionHandler {

    Logger logger = LoggerFactory.getLogger(AutoexecJobSourceActionHandlerBase.class);

    /**
     * 请求runner
     *
     * @param runnerUrl runner 链接
     * @param paramJson 入参
     * @return runner response
     */
    protected String requestRunner(String runnerUrl, JSONObject paramJson) {
        RestVo restVo = new RestVo.Builder(runnerUrl, AuthenticateType.BUILDIN.getValue()).setPayload(paramJson).build();
        String restResult = RestUtil.sendPostRequest(restVo);
        JSONObject resultJson = null;
        try {
            resultJson = JSONObject.parseObject(restResult);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new AutoexecJobRunnerConnectRefusedException(restVo.getUrl() + " " + restResult);
        }
        if (!resultJson.containsKey("Status") || !"OK".equals(resultJson.getString("Status"))) {
            throw new AutoexecJobRunnerHttpRequestException(resultJson.getString("Message"));
        }
        return resultJson.getString("Return");
    }
}
