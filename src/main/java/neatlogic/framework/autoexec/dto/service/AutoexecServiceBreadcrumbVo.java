/*Copyright (C) 2024  深圳极向量科技有限公司 All Rights Reserved.

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

package neatlogic.framework.autoexec.dto.service;

import com.alibaba.fastjson.annotation.JSONField;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.common.dto.BasePageVo;
import neatlogic.framework.restful.annotation.EntityField;

import java.util.ArrayList;
import java.util.List;

public class AutoexecServiceBreadcrumbVo extends BasePageVo {
    @EntityField(name = "服务目录ID", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "上游服务目录名称列表", type = ApiParamType.JSONARRAY)
    private List<String> upwardNameList = new ArrayList<>();
    @EntityField(name = "服务目录列表", type = ApiParamType.JSONARRAY)
    private List<AutoexecServiceVo> tbodyList = new ArrayList<>();

    @EntityField(name = "每页条数", type = ApiParamType.INTEGER)
    private Integer pageSize = 20;
    @EntityField(name = "当前页数", type = ApiParamType.INTEGER)
    private Integer currentPage = 1;
    @EntityField(name = "页数", type = ApiParamType.INTEGER)
    private Integer pageCount = 0;
    @EntityField(name = "总条数", type = ApiParamType.INTEGER)
    private Integer rowNum = 0;

    @JSONField(serialize = false)
    private Integer lft;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getUpwardNameList() {
        return upwardNameList;
    }

    public void setUpwardNameList(List<String> upwardNameList) {
        this.upwardNameList = upwardNameList;
    }

    public List<AutoexecServiceVo> getTbodyList() {
        return tbodyList;
    }

    public void setTbodyList(List<AutoexecServiceVo> tbodyList) {
        this.tbodyList = tbodyList;
    }

    public void addTbody(AutoexecServiceVo tbody) {
        this.tbodyList.add(tbody);
    }

    public void addUpwardName(String upwardName) {
        this.upwardNameList.add(upwardName);
    }

    public Integer getLft() {
        return lft;
    }

    public void setLft(Integer lft) {
        this.lft = lft;
    }
}
