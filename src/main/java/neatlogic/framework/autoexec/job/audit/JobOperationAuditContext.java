package neatlogic.framework.autoexec.job.audit;

import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONArray;

/** 请求内的去重与交互上下文，不依赖审计存储。 */
public final class JobOperationAuditContext {
    private static final Logger logger = LoggerFactory.getLogger(JobOperationAuditContext.class);
    private static final ThreadLocal<JobOperationAuditContext> LOCAL = new ThreadLocal<>();
    private String interactionType;
    private String interactionValue;
    /** 获取当前外层动作的审计上下文，处理链外返回空。 */
    public static JobOperationAuditContext current() { return LOCAL.get(); }
    /** 建立请求级上下文，调用方负责在 finally 中关闭。 */
    public static JobOperationAuditContext open() {
        JobOperationAuditContext context = new JobOperationAuditContext();
        LOCAL.set(context);
        return context;
    }
    /** 清理线程池线程上的请求数据。 */
    public static void close() { LOCAL.remove(); }
    /** 仅保留服务端定义的按钮或选择值，自由输入始终脱敏。 */
    public static void interaction(JSONObject definition, String value) {
        JobOperationAuditContext context = current();
        if (context == null) { return; }
        context.interactionType = definition.getString("opType");
        context.interactionValue = "[REDACTED]";
        JSONArray options = definition.getJSONArray("options");
        if (options == null || value == null || !("button".equals(context.interactionType)
                || "select".equals(context.interactionType) || "mselect".equals(context.interactionType))) { return; }
        Set<String> allowed = new HashSet<>();
        for (Object option : options) {
            Object candidate = option instanceof JSONObject ? ((JSONObject) option).get("value") : option;
            if (candidate != null) { allowed.add(String.valueOf(candidate)); }
        }
        if (allowed.contains(value)) { context.interactionValue = value; return; }
        if ("mselect".equals(context.interactionType) && value.startsWith("[")) {
            try {
                JSONArray selected = JSONArray.parseArray(value);
                List<String> safeValues = new ArrayList<>();
                for (Object item : selected) {
                    if (!allowed.contains(String.valueOf(item))) { return; }
                    safeValues.add(String.valueOf(item));
                }
                context.interactionValue = JSONArray.toJSONString(safeValues);
            } catch (Exception ex) {
                // 不解析失败的交互正文；审计不能改变业务输入的处理行为。
                logger.error("Unable to parse audit interaction choices, type={}, exception={}", context.interactionType, ex.getClass().getSimpleName());
            }
        }
    }
    public String getInteractionType() { return interactionType; }
    public String getInteractionValue() { return interactionValue; }
}
