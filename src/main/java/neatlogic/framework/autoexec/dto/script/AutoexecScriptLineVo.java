/*Copyright (C) 2023  深圳极向量科技有限公司 All Rights Reserved.

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.*/

package neatlogic.framework.autoexec.dto.script;

import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.lcs.BaseLineVo;
import neatlogic.framework.restful.annotation.EntityField;
import neatlogic.framework.util.SnowflakeUtil;

import java.io.Serializable;

public class AutoexecScriptLineVo extends BaseLineVo implements Serializable {

    private static final long serialVersionUID = 8790853531134615524L;
    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "脚本ID", type = ApiParamType.LONG)
    private Long scriptId;
    @EntityField(name = "脚本版本ID", type = ApiParamType.LONG)
    private Long scriptVersionId;
    @EntityField(name = "脚本内容hash", type = ApiParamType.STRING)
    private String contentHash;
//    @EntityField(name = "脚本内容行号", type = ApiParamType.INTEGER)
//    private Integer lineNumber;
//
//    @EntityField(name = "脚本内容", type = ApiParamType.STRING)
//    private String content;
//
//    @EntityField(name = "插入(insert)、删除(delete)、更新(update)", type = ApiParamType.ENUM, member = ChangeType.class)
//    private String changeType;

    private Integer isAnnotation; // 是否是注释行

    @EntityField(name = "含有的危险代码等级", type = ApiParamType.STRING)
    private String riskCodeLevel;

    public AutoexecScriptLineVo() {
    }

//    public AutoexecScriptLineVo(String content, Integer lineNumber) {
//        this.content = content;
//        this.lineNumber = lineNumber;
//    }

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

    public String getContentHash() {
        return contentHash;
    }

    public void setContentHash(String contentHash) {
        this.contentHash = contentHash;
    }

//    public Integer getLineNumber() {
//        return lineNumber;
//    }
//
//    public void setLineNumber(Integer lineNumber) {
//        this.lineNumber = lineNumber;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public String getChangeType() {
//        return changeType;
//    }
//
//    public void setChangeType(String changeType) {
//        this.changeType = changeType;
//    }

    public Integer getIsAnnotation() {
        return isAnnotation;
    }

    public void setIsAnnotation(Integer isAnnotation) {
        this.isAnnotation = isAnnotation;
    }

    public String getRiskCodeLevel() {
        return riskCodeLevel;
    }

    public void setRiskCodeLevel(String riskCodeLevel) {
        this.riskCodeLevel = riskCodeLevel;
    }
}
