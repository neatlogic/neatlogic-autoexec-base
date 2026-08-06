package neatlogic.framework.autoexec.dto.global.param;

import neatlogic.framework.asynchronization.threadlocal.TenantContext;
import neatlogic.framework.asynchronization.threadlocal.UserContext;
import neatlogic.framework.autoexec.dto.AutoexecParamVo;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.common.util.PageUtil;
import neatlogic.framework.dto.UserVo;
import neatlogic.framework.restful.annotation.EntityField;
import neatlogic.framework.util.SnowflakeUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * @author longrf
 * @date 2022/4/18 6:59 下午
 */
public class AutoexecGlobalParamVo extends AutoexecParamVo {

    //以当前页起最多展示页码数
    private static final int OFFSET_SIZE = 5;
    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "common.referencecount", type = ApiParamType.INTEGER)
    private Integer referredCount = 0;
    @JSONField(serialize = false)
    private JSONArray typeList;
    @JSONField(serialize = false)
    private boolean needPage = true;
    @JSONField(serialize = false)
    @EntityField(name = "common.pagesize", type = ApiParamType.INTEGER)
    private Integer pageSize = 20;
    @JSONField(serialize = false)
    @EntityField(name = "common.currentpage", type = ApiParamType.INTEGER)
    private Integer currentPage = 1;
    @JSONField(serialize = false)
    @EntityField(name = "common.pagecount", type = ApiParamType.INTEGER)
    private Integer pageCount = 0;
    @JSONField(serialize = false)
    private Integer startNum;
    @JSONField(serialize = false)
    private String keyword;
    @EntityField(name = "term.autoexec.totalcount", type = ApiParamType.INTEGER)
    @JSONField(serialize = false)
    private Integer rowNum = 0;
    @EntityField(name = "nfad.autoexecglobalparamvo.entityfield.startpage.name", type = ApiParamType.INTEGER)
    private Integer startPage;
    @EntityField(name = "nfad.autoexecglobalparamvo.entityfield.endpage.name", type = ApiParamType.INTEGER)
    private Integer endPage;
    @EntityField(name = "nfad.autoexecglobalparamvo.entityfield.offsetrownum.name", type = ApiParamType.INTEGER)
    @JSONField(serialize = false)
    private Integer offsetRowNum;
    @EntityField(name = "nfad.autoexecglobalparamvo.entityfield.expectoffsetrownum.name", type = ApiParamType.INTEGER)
    @JSONField(serialize = false)
    private Integer expectOffsetRowNum;

    @EntityField(name = "nfad.autoexecglobalparamvo.entityfield.fcu.name", type = ApiParamType.STRING)
    private String fcu;
    @EntityField(name = "nfad.autoexecglobalparamvo.entityfield.fcuname.name", type = ApiParamType.STRING)
    private String fcuName;
    @EntityField(name = "nfad.autoexecglobalparamvo.entityfield.fcd.name", type = ApiParamType.STRING)
    private Date fcd;
    @EntityField(name = "nfad.autoexecglobalparamvo.entityfield.lcu.name", type = ApiParamType.STRING)
    private String lcu;
    @EntityField(name = "nfad.autoexecglobalparamvo.entityfield.lcuname.name", type = ApiParamType.STRING)
    private String lcuName;
    @EntityField(name = "nfad.autoexecglobalparamvo.entityfield.lcd.name", type = ApiParamType.STRING)
    private Date lcd;

    @EntityField(name = "nfad.autoexecglobalparamvo.entityfield.fcuvo.name")
    private UserVo fcuVo;
    @EntityField(name = "nfad.autoexecglobalparamvo.entityfield.lcuvo.name")
    private UserVo lcuVo;

    public AutoexecGlobalParamVo() {
    }

    public AutoexecGlobalParamVo(String key, String name, String type) {
        super.setKey(key);
        super.setName(name);
        super.setType(type);
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

    public Integer getReferredCount() {
        return referredCount;
    }

    public void setReferredCount(Integer referredCount) {
        this.referredCount = referredCount;
    }

    public JSONArray getTypeList() {
        return typeList;
    }

    public void setTypeList(JSONArray typeList) {
        this.typeList = typeList;
    }

    public Integer getRowNum() {
        return rowNum;
    }

    public void setRowNum(Integer rowNum) {
        this.rowNum = rowNum;
    }

    public Boolean getNeedPage() {
        return true;
    }

    public void setNeedPage(Boolean needPage) {
        this.needPage = needPage;
    }

    public Integer getPageSize() {
        if (!this.needPage) {
            pageSize = 100;
        }
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize != null && pageSize > 0) {
            this.pageSize = Math.min(100, pageSize);//pagesize最大100
        }
    }

    public Integer getPageSizePlus() {
        return this.getPageSize() + 1;
    }


    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        if (currentPage == null) {
            this.currentPage = 1;
        } else {
            this.currentPage = currentPage;
        }
    }

    public Integer getStartNum() {
        return Math.max((getCurrentPage() - 1) * getPageSize(), 0);
    }

    public void setStartNum(Integer startNum) {
        this.startNum = startNum;
    }

    public Integer getPageCount() {
        if ((pageCount == null || pageCount == 0) && rowNum != null && rowNum > 0) {
            pageCount = PageUtil.getPageCount(rowNum, pageSize);
        }
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public final String getKeyword() {
        return keyword;
    }


    public final void setKeyword(String keyword) {
        if (StringUtils.isNotBlank(keyword)) {
            this.keyword = keyword.trim();
        }
    }

    public Integer getStartPage() {
        if (currentPage < OFFSET_SIZE + 2) {
            return 1;
        } else {
            return currentPage - OFFSET_SIZE;
        }
    }

    public Integer getEndPage() {
        if (offsetRowNum != null) {
            if (offsetRowNum % pageSize > 0) {
                return currentPage + offsetRowNum / pageSize;
            }
            return currentPage + offsetRowNum / pageSize - 1;
        }
        return null;
    }

    public void setOffsetRowNum(Integer offsetRowNum) {
        this.offsetRowNum = offsetRowNum;
    }

    public Integer getExpectOffsetRowNum() {
        if (expectOffsetRowNum == null) {
            int expectOffsetSize;
            if (currentPage < OFFSET_SIZE + 2) {
                expectOffsetSize = OFFSET_SIZE * 2 - (currentPage - 1);
            } else {
                expectOffsetSize = OFFSET_SIZE;
            }
            return expectOffsetSize * pageSize;
        }
        return expectOffsetRowNum;
    }

    public void setExpectOffsetRowNum(Integer expectOffsetRowNum) {
        this.expectOffsetRowNum = expectOffsetRowNum;
    }


    public String getTenantUuid() {
        return TenantContext.get().getTenantUuid();
    }


    public final String getFcu() {
        if (StringUtils.isBlank(fcu)) {
            fcu = UserContext.get().getUserUuid();
        }
        return fcu;
    }

    public final void setFcu(String fcu) {
        this.fcu = fcu;
    }

    public String getFcuName() {
        return fcuName;
    }

    public void setFcuName(String fcuName) {
        this.fcuName = fcuName;
    }

    public final Date getFcd() {
        return fcd;
    }

    public final void setFcd(Date fcd) {
        this.fcd = fcd;
    }

    public final String getLcu() {
        if (StringUtils.isBlank(lcu)) {
            lcu = UserContext.get().getUserUuid();
        }
        return lcu;
    }

    public final void setLcu(String lcu) {
        this.lcu = lcu;
    }

    public String getLcuName() {
        return lcuName;
    }

    public void setLcuName(String lcuName) {
        this.lcuName = lcuName;
    }

    public final Date getLcd() {
        return lcd;
    }

    public final void setLcd(Date lcd) {
        this.lcd = lcd;
    }

    public final UserVo getFcuVo() {
        if (fcuVo == null && StringUtils.isNotBlank(fcu)) {
            fcuVo = new UserVo(fcu);
        }
        return fcuVo;
    }

    public final UserVo getLcuVo() {
        if (lcuVo == null && StringUtils.isNotBlank(lcu)) {
            lcuVo = new UserVo(lcu);
        }
        return lcuVo;
    }

}
