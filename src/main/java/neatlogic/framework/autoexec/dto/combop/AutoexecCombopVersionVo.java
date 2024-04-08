package neatlogic.framework.autoexec.dto.combop;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.common.dto.BaseEditorVo;
import neatlogic.framework.dto.UserVo;
import neatlogic.framework.restful.annotation.EntityField;
import neatlogic.framework.util.SnowflakeUtil;
import org.apache.commons.lang3.StringUtils;

public class AutoexecCombopVersionVo extends BaseEditorVo {
    @EntityField(name = "common.id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "term.autoexec.combopid", type = ApiParamType.LONG)
    private Long combopId;
    @EntityField(name = "common.name", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "common.isactive", type = ApiParamType.INTEGER)
    private Integer isActive;
    @EntityField(name = "common.versionnum", type = ApiParamType.INTEGER)
    private Integer version;
    @EntityField(name = "common.status", type = ApiParamType.STRING)
    private String status;
    @EntityField(name = "common.reviewer", type = ApiParamType.STRING)
    private String reviewer;
    @EntityField(name = "common.reviewer")
    private UserVo reviewerVo;
    @EntityField(name = "common.config", type = ApiParamType.JSONOBJECT)
    private AutoexecCombopVersionConfigVo config;
    @JSONField(serialize = false)
    private String configStr;
    @EntityField(name = "term.autoexec.needexecuteuser", type = ApiParamType.BOOLEAN)
    private boolean needExecuteUser = false;
    @EntityField(name = "term.autoexec.needprotocol", type = ApiParamType.BOOLEAN)
    private boolean needProtocol = false;
    @EntityField(name = "term.autoexec.needexecutenode", type = ApiParamType.BOOLEAN)
    private boolean needExecuteNode = false;
    @EntityField(name = "term.autoexec.needroundcount", type = ApiParamType.BOOLEAN)
    private boolean needRoundCount = false;
    @EntityField(name = "term.autoexec.allphasesarerunnerorsqlexecmode", type = ApiParamType.BOOLEAN)
    private Boolean allPhasesAreRunnerOrSqlExecMode;
    @EntityField(name = "term.autoexec.existrunnerorsqlexecmode", type = ApiParamType.BOOLEAN)
    private Boolean existRunnerOrSqlExecMode;
    @EntityField(name = "term.autoexec.configexpired", type = ApiParamType.INTEGER)
    private Integer configExpired;
    @EntityField(name = "term.autoexec.configexpiredreason", type = ApiParamType.JSONOBJECT)
    private JSONObject configExpiredReason;
    @JSONField(serialize = false)
    private String configExpiredReasonStr;

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

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
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

    public Boolean getAllPhasesAreRunnerOrSqlExecMode() {
        return allPhasesAreRunnerOrSqlExecMode;
    }

    public void setAllPhasesAreRunnerOrSqlExecMode(Boolean allPhasesAreRunnerOrSqlExecMode) {
        this.allPhasesAreRunnerOrSqlExecMode = allPhasesAreRunnerOrSqlExecMode;
    }

    public Integer getConfigExpired() {
        return configExpired;
    }

    public void setConfigExpired(Integer configExpired) {
        this.configExpired = configExpired;
    }

    public JSONObject getConfigExpiredReason() {
        if (configExpiredReason == null && StringUtils.isNotBlank(configExpiredReasonStr)) {
            configExpiredReason = JSONObject.parseObject(configExpiredReasonStr);
        }
        return configExpiredReason;
    }

    public void setConfigExpiredReason(JSONObject configExpiredReason) {
        this.configExpiredReason = configExpiredReason;
    }

    public String getConfigExpiredReasonStr() {
        if (StringUtils.isBlank(configExpiredReasonStr) && configExpiredReason != null) {
            configExpiredReasonStr = configExpiredReason.toJSONString();
        }
        return configExpiredReasonStr;
    }

    public void setConfigExpiredReasonStr(String configExpiredReasonStr) {
        this.configExpiredReasonStr = configExpiredReasonStr;
    }

    public Boolean getExistRunnerOrSqlExecMode() {
        return existRunnerOrSqlExecMode;
    }

    public void setExistRunnerOrSqlExecMode(Boolean existRunnerOrSqlExecMode) {
        this.existRunnerOrSqlExecMode = existRunnerOrSqlExecMode;
    }
}
