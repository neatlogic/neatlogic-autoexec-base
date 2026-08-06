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

import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

public class AutoexecScriptLineContentVo {

    @EntityField(name = "term.autoexec.contenthash", type = ApiParamType.STRING)
    private String hash;
    @EntityField(name = "nfad.autoexecscriptlinecontentvo.entityfield.content.name", type = ApiParamType.STRING)
    private String content;

    public AutoexecScriptLineContentVo() {
    }

    public AutoexecScriptLineContentVo(String content) {
        this.content = content;
    }

    public String getHash() {
        if (StringUtils.isBlank(hash) && StringUtils.isNotBlank(content)) {
            hash = DigestUtils.md5DigestAsHex(content.getBytes());
        }
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
