package codedriver.framework.autoexec.dto.combop;

import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.common.dto.BaseEditorVo;
import codedriver.framework.common.dto.ValueTextVo;
import codedriver.framework.dto.UserVo;
import codedriver.framework.restful.annotation.EntityField;
import codedriver.framework.util.SnowflakeUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

public class AutoexecCombopVersionVo extends BaseEditorVo {
    @EntityField(name = "主键id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "组合工具id", type = ApiParamType.LONG)
    private Long combopId;
    @EntityField(name = "显示名", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "版本号", type = ApiParamType.INTEGER)
    private Integer version;
    @EntityField(name = "状态(draft:草稿、rejected:已驳回、passed:已通过、submitted:待审批)", type = ApiParamType.STRING)
    private String status;
    @EntityField(name = "状态", type = ApiParamType.JSONOBJECT)
    private ValueTextVo statusVo;
    @EntityField(name = "审核人", type = ApiParamType.STRING)
    private String reviewer;
    @EntityField(name = "审批用户")
    private UserVo reviewerVo;
    @EntityField(name = "配置信息", type = ApiParamType.JSONOBJECT)
    private AutoexecCombopVersionConfigVo config;
    @JSONField(serialize = false)
    private String configStr;
    @EntityField(name = "执行页面是否需要设置执行用户", type = ApiParamType.BOOLEAN)
    private boolean needExecuteUser = false;
    @EntityField(name = "执行页面是否需要设置连接协议", type = ApiParamType.BOOLEAN)
    private boolean needProtocol = false;
    @EntityField(name = "执行页面是否需要设置执行目标", type = ApiParamType.BOOLEAN)
    private boolean needExecuteNode = false;
    @EntityField(name = "执行页面是否需要设置分批数量", type = ApiParamType.BOOLEAN)
    private boolean needRoundCount = false;

    public Long getId() {
        if (id == null) {
            id = SnowflakeUtil.uniqueLong();
        }
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCombopId() {
        return combopId;
    }

    public void setCombopId(Long combopId) {
        this.combopId = combopId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ValueTextVo getStatusVo() {
        return statusVo;
    }

    public void setStatusVo(ValueTextVo statusVo) {
        this.statusVo = statusVo;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public UserVo getReviewerVo() {
        return reviewerVo;
    }

    public void setReviewerVo(UserVo reviewerVo) {
        this.reviewerVo = reviewerVo;
    }

    public AutoexecCombopVersionConfigVo getConfig() {
        if (config == null && configStr != null) {
            config = JSONObject.parseObject(configStr, AutoexecCombopVersionConfigVo.class);
        }
        return config;
    }

    public void setConfig(AutoexecCombopVersionConfigVo config) {
        if (config != null) {
            this.configStr = null;
        }
        this.config = config;
    }

    public String getConfigStr() {
        if (configStr == null && config != null) {
            configStr = JSONObject.toJSONString(config);
        }
        return configStr;
    }

    public void setConfigStr(String configStr) {
        if (configStr != null) {
            this.config = null;
        }
        this.configStr = configStr;
    }

    public boolean getNeedExecuteUser() {
        return needExecuteUser;
    }

    public void setNeedExecuteUser(boolean needExecuteUser) {
        this.needExecuteUser = needExecuteUser;
    }

    public boolean getNeedProtocol() {
        return needProtocol;
    }

    public void setNeedProtocol(boolean needProtocol) {
        this.needProtocol = needProtocol;
    }

    public boolean getNeedExecuteNode() {
        return needExecuteNode;
    }

    public void setNeedExecuteNode(boolean needExecuteNode) {
        this.needExecuteNode = needExecuteNode;
    }

    public boolean getNeedRoundCount() {
        return needRoundCount;
    }

    public void setNeedRoundCount(boolean needRoundCount) {
        this.needRoundCount = needRoundCount;
    }
}
