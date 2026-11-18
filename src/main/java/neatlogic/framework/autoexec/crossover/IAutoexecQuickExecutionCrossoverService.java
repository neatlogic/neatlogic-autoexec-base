package neatlogic.framework.autoexec.crossover;

import com.alibaba.fastjson.JSONObject;
import neatlogic.framework.autoexec.dto.job.AutoexecQuickJobRequestVo;
import neatlogic.framework.crossover.ICrossoverService;

import java.util.List;

/** 向可选集成模块提供受限单主机执行能力，不负责调用方的对象关联存储。 */
public interface IAutoexecQuickExecutionCrossoverService extends ICrossoverService {
  /** 能力版本用于滚动升级时防止旧实现误调用新版契约。 */
  default int getJobConfigVersion() {
    return 1;
  }

  /** 解析映射和有效执行配置；complete 为真时执行完整预检。 */
  JSONObject resolveJob(AutoexecQuickJobRequestVo request);

  /** 校验配置结构，不要求调用时输入值已填写，不创建作业。 */
  JSONObject validateJobConfig(Long combopId, JSONObject jobConfig);

  /** 复用调用方事务创建已解析的手动作业，不启动 Runner。 */
  Long createReadyJobFromConfig(AutoexecQuickJobRequestVo request);

  /** 返回当前用户可执行工具，分页前过滤不支持的目标配置。 */
  JSONObject listTools(JSONObject request);

  /** 返回激活版本、脱敏参数及有效执行配置定义，不返回连接凭据。 */
  JSONObject describe(Long combopId);

  /** 校验目标地址的 Tagent 凭据及执行器路由，供预览和提交共用。 */
  void validateTarget(Long combopId, Long versionId, String host);

  /** 加入调用方事务创建手动作业，不启动、不安排定时执行。 */
  Long createReadyJob(Long combopId, Long versionId, String name, String host, JSONObject param);

  /** 重新鉴权并启动已提交作业；非待启动状态只返回已有状态。 */
  JSONObject startJob(Long jobId);

  /** 批量读取当前用户可查看且仍存在的作业，不包含作业参数。 */
  List<JSONObject> getVisibleJobs(List<Long> jobIds);
}
