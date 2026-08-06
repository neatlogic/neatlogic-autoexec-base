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

package neatlogic.framework.autoexec.dto.script;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.common.dto.BaseEditorVo;
import neatlogic.framework.restful.annotation.EntityField;
import neatlogic.framework.util.SnowflakeUtil;

public class AutoexecScriptAuditVo extends BaseEditorVo {

    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "term.autoexec.scriptid", type = ApiParamType.LONG)
    private Long scriptId;
    @EntityField(name = "term.autoexec.scriptversionid", type = ApiParamType.LONG)
    private Long scriptVersionId;
    @EntityField(name = "nfad.autoexecscriptauditvo.entityfield.operate.name", type = ApiParamType.STRING)
    private String operate;
    @JSONField(serialize = false)
    @EntityField(name = "nfad.autoexecscriptauditvo.entityfield.contenthash.name", type = ApiParamType.STRING)
    private String contentHash;
    @EntityField(name = "common.content", type = ApiParamType.STRING)
    private String content;

    private JSONObject config;

    public AutoexecScriptAuditVo() {
    }

    public AutoexecScriptAuditVo(Long scriptId, Long scriptVersionId, String operate, JSONObject config) {
        this.scriptId = scriptId;
        this.scriptVersionId = scriptVersionId;
        this.operate = operate;
        this.config = config;
    }

    public Long getId() {
        if (id == null) {
            id = SnowflakeUtil.uniqueLong();
        }
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getScriptId() {
        return scriptId;
    }

    public void setScriptId(Long scriptId) {
        this.scriptId = scriptId;
    }

    public Long getScriptVersionId() {
        return scriptVersionId;
    }

    public void setScriptVersionId(Long scriptVersionId) {
        this.scriptVersionId = scriptVersionId;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

    public String getContentHash() {
        return contentHash;
    }

    public void setContentHash(String contentHash) {
        this.contentHash = contentHash;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public JSONObject getConfig() {
        return config;
    }

    public void setConfig(JSONObject config) {
        this.config = config;
    }
}
