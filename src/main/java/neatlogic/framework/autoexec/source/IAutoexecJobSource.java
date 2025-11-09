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
package neatlogic.framework.autoexec.source;

import neatlogic.framework.autoexec.constvalue.JobSourceType;
import neatlogic.framework.autoexec.dto.job.AutoexecJobRouteVo;

import java.util.List;

/**
 * @author lvzk
 * @since 2021/4/30 17:19
 **/
public interface IAutoexecJobSource {

	String getValue();

	String getText();

	/**
	 * 根据唯一键列表获取路由列表
	 * @param idList
	 * @return
	 */
	default List<AutoexecJobRouteVo> getListByUniqueKeyList(List<String> idList) {
		return null;
	}

	default String getType(){
		return JobSourceType.AUTOEXEC.getValue();
	}

}
