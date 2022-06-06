/*
 * Copyright(c) 2022 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.combop;

import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;
import codedriver.framework.util.SnowflakeUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * @author linbq
 * @since 2022/3/23 14:23
 **/
public class AutoexecCombopGroupVo implements Serializable {
    @EntityField(name = "主键id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "uuid", type = ApiParamType.STRING)
    private String uuid;
    @EntityField(name = "组合工具id", type = ApiParamType.LONG)
    private Long combopId;
    @EntityField(name = "运行策略", type = ApiParamType.STRING)
    private String policy;
    @EntityField(name = "排序", type = ApiParamType.INTEGER)
    private Integer sort;
    @EntityField(name = "配置信息", type = ApiParamType.JSONOBJECT)
    private AutoexecCombopGroupConfigVo config;
    @JSONField(serialize = false)
    private String configStr;

    public Long getId() {
        if (id == null) {
            id = SnowflakeUtil.uniqueLong();
        }
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        if (uuid == null) {
            return "";
        }
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Long getCombopId() {
        return combopId;
    }

    public void setCombopId(Long combopId) {
        this.combopId = combopId;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public AutoexecCombopGroupConfigVo getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = JSONObject.parseObject(config, AutoexecCombopGroupConfigVo.class);
    }

    public String getConfigStr() {
        if (this.config == null) {
            return null;
        }
        return JSONObject.toJSONString(config);
    }
}