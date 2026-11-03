package neatlogic.framework.autoexec.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import neatlogic.framework.asynchronization.threadlocal.RequestContext;
import neatlogic.framework.common.config.Config;
import neatlogic.framework.i18n.I18nLocaleResolver;
import neatlogic.framework.exception.runner.RunnerHttpRequestException;
import neatlogic.framework.integration.authentication.enums.AuthenticateType;
import neatlogic.framework.util.$;
import neatlogic.framework.util.HttpRequestUtil;
import org.apache.commons.lang3.StringUtils;

/**
 * 自动化模块与 Runner 通信的公共入口。
 * @author longrf
 * @date 2022/6/1 11:51 上午
 */
public class AutoexecUtil {

    /** 使用配置的连接和读取超时请求 Runner，成功时返回 Return，允许为空。 */
    public static String requestRunner(String runnerUrl, JSONObject paramJson) {
        HttpRequestUtil request = buildRequest(runnerUrl, paramJson).sendRequest();
        // 只展示接口路径，去除可能带有凭据的查询参数及片段。
        String path = StringUtils.substringBefore(StringUtils.substringBefore(runnerUrl, "?"), "#");
        String operation = StringUtils.substringAfterLast(path, "/api/rest/");
        int status = request.getResponseCode();
        if (status == 0 || (status == 200 && StringUtils.isNotBlank(request.getError()))) {
            String reason = StringUtils.contains(request.getError(), "java.net.SocketTimeoutException")
                    ? $.t("autoexec.runnerrequest.timeout") : $.t("autoexec.runnerrequest.transport");
            throw new RunnerHttpRequestException($.t("autoexec.runnerrequest.failed", operation, reason));
        }
        String body = status == 200 ? request.getResult() : request.getErrorResponseBody();
        JSONObject response = body != null && JSON.isValidObject(body)
                ? JSON.parseObject(body, Feature.DisableSpecialKeyDetect) : null;
        if (status == 200 && response != null && "OK".equals(response.get("Status"))) {
            return response.getString("Return");
        }
        // Runner 负责生成用户语言的业务提示，诊断字段 Message 仅供排查。
        if (response != null && "ERROR".equals(response.get("Status"))) {
            Object userMessage = response.get("UserMessage");
            if (userMessage instanceof String && safeDisplayText((String) userMessage)) {
                throw new RunnerHttpRequestException((String) userMessage);
            }
        } else if (status == 200) {
            throw new RunnerHttpRequestException($.t("autoexec.runnerrequest.failed", operation, $.t("autoexec.runnerrequest.invalidresponse")));
        }
        throw new RunnerHttpRequestException($.t("autoexec.runnerrequest.failed", operation, $.t("autoexec.runnerrequest.rejected", status)));
    }

    /** 只接受有界的单行纯文本，返回正文和异常栈不作为可展示提示。 */
    private static boolean safeDisplayText(String message) {
        return message.length() <= 512 && StringUtils.isNotBlank(message)
                && message.chars().noneMatch(c -> Character.isISOControl(c) || c == '<' || c == '>' || c == 0x2028 || c == 0x2029);
    }

    /** 每次创建请求时读取配置；缺失或非正值使用 Runner 默认等待时长（毫秒）。 */
    static HttpRequestUtil buildRequest(String url, JSONObject params) {
        Integer connectTimeout = Config.RUNNER_CONNECT_TIMEOUT();
        Integer readTimeout = Config.RUNNER_READ_TIMEOUT();
        RequestContext context = RequestContext.get();
        return HttpRequestUtil.post(url).setPayload(params.toJSONString()).setAuthType(AuthenticateType.BUILDIN)
                .addHeader("Accept-Language", I18nLocaleResolver.resolveLanguage(context == null ? null : context.getLocale()))
                .setConnectTimeout(connectTimeout != null && connectTimeout > 0 ? connectTimeout : 5000)
                .setReadTimeout(readTimeout != null && readTimeout > 0 ? readTimeout : 15000);
    }
}
