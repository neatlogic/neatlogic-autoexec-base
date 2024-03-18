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
import neatlogic.framework.autoexec.constvalue.AutoexecServiceType;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AutoexecServiceNodeVo extends AutoexecServiceVo {

    @EntityField(name = "子节点", type = ApiParamType.JSONARRAY)
    private List<AutoexecServiceNodeVo> children;

    @EntityField(name = "子节点数", type = ApiParamType.INTEGER)
    private Integer childrenCount;

    @JSONField(serialize=false)
    private AutoexecServiceNodeVo parent;

    public AutoexecServiceNodeVo() {
    }

    public AutoexecServiceNodeVo(Long id, String name, Long parentId) {
        super.setId(id);
        super.setName(name);
        super.setParentId(parentId);
    }

    public List<AutoexecServiceNodeVo> getChildren() {
        if (children == null && Objects.equals(super.getType(), AutoexecServiceType.CATALOG.getValue())) {
            children = new ArrayList<>();
        }
        return children;
    }

    public void setChildren(List<AutoexecServiceNodeVo> children) {
        this.children = children;
    }

    public Integer getChildrenCount() {
        if (childrenCount == null) {
            childrenCount = CollectionUtils.size(children);
        }
        return childrenCount;
    }

    public void setChildrenCount(Integer childrenCount) {
        this.childrenCount = childrenCount;
    }

    public AutoexecServiceNodeVo getParent() {
        return parent;
    }

    public void setParent(AutoexecServiceNodeVo parent) {
        this.parent = parent;
    }

    public boolean addChild(AutoexecServiceNodeVo child) {
        if (children == null) {
            children = new ArrayList<>();
        }
        if(children.contains(child)) {
            return false;
        }
        return children.add(child);
    }

    public boolean removeChild(AutoexecServiceNodeVo child) {
        if (CollectionUtils.isEmpty(children)) {
            return false;
        }
        return children.remove(child);
    }
}
