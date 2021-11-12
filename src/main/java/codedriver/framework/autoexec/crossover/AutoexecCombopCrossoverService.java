/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.crossover;

import codedriver.framework.autoexec.dto.combop.AutoexecCombopVo;
import codedriver.framework.crossover.ICrossoverService;

/**
 * @author lvzk
 * @since 2021/11/9 15:03
 **/
public interface AutoexecCombopCrossoverService extends ICrossoverService {
    /**
     * 设置当前用户可操作按钮权限列表
     *
     * @param autoexecCombopVo 组合工具Vo对象
     */
    void setOperableButtonList(AutoexecCombopVo autoexecCombopVo);
}
