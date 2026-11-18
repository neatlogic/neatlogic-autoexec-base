package neatlogic.framework.autoexec.dto.job;

import com.alibaba.fastjson.JSONObject;

/** 快捷作业解析请求，宿主机和上下文只能由集成模块在服务端构造。 */
public class AutoexecQuickJobRequestVo {
  private Long combopId;
  private Long versionId;
  private String entryName;
  private String host;
  private JSONObject context;
  private JSONObject jobConfig;
  private JSONObject input;
  private boolean complete;

  /** 读取combopId配置。 */
  public Long getCombopId() {
    return combopId;
  }

  /** 设置combopId配置。 */
  public void setCombopId(Long combopId) {
    this.combopId = combopId;
  }

  /** 读取versionId配置。 */
  public Long getVersionId() {
    return versionId;
  }

  /** 设置versionId配置。 */
  public void setVersionId(Long versionId) {
    this.versionId = versionId;
  }

  /** 读取entryName配置。 */
  public String getEntryName() {
    return entryName;
  }

  /** 设置entryName配置。 */
  public void setEntryName(String entryName) {
    this.entryName = entryName;
  }

  /** 读取host配置。 */
  public String getHost() {
    return host;
  }

  /** 设置host配置。 */
  public void setHost(String host) {
    this.host = host;
  }

  /** 读取context配置。 */
  public JSONObject getContext() {
    return context;
  }

  /** 设置context配置。 */
  public void setContext(JSONObject context) {
    this.context = context;
  }

  /** 读取jobConfig配置。 */
  public JSONObject getJobConfig() {
    return jobConfig;
  }

  /** 设置jobConfig配置。 */
  public void setJobConfig(JSONObject jobConfig) {
    this.jobConfig = jobConfig;
  }

  /** 读取input配置。 */
  public JSONObject getInput() {
    return input;
  }

  /** 设置input配置。 */
  public void setInput(JSONObject input) {
    this.input = input;
  }

  /** 读取complete配置。 */
  public boolean isComplete() {
    return complete;
  }

  /** 设置complete配置。 */
  public void setComplete(boolean complete) {
    this.complete = complete;
  }
}
