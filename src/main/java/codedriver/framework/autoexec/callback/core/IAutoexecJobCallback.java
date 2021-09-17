/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.callback.core;

import codedriver.framework.autoexec.dto.job.AutoexecJobVo;

/**
 * @author lvzk
 * @since 2021/9/17 19:16
 **/
public interface IAutoexecJobCallback {
    /**
     * 处理器
     * @return 处理器
     */
    String getHandler();

    /**
     * 是否需要回调
     * @param jobVo 自动化作业
     * @return true|false
     */
    Boolean getIsNeedCallback(AutoexecJobVo jobVo);

    /**
     * 需要执行的逻辑
     * @param invokeId 来源id
     * @param jobVo 自动化作业
     */
    void doService(Long invokeId,AutoexecJobVo jobVo);
}
