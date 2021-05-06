/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */
package codedriver.framework.autoexec.source;

import codedriver.framework.autoexec.dto.AutoexecJobSourceVo;

import java.util.List;

/**
 * @author lvzk
 * @since 2021/4/30 17:19
 **/
public interface IAutoexecJobSource {
	/**
	 *
	 * @return 返回对应的来源
	 */
	 List<AutoexecJobSourceVo> getSource();
}
