package neatlogic.framework.autoexec.crossover;

import com.alibaba.fastjson.JSONObject;

/** 服务端创建的脚本执行会话，封装商业调度状态与整轮资源释放。 */
public interface IAutoexecScriptExecutionSession extends AutoCloseable {
    Long getJobId();
    /** 使用原执行服务执行，不允许客户端构造或替换会话。 */
    Object execute(JSONObject arguments) throws Exception;
    /** 仅释放资源，不运行补偿脚本。 */
    @Override void close();
}
