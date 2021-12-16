/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.crossover;

import codedriver.framework.autoexec.dto.job.AutoexecJobVo;
import codedriver.framework.crossover.ICrossoverService;
import com.alibaba.fastjson.JSONObject;

/**
 * @author laiwt
 * @since 2021/12/07 15:03
 **/
public interface IAutoexecJobActionCrossoverService extends ICrossoverService {
    /**
     * 校验根据组合工具创建的作业
     *
     * @param isNeedAuth 是否需要鉴权
     */
    AutoexecJobVo validateCreateJobFromCombop(JSONObject param, boolean isNeedAuth);
}