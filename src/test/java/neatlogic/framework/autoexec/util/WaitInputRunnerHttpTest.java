package neatlogic.framework.autoexec.util;

import com.alibaba.fastjson.JSONObject;
import com.sun.net.httpserver.HttpServer;
import neatlogic.framework.asynchronization.threadlocal.RequestContext;
import neatlogic.framework.asynchronization.threadlocal.TenantContext;
import neatlogic.framework.asynchronization.threadlocal.UserContext;
import neatlogic.framework.common.config.Config;
import neatlogic.framework.exception.runner.RunnerHttpRequestException;
import neatlogic.framework.util.HttpRequestUtil;
import neatlogic.framework.util.$;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/** 验证有时限的 Runner 通道不会误报失败请求成功或泄露输入。 */
public class WaitInputRunnerHttpTest {
    private HttpServer server;
    private final ExecutorService pool = Executors.newCachedThreadPool();
    private final CompletableFuture<Void> release = new CompletableFuture<>();
    private final JSONObject params = new JSONObject();
    private String root;
    private Field connectConfig;
    private Field readConfig;
    private Object originalConnect;
    private Object originalRead;

    /** 只向回环测试服务发送虚构的作业标识和凭据。 */
    @Before public void start() throws Exception {
        connectConfig = field(Config.class, "RUNNER_CONNECT_TIMEOUT");
        readConfig = field(Config.class, "RUNNER_READ_TIMEOUT");
        originalConnect = connectConfig.get(null);
        originalRead = readConfig.get(null);
        connectConfig.set(null, 1000);
        readConfig.set(null, 250);
        UserContext.init((UserContext) null).setToken("Bearer_fixture");
        TenantContext.init("test");
        params.put("jobId", 42L);
        params.put("nodeId", 17L);
        params.put("option", "sensitive-fixture");
        server = HttpServer.create(new InetSocketAddress("127.0.0.1", 0), 0);
        server.setExecutor(pool);
        server.start();
        // 即使超时保护回归，模拟服务也会结束等待，使测试能够报告失败。
        release.completeOnTimeout(null, 10, TimeUnit.SECONDS);
        root = "http://127.0.0.1:" + server.getAddress().getPort() + "/api/rest/";
    }

    /** 释放挂起的模拟应答及线程上下文。 */
    @After public void stop() throws Exception {
        connectConfig.set(null, originalConnect);
        readConfig.set(null, originalRead);
        release.complete(null);
        if (server != null) server.stop(0);
        pool.shutdownNow();
        UserContext.get().release();
        TenantContext.get().release();
    }

    /** 注册独立响应；空正文表示已接收请求但不发送响应头。 */
    private void response(String action, int code, String body) {
        server.createContext("/api/rest/" + action, exchange -> {
            try {
                exchange.getRequestBody().readAllBytes();
                if (body == null) {
                    release.join();
                } else {
                    byte[] bytes = body.getBytes(StandardCharsets.UTF_8);
                    exchange.sendResponseHeaders(code, bytes.length);
                    exchange.getResponseBody().write(bytes);
                }
            } finally {
                exchange.close();
            }
        });
    }

    /** 获取实际展示的异常消息，检查诊断信息不会泄露。 */
    private String failure(String action) {
        RunnerHttpRequestException error = assertThrows(RunnerHttpRequestException.class,
                () -> AutoexecUtil.requestRunner(root + action, params));
        String message = error.getMessage();
        assertFalse(message, message.contains("sensitive-fixture"));
        return message;
    }

    /** 读取底座实际收到的超时值，避免依赖不可预测的 TCP 握手耗时。 */
    private static Field field(Class<?> owner, String name) throws Exception {
        Field field = owner.getDeclaredField(name);
        field.setAccessible(true);
        return field;
    }

    /** 每次发送前独立解析两个配置；单项无效不会覆盖另一项的有效值。 */
    @Test public void appliesFiniteTimeoutsToEveryRequest() throws Exception {
        assertTimeouts(123, 456, 123, 456);
        assertTimeouts(null, null, 5000, 15000);
        assertTimeouts(0, 456, 5000, 456);
        assertTimeouts(123, -1, 123, 15000);
        assertTimeouts(-1, 0, 5000, 15000);
    }

    /** 校验公共入口组装出的 HTTP 请求使用当前配置或约定默认值。 */
    private void assertTimeouts(Integer connect, Integer read, int expectedConnect, int expectedRead) throws Exception {
        connectConfig.set(null, connect);
        readConfig.set(null, read);
        HttpRequestUtil request = AutoexecUtil.buildRequest(root + "job/console/log/tail", params);
        assertEquals(expectedConnect, field(HttpRequestUtil.class, "connectTimeout").getInt(request));
        assertEquals(expectedRead, field(HttpRequestUtil.class, "readTimeout").getInt(request));
    }

    /** 未知或夹带文本的错误只能显示 HTTP 状态，不能回显原文。 */
    @Test public void fallsBackForUntrustedOrUnexpectedResponses() {
        String[] bodies = {
                errorBody("ERROR", "FIFO ENXIO (errno=6)"),
                errorBody("ERROR", "文件路径不合法"),
                errorBody("ERROR", "FIFO ENXIO (errno=6) sensitive-fixture"),
                errorBody("ERROR", "FIFO ENXIO (errno=sensitive-fixture)"),
                errorBody("ERROR", "文件路径不合法\n    at sensitive-fixture"),
                errorBody("ERROR", 42),
                errorBody("ERROR", new JSONObject()),
                errorBody("OK", "FIFO ENXIO"),
                "<html>sensitive-fixture</html>"
        };
        for (int i = 0; i < bodies.length; i++) {
            String action = "unknown/" + i;
            response(action, 520, bodies[i]);
            assertEquals($.t("autoexec.runnerrequest.failed", action, $.t("autoexec.runnerrequest.rejected", 520)), failure(action));
        }
        response("otherStatus", 503, errorBody("ERROR", "FIFO ENXIO"));
        assertEquals($.t("autoexec.runnerrequest.failed", "otherStatus", $.t("autoexec.runnerrequest.rejected", 503)), failure("otherStatus"));
    }

    /** 构造与 Runner 一致的响应信封，保留 Message 的真实 JSON 类型。 */
    private static String errorBody(String status, Object message) {
        JSONObject response = new JSONObject();
        response.put("Status", status);
        response.put("Message", message);
        return response.toJSONString();
    }

    /** 新 Runner 负责本地化，服务端传递用户语言并原样展示专用字段。 */
    @Test public void forwardsLanguageAndDisplaysRunnerUserMessage() {
        String action = "new-runner";
        server.createContext("/api/rest/" + action, exchange -> {
            try {
                String language = exchange.getRequestHeaders().getFirst("Accept-Language");
                JSONObject error = new JSONObject();
                error.put("Status", "ERROR");
                error.put("Message", "sensitive-fixture");
                error.put("UserMessage", "en".equals(language) ? "The pipe has no reader"
                        : "zh".equals(language) ? "管道没有读取进程" : "missing language");
                byte[] bytes = error.toJSONString().getBytes(StandardCharsets.UTF_8);
                exchange.sendResponseHeaders(520, bytes.length);
                exchange.getResponseBody().write(bytes);
            } finally {
                exchange.close();
            }
        });
        RequestContext previous = RequestContext.get();
        RequestContext context = RequestContext.init(null);
        try {
            context.setLocale(Locale.US);
            assertEquals("The pipe has no reader", failure(action));
            context.setLocale(Locale.SIMPLIFIED_CHINESE);
            assertEquals("管道没有读取进程", failure(action));
        } finally {
            context.release();
            if (previous != null) RequestContext.init(previous);
        }
    }

    /** 非单行纯文本和错误类型不能通过可展示字段泄露响应正文。 */
    @Test public void ignoresInvalidUserMessages() {
        Object[] unsafe = {null, " ", "<pre>sensitive-fixture</pre>", "trace\nsensitive-fixture", "X".repeat(513), new JSONObject()};
        for (int i = 0; i < unsafe.length; i++) {
            String action = "invalid-display/" + i;
            JSONObject body = JSONObject.parseObject(errorBody("ERROR", "sensitive-fixture"));
            body.put("UserMessage", unsafe[i]);
            response(action, 520, body.toJSONString());
            assertEquals($.t("autoexec.runnerrequest.failed", action, $.t("autoexec.runnerrequest.rejected", 520)), failure(action));
        }
    }

    /** 覆盖两处各自的读取超时及所有错误响应出口。 */
    @Test public void checksBothCallsAndResponseEnvelope() {
        String status = "job/phase/node/status/get";
        String submit = "job/phase/node/submit/waitInput";
        response(status, 200, null);
        response(submit, 200, null);
        assertTrue(failure(status).contains($.t("autoexec.runnerrequest.timeout")));
        assertTrue(failure(submit).contains($.t("autoexec.runnerrequest.timeout")));
        for (int code : new int[]{200, 503}) {
            String action = "business-error/" + code;
            response(action, code, "{\"Status\":\"ERROR\",\"UserMessage\":\"Runner detail\"}");
            assertEquals("Runner detail", failure(action));
        }
        response("network", 503, "sensitive-fixture");
        failure("network");
        response("application", 200, "{\"Status\":\"ERROR\",\"Message\":\"sensitive-fixture\"}");
        failure("application");
        response("malformed", 200, "sensitive-fixture");
        failure("malformed");
        response("success", 200, "{\"Status\":\"OK\",\"Return\":\"state\"}");
        assertEquals("state", AutoexecUtil.requestRunner(root + "success", params));
        response("object", 200, "{\"Status\":\"OK\",\"Return\":{\"id\":3}}");
        assertEquals("{\"id\":3}", AutoexecUtil.requestRunner(root + "object", params));
        response("array", 200, "{\"Status\":\"OK\",\"Return\":[1,2]}");
        assertEquals("[1,2]", AutoexecUtil.requestRunner(root + "array", params));
        response("null", 200, "{\"Status\":\"OK\",\"Return\":null}");
        assertNull(AutoexecUtil.requestRunner(root + "null", params));
        response("empty", 200, "{\"Status\":\"OK\"}");
        assertNull(AutoexecUtil.requestRunner(root + "empty", params));
    }
}
