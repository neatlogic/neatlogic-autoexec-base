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
 * @author linbq
 * @since 2022/3/23 14:23
 **/
public class AutoexecCombopGroupVo implements Serializable {
    @EntityField(name = "主键id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "uuid", type = ApiParamType.STRING)
    private String uuid;
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
