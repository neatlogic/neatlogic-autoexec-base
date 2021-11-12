/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.job.action.core;

import codedriver.framework.autoexec.dto.job.AutoexecJobVo;
import com.alibaba.fastjson.JSONObject;

/**
 * @author lvzk
 * @since 2021/11/9 11:29
 **/
public interface IAutoexecJobActionHandler {

    /**
     * 操作名
     * @return 操作名
     */
    String getName();

    /**
     * 执行操作前的验证
     * @param jobVo 作业
     * @return 是否执行后续操作
     */
    boolean validate(AutoexecJobVo jobVo);

    /**
     * 执行操作逻辑
     * @param jobVo 作业
     */
    JSONObject doService(AutoexecJobVo jobVo) throws Exception;

    /**
     * 是否需要校验是否拥有组合工具执行权限
     * @return true|false
     */
    default boolean isNeedExecuteAuthCheck(){
        return false;
    }
}
