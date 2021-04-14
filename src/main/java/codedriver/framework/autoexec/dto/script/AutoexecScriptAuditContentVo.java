/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.script;

import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.common.dto.BaseEditorVo;
import codedriver.framework.restful.annotation.EntityField;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

public class AutoexecScriptAuditContentVo extends BaseEditorVo {

    @EntityField(name = "内容hash值", type = ApiParamType.STRING)
    private String hash;
    @EntityField(name = "活动内容", type = ApiParamType.STRING)
    private String content;

    public AutoexecScriptAuditContentVo() {
    }

    public AutoexecScriptAuditContentVo(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public String getHash() {
        if (StringUtils.isBlank(hash) && StringUtils.isNotBlank(content)) {
            hash = DigestUtils.md5DigestAsHex(content.getBytes());
        }
        return hash;
    }
}
