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

package neatlogic.framework.autoexec.dto;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import neatlogic.framework.autoexec.dto.script.AutoexecScriptExecrtoolAuthorityVo;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;

import java.util.List;

public class AutoexecToolVo extends AutoexecOperationVo {
    @EntityField(name = "common.isactive", type = ApiParamType.INTEGER)
    private Integer isActive;

    @EntityField(name = "common.editdate", type = ApiParamType.LONG)
    private Long importTime;

    // 直接执行权限过滤参数仅用于列表 Mapper 动态拼接，不直接输出给调用方。
    @JSONField(serialize = false)
    private String execrtoolAuthorityStatus;
    @JSONField(serialize = false)
    private List<String> execrtoolAuthorityUuidList;
    @EntityField(name = "common.executeauthoritylist", type = ApiParamType.JSONARRAY)
    private List<AutoexecScriptExecrtoolAuthorityVo> execrtoolAuthorityList;

    public AutoexecToolVo() {
    }

    public AutoexecToolVo(JSONObject object) {
        setName(object.getString("opName"));
        setExecMode(object.getString("opType"));
        setParser(object.getString("interpreter"));
        setDescription(object.getString("description"));
        this.importTime = object.getLong("importTime");
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public Long getImportTime() {
        return importTime;
    }

    public void setImportTime(Long importTime) {
        this.importTime = importTime;
    }

    public String getExecrtoolAuthorityStatus() {
        return execrtoolAuthorityStatus;
    }

    public void setExecrtoolAuthorityStatus(String execrtoolAuthorityStatus) {
        this.execrtoolAuthorityStatus = execrtoolAuthorityStatus;
    }

    public List<String> getExecrtoolAuthorityUuidList() {
        return execrtoolAuthorityUuidList;
    }

    public void setExecrtoolAuthorityUuidList(List<String> execrtoolAuthorityUuidList) {
        this.execrtoolAuthorityUuidList = execrtoolAuthorityUuidList;
    }

    public List<AutoexecScriptExecrtoolAuthorityVo> getExecrtoolAuthorityList() {
        return execrtoolAuthorityList;
    }

    public void setExecrtoolAuthorityList(List<AutoexecScriptExecrtoolAuthorityVo> execrtoolAuthorityList) {
        this.execrtoolAuthorityList = execrtoolAuthorityList;
    }
}
