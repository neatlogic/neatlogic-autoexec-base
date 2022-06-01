/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.job.source.action;

import codedriver.framework.autoexec.dto.combop.AutoexecCombopPhaseVo;
import codedriver.framework.autoexec.dto.job.AutoexecJobVo;

/**
 * @author lvzk
 * @since 2022/05/30 11:29
 **/
public interface IAutoexecJobSourceActionHandler {

    /**
     * 来源
     *
     * @return 来源
     */
    String getName();

    /**
     * 保存作业阶段
     *
     * @param combopPhaseVo 组合工具｜流水线阶段
     */
    void saveJobPhase(AutoexecCombopPhaseVo combopPhaseVo);

    /**
     * 获取作业sql内容
     *
     * @param jobVo
     * @return
     */
    String getJobSqlContent(AutoexecJobVo jobVo);

    /**
     * 下载作业sql文件
     *
     * @param jobVo
     * @return
     * @throws Exception
     */
    void  downloadJobSqlFile(AutoexecJobVo jobVo) throws Exception;
}
