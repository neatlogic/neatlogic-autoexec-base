/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.catalog;

import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.common.dto.BasePageVo;
import codedriver.framework.restful.annotation.EntityField;
import codedriver.framework.util.SnowflakeUtil;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;
import java.util.List;

public class AutoexecCatalogVo extends BasePageVo {

    public static final Long ROOT_PARENTID = -1L;
    public static final Long ROOT_ID = 0L;

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

    @JSONField(serialize = false)
    private AutoexecCatalogVo parent;

    public AutoexecCatalogVo() {
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
}
