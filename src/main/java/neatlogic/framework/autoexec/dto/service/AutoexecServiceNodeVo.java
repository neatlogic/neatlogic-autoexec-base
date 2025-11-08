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
