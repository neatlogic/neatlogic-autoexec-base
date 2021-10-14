/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dao.mapper;

import codedriver.framework.autoexec.dto.schedule.AutoexecScheduleVo;

import java.util.List;

/**
 * @author linbq
 * @since 2021/9/29 16:41
 **/
public interface AutoexecScheduleMapper {
    int checkAutoexecScheduleNameIsExists(AutoexecScheduleVo autoexecScheduleVo);

    AutoexecScheduleVo getAutoexecScheduleById(Long id);

    AutoexecScheduleVo getAutoexecScheduleByUuid(String uuid);

    int getAutoexecScheduleCount(AutoexecScheduleVo autoexecScheduleVo);

    List<AutoexecScheduleVo> getAutoexecScheduleList(AutoexecScheduleVo autoexecScheduleVo);

    int insertAutoexecSchedule(AutoexecScheduleVo autoexecScheduleVo);

    int updateAutoexecSchedule(AutoexecScheduleVo autoexecScheduleVo);

    int updateAutoexecScheduleIsActiveById(Long id);

    int deleteAutoexecScheduleById(Long id);
}
