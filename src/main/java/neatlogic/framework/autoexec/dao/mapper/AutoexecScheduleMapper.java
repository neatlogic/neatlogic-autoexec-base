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

package neatlogic.framework.autoexec.dao.mapper;

import neatlogic.framework.autoexec.dto.schedule.AutoexecScheduleVo;

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

    List<AutoexecScheduleVo> getAutoexecScheduleListByIdList(List<Long> idList);

    int insertAutoexecSchedule(AutoexecScheduleVo autoexecScheduleVo);

    int updateAutoexecSchedule(AutoexecScheduleVo autoexecScheduleVo);

    int updateAutoexecScheduleIsActiveById(AutoexecScheduleVo autoexecScheduleVo);

    int deleteAutoexecScheduleById(Long id);
}
