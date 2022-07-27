/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.job.source;

import codedriver.framework.autoexec.dto.job.AutoexecJobVo;
import com.alibaba.fastjson.JSONObject;

/**
 * @author lvzk
 * @since 2022/05/30 11:29
 **/
public interface IAutoexecJobSourceHandler {

    /**
     * 来源
     *
     * @return 来源
     */
    String getName();

    /**
     * 获取作业额外的信息
     * @param jobVo 作业
     * @return 作业额外信息
     */
    JSONObject getExtraJobInfo(AutoexecJobVo jobVo);

}
