/*
 * Copyright(c) 2023 NeatLogic Co., Ltd. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
