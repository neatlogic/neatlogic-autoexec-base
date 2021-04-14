/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.combop;

import codedriver.framework.common.dto.BaseEditorVo;
import codedriver.framework.util.SnowflakeUtil;

/**
 * 组合共定时作业Vo类
 * @author: linbq
 * @since: 2021/4/13 10:08
 **/
public class AutoexecCombopScheduleVo extends BaseEditorVo {
    private Long id;
    private Long combopId;
    private String cron;

    public Long getId() {
        if(id == null){
            id = SnowflakeUtil.uniqueLong();
        }
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCombopId() {
        return combopId;
    }

    public void setCombopId(Long combopId) {
        this.combopId = combopId;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }
}
