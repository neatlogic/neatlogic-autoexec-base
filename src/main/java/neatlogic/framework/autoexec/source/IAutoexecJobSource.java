/*Copyright (C) $today.year  深圳极向量科技有限公司 All Rights Reserved.

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
