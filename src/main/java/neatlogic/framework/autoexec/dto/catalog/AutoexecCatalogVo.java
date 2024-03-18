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

package neatlogic.framework.autoexec.dto.catalog;

import com.alibaba.fastjson.annotation.JSONField;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.common.dto.BasePageVo;
import neatlogic.framework.restful.annotation.EntityField;
import neatlogic.framework.util.SnowflakeUtil;

import java.util.ArrayList;
import java.util.List;

public class AutoexecCatalogVo extends BasePageVo {

    public static final Long ROOT_PARENTID = -1L;
    public static final Long ROOT_ID = 0L;
    public static final String ROOT_NAME = "所有";

    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "名称", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "父ID", type = ApiParamType.LONG)
    private Long parentId;
    @EntityField(name = "左编码", type = ApiParamType.INTEGER)
    private Integer lft;
    @EntityField(name = "右编码", type = ApiParamType.INTEGER)
    private Integer rht;
    @EntityField(name = "子目录数量", type = ApiParamType.INTEGER)
    private Integer childCount;
    @EntityField(name = "子目录列表", type = ApiParamType.JSONARRAY)
    private List<AutoexecCatalogVo> children = new ArrayList<>();
    @EntityField(name = "关联的自定义工具数量", type = ApiParamType.INTEGER)
    private Integer referenceCountForScript;
    @EntityField(name = "工具完整目录名称", type = ApiParamType.STRING)
    private String fullCatalogName;

    private Integer referenceCountOfSelfAndChildren;// 目录自身与子目录关联的工具数量

    @JSONField(serialize = false)
    private AutoexecCatalogVo parent;

    public AutoexecCatalogVo() {
    }

    public AutoexecCatalogVo(Long id, String name, Long parentId) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }

    public AutoexecCatalogVo(String name, Long parentId, Integer lft, Integer rht) {
        this.name = name;
        this.parentId = parentId;
        this.lft = lft;
        this.rht = rht;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getLft() {
        return lft;
    }

    public void setLft(Integer lft) {
        this.lft = lft;
    }

    public Integer getRht() {
        return rht;
    }

    public void setRht(Integer rht) {
        this.rht = rht;
    }

    public Integer getChildCount() {
        return childCount;
    }

    public void setChildCount(Integer childCount) {
        this.childCount = childCount;
    }

    public AutoexecCatalogVo getParent() {
        return parent;
    }

    public void setParent(AutoexecCatalogVo parent) {
        this.parent = parent;
        parent.getChildren().add(this);
    }

    public List<AutoexecCatalogVo> getChildren() {
        return children;
    }

    public void setChildren(List<AutoexecCatalogVo> children) {
        this.children = children;
    }

    public Integer getReferenceCountForScript() {
        return referenceCountForScript;
    }

    public void setReferenceCountForScript(Integer referenceCountForScript) {
        this.referenceCountForScript = referenceCountForScript;
    }

    public Integer getReferenceCountOfSelfAndChildren() {
        return referenceCountOfSelfAndChildren;
    }

    public void setReferenceCountOfSelfAndChildren(Integer referenceCountOfSelfAndChildren) {
        this.referenceCountOfSelfAndChildren = referenceCountOfSelfAndChildren;
    }

    public String getFullCatalogName() {
        return fullCatalogName;
    }

    public void setFullCatalogName(String fullCatalogName) {
        this.fullCatalogName = fullCatalogName;
    }
}
