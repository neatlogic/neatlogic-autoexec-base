/*
 *
 * Copyright (C) 2025  TechSure Co., Ltd.  All Rights Reserved.
 * This file is part of the NeatLogic software.
 * Licensed under the NeatLogic Sustainable Use License (NSUL), Version 4.x – 2025.
 * You may use this file only in compliance with the License.
 * See the LICENSE file distributed with this work for the full license text.
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 */

package neatlogic.framework.autoexec.dto.combop;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;
import neatlogic.framework.util.SnowflakeUtil;

import java.io.Serializable;

/**
 * 组合工具阶段Vo类
 *
 * @author: linbq
 * @since: 2021/4/13 10:05
 **/
public class AutoexecCombopPhaseVo implements Serializable {
    @EntityField(name = "主键id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "唯一标识", type = ApiParamType.STRING)
    private String uk;
    @EntityField(name = "显示名", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "执行方式", type = ApiParamType.STRING)
    private String execMode;
    @EntityField(name = "执行方式名称", type = ApiParamType.STRING)
    private String execModeName;
    @EntityField(name = "配置信息", type = ApiParamType.STRING)
    private AutoexecCombopPhaseConfigVo config;
    @EntityField(name = "阶段组", type = ApiParamType.JSONOBJECT)
    private AutoexecCombopGroupVo groupVo;
    @EntityField(name = "排序", type = ApiParamType.INTEGER)
    private Integer sort;
    @EntityField(name = "uuid", type = ApiParamType.STRING)
    private String uuid;
    @EntityField(name = "组id", type = ApiParamType.LONG)
    private Long groupId;
    @EntityField(name = "组uuid", type = ApiParamType.STRING)
    private String groupUuid;
    @EntityField(name = "组排序", type = ApiParamType.INTEGER)
    private Integer groupSort;
    @EntityField(name = "执行策略", type = ApiParamType.STRING)
    private String policy;
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

    public String getUk() {
        return uk;
    }

    public void setUk(String uk) {
        this.uk = uk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExecMode() {
        return execMode;
    }

    public void setExecMode(String execMode) {
        this.execMode = execMode;
    }

    public String getExecModeName() {
        return execModeName;
    }

    public void setExecModeName(String execModeName) {
        this.execModeName = execModeName;
    }

    public AutoexecCombopPhaseConfigVo getConfig() {
        if (config == null && configStr != null) {
            config = JSONObject.parseObject(configStr, AutoexecCombopPhaseConfigVo.class);
        }
        return config;
    }

    public void setConfig(AutoexecCombopPhaseConfigVo config) {
        if (config != null) {
            configStr = null;
        }
        this.config = config;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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

    public String getGroupUuid() {
        return groupUuid;
    }

    public void setGroupUuid(String groupUuid) {
        this.groupUuid = groupUuid;
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

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public AutoexecCombopGroupVo getGroupVo() {
        return groupVo;
    }

    public void setGroupVo(AutoexecCombopGroupVo groupVo) {
        this.groupVo = groupVo;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public Integer getGroupSort() {
        return groupSort;
    }

    public void setGroupSort(Integer groupSort) {
        this.groupSort = groupSort;
    }

}
